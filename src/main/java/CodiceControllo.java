public class CodiceControllo {

    String CF = "";
    private String pari = "";
    private String dispari = "";
    
    public CodiceControllo(String CF){
        this.CF = CF;
        convertiPariDispari();
    }

    private void convertiPariDispari(){
        int i = 0;
        for(char c : CF.toCharArray()){
            
            if( i%2 == 0){
                dispari += c;
            }
            else{
                pari += c;
            }
            i++;
        }
    }

    public String getDispari(){
        
        return dispari;
    }
    public String getPari(){
        
        return pari;
    }

    private int sommaDispari(){
        int somma = 0;
        for(char c : dispari.toCharArray()){
            somma += Mappature.mappaDispari.get(c);
        }
        return somma;
    }
    private int sommaPari(){
        int somma = 0;
        for(char c : pari.toCharArray()){
            somma += Mappature.mappaPari.get(c);
        }
        return somma;
    }
    public char calcolaCodiceControllo(){
        int somma = sommaPari() + sommaDispari();
        int i = 1;
        int valore = 0;
        while(26 * i <= somma){
            valore = 26 * i;
            i++;
            
        }
        int resto = somma-valore;
        return Mappature.mappaResto.get(resto);
    }

}
