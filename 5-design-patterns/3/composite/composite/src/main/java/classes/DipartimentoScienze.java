package classes;

import interfaces.Dipartimento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DipartimentoScienze implements Dipartimento {

    private final List<Dipartimento> sottoDipartimenti = new ArrayList<>();

    private String nome;

    public DipartimentoScienze() {}

    public DipartimentoScienze(String nome, Dipartimento... sottoDipartimenti) {
        this.nome = nome;
        this.sottoDipartimenti.addAll(Arrays.asList(sottoDipartimenti));
    }

    @Override
    public void stampaNomeDipartimento() {
        System.out.println("Dipartimento: " + nome);
        System.out.print("Sottodipartimenti: ");
        for (int i = 0; i < sottoDipartimenti.size(); i++) {
            sottoDipartimenti.get(i).stampaNomeDipartimento();
            if (i < sottoDipartimenti.size() - 1) System.out.print(", ");
        }

    }
}
