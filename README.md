# CodiceFiscale-Java-OOP

> 🇮🇹 [Versione Italiana](#versione-italiana) | 🇬🇧 [English Version](#english-version)

---

<a name="versione-italiana"></a>
## 🇮🇹 Versione Italiana

Applicativo Java per il calcolo del **Codice Fiscale italiano**. Sviluppato con architettura orientata agli oggetti (OOP) e lettura dei codici catastali dei comuni italiani tramite file CSV.

### Cos'è il Codice Fiscale?

Il Codice Fiscale è un codice alfanumerico di 16 caratteri utilizzato in Italia per identificare univocamente i cittadini. È composto da:

| Posizione | Caratteri | Descrizione |
|-----------|-----------|-------------|
| 1–3       | 3 lettere | Cognome |
| 4–6       | 3 lettere | Nome |
| 7–8       | 2 cifre   | Anno di nascita (ultime due cifre) |
| 9         | 1 lettera | Mese di nascita (codice lettera) |
| 10–11     | 2 cifre   | Giorno di nascita (+40 per le donne) |
| 12–15     | 1 lettera + 3 cifre | Codice catastale del comune/stato di nascita |
| 16        | 1 carattere | Carattere di controllo |

#### Regole di calcolo

**Cognome (posizioni 1–3):**
- Si estraggono prima le consonanti, poi le vocali.
- Se i caratteri sono meno di 3, si aggiunge `X` come riempitivo.

**Nome (posizioni 4–6):**
- Se il nome ha 4 o più consonanti, si prendono la 1ª, 3ª e 4ª consonante.
- Se ha esattamente 3 consonanti, si usano tutte e 3.
- Altrimenti: consonanti + vocali + `X` come riempitivo.

**Anno di nascita (posizioni 7–8):**
- Ultime due cifre dell'anno (es. `1990` → `90`).

**Mese di nascita (posizione 9):**

| Mese | Codice | Mese | Codice |
|------|--------|------|--------|
| Gennaio   | A | Luglio    | L |
| Febbraio  | B | Agosto    | M |
| Marzo     | C | Settembre | P |
| Aprile    | D | Ottobre   | R |
| Maggio    | E | Novembre  | S |
| Giugno    | H | Dicembre  | T |

**Giorno di nascita e sesso (posizioni 10–11):**
- Maschi: giorno di nascita (es. `05`).
- Femmine: giorno di nascita + 40 (es. `05` → `45`).

**Codice catastale (posizioni 12–15):**
- Letto da file CSV contenente i comuni italiani e i relativi codici Belfiore (es. `F205` per Milano).

**Carattere di controllo (posizione 16):**
- Calcolato sommando i valori dei caratteri in posizione dispari e pari secondo tabelle predefinite, quindi applicando il modulo 26 per ottenere la lettera finale.

---

### Funzionalità

- ✅ Calcolo del Codice Fiscale a partire dai dati anagrafici
- ✅ Architettura OOP con classi ben definite
- ✅ Lettura del codice catastale del comune da file CSV
- ✅ Supporto per comuni italiani e stati esteri
- ✅ Calcolo del carattere di controllo
- ✅ Gestione di nomi e cognomi con caratteri speciali

---

### Struttura del Progetto

```
CodiceFiscale-Java-OOP/
├── Main.java                  # Punto di ingresso e lettura input da console
├── CognomeNome.java           # Estrazione dei 3 caratteri da cognome e nome
├── DataNascita.java           # Codifica anno, mese e giorno di nascita
├── CodiceCatastale.java       # Lettura del CSV e ricerca del codice catastale
├── CodiceControllo.java       # Calcolo del carattere di controllo
├── Mappature.java             # Tabelle di mappatura per il carattere di controllo
├── CodiciCatastali.csv        # Database dei comuni italiani con codici catastali
├── .gitignore
├── LICENSE
└── README.md
```

#### Descrizione delle Classi Principali

| Classe | Responsabilità |
|--------|----------------|
| `Main` | Legge i dati da console, orchestra il calcolo e stampa il codice fiscale |
| `CognomeNome` | Estrae i 3 caratteri del codice dal cognome e dal nome |
| `DataNascita` | Calcola anno, mese e giorno codificati (giorno +40 per le donne) |
| `CodiceCatastale` | Legge il file CSV e restituisce il codice Belfiore del comune |
| `CodiceControllo` | Calcola il carattere di controllo in base alle posizioni pari/dispari |
| `Mappature` | Contiene le tabelle statiche di mappatura per il calcolo del carattere di controllo |

---

### Formato del File CSV

Il file `CodiciCatastali.csv` contiene i codici catastali dei comuni italiani nel seguente formato (senza riga di intestazione):

```csv
A001,ABANO TERME,PD
F205,MILANO,MI
H501,ROMA,RM
F839,NAPOLI,NA
...
```

| Colonna | Descrizione |
|---------|-------------|
| 1ª | Codice Belfiore (1 lettera + 3 cifre) |
| 2ª | Nome del comune (maiuscolo) |
| 3ª | Sigla della provincia (2 lettere) |

---

### Requisiti

- **Java** 11 o superiore
- **Maven** 3.6+ (opzionale, per la gestione delle dipendenze)

---

### Come Compilare ed Eseguire

#### Compilazione con `javac`

```bash
# Clonare il repository
git clone https://github.com/Fili7777/CodiceFiscale-Java-OOP.git
cd CodiceFiscale-Java-OOP

# Compilare i sorgenti
javac *.java

# Eseguire l'applicazione
java Main
```

#### Compilazione con Maven

```bash
# Compilare il progetto
mvn compile

# Eseguire i test
mvn test

# Creare il JAR eseguibile
mvn package

# Eseguire il JAR
java -jar target/CodiceFiscale-Java-OOP.jar
```

---

### Esempio di Utilizzo

L'applicazione viene eseguita da terminale e richiede i dati in modo interattivo:

```text

Questo progetto è distribuito sotto licenza **MIT**. Consulta il file [LICENSE](LICENSE) per i dettagli.

---
---

<a name="english-version"></a>
## 🇬🇧 English Version

A Java application to calculate the **Italian Fiscal Code (Codice Fiscale)**. Developed using Object-Oriented Programming (OOP) principles, with Italian municipality codes read from a CSV file.

### What is the Codice Fiscale?

The Italian Fiscal Code (*Codice Fiscale*) is a 16-character alphanumeric code used in Italy to uniquely identify citizens. It is structured as follows:

| Position | Characters | Description |
|----------|------------|-------------|
| 1–3      | 3 letters  | Surname |
| 4–6      | 3 letters  | First name |
| 7–8      | 2 digits   | Birth year (last two digits) |
| 9        | 1 letter   | Birth month (letter code) |
| 10–11    | 2 digits   | Birth day (+40 for females) |
| 12–15    | 1 letter + 3 digits | Cadastral code of the municipality/country of birth |
| 16       | 1 character | Check character |

#### Calculation Rules

**Surname (positions 1–3):**
- Consonants are extracted first, then vowels.
- If fewer than 3 characters are available, `X` is used as padding.

**First name (positions 4–6):**
- If the name has 4 or more consonants, use the 1st, 3rd, and 4th consonant.
- If it has exactly 3 consonants, use all three.
- Otherwise: consonants + vowels + `X` padding.

**Birth year (positions 7–8):**
- Last two digits of the year (e.g. `1990` → `90`).

**Birth month (position 9):**

| Month | Code | Month | Code |
|-------|------|-------|------|
| January   | A | July      | L |
| February  | B | August    | M |
| March     | C | September | P |
| April     | D | October   | R |
| May       | E | November  | S |
| June      | H | December  | T |

**Birth day and gender (positions 10–11):**
- Males: birth day (e.g. `05`).
- Females: birth day + 40 (e.g. `05` → `45`).

**Cadastral code (positions 12–15):**
- Read from a CSV file containing Italian municipalities and their Belfiore codes (e.g. `F205` for Milan).

**Check character (position 16):**
- Computed by summing the values of characters in odd and even positions using predefined lookup tables, then applying modulo 26 to obtain the final letter.

---

### Features

- ✅ Fiscal code generation from personal data
- ✅ OOP architecture with well-defined classes
- ✅ Municipality cadastral code lookup from CSV file
- ✅ Support for Italian municipalities and foreign countries
- ✅ Check character calculation
- ✅ Handling of names with special characters

---

### Project Structure

```
CodiceFiscale-Java-OOP/
├── Main.java                  # Entry point and console input handling
├── CognomeNome.java           # Extracts 3 characters from surname and first name
├── DataNascita.java           # Encodes birth year, month, and day
├── CodiceCatastale.java       # Reads the CSV and looks up the cadastral code
├── CodiceControllo.java       # Calculates the check character
├── Mappature.java             # Static lookup tables for check character calculation
├── CodiciCatastali.csv        # Italian municipality database with cadastral codes
├── .gitignore
├── LICENSE
└── README.md
```

#### Main Classes

| Class | Responsibility |
|-------|----------------|
| `Main` | Reads input from the console, orchestrates the calculation, and prints the result |
| `CognomeNome` | Extracts the 3-character code from the surname and the first name |
| `DataNascita` | Encodes year, month, and day (day +40 for females) |
| `CodiceCatastale` | Reads the CSV file and returns the Belfiore code for the municipality |
| `CodiceControllo` | Computes the check character based on odd/even character positions |
| `Mappature` | Contains the static mapping tables used for check character calculation |

---

### CSV File Format

The `CodiciCatastali.csv` file contains the cadastral codes for Italian municipalities in the following format (no header row):

```csv
A001,ABANO TERME,PD
F205,MILANO,MI
H501,ROMA,RM
F839,NAPOLI,NA
...
```

| Column | Description |
|--------|-------------|
| 1st | Belfiore code (1 letter + 3 digits) |
| 2nd | Municipality name (uppercase) |
| 3rd | Province abbreviation (2 letters) |

---

### Requirements

- **Java** 11 or higher
- **Maven** 3.6+ (optional, for dependency management)

---

### How to Build and Run

#### Compile with `javac`

```bash
# Clone the repository
git clone https://github.com/Fili7777/CodiceFiscale-Java-OOP.git
cd CodiceFiscale-Java-OOP

# Compile source files
javac *.java

# Run the application
java Main
```

#### Compile with Maven

```bash
# Build the project
mvn compile

# Run tests
mvn test

# Create executable JAR
mvn package

# Run the JAR
java -jar target/CodiceFiscale-Java-OOP.jar
```

---

### Usage Example

The application runs from the terminal and prompts for input interactively:

```text
=== CALCOLATORE CODICE FISCALE ===
Inserisci nome: Mario
Inserisci cognome: Rossi
Sesso (M/F): M
Data di nascita (GG/MM/AAAA): 01/01/1990
Provincia (es. NA): MI
Comune: MILANO

IL TUO CODICE FISCALE E': RSSMRA90A01F205X
```

---

### License

This project is distributed under the **MIT** license. See the [LICENSE](LICENSE) file for details.
