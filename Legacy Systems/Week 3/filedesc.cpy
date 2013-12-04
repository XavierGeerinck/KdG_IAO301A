           02 KDGEX.
              05 B1-LENGTH PIC S9(04) USAGE IS COMP.
              05 B1-CODE PIC S9(04) USAGE IS COMP.
              05 B1-NUMBER PIC X(08).
              05 B1-PPR-NAME PIC X(06).
              05 B1-PPR-FED PIC 9(03).
              05 B1-PPR-RNR PIC S9(08) USAGE IS COMP.
              05 B1-DATA.
                10 B1-VBOND PIC 9(02).
                10 B1-KONST.
                  20 B1-AFDEL PIC 9(03).
                  20 B1-KASSIER PIC 9(03).
                  20 B1-DATZIT-DM PIC 9(04).
                10 B1-BETWYZ PIC X(01).
                10 B1-RNR PIC X(13).
                10 B1-BETKOD PIC 9(02).
                10 B1-VOLGNR-INF PIC 9(02).
                10 B1-QUAL-PREST PIC 9(03).
                10 B1-REKNUM PIC 9(12).
                10 B1-REKNR REDEFINES B1-REKNUM.
                  20 B1-REKNR-PART1 PIC 9(03).
                  20 B1-REKNR-PART2 PIC 9(07).
                  20 B1-REKNR-PART3 PIC 9(02).
                10 B1-VOLGNR-M30 PIC 9(03).
                10 B1-OMSCHR.
                  15 B1-OMSCHR1 PIC X(14).
                  15 B1-OMSCHR2 PIC X(14).
                10 B1-OMSCHR-INF REDEFINES B1-OMSCHR.
                  15 B1-AANT-PREST PIC 9(02).
                  15 B1-VERSTR PIC 9(01).
                  15 B1-LASTDATE PIC 9(06).
                  15 B1-HONOR PIC 9(06).
                  15 B1-RIJKN PIC X(13).
                10 FILLER--1 PIC 9(02).
                10 B1-INFOREK PIC 9(01).
                10 B1-BEDRAG-EUR PIC 9(08).
                10 B1-BEDRAG-DV PIC X(01).
                10 B1-BEDRAG-RMG-DV REDEFINES B1-BEDRAG-DV PIC X(01).
              05 FILLER PIC X(5).