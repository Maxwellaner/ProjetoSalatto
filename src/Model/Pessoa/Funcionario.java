package Model.Pessoa;

import Model.Pessoa.Pessoa;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    
    private String cargo;
    private double salario;
    private LocalDate admissao;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getAdmissao() {
        return admissao;
    }

    public void setAdmissao(LocalDate admissao) {
        this.admissao = admissao;
    }
    
}
