# Makefile for COBOL course
# Author: Kris Demuynck
# Karel de Grote-Hogeschool
# 2008-2009

COBC=cobc -x -O2
SOURCES=$(wildcard *.cob)
EXECUTABLES=$(SOURCES:.cob=)

.SUFFIXES:	.cob

all:	$(EXECUTABLES)

clean:
	rm -rf $(EXECUTABLES)

.cob:
	$(COBC) -o $@ $<
