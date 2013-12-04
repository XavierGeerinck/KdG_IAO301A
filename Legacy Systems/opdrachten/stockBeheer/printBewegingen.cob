       IDENTIFICATION DIVISION.
       PROGRAM-ID. PRINT-BEWEGINGEN.
       AUTHOR. XAVIER.

       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT Bewegingen ASSIGN TO "BESTANDEN/BEWEGINGEN.DAT".

       DATA DIVISION.
       FILE SECTION.
       FD Bewegingen BLOCK CONTAINS 10 RECORDS.
       01 BEWEGING.
           02 PRODNR     PIC X(6).
           02 CHANGE     PIC S9(5).
       WORKING-STORAGE SECTION.
       77  NRKOP      PIC X(6)  VALUE "PRODNR".
       77  CHANGEKOP  PIC X(6)  VALUE "CHANGE".
       77  GEDAAN     PIC X(1).
           88 STOPLEZEN VALUE "J".

       PROCEDURE DIVISION.

       MAIN.
           PERFORM INITIALISEER
           PERFORM PRINTSTOCK
           PERFORM SLUITBESTAND
           STOP RUN.

       INITIALISEER.
           MOVE ZEROS TO BEWEGING
           MOVE "N" TO GEDAAN
           OPEN INPUT Bewegingen.

       PRINTSTOCK.
           PERFORM PRINTHEADLINES
           DISPLAY "|" NRKOP "|" CHANGEKOP "|"
           PERFORM PRINTHEADLINES
           PERFORM PRINTBEWEGING UNTIL STOPLEZEN
           PERFORM PRINTHEADLINES.

       PRINTHEADLINES.
           DISPLAY "+------+" WITH NO ADVANCING
           PERFORM PRINTMIN 6 TIMES
           DISPLAY "+".

       PRINTMIN.
           DISPLAY "-" WITH NO ADVANCING.

       PRINTBEWEGING.
           READ Bewegingen AT END MOVE "J" TO GEDAAN
           END-READ
           IF NOT STOPLEZEN
               DISPLAY "|" PRODNR "|" CHANGE "|"
           END-IF.

       SLUITBESTAND.
           CLOSE Bewegingen.