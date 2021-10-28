
package LaurasBossPuzzle.laskentaJaTuki;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;


public class LaskentaArrayDeQuella {
    
    ArrayDeque pino;
    
    public LaskentaArrayDeQuella() {
        this.pino = new ArrayDeque<int[][]>();
    }
    
    /**
     * Metodi palauttaa ja poistaa pinon viimeisimmän puzzlen eli vanhimman pelitilanteen
     * @return pinon alimmainen puzzle eli pelitilanne
     */ 
    public int[][] otaPinosta() {
        return (int[][]) pino.pollLast();
    }
    
    /**
     * Metodi toteuttaa IDA* algoritmin eli selvittää lyhimmän ratkaisun 
     * hyödyntäen Manhattan-etäisyyksiä.   
     * @param puzzle
     * @return miten monta siirtoa lyhin ratkaisu tarvitsee
     */
    public int idaStar(int[][] puzzle) {

        int rajaArvo = Tukitoimet.laskeManhattan(puzzle);
        pino.add(puzzle);
        
        while (true) {
            int paluu = etsi(pino, 0, rajaArvo);
     
            if (paluu == 0) {
                return pino.size() - 1;
            }
            
            if (paluu == 1000) {
                 return 1000;
            }
            
            rajaArvo = paluu;
        }
        
    }
    
    /**
     * Metodi toteuttaa käytännössä syvyyshaun. Se siis laskee annetun pinon 
     * päällimmäisen puzzlen kokonaiskustannuksen ja toimii sen perusteella:
     * Jos kokonaiskustannus on suurempi kuin annettu raja-arvo (eli optimaalinen
     * ratkaisu ei voi löytyä tästä haarasta), metodi palauttaa kokonaiskustannuksen. 
     * Jos pinon päällimmäinen on ongelman ratkaisu, metodi palauttaa nollan.
     * Muutoin metodi selvittää pinon päällimmäisen mahdolliset siirrot ja tekee 
     * ne yksitellen (toki tarkastaen ensin, ettei siirto johda jo vierailtuun 
     * pelitilanteeseen). Metodi siis laittaa siirron jälkeisen pelitilanteen
     * pinoon ja kutsuu itseään. Jos paluuarvona on nolla, ratkaisu on löytynyt.
     * Muutoin metodi palauttaa kutsutun tilanteen (lapsen) kokonaiskustannuksen 
     * poistettuaan lapsen ensin pinosta.
     * @param pino
     * @param kustannus
     * @param rajaArvo
     * @return pinon päällimmäisen kokonaiskustanuksen, nollan tai pienimmän 
     * seuraavien mahdollisten siirtojen kokonaiskustannuksen. 
     */
    public int etsi(ArrayDeque<int[][]> pino, int kustannus, int rajaArvo) {
       
        int kokonaisKustannus = kustannus + Tukitoimet.laskeManhattan(pino.peek());

        if (kokonaisKustannus > rajaArvo) {
            return kokonaisKustannus;
        }
        
        if (Tukitoimet.onkoSama(pino.peek(), Vakiot.TAVOITETILA)) {
            return 0; // löytyi
        }
        
        int min = 1000;
        
        ArrayList<Integer> siirrot = Tukitoimet.selvitaMahdSiirrot(pino.peek());
             
        for (int i: siirrot) {

            int[][] seuraajaNode = Tukitoimet.teeSiirto(pino.peek(), i);
            
            boolean eiOleJoPinossa = true;
            
            Iterator<int[][]> iterointi = pino.iterator();
            while (iterointi.hasNext()) {
                if (Tukitoimet.onkoSama(iterointi.next(), seuraajaNode)) {
                    eiOleJoPinossa = false;
                    break;
                }
            }

            if (eiOleJoPinossa) {
                pino.push(seuraajaNode);

                int paluu = etsi(pino, kustannus + 1, rajaArvo);

                if (paluu == 0) {
                    return 0;
                }

                if (paluu < min) {
                    min = paluu;
                }

                pino.poll();

                eiOleJoPinossa = true;
            }

        }
        
        return min;
        
    }

}
