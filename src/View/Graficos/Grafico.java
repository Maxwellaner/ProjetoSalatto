package View.Graficos;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Grafico {
    
    public static void graficoPizza() {
        
        // cria o modelo do gráfico com as camadas e informações
        DefaultPieDataset pizza = new DefaultPieDataset();
        // Titulo e valor
        pizza.setValue("Brasil", 5);
        pizza.setValue("Alemanha", 4);
        pizza.setValue("Itália", 4);
        
        // cria o grafico. Passa o titulo, o modelo, legendas visíveis (true ou false), tooltip (mouse em cima, true ou false), url (true ou false)
        JFreeChart grafico = ChartFactory.createPieChart("Campeões Mundiais", pizza, true, true, false);
        // cria o painel para adicionar o gráfico
        ChartPanel painelGrafico = new ChartPanel(grafico);
        
    }
    
}
