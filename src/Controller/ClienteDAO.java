package Controller;

import Model.Pessoa.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteDAO {

    public static List<Cliente> ListaClientes() throws Exception {
        String sql = "SELECT * FROM clientes ORDER BY nome";
        Connection conn = Conexao.conectar();
        PreparedStatement comando = conn.prepareStatement(sql);
        ResultSet consulta = comando.executeQuery();
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        while (consulta.next()) {
            Cliente c = new Cliente();
            c.setId(consulta.getInt("id"));
            c.setNome(consulta.getString("nome"));
            c.setCPF(consulta.getString("cpf"));
            c.setEmail(consulta.getString("email"));
            c.setEndereco(consulta.getString("endereco"));
            c.setCelular(consulta.getString("celular"));
            c.setNascimento(consulta.getDate("nascimento"));
            c.setTelefone(consulta.getString("telefone"));
            listaClientes.add(c);
        }

        // fecha a conexão
        consulta.close();
        comando.close();
        conn.close();
               
        return listaClientes;
    }

    public static void cadastraCliente(Cliente cliente) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement comando = null;
            
            try {
                comando = conn.prepareStatement("INSERT INTO clientes(nome, nascimento, cpf, endereco, celular, telefone, email) VALUES(?,?,?,?,?,?,?)");
                comando.setString(1, cliente.getNome());
                comando.setDate(2, cliente.getNascimento());
                comando.setString(3, cliente.getCPF());
                comando.setString(4, cliente.getEndereco());
                comando.setString(5, cliente.getCelular());
                comando.setString(6, cliente.getTelefone());
                comando.setString(7, cliente.getEmail());
                
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

    public static void alterar(Cliente c) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement comando = null;
            
            try {
                comando = conn.prepareStatement("UPDATE clientes SET nome=?, endereco=?, cpf=?, celular=?, telefone=?, nascimento=?, email=?"
                        + " WHERE id=?");
                comando.setString(1, c.getNome());
                comando.setString(2, c.getEndereco());
                comando.setString(3, c.getCPF());
                comando.setString(4, c.getCelular());
                comando.setString(5, c.getTelefone());
                comando.setDate(6, c.getNascimento());
                comando.setString(7, c.getEmail());
                comando.setInt(8, c.getId());
                
                comando.executeUpdate();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar! " + ex);
            } finally {
                Conexao.fecharConexao(conn, comando);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Algo errado com a conexão!");
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void excluir(int id) {
        Connection conn = null;
        PreparedStatement comando = null;
        
        try{
            conn = Conexao.conectar();
            comando = conn.prepareStatement("DELETE FROM clientes WHERE id=?");
            comando.setInt(1, id);
            System.out.println(comando);
            comando.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Erro ao deletar Cliente");
        } finally {
            Conexao.fecharConexao(conn, comando);
        }
    }
}
