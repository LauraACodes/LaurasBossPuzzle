
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

        int rajaArvo = tukitoimet.laskeManhattan(puzzle);
        System.out.println("eka manhattan = " + rajaArvo);
        pino.add(puzzle);
        
        while (true) {
            int paluu = etsi(pino, 0, rajaArvo);
     
            if (paluu == 0) {
                return pino.size();
            }
            
            if (paluu == 1000) {
                 return 1000;
            }
            
            rajaArvo = paluu;
        }
        
    }
    
    public int etsi(ArrayDeque<int[][]> pino, int kustannus, int rajaArvo) {
       
        int kokonaisKustannus = kustannus + tukitoimet.laskeManhattan(pino.peek());

        if (kokonaisKustannus > rajaArvo) {
            return kokonaisKustannus;
        }
        
        if (tukitoimet.onkoSama(pino.peek(), Vakiot.TAVOITETILA)) {
            ratkaisu = true;
            return 0; // löytyi
        }
        
        int min = 1000;
        
        ArrayList<Integer> siirrot = tukitoimet.selvitaMahdSiirrot(pino.peek());
             
        for (int i: siirrot) {

            int[][] seuraajaNode = tukitoimet.teeSiirto(pino.peek(), i);
            
            boolean eiOleJoPinossa = true;
            
            Iterator<int[][]> iterointi = pino.iterator();
            while (iterointi.hasNext()) {
                if (tukitoimet.onkoSama(iterointi.next(), seuraajaNode)) {
                    eiOleJoPinossa = false;
                }
            }

            if (eiOleJoPinossa) {
                pino.push(seuraajaNode);

                int paluu = etsi(pino, kustannus + 1, rajaArvo);

                if (paluu == 0) {
                    ratkaisu = true;
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
