
package LaurasBossPuzzle.LaskentaJaTuki;

public class Pino {
    int[][] pino;
    int viimeisenIndeksi;
    
    public Pino() {
        this.pino = new int[1000][16];
        this.viimeisenIndeksi = 0;
    }
    
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
    
    public int[][] pollPaallimmainen() {
        int[][] puzzle = pinostaPuzzleksi(viimeisenIndeksi);
        viimeisenIndeksi--;
        return puzzle;        
    }

    public int[][] peekPaallimmainen() {
        return pinostaPuzzleksi(viimeisenIndeksi);
    }
    
    public int[][] peekIndeksi(int i) {
        return pinostaPuzzleksi(i);
    }
    
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
    
    public int getPinonkoko() {
        return viimeisenIndeksi;
    }
}
