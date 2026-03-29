public class CognomeNome {
    String nome, cognome;
    String consonanti = "bcdfghjklmnpqrstvwxyz";
    String vocali = "aeiou";

    public CognomeNome(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }

    public String cognome() {
        String CCF = "";
        int numConsonanti = contaConsonanti(cognome);
        int numVocali = contaVocali(cognome);

        //1 caso: Se il cognome contiene tre o più consonanti, i tre caratteri da rilevare sono, nell'ordine, la prima, 
        // la seconda e la terza consonante.

        if (numConsonanti >= 3) {
            int consonantCount = 0;
            for (int i = 0; i < cognome.length(); i++) {
                char ch = cognome.charAt(i); // Ottieni il carattere corrente

                // Controlla se il carattere è una consonante
                if (consonanti.indexOf(ch) != -1) {
                    CCF += ch; // Aggiungi la consonante a CCF
                    consonantCount++;
                }
                if(consonantCount == 3){
                    break;
                }
            }
        }

        //2 caso: Se il cognome contiene due consonanti, i tre caratteri da rilevare sono, nell'ordine, la prima e la seconda 
        //consonante e la prima vocale.
        //Se il cognome contiene una consonante e due vocali, si rilevano, nell'ordine, quella consonante e quindi la prima e la seconda vocale.

        else if(numConsonanti == 2 || numConsonanti == 1 && numVocali == 2){
            int Count = 0;
            //PRIMO CICLO ALLORA PRENDIAMO LE CONSONANTI ( SE PRESENTI)
            for (int i = 0; i < cognome.length(); i++) {
                char ch = cognome.charAt(i); // Ottieni il carattere corrente

                // Controlla se il carattere è una consonante
                if (consonanti.indexOf(ch) != -1) {
                    CCF += ch; // Aggiungi la consonante a CCF
                    Count++;
                }
            }
            //ORA PRENDIAMO LE VOCALI
            for (int i = 0; i < cognome.length(); i++) {
                char ch = cognome.charAt(i); // Ottieni il carattere corrente
                if (vocali.indexOf(ch) != -1) {
                    CCF += ch; // Aggiungi la vocale a CCF
                    Count++;
                }

                if(Count == 3){
                    break;
                }

            }

        }
        //3 caso: Se il cognome contiene una consonante e una vocale, si rilevano la consonante e la vocale, nell'ordine, 
        // e si assume come terzo carattere la lettera x.

        else if(numConsonanti == 1 && numVocali == 1){
            for (int i = 0; i < cognome.length(); i++) {
                char ch = cognome.charAt(i); // Ottieni il carattere corrente

                if (consonanti.indexOf(ch) != -1) {
                    CCF += ch;
                }
                else if(vocali.indexOf(ch) != -1){
                    CCF += ch;
                }


            }
            //infine aggiungiamo la x
            CCF += "X";
        }
       // Se il cognome e' costituito da due sole vocali, esse si rilevano, nell'ordine, e si assume come terzo
        //carattere la lettera x (ics).
        else if(numConsonanti == 1 && numVocali > 2){
            int contare = 0;
            for (int i = 0; i < cognome.length(); i++) {
                char ch = cognome.charAt(i); // Ottieni il carattere corrente

                if (consonanti.indexOf(ch) != -1) {
                    CCF += ch;
                }
                else if(vocali.indexOf(ch) != -1){
                    CCF += ch;
                }

                contare++;
                if(contare == 3){
                    break;
                }


            }
        }
        //altrimenti ... 
        else{
            CCF = cognome;
            while (CCF.length() < 3) {
                CCF += "X";
            }
            
        }

        return CCF;
    }
    public String nome(){
        String NCF = "";
        int numConsonanti = contaConsonanti(nome);
        int numVocali = contaVocali(nome);

        //1 caso: Se il nome contiene quattro o più consonanti, i tre caratteri da rilevare sono, nell'ordine, la prima,
        // la terza e la quarta consonante.

        if(numConsonanti >= 4){
            //rimuoviamo tutte le vocali dal nome
            String regex = "[" + vocali + "]";
            nome = nome.replaceAll(regex, "");

            NCF += nome.charAt(0);
            NCF += nome.charAt(2);
            NCF += nome.charAt(3);
        }
        //2 caso: Se il nome contiene tre consonanti, i tre caratteri da rilevare sono, nell'ordine, la prima, la seconda e la
        //terza consonante.
        else if(numConsonanti == 3){
            //rimuoviamo tutte le vocali dal nome
            String regex = "[" + vocali + "]";
            nome = nome.replaceAll(regex, "");

            NCF += nome.charAt(0);
            NCF += nome.charAt(1);
            NCF += nome.charAt(2);
        }
        /*caso 3 :
        Se il nome contiene due consonanti, i tre caratteri da rilevare sono, nell'ordine, la prima e la seconda consonante e la prima vocale.
        Se il nome contiene una consonante e due vocali, i tre caratteri da rilevare sono, nell'ordine, quella consonante e quindi la prima e la seconda vocale.
            */
        else if(numConsonanti == 2 || numConsonanti == 1 && numVocali == 2){
            //PRIMO CICLO ALLORA PRENDIAMO LE CONSONANTI
            int Count = 0;
            for(int i = 0; i < nome.length(); i++){


                char ch = nome.charAt(i); // Ottieni il carattere corrente

                // Controlla se il carattere è una consonante
                if (consonanti.indexOf(ch) != -1) {
                    NCF += ch; // Aggiungi la consonante a ncf
                    Count++;
                }
            }
            //ORA PRENDIAMO LE VOCALI
            for (int i = 0; i < nome.length(); i++) {
                char ch = nome.charAt(i); // Ottieni il carattere corrente
                if (vocali.indexOf(ch) != -1) {
                    NCF += ch; // Aggiungi la vocale a ncf
                    Count++;
                }

                if(Count == 3){
                    break;
                }

            }

        }
        //4 CASO: Se il nome contiene una consonante e una vocale, si rilevano la consonante e la vocale, nell'ordine, e si
        //assume come terzo carattere la lettera x
        else if(numConsonanti == 1 && numVocali == 1){
            if(consonanti.indexOf(nome.charAt(0)) != -1){
                NCF += nome.charAt(0);
                NCF += nome.charAt(1);
            }else{
                NCF += nome.charAt(1);
                NCF += nome.charAt(0);
            }
            NCF += "X"; //x finale
        }
        else if(numConsonanti == 1 && numVocali > 2){
            int contare = 0;
            for (int i = 0; i < nome.length(); i++) {
                char ch = nome.charAt(i); // Ottieni il carattere corrente

                if (consonanti.indexOf(ch) != -1) {
                    NCF += ch;
                }
                else if(vocali.indexOf(ch) != -1){
                    NCF += ch;
                }

                contare++;
                if(contare == 3){
                    break;
                }


            }
        }

        else{
            NCF += nome;
                while (NCF.length() < 3) {
                    NCF += "X";
                }
        }
        return NCF;
    }



    private int contaConsonanti(String variabile) {
        int count = 0;

        variabile = variabile.toLowerCase();

        // Ciclo su ogni carattere della stringa
        for (int i = 0; i < variabile.length(); i++) {
            char ch = variabile.charAt(i);
            // Se il carattere è una consonante, incrementa il conteggio
            if (consonanti.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    
    private int contaVocali(String variabile) {
        int count = 0;

        variabile = variabile.toLowerCase();

        // Ciclo su ogni carattere della stringa
        for (int i = 0; i < variabile.length(); i++) {
            char ch = variabile.charAt(i);
            // Se il carattere è una consonante, incrementa il conteggio
            if (vocali.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}
