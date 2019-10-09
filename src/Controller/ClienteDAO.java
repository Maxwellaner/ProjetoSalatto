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
            c.setEndereco(consulta.getString("endereco"));
            c.setCelular(consulta.getString("celular"));
            c.setNascimento(consulta.getDate("nascimento"));
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

}
