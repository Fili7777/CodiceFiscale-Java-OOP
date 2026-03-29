# 🇮🇹 Calcolatore Codice Fiscale - Java OOP

Applicativo Java per il calcolo del **Codice Fiscale italiano**. Il progetto utilizza un'architettura orientata agli oggetti (OOP) e gestisce i dati dei comuni tramite un database in formato CSV.

---

### Funzionalità
- **Calcolo completo:** Generazione del codice a 16 caratteri dai dati anagrafici.
- **Database Comuni:** Ricerca automatica del codice Belfiore da un file con oltre 8.000 comuni.
- **Validazione:** Controllo formale degli input (nomi, date, sesso).
- **Carattere di Controllo:** Algoritmo integrato per il calcolo dell'ultima lettera (carattere di controllo).

---

### Struttura del Progetto
Il codice è organizzato in modo professionale seguendo la struttura standard:

```text
CodiceFiscale-Java-OOP/
├── src/
│   └── main/
│       ├── java/           # Codice sorgente (.java)
│       │   ├── Main.java
│       │   ├── CognomeNome.java
│       │   ├── DataNascita.java
│       │   ├── CodiceCatastale.java
│       │   ├── CodiceControllo.java
│       │   └── Mappature.java
│       └── resources/      # File esterni (.csv)
│           └── CodiciCatastali.csv
├── LICENSE
└── README.md
