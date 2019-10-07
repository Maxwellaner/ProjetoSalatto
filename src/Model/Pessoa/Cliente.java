package Model.Pessoa;

import Model.Pessoa.Pessoa;

public class Cliente extends Pessoa {
    
    private int id;

    public Cliente(String nome) {
        this.setNome(nome);
    }
    
    public Cliente() {
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + "nome=" + this.getNome() + "endereço="
                + this.getEndereco() + "celular=" + this.getCelular()
                + "cpf=" + this.getCPF() + "telefone=" + this.getTelefone()
                + "email=" + this.getEmail() + '}';
    }
    
}