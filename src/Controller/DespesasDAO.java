package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Util.Util;

public class DespesasDAO {

    public static void LancarDespesas(double valor, Date data) {
        Connection conn = null;
        PreparedStatement comando = null;

        try {
            conn = Conexao.conectar();
            comando = conn.prepareStatement("INSERT INTO despesas (data, valor) VALUES(?,?)");
            comando.setDate(1, data);
            comando.setDouble(2, valor);

            comando.executeUpdate();

            JOptionPane.showMessageDialog(null, "Despesa Lançada!");
        } catch (Exception e) {
            System.out.println("Não foi possível lançar desepesa.");
        } finally {
            Conexao.fecharConexao(conn, comando);
        }
    }

    public static double despesaDoDia() {
        Connection conn = null;
        PreparedStatement comando = null;
        ResultSet rs = null;
        Date hoje = Util.dataAtual();
        double resultado = 0;
        try {
            conn = Conexao.conectar();
            comando = conn.prepareStatement("SELECT * FROM despesas WHERE data=?");
            comando.setDate(1, hoje);

            rs = comando.executeQuery();

            while (rs.next()) {
                resultado += rs.getDouble("valor");
            }
        } catch (Exception e) {
            System.out.println("Impossível retornar o valor das despesas de hoje");
        } finally {
            Conexao.fecharConexao(conn, comando, rs);
        }
        System.out.println(resultado);
        return resultado;
    }

}
