# Viikkoraportti 4

## Mitä tein?
Keksin miksi Manhattan laski väärin (tyhjänkin muuvit laskin mukaan, huoh) ja korjasin sen.  
Rakensin workfown githubiin ja laitoin README:hen napit testeistä.   
Selvittelin miten ratkaisun oikeellisuutta voisi testata. En keksinyt muuta kuin sen,  
että katsoo, ettei tuhannella iteraatiolla yhdelläkään tule yli 80 siirtoa.  
Täytyy vielä yrittää keksiä jokin muu testi. Refaktoroin olemassa olevaa koodia ja kirjoitin  
javadocit.

## Miten ohjelma edistynyt?
Ei kovin paljoa muuten kuin selkeytynyt viime viikosta.
 
## Mitä opin tällä viikolla?
Kertaus on opintojen äiti! Githubin workfowt, kaikkien nappien teko README:hin, java docin
muodot. Sen, että 15-puzzleilla on max 80 siirtoa.

## Mikä jäi epäselväksi?
Edelleen tuo, miten oikeasti voisin testata sitä ratkaisun oikeellisuutta (muutoin kuin antamalla 
jonkun laudan (jonka ratkaisun tietää) testattavaksi). Yritin etsiä jotain teoriaa mutta en  
toistaiseksi löytänyt.

## Mitä teen seuraavaksi?

*ToDo seuraavaksi:*
* Jatka sen selvittämistä, miten IDAn tuloksen oikeellisuuden voi testata.
* Panosta testausdokumenttiin.
* Lisää ajanotto.
* Pelilaudan visuaalinen ilme. JavaFX? Tai ehkä vain komentoriviltä käytettävä ui... :I
* Muut heuristiikat kuin Manhattan.
* Puzzlen generoiminen satunnaisesti ja tsekkaus onko ratkaistavissa.

## Ajankäyttö

| pvm | tunnit | mitä tehty |
|:----:|:----:|:-----:|
| 19.9. | 5 | testit toimimaan, jee! |
| 21.9. | 6 | idan ohjelmointi |
| 23.9. | 7 | koodin siivous, ida toimimaan, testejä, dokumentointia |
