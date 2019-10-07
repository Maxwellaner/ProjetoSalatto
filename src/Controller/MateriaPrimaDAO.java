package Controller;

import Model.MateriaPrima;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MateriaPrimaDAO {
    
    public static void cadastrarMateriaPrima(MateriaPrima mtp) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement comando = null;
            
            try {
                comando = conn.prepareStatement("INSERT INTO materiaPrima(nome, marca, precoKg, quantidadeEstoque) VALUES(?,?,?,?)");
                comando.setString(1, mtp.getNome());
                comando.setString(2, mtp.getMarca());      
                comando.setDouble(3, mtp.getPrecoKg());
                comando.setInt(4, mtp.getQuantidadeEstoque());
                
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
    
    public static List<MateriaPrima> listarMateriaPrima() throws Exception {
        // Abre a conexão
        Connection conn = Conexao.conectar();

        // Mapeia o objeto 
        PreparedStatement comando = conn.prepareStatement("SELECT * FROM materiaprima");

        // Executa a sql e captura o resultado da consulta
        ResultSet consulta = comando.executeQuery();

        // Lista para armazenar o resultado da consulta
        List<MateriaPrima> listaMateriaPrima = new ArrayList<MateriaPrima>();

        // percorre todos os resultados trazidos pela consulta
        while (consulta.next()) {
            MateriaPrima mtp = new MateriaPrima();
            mtp.setId(consulta.getInt("id"));
            mtp.setNome(consulta.getString("nome"));
            mtp.setMarca(consulta.getString("marca"));
            mtp.setQuantidadeEstoque(Integer.parseInt(consulta.getString("quantidadeEstoque")));
            mtp.setPrecoKg(Double.parseDouble(consulta.getString("precoKg")));

            // armazena na lista de clientes
            listaMateriaPrima.add(mtp);
        }

        // fecha a conexão
        consulta.close();
        comando.close();
        conn.close();

        return listaMateriaPrima;    
    }
    
    public static void baixaMaterialEstoque(int quantidade) {
        
    }
}
