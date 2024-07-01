package classes;

import interfaces.Dipartimento;

public class DipartimentoInformatica implements Dipartimento {

    private String nome;

    public DipartimentoInformatica() {}

    public DipartimentoInformatica(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void stampaNomeDipartimento() {
        System.out.print(nome);
    }
}
