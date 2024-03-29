package Controller;

import Model.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EmpresaDAO {
    
    public static void cadastrarEmpresa(Empresa empresa) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement comando = null;
            
            try {
                comando = conn.prepareStatement("INSERT INTO empresas(nomeFantasia, razaoSocial, cnpj, endereco, celular, telefone, email, dataContrato) VALUES(?,?,?,?,?,?,?,?)");
                comando.setString(1, empresa.getNomeFantasia());
                comando.setString(2, empresa.getRazaoSocial());
                comando.setString(3, empresa.getCnpj());
                comando.setString(4, empresa.getEndereco());
                comando.setString(5, empresa.getCelularComercial());
                comando.setString(6, empresa.getTelefoneComercial());
                comando.setString(7, empresa.getEmailComercial());
                comando.setDate(8, empresa.getDataContrato());
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
    
    public static List<Empresa> listarEmpresas() throws Exception {
        String sql = "SELECT * FROM empresas ORDER BY nomeFantasia";
        Connection conn = Conexao.conectar();
        PreparedStatement comando = conn.prepareStatement(sql.toString());
        ResultSet consulta = comando.executeQuery();
        List<Empresa> listaEmpresas = new ArrayList<Empresa>();
        while (consulta.next()) {
            Empresa e = new Empresa();
            e.setId(consulta.getInt("id"));
            e.setNomeFantasia(consulta.getString("nomeFantasia"));
            e.setRazaoSocial(consulta.getString("razaoSocial"));
            e.setEndereco(consulta.getString("endereco"));
            e.setTelefoneComercial(consulta.getString("telefone"));
            e.setCelularComercial(consulta.getString("celular"));
            e.setCnpj(consulta.getString("cnpj"));
            e.setDataContrato(consulta.getDate("dataContrato"));
            e.setEmailComercial(consulta.getString("email"));
            listaEmpresas.add(e);
        }

        // fecha a conexão
        consulta.close();
        comando.close();
        conn.close();

        return listaEmpresas;
    }
    
    public static void excluir(int id) {
        Connection conn = null;
        PreparedStatement comando = null;
        
        try{
            conn = Conexao.conectar();
            comando = conn.prepareStatement("DELETE FROM empresas WHERE id=?");
            comando.setInt(1, id);
            comando.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Erro ao deletar Empresa");
        } finally {
            Conexao.fecharConexao(conn, comando);
        }
    }
    
    public static void alterar(Empresa e) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement comando = null;
            
            try {
                comando = conn.prepareStatement("UPDATE empresas SET nomeFantasia=?, razaoSocial=?, cnpj=?, celular=?, telefone=?, email=?, dataContrato=?, endereco=?"
                        + " WHERE id=?");
                comando.setString(1, e.getNomeFantasia());
                comando.setString(2, e.getRazaoSocial());
                comando.setString(3, e.getCnpj());
                comando.setString(4, e.getCelularComercial());
                comando.setString(5, e.getTelefoneComercial());
                comando.setString(6, e.getEmailComercial());
                comando.setDate(7, e.getDataContrato());
                comando.setString(8, e.getEndereco());
                comando.setInt(9, e.getId());
                
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
}
