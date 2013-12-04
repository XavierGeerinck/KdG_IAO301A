      *************************************************
      * PRINT KLANTEN
      *
      * DRUKT ALLE KLANTGEGEVENS AF OP STANDARD OUTPUT
      *
      *************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PRINT-KLANTEN.

       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT KLANTEN ASSIGN TO "BESTANDEN/KLANTEN"
                  ACCESS MODE IS SEQUENTIAL
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
       WORKING-STORAGE SECTION.
       77  NRKOP PIC X(7) VALUE "  NR  ".
       77  NAAMKOP   PIC X(20) VALUE "        NAAM        ".
       77  STRAATKOP PIC X(30) VALUE "            STRAAT            ".
       77  POSTNRKOP PIC X(8) VALUE "POSTCODE".
       77  GEMEENTEKOP PIC X(20) VALUE "      GEMEENTE      ".
       77  TELKOP    PIC X(13) VALUE "     TEL     ".
       77  GEDAAN    PIC X(1).
           88 STOPLEZEN VALUE "J".

       PROCEDURE DIVISION.

       MAIN.
           PERFORM INITIALISEER
           PERFORM PRINTKLANTEN
           PERFORM SLUITBESTAND
           STOP RUN.

       INITIALISEER.
           MOVE ZEROS TO KLANT
           MOVE "N" TO GEDAAN
           OPEN INPUT KLANTEN.

       PRINTKLANTEN.
           PERFORM PRINTHEADLINES
           DISPLAY "|" NRKOP "|" NAAMKOP WITH NO ADVANCING
           DISPLAY "|" STRAATKOP "|" POSTNRKOP WITH NO ADVANCING
           DISPLAY "|" GEMEENTEKOP "|" TELKOP "|"
           PERFORM PRINTHEADLINES
           PERFORM PRINTKLANT UNTIL STOPLEZEN
           PERFORM PRINTHEADLINES.

       PRINTHEADLINES.
           DISPLAY "+-------+" WITH NO ADVANCING
           PERFORM PRINTMIN 20 TIMES
           DISPLAY "+" WITH NO ADVANCING
           PERFORM PRINTMIN 30 TIMES
           DISPLAY "+" WITH NO ADVANCING
           PERFORM PRINTMIN 8 TIMES
           DISPLAY "+" WITH NO ADVANCING
           PERFORM PRINTMIN 20 TIMES
           DISPLAY "+" WITH NO ADVANCING
           PERFORM PRINTMIN 13 TIMES
           DISPLAY "+".

       PRINTMIN.
           DISPLAY "-" WITH NO ADVANCING.

       PRINTKLANT.
           READ KLANTEN AT END MOVE "J" TO GEDAAN
           END-READ
           IF NOT STOPLEZEN
               DISPLAY "|" NR "|" NAAM "|" WITH NO ADVANCING
               DISPLAY STRAAT "|" POSTCODE "|" GEMEENTE "|" TEL "|"
           END-IF.

       SLUITBESTAND.
           CLOSE KLANTEN.
