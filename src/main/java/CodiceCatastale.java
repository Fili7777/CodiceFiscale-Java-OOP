import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CodiceCatastale  {
    String comune, provincia;
    private String CodiceCatastale = "";

    public CodiceCatastale(String comune, String provincia){
        this.comune = comune;
        this.provincia = provincia;
    }

    public void leggiCodici() {
    try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/CodiciCatastali.csv"))){
        String line;
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String Comun = parts[1];
            String Provin = parts[2];

            if(Comun.equals(comune) && Provin.equals(provincia)){
                CodiceCatastale = parts[0];
                break;
            }
           
        }
        

        
        if (CodiceCatastale == "") {
            System.out.println("Ricerco codice catastale");
            try{

                for(int i = 0; i < 3; i++){
                    Thread.sleep(550);
                    System.out.print(".");
                }
                System.out.println();
                System.out.println("CODICE CATASTALE NON TROVATO!");
                System.out.println("------------------------ \ncontinuo calcolo codice fiscale");
                
                
                for(int i = 0; i < 3; i++){
                    Thread.sleep(500);
                    System.out.print(".");
                }
                System.out.println();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        
    } catch (IOException e) {
        System.out.println("Errore nel caricamento dei codici: " + e.getMessage());
    }
}


    public String getCodiceCatastale(){  
        return CodiceCatastale;
    }

}
