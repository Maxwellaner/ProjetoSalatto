package Model;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private int id;
    private Pedido[] pedido;
    private List<Produto> estoque;
    private double desconto;
    private double valorFinal;

    public Venda(Pedido[] pedido) {
        this.pedido = pedido;
    }

}