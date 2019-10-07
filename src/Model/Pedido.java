package Model;

import Model.Pessoa.Cliente;
import java.sql.Date;
import java.util.List;

public class Pedido {
    
    private int id;
    private Cliente cliente;
    private Empresa empresa;
    private List<Produto> produtos;
    private List quantidade;
    private boolean isPago;
    private double adiantamento;
    private double valorTotal;
    private Date dataPedido;
    private Date dataEntrega;
    private int idCliente;
    private int idEmpresa;
    
    public Pedido(Cliente cliente, List<Produto> listaCompras, List quantidade, 
            boolean isPago, double adiantamento, 
            double valorTotal, Date dataPedido, Date dataEntrega) {
        this.cliente = cliente;
        this.produtos = listaCompras;
        this.quantidade = quantidade;
        this.isPago = isPago;
        this.adiantamento = adiantamento;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
        this.dataEntrega = dataEntrega;
        this.idCliente = cliente.getId();
    }
    
    public Pedido(Empresa empresa, List<Produto> listaCompras, List quantidade,
            boolean isPago, double adiantamento, double valorTotal,
            Date dataPedido, Date dataEntrega) {
        this.empresa = empresa;
        this.produtos = listaCompras;
        this.quantidade = quantidade;
        this.adiantamento = adiantamento;
        this.dataEntrega = dataEntrega;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
        this.isPago = isPago;
        this.idEmpresa = empresa.getId();
    }
    
    public Pedido(Cliente cliente, Empresa empresa, List<Produto> listaCompras,  List quantidade,
            double valorTotal, boolean isPago, double adiantamento, Date dataPedido,
            Date dataEntrega) {
        this.cliente = cliente;
        this.empresa = empresa;
        this.produtos = listaCompras;
        this.quantidade = quantidade;
        this.isPago = isPago;
        this.adiantamento = adiantamento;
        this.valorTotal = valorTotal;
        this.dataEntrega = dataEntrega;
        this.dataPedido = dataPedido;
        this.idCliente = cliente.getId();
        this.idEmpresa = empresa.getId();
    }
    
    public Pedido() {
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    public boolean isIsPago() {
        return isPago;
    }

    public void setIsPago(boolean isPago) {
        this.isPago = isPago;
    }

    public double getAdiantamento() {
        return adiantamento;
    }

    public void setAdiantamento(double adiantamento) {
        this.adiantamento = adiantamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", cliente=" + cliente + ", empresa=" + empresa + ", produtos=" + produtos + ", quantidade=" + quantidade + ", isPago=" + isPago + ", adiantamento=" + adiantamento + ", valorTotal=" + valorTotal + ", dataPedido=" + dataPedido + ", dataEntrega=" + dataEntrega + ", idCliente=" + idCliente + ", idEmpresa=" + idEmpresa + '}';
    }
}
