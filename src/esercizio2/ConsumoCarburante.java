package esercizio2;

import esercizio1.ArrayDinamico;
import esercizio1.IndiceNonValido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ConsumoCarburante {
    static Scanner scanner = new Scanner(System.in);

    private final static Logger LOGGER = LoggerFactory.getLogger(ConsumoCarburante.class);

    public static void main(String[] args) {

        System.out.println("Inserisci km fatti dall'auto:");
        int km = scanner.nextInt();

        int litri = 0;
        boolean valoreValido = false;

        // Ciclo per richiedere i litri finché non è valido
        do {
            try {
                System.out.println("Inserisci litri di carburante consumati:");
                litri = scanner.nextInt();
                verificaLitri(litri); // Verifica se il valore è valido
                valoreValido = true; // Esci dal ciclo se il valore è corretto
            } catch (ValoreLitriNonValido e) {
                LOGGER.error(e.getMessage());
                System.out.println("Errore: " + e.getMessage());
            }
        } while (!valoreValido);

        // Calcolo dei km per litro
        int kmPercorsi = km / litri;
        System.out.println("Km percorsi con un litro: " + kmPercorsi);

        scanner.close();
    }

    private static void verificaLitri(int valoreLitri) {
        if (valoreLitri == 0) {
            throw new ValoreLitriNonValido("Il valore dei litri non può essere 0. Riprova.");
        }
    }
}
