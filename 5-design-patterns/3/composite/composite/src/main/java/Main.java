import classes.DipartimentoInformatica;
import classes.DipartimentoMatematica;
import classes.DipartimentoScienze;
import interfaces.Dipartimento;

public class Main {

    public static void main(String[] args) {

        Dipartimento dipartimentoInformaticaTrieste =
                new DipartimentoInformatica("Dipartimento di Informatica di Trieste");

        dipartimentoInformaticaTrieste.stampaNomeDipartimento();
        System.out.println();

        Dipartimento dipartimentoMatematicaTrieste =
                new DipartimentoMatematica("Dipartimento di Matematica di Trieste");
        dipartimentoMatematicaTrieste.stampaNomeDipartimento();
        System.out.println();

        dipartimentoMatematicaTrieste.stampaNomeDipartimento();

        Dipartimento dipartimentoScienzeTrieste =
                new DipartimentoScienze(
                        "Dipartimento di Scienze di Trieste",
                        dipartimentoMatematicaTrieste, dipartimentoInformaticaTrieste
                );

        dipartimentoScienzeTrieste.stampaNomeDipartimento();


    }

}
