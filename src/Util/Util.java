package Util;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

public class Util {

    public static String ler(String s) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(s);
        String retorno = null;
        retorno = entrada.nextLine();
        return retorno;
    }

    public static LocalDate stringToLocalDate(String data) {
        String[] partes = data.split("/");
        //quebra de data
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);
        //criaçao de nova data - alteração de partes
        LocalDate newDate = LocalDate.of(ano, mes, dia);
        //retorno
        return newDate;
    }

    public static int randomNumero() {
        int energ = 0;
        Random random = new Random();
        energ = random.nextInt(100);
        return energ;
    }

    public static MaskFormatter Mascara(String mascara) {

        MaskFormatter fmask = new MaskFormatter();

        try {
            fmask.setMask(mascara);
            fmask.setPlaceholderCharacter(' ');
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fmask;
    }

    public static String formatarValor(double valor) {
        String result = null;
        Math.ceil(valor);
        DecimalFormat df = new DecimalFormat("0.###");
        result = df.format(valor);
        return result;
    }

    public static Date dataAtual() {
        Date dataSistema = new Date(System.currentTimeMillis());
        return dataSistema;
    }
    
    public static Date amanha() {
        Date data = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        data = (Date) calendar.getTime();
        return data;
    }

    public static Date stringToDate(String s) {
        String[] data = s.split("");
        String aux = data[6]+data[7]+data[8]+data[9]+"-"+data[3]+data[4]+"-"+data[0]+data[1];
        Date result = Date.valueOf(aux);
        return result;
    }
}
