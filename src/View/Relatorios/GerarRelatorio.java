package View.Relatorios;

import Controller.Conexao;
import Model.Pessoa.Cliente;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerarRelatorio {

    public static void gerarPDF(String nomeRelatorio) throws Exception {
        
        String sql = "SELECT * FROM clientes";
        
        Connection conn = Conexao.conectar();
        
        PreparedStatement comando = conn.prepareStatement(sql);
        
        ResultSet consulta = comando.executeQuery();
        
        // inicia um documento
        Document doc = new Document();   
        
        PdfPTable table = new PdfPTable(4);
        
        try {
            // inicia um escritor de pdf passando o documento e um outputStream
            PdfWriter.getInstance(doc, new FileOutputStream(nomeRelatorio + ".pdf"));
            // abre o documento
            doc.open();
            // escreve o documento
            doc.add(new Paragraph("Lista de Clientes"));
            // inicia uma tabela com 4 colunas
            
            // inicia uma célula de uma coluna e assim sussessivamente
            PdfPCell coluna1 = new PdfPCell(new Paragraph("Id"));
            coluna1.setBackgroundColor(BaseColor.DARK_GRAY);
            PdfPCell coluna2 = new PdfPCell(new Paragraph("Nome"));
            coluna1.setBackgroundColor(BaseColor.DARK_GRAY);
            PdfPCell coluna3 = new PdfPCell(new Paragraph("Endereço"));
            coluna1.setBackgroundColor(BaseColor.DARK_GRAY);
            PdfPCell coluna4 = new PdfPCell(new Paragraph("Celular"));
            coluna1.setBackgroundColor(BaseColor.DARK_GRAY);
            table.addCell(coluna1);
            table.addCell(coluna2);
            table.addCell(coluna3);
            table.addCell(coluna4);
            
        } catch (FileNotFoundException | DocumentException ex) {
            System.out.println("Erro na geração do PDF: " + ex);
        } finally {
            doc.close();
        }
         
        Cliente c = new Cliente();
        
        while (consulta.next()) {       
            c.setId(consulta.getInt("id"));
            c.setNome(consulta.getString("nome"));
            c.setEndereco(consulta.getString("endereco"));
            c.setCelular(consulta.getString("celular"));
            table.addCell(Integer.toString(c.getId()));
            table.addCell(c.getNome());
            table.addCell(c.getEndereco());
            table.addCell(c.getCelular());
        }
        
        
        
        // comando para abrir o documento assim que criado
        try {
            Desktop.getDesktop().open(new File(nomeRelatorio + ".pdf"));
        } catch (IOException ex) {
            Logger.getLogger(GerarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

// SETA O FORMATO DA PÁGINA
// doc.setPageSize(PageSize.A3);

// SETA COR DE FUNDO
// pageSize.setBackgroundColor(new java.awt.Color(0xFF, 0xFF, 0xDE));

// ADICIONA IMAGEM 
// Image figura = Image.getInstance("C:\\imagem.jpg");
// document.add(figura);