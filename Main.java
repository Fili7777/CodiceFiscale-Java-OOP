import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CALCOLATORE CODICE FISCALE ===");

        try (Scanner input = new Scanner(System.in, StandardCharsets.UTF_8)) {
            String nome, cognome, dataNascita, sesso, provincia, comune;

            // Validazione Input
            do {
                System.out.print("Inserisci nome: ");
                nome = input.nextLine().toLowerCase().trim();
            } while(!checkVar(nome));

            do {
                System.out.print("Inserisci cognome: ");
                cognome = input.nextLine().toLowerCase().trim();
            } while(!checkVar(cognome));

            do {
                System.out.print("Sesso (M/F): ");
                sesso = input.nextLine().toUpperCase().trim();
            } while(sesso.isEmpty() || (sesso.charAt(0) != 'M' && sesso.charAt(0) != 'F'));

            do {
                System.out.print("Data di nascita (GG/MM/AAAA): ");
                dataNascita = input.nextLine().trim();
            } while(!checkData(dataNascita));

            System.out.print("Provincia (es. NA): ");
            provincia = input.nextLine().toUpperCase().trim();
            System.out.print("Comune: ");
            comune = input.nextLine().toUpperCase().trim();

            // Esecuzione Logica
            DataNascita dn = new DataNascita(dataNascita, sesso);
            CognomeNome cn = new CognomeNome(nome, cognome);
            CodiceCatastale cc = new CodiceCatastale(comune, provincia);
            cc.leggiCodici();

            String parzialeCF = cn.cognome() + cn.nome() + dn.anno() + dn.mese() + dn.giorno() + cc.getCodiceCatastale();
            CodiceControllo ctrl = new CodiceControllo(parzialeCF.toUpperCase());

            String finale = parzialeCF.toUpperCase() + ctrl.calcolaCodiceControllo();
            System.out.println("\nIL TUO CODICE FISCALE E': " + finale);
        }
    }


    private static boolean checkVar(Object var) {
        if (var instanceof String) {
            String s = (String) var;
            return !s.isEmpty() && s.matches("[a-zA-Z\\s]+");
        }
        return false;
    }

    private static boolean checkData(String data) {
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }
}