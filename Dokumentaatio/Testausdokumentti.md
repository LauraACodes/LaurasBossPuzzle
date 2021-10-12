# Testausdokumentti

## Yksikkötestauksen kattavuusraportti##

[![codecov](https://codecov.io/gh/LauraACodes/LaurasBossPuzzle/branch/main/graph/badge.svg?token=FDOVVTAKT1)](https://codecov.io/gh/LauraACodes/LaurasBossPuzzle)

## Mitä testattiin?

### Yksikkötestit
Algoritmin oikea toiminta perustuu pitkälti Tukitoiminnot -luokasta löytyviin metodien oikeaan toimintaan.

Tukitoiminnot-luokan metodeja testattiinkin kattavasti  mm. osaavatko metodit...
- ...selvittää mitkä siirrot pelilaudalla ovat mahdollisia ja mitkä ei.
- ...toteuttaa siirrot oikein joka suuntaan.
- ...laskea Manhattan etäisyydet oikein.
- ...laskea inversioiden lukumäärät oikein.
- ...puzzle osataan luoda oikein niin satunnaisesti kuin sekoittamalla.
- ...vertailla kahta puzzlea/tilannetta oikein.
 
Molempien toteutusten (ArrayDeQue ja oma pino-rakenne) IDA*-algoritmin oikeellisuutta testattiin kahdella tapauksella: palauttaako algoritmi oikean siirtojen lukumäärän helpossa ja vaikeammassa tapauksessa.

Käyttöliittymä ja suorituskykytestauksen toteutus jätettiin yksikkötestien ulkopuolelle. 

### Suorituskyvyn testaus
IDA* suorituskykyä Manhattan heuristiikalla testattiin kahdella eri tietorakenteella: Javan valmiilla ArrayDeQue:lla ja omalla pino-toteutuksella.

Suorituskykytesti tehtiin siten, että ohjelma generoi 100 lähtötilannetta sekoittamalla ja etsi kullekin generoidulle tilanteelle ratkaisun eri tietorakenteita hyödyntävällä IDA*:lla.

Suoritettiinpa IDA* kummalla tietorakenteella tahansa, lähtökohtaiseti mitä lyhyempi ratkaisu on, sitä nopeammin ratkaisu IDA* löytyy. Läpikäymättä jää suuri määrä muita mahdollisia polkuja.

Luonnollisesti ArrayDeQuetä hyödyntävä IDA* löysi ratkaisut selvästi nopeammin: 
Yhdellä 100 laudan testiaineistolla ArrayDeQuella kesti keskimäärin 3,3 sekuntia (huom, EI millisekuntia) löytää ratkaisu kun itse tehdyllä pinolla ratkaisujen löytäminen samoihin lähtötilanteisiin kesti 12,7 sekuntia.

Alla näkyy samasta aineistosta tehdyt kuvat:

![Kaikki ratkaisut](https://github.com/LauraACodes/LaurasBossPuzzle/blob/main/Dokumentaatio/SataKaikki.png)

![Kaikki ratkaisut](https://github.com/LauraACodes/LaurasBossPuzzle/blob/main/Dokumentaatio/SataAlleMinuutti.png)
