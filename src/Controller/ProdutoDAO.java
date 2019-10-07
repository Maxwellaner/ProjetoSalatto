package Controller;

import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProdutoDAO {
    
    public static List<Produto> listarProdutos() throws Exception {
        String sql = "SELECT id, nome, descricao, quantidadeEstoque, valorCompra, valorVenda FROM produtos ORDER BY nome";
        // Abre a conexão
        Connection conn = Conexao.conectar();

        // Mapeia o objeto 
        PreparedStatement comando = conn.prepareStatement(sql);

        // Executa a sql e captura o resultado da consulta
        ResultSet consulta = comando.executeQuery();

        // Lista para armazenar o resultado da consulta
        List<Produto> listaProdutos = new ArrayList<Produto>();

        // percorre todos os resultados trazidos pela consulta
        while (consulta.next()) {
            Produto p = new Produto();
            p.setId(consulta.getInt("id"));
            p.setValorCompra(consulta.getDouble("valorCompra"));
            p.setValorVenda(consulta.getDouble("valorVenda"));
            p.setNome(consulta.getString("nome"));
            p.setDescricao(consulta.getString("descricao"));
            p.setQuantidadeEstoque(consulta.getInt("quantidadeEstoque"));
            
            // armazena na lista de clientes
            listaProdutos.add(p);
        }

        // fecha a conexão
        consulta.close();
        comando.close();
        conn.close();

        return listaProdutos;
        
        
    }
      
    public static void cadastraProduto(Produto produto) {
        
         try {
            Connection conn = Conexao.conectar();
            PreparedStatement comando = null;
            
            try {
                comando = conn.prepareStatement("INSERT INTO produtos(nome, quantidadeEstoque, valorCompra, valorVenda, descricao) VALUES(?,?,?,?,?)");
                comando.setString(1, produto.getNome());
                comando.setInt(2, produto.getQuantidadeEstoque());
                comando.setDouble(3, produto.getValorCompra());
                comando.setDouble(4, produto.getValorVenda());
                comando.setString(5, produto.getDescricao());
                
                comando.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
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
    
    public static void baixaProdutoEstoque(int quantidade, int idProduto) {
        Connection conn = null;
        PreparedStatement comando = null;
        
        try{
            conn = Conexao.conectar();
            comando = conn.prepareStatement("UPDATE produtos SET quantidadeEstoque=quantidadeEstoque - ? WHERE id=?");
            comando.setInt(1, quantidade);
            comando.setInt(2, idProduto);  
            comando.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Erro ao dar baixa em Produto");
        }
    }
    
    public static void lancamentoProdutoEstoque (int quantidade, int idProduto) {
        Connection conn = null;
        PreparedStatement comando = null;
        
        try{
            conn = Conexao.conectar();
            comando = conn.prepareStatement("UPDATE produtos SET quantidadeEstoque=quantidadeEstoque+?"
                    + " WHERE id=?");
            comando.setInt(1, quantidade);
            comando.setInt(2, idProduto);
            comando.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Erro ao lançar Produto em estoque");
        }
    }
}
