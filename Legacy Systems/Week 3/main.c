#include <stdio.h>   /* required for file operations */

FILE *fr;            /* declare the file pointer */

/* Struct of the inputfile */
struct B1_KONST {
    char b1_afdel;                  // PIC 9(03).
    char b1_kassier;                // PIC 9(03).
    char b1_datzit_dm;              // PIC 9(03).
};

/* 
10 B1-OMSCHR-INF REDEFINES B1-OMSCHR.
  15 B1-AANT-PREST PIC 9(02).
  15 B1-VERSTR PIC 9(01).
  15 B1-LASTDATE PIC 9(06).
  15 B1-HONOR PIC 9(06).
  15 B1-RIJKN PIC X(13).
*/
struct B1_OMSCHR {
    char b1_omschr1[14];            // PIC X(14).
    char b1_omschr2[14];            // PIC X(14).
};

struct B1_DATA {
    short unsigned int b1_vbond;    // PIC 9(02).
    struct B1_KONST b1_konst;       // STRUCT b1-konst
    char b1_betwyz[1];              // PIC X(01).
    char b1_rnr[13];                // PIC X(13).
    char b1_betkod;                 // PIC 9(02).
    char b1_volgnr_inf;             // PIC 9(02).
    char b1_qual_prest;             // PIC 9(03).
    long unsigned int b1_reknum;    // PIC 9(12). B1-REKNR-PART1 PIC 9(03), B1-REKNR-PART2 PIC 9(07), B1-REKNR-PART3 PIC 9(02)
    char b1_volgnr_m30;             // PIC 9(03).
    struct B1_OMSCHR b1_omschr;     // STRUCT b1-omschr
    char filler_1;                  // FILLER--1 PIC 9(02).
    char b1_inforek;                // PIC 9(01).
    unsigned int b1_bedrag_eur;     // PIC 9(08).
    char b1_bedrag_dv[1];           // PIC X(01). B1-BEDRAG-RMG-DV REDEFINES B1-BEDRAG-DV PIC X(01).  
};

struct KDGEX {
    short signed int b1_length;     // S9(04) COMP
    short signed int b1_code;       // S9(04) COMP
    char b1_number[8];              // X(08)
    char b1_ppr_name[6];            // X(06)
    char b1_ppr_fed;                // 9(03)
    long signed int b1_ppr_rnr;     // S9(08) COMP
    struct B1_DATA b1_data;         // STRUCT b1-data
    char filler[5];                 // X(5)
};

void inSituEbcdicToAscii (char *s) {
    static char etoa[] =
        "                                "
        "                                "
        "           .<(+|&         !$*); "  // first char here is real space
        "-/         ,%_>?         `:#@'=\""
        " abcdefghi       jklmnopqr      "
        "  stuvwxyz                      "
        " ABCDEFGHI       JKLMNOPQR      "
        "  STUVWXYZ      0123456789      ";

    while (*s != '\0') {
        *s = etoa[(unsigned char)*s];
        s++;
    }
}

main() {
    FILE *readFile;
    FILE *writeFile;
    char line[sizeof(struct KDGEX)];

    // Open binary read
    readFile = fopen("inputfile.dat","rb");
    writeFile = fopen("outputfile_test.dat","wb");
    
    if (!readFile) {
        printf("Unable to open file!");
        return 1;
    }
    
    while(fgets(line, 101, readFile)) {
        inSituEbcdicToAscii(line);
        fprintf(writeFile, "%s\n", line);
        //printf("%d\n", sizeof(struct KDGEX));
    }  
    
    fclose(readFile);
    fclose(writeFile);
    return 0;    
}