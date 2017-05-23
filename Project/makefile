# Makefile

ROOTDIR = $(shell pwd)
CLIENTDIR = ./src/main/client
DISTDIR = ./src/main/resources/static

all: clean build run

install:
	cd $(CLIENTDIR) && npm install

build:
	cd $(CLIENTDIR) && webpack 

run:
	mvn spring-boot:run

.PHONY: clean

clean:
	rimraf $(DISTDIR)/*

deepclean:
	rimraf ./target $(DISTDIR)/* $(CLIENTDIR)/node_modules $(CLIENTDIR)/typings

