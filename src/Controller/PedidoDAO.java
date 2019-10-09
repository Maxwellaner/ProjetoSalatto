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

    private static void darBaixa() {

        Connection conn = null;
        PreparedStatement comando = null;

        try {
            conn = Conexao.conectar();

            for (int i = 0; i <= listaProdutos.size() - 1; i++) {
                String sqlConsulta = "UPDATE produtos SET quantidadeEstoque=quantidadeEstoque-" + quantidadeProdutos.get(i)
                        + " WHERE id=" + listaProdutos.get(i).getId();
                // Mapeia o objeto 
                comando = conn.prepareStatement(sqlConsulta);

                // Executa a sql e captura o resultado da consulta
                comando.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("Erro ao lançar valores atualizados em produtos");
        } finally {
            Conexao.fecharConexao(conn, comando);
        }
    }

    public static List<Pedido> pedidosHoje() {
        Connection conn = null;
        PreparedStatement comando = null;
        ResultSet rs = null;
        Date hoje = Util.dataAtual();
        List<Pedido> listaPedidos = new ArrayList<Pedido>();
        try {
            conn = Conexao.conectar();
            comando = conn.prepareStatement("SELECT * FROM pedidos WHERE dataEntrega=?");
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
                //System.out.println(listaPedidos.get(i));
            }

        } catch (Exception e) {
            System.out.println("Erro na lista dos pedidos do dia!");
        } finally {
            Conexao.fecharConexao(conn, comando, rs);
        }

        return listaPedidos;
    }

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

    public static List<Produto> produtosPedido(int i) {
        Connection conn = null;
        PreparedStatement comando = null;
        ResultSet rs = null;
        List<Produto> listaProdutos = new ArrayList<Produto>();
        List indiceProdutos = new ArrayList();
        List qntProdutos = new ArrayList();

        try {
            String s = "SELECT * FROM pedido_produto WHERE id_pedido="+i;
            conn = Conexao.conectar();
            comando = conn.prepareStatement(s);
            //comando.setInt(1, i);
            rs = comando.executeQuery();
            //System.out.println(i);
            while (rs.next()) {
                indiceProdutos.add(rs.getInt("id_produto"));
                qntProdutos.add(rs.getInt("quantidade"));
            }
            //System.out.println(indiceProdutos);
            //System.out.println(qntProdutos);
        } catch (Exception ex) {
            System.out.println("Erro ao buscar produtos na tabela pedido_produtos");
        }
        

        try {
            
            String sql = "SELECT * FROM produtos WHERE id=";
            for (int j = 0; j <= indiceProdutos.size() - 1; j++) {
                int idProduto = (int) indiceProdutos.get(j);
                comando = conn.prepareStatement(sql + idProduto);
                //comando.setInt(1, (int) indiceProdutos.get(j));
                //System.out.println(comando);
                rs = comando.executeQuery();

                while (rs.next()) {
                    Produto p = new Produto();
                    p.setNome(rs.getString("nome"));
                    p.setId(rs.getInt("id"));
                    p.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                    p.setValorCompra(rs.getDouble("valorCompra"));
                    p.setValorVenda(rs.getDouble("valorVenda"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setQuantidadePorPedido((int)qntProdutos.get(j));
                    
                    listaProdutos.add(p);
                }
                
            }
            //System.out.println(listaProdutos);

        } catch (Exception ex) {
            System.out.println("Erro ao buscar produtos do pedido");
        }
        Conexao.fecharConexao(conn, comando, rs);

        return listaProdutos;
    }

    public static List<Pedido> pedidosFazer() {
        Connection conn = null;
        PreparedStatement comando = null;
        ResultSet rs = null;
        Date hoje = Util.dataAtual();
        List<Pedido> listaPedidos = new ArrayList<Pedido>();
        try {
            conn = Conexao.conectar();
            comando = conn.prepareStatement("SELECT * FROM pedidos WHERE dataEntrega >= NOW() ORDER BY dataEntrega ASC");
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
                //System.out.println(listaPedidos.get(i));
            }

        } catch (Exception e) {
            System.out.println("Erro na lista dos pedidos do dia!");
        } finally {
            Conexao.fecharConexao(conn, comando, rs);
        }

        return listaPedidos;
    }
}
