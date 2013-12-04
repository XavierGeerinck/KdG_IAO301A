      *************************************************************
      * VOEG KLANT TOE
      *
      * LAAT TOE OM EEN KLANT TOE TE VOEGEN AAN HET KLANTENBESTAND
      * VIA DE STANDARD INPUT
      *
      *************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. VOEGKLANTTOE.

       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT OPTIONAL KLANTEN ASSIGN TO "BESTANDEN/KLANTEN"
                  ACCESS MODE IS RANDOM
                  ORGANIZATION IS INDEXED
                  RECORD KEY IS NR.

       DATA DIVISION.
       FILE SECTION.
       FD  KLANTEN BLOCK CONTAINS 10 RECORDS.
       01  KLANT.
           02 NR       PIC 9(7).
           02 NAAM     PIC X(20).
           02 STRAAT   PIC X(30).
           02 POSTCODE PIC X(8).
           02 GEMEENTE PIC X(20).
           02 TEL      PIC X(13).

       PROCEDURE DIVISION.

       MAIN.
           PERFORM INITIALISEER
           PERFORM LEES-KLANT-IN
           PERFORM BEWAAR-KLANT
           PERFORM SLUIT-BESTAND
           STOP RUN.

       INITIALISEER.
           MOVE ZEROS TO KLANT
           OPEN I-O KLANTEN.

       LEES-KLANT-IN.
           DISPLAY "GEEF KLANTNUMMER OP:"
           ACCEPT NR
           DISPLAY "GEEF DE NAAM OP:"
           ACCEPT NAAM
           DISPLAY "GEEF DE STRAAT EN NUMMER:"
           ACCEPT STRAAT
           DISPLAY "GEEF DE POSTCODE:"
           ACCEPT POSTCODE
           DISPLAY "GEEF DE GEMEENTE:"
           ACCEPT GEMEENTE
           DISPLAY "GEEF HET TELEFOONNUMMER:"
           ACCEPT TEL.

       BEWAAR-KLANT.
           WRITE KLANT INVALID KEY PERFORM FOUT
           END-WRITE.

       SLUIT-BESTAND.
           CLOSE KLANTEN.

       FOUT.
           DISPLAY "ER IS EEN FOUT OPGETREDEN"
           STOP RUN.

