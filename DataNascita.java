import java.util.HashMap;
public class DataNascita{
    
    String dataNascita;
    String sesso;

    public DataNascita(String dataNascita,String sesso){
        this.dataNascita = dataNascita;
        this.sesso = sesso;
    }

    public String giorno(){

        String[] numeri = dataNascita.split("/");

        String giorno = numeri[0];

        if(sesso.equals("F")){
            int day = Integer.parseInt(giorno);
            day+=40;
            giorno = Integer.toString(day);
        }
        return giorno;
    }

    public String anno(){

        String[] numeri = dataNascita.split("/");
        
        String anno = numeri[2].substring(2,4);

        return anno;
    }

    private static final HashMap<Integer, Character> MesiCF = new HashMap<>();

    static {
        MesiCF.put(1, 'A');
        MesiCF.put(2, 'B');
        MesiCF.put(3, 'C');
        MesiCF.put(4, 'D');
        MesiCF.put(5, 'E');
        MesiCF.put(6, 'H');
        MesiCF.put(7, 'L');
        MesiCF.put(8, 'M');
        MesiCF.put(9, 'P');
        MesiCF.put(10, 'R');
        MesiCF.put(11, 'S');
        MesiCF.put(12, 'T');
    }

    public char mese(){

        String[] numeri = dataNascita.split("/");

        int mese = Integer.parseInt(numeri[1]);

        return MesiCF.get(mese);
    }
}