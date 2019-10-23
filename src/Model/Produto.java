package Model;

import java.util.Objects;

public class Produto {
    
    private int id;
    private String nome;
    private int quantidadeEstoque;
    private double valorCompra;
    private double valorVenda;
    private String descricao;
    private int quantidadePorPedido; // variável auxiliar para preenchimento dos produtos em pedidos

    public Produto(String nome, double valorCompra, double valorVenda) {
        this.nome = nome;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
    }
    
    public Produto() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadePorPedido() {
        return quantidadePorPedido;
    }

    public void setQuantidadePorPedido(int quantidadePorPedido) {
        this.quantidadePorPedido = quantidadePorPedido;
    }
    

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", quantidadeEstoque=" + quantidadeEstoque + ", valorCompra=" + valorCompra + ", valorVenda=" + valorVenda + ", descricao=" + descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + this.quantidadeEstoque;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.valorCompra) ^ (Double.doubleToLongBits(this.valorCompra) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.valorVenda) ^ (Double.doubleToLongBits(this.valorVenda) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.quantidadeEstoque != other.quantidadeEstoque) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorCompra) != Double.doubleToLongBits(other.valorCompra)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorVenda) != Double.doubleToLongBits(other.valorVenda)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }
}
