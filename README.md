# ElektroNet

Desktop aplikacija za upravljanje računima za električnu energiju. Napisana u Javi sa Swing GUI-jem i MySQL bazom podataka.

## O projektu

ElektroNet je sistem za evidenciju korisnika, računa i plaćanja električne energije. Administrator može dodavati nove korisnike i kreirati račune, dok korisnici mogu pregledati svoje račune i izvršiti plaćanje.

## Funkcionalnosti

**Admin:**
- Kreiranje novih korisnika
- Pregled svih korisnika u sistemu
- Kalkulacija računa za korisnike
- Pregled depozita i uplate

**Korisnik:**
- Pregled računa
- Plaćanje računa (fizički i online)
- Štampanje računa
- Ažuriranje ličnih podataka

## Tehnologije

- Java (Swing GUI)
- MySQL baza podataka
- JDBC za konekciju
- rs2xml biblioteka

## Instalacija

### Potrebno

- Java JDK 17 ili noviji
- MySQL Server 8.0+
- MySQL Connector/J JAR fajl
- rs2xml.jar biblioteka

### Preuzimanje biblioteka

Dodaj u `lib/` folder:

**MySQL Connector/J:**
- Fajl: `mysql-connector-j-8.0.33.jar`
- Link: https://dev.mysql.com/downloads/connector/j/
- Direktan link: https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.0.33/mysql-connector-j-8.0.33.jar

**rs2xml:**
- Fajl: `rs2xml.jar`
- Link: https://sourceforge.net/projects/finalangelsanddemons/files/rs2xml.jar/download

### Setup koraci

1. Kloniraj projekat
```bash
git clone https://github.com/your-username/ElektroNet.git
cd ElektroNet
```

2. Kreiraj MySQL bazu
```sql
CREATE DATABASE Elektro_net;
```

3. Importuj SQL strukturu
```bash
mysql -u root -p Elektro_net < ElektroNet/elektronet_database.sql
```

4. Podesi kredencijale

U `ElektroNet/src/ElektroNet/database.java` izmeni:
```java
connection = DriverManager.getConnection(url, "root", "tvoja_lozinka");
```

5. Kompajliranje
```bash
javac -cp ".;lib\rs2xml.jar;lib\mysql-connector-j-8.0.33.jar" ElektroNet\src\ElektroNet\*.java
```

6. Pokretanje
```bash
java -cp ".;lib\rs2xml.jar;lib\mysql-connector-j-8.0.33.jar;ElektroNet\src" ElektroNet.SplashScreen
```

## Struktura projekta

```
ElektroNet/
├── ElektroNet/
│   ├── src/ElektroNet/     - Java source fajlovi
│   ├── src/icons/          - Slike i ikonice
│   └── elektronet_database.sql - SQL skripta
└── lib/                    - Eksterni JAR fajlovi
```

## Setup u IntelliJ IDEA

1. Otvori projekat u IntelliJ
2. File → Project Structure → Modules → Dependencies
3. Klikni + → JARs or Directories
4. Dodaj `mysql-connector-j-8.0.33.jar` i `rs2xml.jar`
5. Apply → OK

## Bezbednost

- Koristi PreparedStatement za SQL upite (zaštita od SQL Injection)
- Pravilno zatvaranje resursa (Connection, Statement, ResultSet)
- Validacija korisničkih unosa
- Error handling sa jasnim porukama

## Troubleshooting

Ako se pojave greške:
- Proveri da li je MySQL server pokrenut
- Proveri kredencijale u database.java
- Uveri se da su JAR fajlovi u classpath-u
- Pogledaj error log u konzoli

## Doprinošenje

Pull request-ovi su dobrodošli. Za veće izmene otvori Issue da se diskutuje.

Pravila:
- Koristi Java konvencije za imenovanje
- Dodaj komentare gde je potrebno
- Uvek koristi PreparedStatement za SQL
- Zatvori sve resurse
- Testiraj kod pre PR-a

## Licenca

MIT

## Kontakt

Za pitanja ili probleme otvori Issue na GitHub-u.
