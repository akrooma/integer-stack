# README #

See on kolmanda kodutöö failide hoidla, mida saab kasutada ainult algseks lugemiseks.
Töötamiseks looge endale isiklik repositoorium, näiteks privaatne 'fork' siiasamasse bitbucket serverisse, millest saate luua klooni oma arvutisse.

## Näidete kasutamine käsurealt ##
#### Kompileerimine: ####

```
#!bash

javac -cp src src/IntStack.java
```

#### Käivitamine: ####

```
#!bash

java -cp src IntStack
```


### Testide kasutamine ###
#### Testi kompileerimine: ####

```
#!bash

javac -cp 'src:test:test/junit-4.12.jar:test/hamcrest-core-1.3.jar' test/IntStackTest.java

```
Sama Windows aknas (koolonite asemel peavad olema semikoolonid):

```
#!bash

javac -cp 'src;test;test/junit-4.12.jar;test/hamcrest-core-1.3.jar' test/IntStackTest.java


```

#### Testi käivitamine: ####

```
#!bash

java -cp 'src:test:test/junit-4.12.jar:test/hamcrest-core-1.3.jar' org.junit.runner.JUnitCore IntStackTest
```

Sama Windows aknas (koolonite asemel semikoolonid):

```
#!bash

java -cp 'src;test;test/junit-4.12.jar;test/hamcrest-core-1.3.jar' org.junit.runner.JUnitCore IntStackTest
```
