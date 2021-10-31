
package LaurasBozzPuzzle.laskenta;

/**
 * Luokka toteuttaa itse rakennetun version Pinosta.
 * @author andlaura
 */
public class OmaPino {
    int[][] pino;
    int viimeisenIndeksi;
    
    public OmaPino() {
        this.pino = new int[1000][16];
        this.viimeisenIndeksi = 0;
    }
    
    /**
     * Metodi lisää pelitilanteen pinoon.
     * @param puzzle 
     */
    public void lisaaPinoon(int[][] puzzle) {
        
        viimeisenIndeksi++;
        int osoitin = 0;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                pino[viimeisenIndeksi][osoitin] = puzzle[x][y];
                osoitin++;
            }
        }       
    }
   
    /**
     * Metodi palauttaa pinon päällimmäisen ja poistaa sen.
     * @return 
     */
    public int[][] pollPaallimmainen() {
        int[][] puzzle = pinostaPuzzleksi(viimeisenIndeksi);
        viimeisenIndeksi--;
        return puzzle;        
    }

    /**
     * Metodi palauttaa pinon päällimmäisen, ei poista.
     * @return 
     */
    public int[][] peekPaallimmainen() {
        return pinostaPuzzleksi(viimeisenIndeksi);
    }
    
    /**
     * Metodi palauttaa annetulla indeksillä pinossa olevan puzzlen.
     * @param i
     * @return puzzle
     */
    public int[][] peekIndeksi(int i) {
        return pinostaPuzzleksi(i);
    }
    
    /**
     * Metodi palauttaa tietyn indeksin puzzlen.
     * @param pinonIndeksi
     * @return 
     */
    public int[][] pinostaPuzzleksi(int pinonIndeksi) {
        int[][] puzzle = new int[4][4];
        int osoitin = 0;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                puzzle[x][y] = pino[pinonIndeksi][osoitin];
                osoitin++;
            }
        }  
        
        return puzzle;
    }
    
    /**
     * Metodi palauttaa pinon koon tietyllä hetkellä
     * @return pinon koko eli viimeisimmänIndeksin
     */
    public int getPinonkoko() {
        return viimeisenIndeksi;
    }
}
