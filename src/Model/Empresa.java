package Model;

import java.sql.Date;

public class Empresa {
    
    private int id;
    private String nomeFantasia;
    private String razaoSocial;
    private String celularComercial;
    private String telefoneComercial;
    private Date dataContrato;
    private String emailComercial;
    private String cnpj;
    private String endereco;

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCelularComercial() {
        return celularComercial;
    }

    public void setCelularComercial(String celularComercial) {
        this.celularComercial = celularComercial;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public String getEmailComercial() {
        return emailComercial;
    }

    public void setEmailComercial(String emailComercial) {
        this.emailComercial = emailComercial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial + ", celularComercial=" + celularComercial + ", telefoneComercial=" + telefoneComercial + ", dataContrato=" + dataContrato + ", emailComercial=" + emailComercial + ", cnpj=" + cnpj + ", endereco=" + endereco + '}';
    }
    
}
