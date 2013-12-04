      **********************************************************
      * NIEUW PRODUCT
      *
      * AUTHOR: XAVIER GEERINCK
      * DATE: NOVEMBER 2013
      * KAREL DE GROTE-HOGESCHOOL
      *
      * DIT PROGRAMMA LAAT TOE OM EEN NIEUW PRODUCT TOE TE VOEGEN.
      *
      **********************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. NIEUW-PRODUCT.
       AUTHOR. XAVIER.

       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT Stock ASSIGN TO "BESTANDEN/STOCK.DAT"
                  ACCESS MODE IS RANDOM
                  ORGANIZATION IS INDEXED
                  RECORD KEY IS NR.

       DATA DIVISION.
       FILE SECTION.
       FD Stock.
       01  PRODUCT.
           02 NR       PIC X(6).
           02 NAAM     PIC X(40).
           02 INSTOCK  PIC 9(4).

       PROCEDURE DIVISION.

       MAIN.
           PERFORM INITIALISEER
           PERFORM INVOER-PRODUCT
           PERFORM VOEG-PRODUCT-TOE
           PERFORM SLUIT-STOCK
           STOP RUN.

       INITIALISEER.
           MOVE ZEROS TO PRODUCT
           OPEN I-O Stock.

       INVOER-PRODUCT.
           DISPLAY "GEEF HET PRODUCTNUMMER:"
           ACCEPT NR.
           DISPLAY "GEEF DE NAAM:"
           ACCEPT NAAM.
           DISPLAY "GEEF HET STOCKAANTAL"
           ACCEPT INSTOCK.

       VOEG-PRODUCT-TOE.
           WRITE PRODUCT INVALID KEY PERFORM FOUT
           END-WRITE.

       SLUIT-STOCK.
           CLOSE Stock.

       FOUT.
           DISPLAY "ER IS EEN FOUT OPGETREDEN"
           STOP RUN.

