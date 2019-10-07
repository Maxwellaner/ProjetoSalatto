package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/salatto";
    private static final String USER = "root";
    private static final String SENHA = "";

    // Conecta ao banco de dados
    public static Connection conectar() throws Exception {
        try {
            // Registra o driver
            Class.forName(DRIVER);
            // obtém a conexão
            Connection conn = DriverManager.getConnection(URL, USER, SENHA);
            //System.out.println("Conectado!");
            //JOptionPane.showMessageDialog(null, "Conectado");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static void fecharConexao(Connection conn, PreparedStatement comando) {

        fecharConexao(conn);

        try {

            if (comando != null) {
                comando.close();;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fecharConexao(Connection conn) {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void fecharConexao(Connection conn, PreparedStatement comando, ResultSet rs) {

        fecharConexao(conn, comando);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
