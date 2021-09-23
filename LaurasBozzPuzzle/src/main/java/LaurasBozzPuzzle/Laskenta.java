
package LaurasBozzPuzzle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;


public class Laskenta {
    
    Tukitoimet tukitoimet;
    ArrayDeque pino;
    Boolean ratkaisu;
    
    public Laskenta() {
        this.tukitoimet = new Tukitoimet();
        this.pino = new ArrayDeque<int[][]>();
        this.ratkaisu = false;
    }
    
    public ArrayDeque<int[][]> getPino() {
        return pino;
    }
    
    public Boolean getRatkaisu() {
        return ratkaisu;
    }
    
    public int idaStar(int[][] puzzle) {
        //int[][] sijainnit = tukitoimet.paivitaSijainnit(puzzle);
 //       System.out.println("Sijainnit heti alussa");
 //       tulostaSijainnit(sijainnit);
        int rajaArvo = tukitoimet.laskeManhattan(puzzle);
        System.out.println("eka manhattan = " + rajaArvo);
        pino.add(puzzle);
        
        while (true) {
            int paluu = etsi(pino, 0, rajaArvo);
            //löytyi
            if (paluu == 0) {
                return rajaArvo;
            }
            
            if (paluu == 1000) {
                 return 1000;
            }
            
            rajaArvo = paluu;
        }
        
    }
    
    public int etsi(ArrayDeque<int[][]> pino, int kustannus, int rajaArvo) {
       
        int kokonaisKustannus = kustannus + tukitoimet.laskeManhattan(pino.peek());
        //System.out.println("Kokonaiskustannus on: " + kokonaisKustannus + ", ja rajaArvo on: " + rajaArvo);

        // tämän noden kokonaiskustannus on suurempi kuin raja-arvo eli ratkaisu ei voi löytyä täältä
        if (kokonaisKustannus > rajaArvo) {
            //System.out.println("kokonaiskustannus suurepi kuin raja-arvo, palaa");
            return kokonaisKustannus;
        }
        
        // katsotaan onko tämä pinon päällimmäinen oikea ratkaisu
        if (tukitoimet.onkoSama(pino.peek(), Vakiot.TAVOITETILA)) {
            ratkaisu = true;
            return 0; // löytyi
        }
        
        int min = 1000;
        //System.out.println("Minkä puzzlen siirtoja lähtee selvittamaan:");
        //tulostaPuzzle(pino.peek());
        
        ArrayList<Integer> siirrot = tukitoimet.selvitaMahdSiirrot(pino.peek());
        
        //System.out.println("mahdollisia siirtoja " + siirrot.size());
        
        for (int i: siirrot) {
            //System.out.println("Ennen siirtoja alkunode: ");
            //tulostaPuzzle(pino.peek());
            //System.out.println("Lähtee katsomaan siirtoja, nyt = " + i);
            int[][] seuraajaNode = tukitoimet.teeSiirto(pino.peek(), i);
            
            //System.out.println("Seuraajanode: ");
            //tulostaPuzzle(seuraajaNode);
            
            boolean eiOleJoPinossa = true;
            
            Iterator<int[][]> iterointi = pino.iterator();
            while (iterointi.hasNext()) {
                //System.out.println("pinon koko " + pino.size());
                //System.out.println("tarkastaa onko sama");
                if (tukitoimet.onkoSama(iterointi.next(), seuraajaNode)) {
                    //System.out.println("oli sama");
                    eiOleJoPinossa = false;
                    
                }
                //System.out.println("ei ollut sama");
            }

            if (eiOleJoPinossa) {
                pino.push(seuraajaNode);
                //System.out.println("pinon koko nyt " + pino.size());
               // System.out.println("ja päällimmäinen on");
                //tulostaPuzzle(pino.peek());
                int paluu = etsi(pino, kustannus + 1, rajaArvo);
                //System.out.println("paluu-arvo = " + paluu);
                if (paluu == 0) {
                    ratkaisu = true;
                    return 0;
                }

                if (paluu < min) {
                    min = paluu;
                }
               // System.out.println("pinossa päällimmäisenä");
               // tulostaPuzzle(pino.peek());
                pino.poll();
               // System.out.println("nyt pitäisi olla poistettu..");
              //  System.out.println("pinossa päällimmäisenä");
               // tulostaPuzzle(pino.peek());
                eiOleJoPinossa = true;
            }

        }
        
        return min;
        
    }

    public void tulostaPuzzle(int[][] puzzle) {
        StringBuilder stringB = new StringBuilder("");
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                stringB.append(puzzle[i][j]);
                stringB.append(" ");
                if (j == 3) {
                    stringB.append("\n");
                }
            }
        }
        System.out.println(stringB);
    }
}
