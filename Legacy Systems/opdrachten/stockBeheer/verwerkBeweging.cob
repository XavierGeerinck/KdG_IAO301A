       IDENTIFICATION DIVISION.
       PROGRAM-ID. VERWERK-BEWEGING.
       AUTHOR. XAVIER.

       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT Stock ASSIGN TO "BESTANDEN/STOCK.DAT"
                  ACCESS MODE IS RANDOM
                  ORGANIZATION IS INDEXED
                  RECORD KEY IS NR IN Stock.

           SELECT OPTIONAL Bewegingen
                  ASSIGN TO "BESTANDEN/BEWEGINGEN.DAT"
                  ACCESS MODE IS RANDOM.

       DATA DIVISION.
       FILE SECTION.
       FD Bewegingen BLOCK CONTAINS 10 RECORDS.
       01  BEWEGING.
           02 PRODNR     PIC X(6).
           02 CHANGE     PIC S9(5).

       FD Stock BLOCK CONTAINS 10 RECORDS.
       01  PRODUCT.
           02 NR       PIC X(6).
           02 NAAM     PIC X(40).
           02 INSTOCK  PIC 9(4).

       WORKING-STORAGE SECTION.
       77 GEDAAN PIC X(1).
           88 STOP-LEZEN VALUE "J".
       77 LEESRESULTAAT PIC X(1).
           88 LEESFOUT VALUE "J".
           88 GEEN-LEESFOUT VALUE "N".
       01 PROD-NAAR.
           02 NR      PIC X(6).
           02 NAAM    PIC X(40).
           02 INSTOCK PIC 9(4).

       PROCEDURE DIVISION.

       MAIN.
           PERFORM INITIALISEER
           PERFORM VERWERK-BEWEGING UNTIL STOP-LEZEN
           PERFORM SLUIT-BESTANDEN
           STOP RUN.

       INITIALISEER.
           MOVE ZEROS TO BEWEGING PRODUCT
           OPEN I-O Stock
           OPEN I-O Bewegingen.

       VERWERK-BEWEGING.
           READ Bewegingen 
               AT END SET STOP-LEZEN TO TRUE
               NOT AT END PERFORM DOESTOCKCHANGE
           END-READ.

       DOESTOCKCHANGE.
           DISPLAY "* STOCKCHANGE OP " WITH NO ADVANCING
           DISPLAY PRODNR IN BEWEGING
           MOVE PRODNR TO NR IN PRODUCT
           SET GEEN-LEESFOUT TO TRUE
           READ Stock INTO PROD-NAAR
               INVALID KEY SET LEESFOUT TO TRUE
           END-READ
           DISPLAY "PRODNAAM: " WITH NO ADVANCING
           DISPLAY NAAM IN PROD-NAAR
           IF GEEN-LEESFOUT
               ADD CHANGE TO INSTOCK IN PROD-NAAR
               REWRITE PRODUCT FROM PROD-NAAR
               
           ELSE
               DISPLAY "FOUT BIJ HET ZOEKEN VAN HET PRODUCT!"
           END-IF.

       SLUIT-BESTANDEN.
           DELETE FILE Bewegingen
           CLOSE Stock.

       FOUT.
           DISPLAY "ER IS EEN FOUT OPGETREDEN"
           STOP RUN.
