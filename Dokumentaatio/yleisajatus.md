## Logiikka:

1. Vakioina valmiina: 
  - jokaisen palikan tavoitesijanti koordinaatteina int[2][16]-taulukossa (esim. 1 = 0,0).

2. Pelilauta luodaan randomina. Tuloksena käytännössä lähdenode.

3. Lähtönode X: Sillä on:
  - palikoiden sijainti int[2][16]-taulukossa (int[0][15] kertoo missä tyhjä on)
  - cost = 0 (?)
  - manhattanArvo = kaikkien palikoiden tarvittavien siirtymien summa. (Oma metodi: vertaa nykyisiä ja tavoitesijainteja).
  - fArvo = kustannus + manhattanArvo.

4. Algoritmi:
  - Ajanotto käyntiin.
  - Luo pinon
  - Alustaa muuttujan "löytyi" falseksi 
  - Asettaa raja-arvon nollaksi (? vai lähtönoden fArvo-1?)
    
  REKURSIO ALKAA:
  - Jos raja-arvo on yli jonkun maksimin, poistu (ratkaisua ei löydy ollenkaan. Mikä on maksimi...?)
  - Laittaa käsiteltävän noden pinoon.  
  - Katsoo onko noden fArvo <= raja-arvo.
    - Jos ei, poistaa noden pinosta ja palaa.
    - Jos on, Katsoo onko tavoitenode. (oma metodi etsimiseen)
      - Jos on, päivittää "löytyi"-muuttujan trueksi ja palaa.
    - Jos on, käy läpi mahdolliset liikkeet (eli lapset), MAX 4:
      = Luo lapsen yksi kerrallaan (oma metodi)ja jos mahdollinen, kutsu rekursiota. 
    - Kun kaikki liikkeet käyty läpi:
      - jos pinon korkeus==yksi (ei löytynyt kyseisellä raja-arvolla), kasvata raja-arvoa yhdellä ja 
	kutsu rekursiota uudelleen
      - muuten palaa. 

5. Lopputyöt
  - Ajanotto loppuu
  - Näkymän päivittäminen löytyi tai ei: Aika ja liikkeiden lkm.
  - (Jos ehtii: Visu oikeasta ratkaisusta, palikat liikkuu jne.)
