package Controller;

import Model.Pessoa.Cliente;
import Model.Empresa;
import Model.Pedido;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Util.Util;
import java.sql.Date;
import java.util.ArrayList;

public class PedidoDAO {

    private static List<Produto> listaProdutos;
    private static List quantidadeProdutos;

    /**
     * Método para cadastrar os pedidos.
     * @param pedido
     * @param produtos
     * @param quantidade 
     */
    public static void cadastrarPedido(Pedido pedido, List<Produto> produtos, List quantidade) {

        listaProdutos = produtos;
        quantidadeProdutos = quantidade;

        try {
            Connection conn = Conexao.conectar();
            PreparedStatement comando = null;

            int idComprador = 0;
            String comprador = "";

            if (pedido.getIdCliente() != 0) {
                idComprador = pedido.getIdCliente();
                comprador = "id_cliente";
            } else {
                idComprador = pedido.getIdEmpresa();
                comprador = "id_empresa";
            }
            String insertPedido = "INSERT INTO pedidos(isPago, adiantamento, valorTotal, dataPedido,"
                    + "dataEntrega, " + comprador + ", status" + ") VALUES(?,?,?,?,?,?,?)";

            try {
                // INSERÇÃO NA TABELA PEDIDOS
                comando = conn.prepareStatement(insertPedido, Statement.RETURN_GENERATED_KEYS);
                comando.setBoolean(1, pedido.isIsPago());
                comando.setDouble(2, pedido.getAdiantamento());
                comando.setDouble(3, pedido.getValorTotal());
                comando.setDate(4, pedido.getDataPedido());
                comando.setDate(5, (pedido.getDataEntrega()));
                comando.setInt(6, idComprador);
                comando.setString(7, "ABERTO");

                comando.executeUpdate();

                ResultSet rs = comando.getGeneratedKeys();

                int ultimoRegistro = -1;

                if (rs.next()) {
                    ultimoRegistro = rs.getInt(1);
                } else {
                    System.out.println("Erro ao pegar o último registro da inserção");
                }

                // INSERÇÕES NA TABELA PEDIDO_PRODUTO
                String insertPedidoProdutos = "INSERT INTO pedido_produto(id_pedido, id_produto, quantidade) VALUES(?,?,?)";
                comando = conn.prepareStatement(insertPedidoProdutos);

                for (int i = 0; i <= produtos.size() - 1; i++) {
                    comando.setInt(1, ultimoRegistro);
                    comando.setInt(2, listaProdutos.get(i).getId());
                    comando.setInt(3, (int) quantidadeProdutos.get(i));

                    comando.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

                darBaixa();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar! " + ex);
            } finally {
                Conexao.fecharConexao(conn, comando);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Algo errado com a conexão!");
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para dar baixa nos produtos.
     */
    private static void darBaixa() {

        Connection conn = null;
        PreparedStatement comando = null;

        try {
            conn = Conexao.conectar();

            for (int i = 0; i <= listaProdutos.size() - 1; i++) {
                String sqlConsulta = "UPDATE produtos SET quantidadeEstoque=quantidadeEstoque-" + quantidadeProdutos.get(i)
                        + " WHERE id=" + listaProdutos.get(i).getId();
                comando = conn.prepareStatement(sqlConsulta);
                comando.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("Erro ao lançar valores atualizados em produtos");
        } finally {
            Conexao.fecharConexao(conn, comando);
        }
    }

    /**
     * Método que lista todos os pedidos do dia.
     * @return - lista com os pedidos do dia.
     */
    public static List<Pedido> pedidosHoje() {
        Connection conn = null;
        PreparedStatement comando = null;
        ResultSet rs = null;
        Date hoje = Util.dataAtual();
        List<Pedido> listaPedidos = new ArrayList<Pedido>();
        try {
            conn = Conexao.conectar();
            comando = conn.prepareStatement("SELECT * FROM pedidos WHERE dataEntrega=? AND status='ABERTO'");
            comando.setDate(1, hoje);
            rs = comando.executeQuery();

            while (rs.next()) {
                Pedido pedidosHoje = new Pedido();
                pedidosHoje.setId(rs.getInt("id"));
                pedidosHoje.setIdCliente(rs.getInt("id_cliente"));
                pedidosHoje.setIdEmpresa(rs.getInt("id_empresa"));
                pedidosHoje.setDataEntrega(rs.getDate("dataEntrega"));
                pedidosHoje.setDataPedido(rs.getDate("dataPedido"));
                pedidosHoje.setIsPago(rs.getBoolean("isPago"));
                pedidosHoje.setValorTotal(rs.getDouble("valorTotal"));
                pedidosHoje.setAdiantamento(rs.getDouble("adiantamento"));

                listaPedidos.add(pedidosHoje);
            }

            for (int i = 0; i <= listaPedidos.size() - 1; i++) {

                if (listaPedidos.get(i).getIdCliente() != 0) {
                    listaPedidos.get(i).setCliente(clientePedido(listaPedidos.get(i).getIdCliente()));
                } else {
                    listaPedidos.get(i).setEmpresa(empresaPedido(listaPedidos.get(i).getIdEmpresa()));
                }
                listaPedidos.get(i).setProdutos(produtosPedido(listaPedidos.get(i).getId()));
            }

        } catch (Exception e) {
            System.out.println("Erro na lista dos pedidos do dia!");
        } finally {
            Conexao.fecharConexao(conn, comando, rs);
        }

        return listaPedidos;
    }

    /**
     * Método de apoio para buscar e adicionar o cliente ao pedido.
     * @param i
     * @return - retorna o cliente referente.
     */
    private static Cliente clientePedido(int i) {
        String sql = "SELECT * FROM clientes WHERE id=" + i;
        Connection conn = null;
        PreparedStatement comando = null;
        ResultSet rs = null;
        Cliente c = new Cliente();
        try {
            conn = Conexao.conectar();
            comando = conn.prepareStatement(sql);
            rs = comando.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCelular(rs.getString("celular"));
                c.setEndereco(rs.getString("endereco"));
                c.setNascimento(rs.getDate("nascimento"));
                c.setCPF(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao retornar cliente por id do Pedido");
        } finally {
            Conexao.fecharConexao(conn, comando, rs);
        }
        return c;
    }

    /**
     * Método de apoio para adicionar a empresa ao pedido.
     * @param i
     * @return - retorna a empresa referente.
     */
    private static Empresa empresaPedido(int i) {
        String sql = "SELECT * FROM empresas WHERE id=" + i;
        Connection conn = null;
        PreparedStatement comando = null;
        ResultSet rs = null;
        Empresa e = new Empresa();
        try {
            conn = Conexao.conectar();
            comando = conn.prepareStatement(sql);
            rs = comando.executeQuery();
            while (rs.next()) {
                e.setId(rs.getInt("id"));
                e.setCnpj(rs.getString("cnpj"));
                e.setEndereco(rs.getString("endereco"));
                e.setEmailComercial(rs.getString("email"));
                e.setCelularComercial(rs.getString("celular"));
                e.setRazaoSocial(rs.getString("razaoSocial"));
                e.setNomeFantasia(rs.getString("nomeFantasia"));
                e.setTelefoneComercial(rs.getString("telefone"));
                e.setDataContrato(rs.getDate("dataContrato"));
            }
        } catch (Exception ex) {
            System.out.println("Erro ao retornar empresa por id do Pedido");
        } finally {
            Conexao.fecharConexao(conn, comando, rs);
        }
        return e;
    }

    /**
     * Método de apoio para adicionar os produtos do pedido.
     * @param i
     * @return - retorna uma lista com os produtos referentes.
     */
    public static List<Produto> produtosPedido(int i) {
        Connection conn = null;
        PreparedStatement comando = null;
        ResultSet rs = null;
        List<Produto> listaProdutos = new ArrayList<Produto>();
        List indiceProdutos = new ArrayList();
        List qntProdutos = new ArrayList();

        try {
            String s = "SELECT * FROM pedido_produto WHERE id_pedido=" + i;
            conn = Conexao.conectar();
            comando = conn.prepareStatement(s);
            rs = comando.executeQuery();
            while (rs.next()) {
                indiceProdutos.add(rs.getInt("id_produto"));
                qntProdutos.add(rs.getInt("quantidade"));
            }
        } catch (Exception ex) {
            System.out.println("Erro ao buscar produtos na tabela pedido_produtos");
        }

        try {

            String sql = "SELECT * FROM produtos WHERE id=";
            for (int j = 0; j <= indiceProdutos.size() - 1; j++) {
                int idProduto = (int) indiceProdutos.get(j);
                comando = conn.prepareStatement(sql + idProduto);
                rs = comando.executeQuery();

                while (rs.next()) {
                    Produto p = new Produto();
                    p.setNome(rs.getString("nome"));
                    p.setId(rs.getInt("id"));
                    p.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                    p.setValorCompra(rs.getDouble("valorCompra"));
                    p.setValorVenda(rs.getDouble("valorVenda"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setQuantidadePorPedido((int) qntProdutos.get(j));

                    listaProdutos.add(p);
                }
            }

        } catch (Exception ex) {
            System.out.println("Erro ao buscar produtos do pedido");
        }
        Conexao.fecharConexao(conn, comando, rs);

        return listaProdutos;
    }

    /**
     * Método para listar os pedidos a fazer à partir da data atual.
     * @return - retorna uma lista com os pedidos a fazer.
     */
    public static List<Pedido> pedidosFazer() {
        Connection conn = null;
        PreparedStatement comando = null;
        ResultSet rs = null;
        List<Pedido> listaPedidos = new ArrayList<Pedido>();
        try {
            conn = Conexao.conectar();
            comando = conn.prepareStatement("SELECT * FROM pedidos WHERE dataEntrega >= NOW() AND status='ABERTO' ORDER BY dataEntrega ASC");
            rs = comando.executeQuery();

            while (rs.next()) {
                Pedido pedidosHoje = new Pedido();
                pedidosHoje.setId(rs.getInt("id"));
                pedidosHoje.setIdCliente(rs.getInt("id_cliente"));
                pedidosHoje.setIdEmpresa(rs.getInt("id_empresa"));
                pedidosHoje.setDataEntrega(rs.getDate("dataEntrega"));
                pedidosHoje.setDataPedido(rs.getDate("dataPedido"));
                pedidosHoje.setIsPago(rs.getBoolean("isPago"));
                pedidosHoje.setValorTotal(rs.getDouble("valorTotal"));
                pedidosHoje.setAdiantamento(rs.getDouble("adiantamento"));

                listaPedidos.add(pedidosHoje);
            }

            for (int i = 0; i <= listaPedidos.size() - 1; i++) {

                if (listaPedidos.get(i).getIdCliente() != 0) {
                    listaPedidos.get(i).setCliente(clientePedido(listaPedidos.get(i).getIdCliente()));
                } else {
                    listaPedidos.get(i).setEmpresa(empresaPedido(listaPedidos.get(i).getIdEmpresa()));
                }
                listaPedidos.get(i).setProdutos(produtosPedido(listaPedidos.get(i).getId()));
            }

        } catch (Exception e) {
            System.out.println("Erro na lista dos pedidos do dia!");
        } finally {
            Conexao.fecharConexao(conn, comando, rs);
        }

        return listaPedidos;
    }

    /**
     * Método para fechar o pedido, ou seja, status = FECHADO.
     * @param indice 
     */
    public static void fechaPedido(int indice) {
        System.out.println(indice);
        Connection conn = null;
        PreparedStatement comando = null;
        Date hoje = Util.dataAtual();
        try {
            String sql = "UPDATE pedidos SET status='FECHADO', dataFechamento=?" + " WHERE id=?";
            conn = Conexao.conectar();
            comando = conn.prepareStatement(sql);
            comando.setDate(1, hoje);
            comando.setInt(2, indice);
            System.out.println(comando);
            comando.executeUpdate();
            comando.executeUpdate();
        } catch (Exception e) {
            System.out.println("Não foi possível fechar o pedido");
            System.out.println(e.getMessage());
        } finally {
            Conexao.fecharConexao(conn, comando);
        }
    }

    /**
     * Método para listar os pedidos fechados na data atual.
     * @return - retorna uma lista com os pedidos.
     */
    public static List<Pedido> pedidosFechadosHoje() {
        Connection conn = null;
        PreparedStatement comando = null;
        ResultSet rs = null;
        Date hoje = Util.dataAtual();
        List<Pedido> pedidos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedidos WHERE dataFechamento=? AND status='FECHADO'";//+ hoje + " ORDER BY dataEntrega ASC";
            conn = Conexao.conectar();   
            comando = conn.prepareStatement("SELECT * FROM pedidos WHERE dataFechamento=? AND status='FECHADO'");
            comando.setDate(1, hoje);
            rs = comando.executeQuery();

            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setIdCliente(rs.getInt("id_cliente"));
                p.setIdEmpresa(rs.getInt("id_empresa"));
                p.setDataEntrega(rs.getDate("dataEntrega"));
                p.setDataPedido(rs.getDate("dataPedido"));
                p.setIsPago(rs.getBoolean("isPago"));
                p.setValorTotal(rs.getDouble("valorTotal"));
                p.setAdiantamento(rs.getDouble("adiantamento"));

                pedidos.add(p);
            }
            
            for (int i = 0; i <= pedidos.size() - 1; i++) {

                if (pedidos.get(i).getIdCliente() != 0) {
                    pedidos.get(i).setCliente(clientePedido(pedidos.get(i).getIdCliente()));
                } else {
                    pedidos.get(i).setEmpresa(empresaPedido(pedidos.get(i).getIdEmpresa()));
                }
                pedidos.get(i).setProdutos(produtosPedido(pedidos.get(i).getId()));
            }
            
            
        } catch (Exception e) {
            System.out.println("Não foi possível buscar os pedidos fechados hoje");
        } finally {
            Conexao.fecharConexao(conn, comando, rs);
        }
        return pedidos;
    }
    
    /**
     * Método que retorna um pedido pela data de fechamento.
     * @param s
     * @return - retorna uma lista com os pedidos.
     */
    public static List<Pedido> pedidoPorDataFechamento(String s) {
        Connection conn = null;
        PreparedStatement comando = null;
        ResultSet rs = null;
        Date data = Util.stringToDate(s);
        List<Pedido> listaPedidos = new ArrayList<Pedido>();
        try {
            conn = Conexao.conectar();
            comando = conn.prepareStatement("SELECT * FROM pedidos WHERE dataEntrega=?");
            comando.setDate(1, data);
            rs = comando.executeQuery();

            while (rs.next()) {
                Pedido pedidosHoje = new Pedido();
                pedidosHoje.setId(rs.getInt("id"));
                pedidosHoje.setIdCliente(rs.getInt("id_cliente"));
                pedidosHoje.setIdEmpresa(rs.getInt("id_empresa"));
                pedidosHoje.setDataEntrega(rs.getDate("dataEntrega"));
                pedidosHoje.setDataPedido(rs.getDate("dataPedido"));
                pedidosHoje.setIsPago(rs.getBoolean("isPago"));
                pedidosHoje.setValorTotal(rs.getDouble("valorTotal"));
                pedidosHoje.setAdiantamento(rs.getDouble("adiantamento"));

                listaPedidos.add(pedidosHoje);
            }

            for (int i = 0; i <= listaPedidos.size() - 1; i++) {

                if (listaPedidos.get(i).getIdCliente() != 0) {
                    listaPedidos.get(i).setCliente(clientePedido(listaPedidos.get(i).getIdCliente()));
                } else {
                    listaPedidos.get(i).setEmpresa(empresaPedido(listaPedidos.get(i).getIdEmpresa()));
                }
                listaPedidos.get(i).setProdutos(produtosPedido(listaPedidos.get(i).getId()));
            }

        } catch (Exception e) {
            System.out.println("Erro na lista dos pedidos do dia!");
        } finally {
            Conexao.fecharConexao(conn, comando, rs);
        }

        return listaPedidos;
    }
    
    /**
     * Método para listar todos os pedidos do banco de dados
     * @return - uma lista com todos os pedidos
     */
    public static List<Pedido> pedidos() {
        Connection conn = null;
        PreparedStatement comando = null;
        ResultSet rs = null;
        List<Pedido> listaPedidos = new ArrayList<Pedido>();
        try {
            conn = Conexao.conectar();
            comando = conn.prepareStatement("SELECT * FROM pedidos");
            rs = comando.executeQuery();

            while (rs.next()) {
                Pedido pedidosHoje = new Pedido();
                pedidosHoje.setId(rs.getInt("id"));
                pedidosHoje.setIdCliente(rs.getInt("id_cliente"));
                pedidosHoje.setIdEmpresa(rs.getInt("id_empresa"));
                pedidosHoje.setDataEntrega(rs.getDate("dataEntrega"));
                pedidosHoje.setDataPedido(rs.getDate("dataPedido"));
                pedidosHoje.setIsPago(rs.getBoolean("isPago"));
                pedidosHoje.setValorTotal(rs.getDouble("valorTotal"));
                pedidosHoje.setAdiantamento(rs.getDouble("adiantamento"));

                listaPedidos.add(pedidosHoje);
            }

            for (int i = 0; i <= listaPedidos.size() - 1; i++) {

                if (listaPedidos.get(i).getIdCliente() != 0) {
                    listaPedidos.get(i).setCliente(clientePedido(listaPedidos.get(i).getIdCliente()));
                } else {
                    listaPedidos.get(i).setEmpresa(empresaPedido(listaPedidos.get(i).getIdEmpresa()));
                }
                listaPedidos.get(i).setProdutos(produtosPedido(listaPedidos.get(i).getId()));
            }
        } catch (Exception e) {
            System.out.println("Erro na lista dos pedidos do dia!");
        } finally {
            Conexao.fecharConexao(conn, comando, rs);
        }

        return listaPedidos;
    }
}
