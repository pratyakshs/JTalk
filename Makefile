DOXYGEN = doxygen
PROJECT_ROOT := $(CURDIR)
SRCDIR = $(PROJECT_ROOT)/src
DOCDIR = $(PROJECT_ROOT)/doc
CLASSDIR = $(PROJECT_ROOT)/objs
######################################
.PHONY: doc clean compile
all:clean compile doc
compile:
	@mkdir -p objs
	@cd src;javac -Xlint -d ../objs ./jtalkG09.java;
	@echo "Main-Class: jtalkG09" | cat >MANIFEST.MF;cd objs;jar -cmf ../MANIFEST.MF ../jtalk.jar jtalkG09.class cs296JTalk;
clean:
	@echo "Cleaning up..."
	@rm -rf $(CLASSDIR)
	@rm -rf *.jar
