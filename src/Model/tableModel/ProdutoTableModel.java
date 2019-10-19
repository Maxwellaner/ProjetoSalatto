package Model.tableModel;

import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel {

    private List<Produto> produtos = new ArrayList<>();
    private List quantidade = new ArrayList<>();
    private String[] colunas = {"Produtos", "Quantidade"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return produtos.get(linha);
            case 1:
                return quantidade.get(linha);
        }
        return null;
    }

    public void addRow(Produto p, int qnt) {
        this.produtos.add(p);
        this.quantidade.add(qnt);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.produtos.remove(linha);
        this.quantidade.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(List quantidade) {
        this.quantidade = quantidade;
    }
}
