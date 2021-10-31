# Toteutusdokumentti

## Ohjelman rakenne

Alta löytyy ohjelman rakenne ja luokat

![Rakenne](https://github.com/LauraACodes/LaurasBossPuzzle/blob/main/Dokumentaatio/rakenne.png

## Aika- ja tilavaativuudet
IDA* aikavaativuus on luokkaa O(n potenssiin m), m <= 80, koska tämä on maksimi määrä siirtoja (eli polun pituus), joilla 15-puzzle on ratka>

Tilavaatimus on O(nm).

Suorituskykytestaukset löytyvät testausdokumentista. 

## Puutteet ja parannusehdotukset

Ohjelman selvä puute on hitaus. Luettujen materiaalien mukaan IDA* toimintaa voisi nopeuttaa mm. täydentämällä Manhattan-heuristiikkaa. Tätä tai muitakaan nopeuttavia toimia ei tehty.

Pieni yksityiskohta: Ohjelma ei validoi käyttäjän antamia syötteitä.

## Lähteet

https://en.wikipedia.org/wiki/Iterative_deepening_A*
https://www.youtube.com/watch?v=5LMXQ1NGHwU
https://www.algorithms-and-technologies.com/iterative_deepening_a_star/java
https://www.geeksforgeeks.org/check-instance-15-puzzle-solvable/
Ja miljoona muuta sivua, jotka liittyvät siihen, miten gradlesta ja javasta saa juuri tarvittavat versiot ja miten niitä muunnellaan :)

