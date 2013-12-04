      *************************************************
      * PRINT REKENINGEN
      *
      * DRUKT ALLE REKENINGEN AF OP STANDARD OUTPUT
      *
      *************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PRINT-REKENINGEN.

       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT REKENINGEN ASSIGN TO "BESTANDEN/REKENINGEN"
                  ACCESS MODE IS SEQUENTIAL
                  ORGANIZATION IS INDEXED
                  RECORD KEY IS REKNR.

       DATA DIVISION.
       FILE SECTION.
       FD  REKENINGEN BLOCK CONTAINS 10 RECORDS.
       01  REK.
           02 REKNR.
               03 DEEL1 PIC 999.
               03 DEEL2 PIC 9(7).
               03 DEEL3 PIC 99.
           02 KLANTNR PIC 9(7).
           02 SALDO PIC 9(7)V99.
           02 GEWIJZIGD PIC 9(8).
           02 RENTE PIC 9(7)V99.

       WORKING-STORAGE SECTION.
       77  FILE-STATUS PIC X.
           88 NOG-NIET-EINDE VALUE "N".
           88 EINDE VALUE "E".

       PROCEDURE DIVISION.

       MAIN.
           PERFORM INITIALISEER
           PERFORM TOON-REKENINGEN
           PERFORM SLUIT-BESTAND
           STOP RUN.

       INITIALISEER.
           SET NOG-NIET-EINDE TO TRUE
           OPEN INPUT REKENINGEN.

       TOON-REKENINGEN.
           PERFORM TOONVOLGENDE UNTIL EINDE.

       TOONVOLGENDE.
           READ REKENINGEN AT END SET EINDE TO TRUE
           END-READ
           IF NOG-NIET-EINDE
               DISPLAY DEEL1 "-" DEEL2 "-" DEEL3
               DISPLAY "  SALDO: " SALDO
           END-IF.

       SLUIT-BESTAND.
           CLOSE REKENINGEN.

