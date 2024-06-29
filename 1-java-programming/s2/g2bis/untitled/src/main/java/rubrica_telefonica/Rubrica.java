package rubrica_telefonica;

import java.util.*;

public class Rubrica {

    private final Map<String, String> listaContatti = new HashMap<>();

    public void inserisciContatto(String nome, String numero) {
        listaContatti.put(nome, numero);
    }

    public void rimuoviContatto(String nome) {
        listaContatti.remove(nome);
    }

    // i valori non sono univoci come le chiavi pertanto restituirò una lista anziché
    // la prima occorrenza. Più nomi possono avere lo stesso numero di telefono

    public List<String> cercaPersonePerNumero(String numero) {
        Set<String> keySet = listaContatti.keySet();
        List<String> persone = new ArrayList<>();
        for (String nome : keySet) {
            if (listaContatti.get(nome).equals(numero))
                persone.add(nome);
        }
        return persone;
    }

    public String cercaNumeroPerPersona (String persona) {
        return listaContatti.get(persona);
    }

    public void stampaListaContatti() {
        Set<String> keySet = listaContatti.keySet();
        keySet.stream().forEach(key -> {
            System.out.println("Nome: " + key);
            System.out.println("Numero" + cercaNumeroPerPersona(key) + "\n");
        });
    }

}
