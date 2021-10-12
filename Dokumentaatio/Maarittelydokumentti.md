# Määrittelydokumentti 

## Perusasiat
**Kieli:** Java  
**Muut hallitsemani kielet:** Ei ole.  
**Dokumentointikieli:** Suomi  
**Opinto-ohjelma:** TKT kandi

## Projektin algoritmit/tietorakenteet
Lyhyimmän ratkaisun löytämiseen käytin IDA*, heuristiikka perustuu Manhattan etäisyyksiin.

Tietorakenteet:
* Pelilauta/tilanne kaksiulotteisena taulukkona
* Pino ArrayDeQuena ja
* Pino itse toteutettuna kaksiulotteinen taulukko

## Ohjelman syötteet ja niiden käyttö
Ohjelmassa voi generoida lähtötilanteen joko sekoittamalla tai satunnaisesti.
Satunnaisessa versiossa ennen ratkaisun etsimistä tarkistetaan, onko laudalla ylipäätään ratkaisua. 

Suorituskykytestausta varten ohjelmassa on lisäksi osio, joka generoi sekoittamalla sata pelilautaa ja katsoo, kuinka kauan  
näiden ratkaisemiseen kuluu ArrayDeQueta hyödyntävällä IDA*:lla verrattuna itse tehtyä pinoa hyödyntävällä.

## Aika- ja tilavaativuudet
IDA* aikavaativuus on luokkaa O(n potenssiin m), m <= 80, koska tämä on maksimi määrä siirtoja (eli polun pituus), joilla 15-puzzle on ratkaistavissa. 

Tilavaatimus on O(nm).

##Lähteet

https://en.wikipedia.org/wiki/Iterative_deepening_A*  
https://www.youtube.com/watch?v=5LMXQ1NGHwU  
https://www.algorithms-and-technologies.com/iterative_deepening_a_star/java  
https://www.geeksforgeeks.org/check-instance-15-puzzle-solvable/

