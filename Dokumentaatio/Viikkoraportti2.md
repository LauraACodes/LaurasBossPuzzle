# Viikkoraportti 2

## Mitä tein?
Sain omaan päähän taottua miten IDA toimii ja miten ohjelma kannattaa rakentaa, kiitos Hannu!
Sain tehtyä palojen shufflen, eli aloitustilanteen. Koodi ei ihan parhainta vielä, tähän palaan.
Tarkoituksena oli tehdä testit koodaamilleni asioille mutta jostain syystä netbeans (tai gradle  
komentoriviltä) ei suostu niitä ajamaan. Aluksi oli liian vanha gradle-versio, nyt ilmeisesti  
liian uusi. Järki lähtee. 
Checkstylepohjat jne. laitoin myös kuntoon.  

## Miten ohjelma edistynyt?
Sain tehtyä palojen shufflen ja sen (ja myös IDA*n jatkossa) tueksi tarvittavia metodeita,  
esim. mahdollisten siirtojen tarkistamisen. 
 
## Mitä opin tällä viikolla?
Paremmin tuon IDA*n toiminnnan.  
Sen, että toteutus onnistuu tehokkaammin ilman, että tiloista tekee omia olioita.
Ja hyödyllisenä kertauksena juttuja yksikkötestauksesta, checkstyleistä jne. 

## Mikä jäi epäselväksi?
Mikä gradle.buildissa tai muualla on väärin kun testit ei pyöri?! **SAA VINKATA!**

## Mitä teen seuraavaksi?

*ToDo seuraavaksi:*
* Testit pitää saada toimimaan. Pitäisikö kopioida joku toimiva vanha gradle-projekti ja siirtää koodi sinne...?
* Manhattan-etäisyyksien laskemisen koodaus.
* Idan koodaus.
* Pelilaudan visuaalinen ilme. JavaFX?
* Selitteet Jacoco-muotoon.
* testikattavuus jne. napit README:hen.

## Ajankäyttö

| pvm | tunnit | mitä tehty |
|:----:|:----:|:-----:|
| 15.9. | 6 | laskennan selvittämistä |
| 16.9. | 6 | hyviä neuvoja Hannulta, shufflen koodays |
| 18.9. | 5 | checkstylet jne. paikalleen, testien kanssa tappelu |
