
package LaurasBozzPuzzle.ui;

import LaurasBossPuzzle.LaskentaJaTuki.Vakiot;
import LaurasBossPuzzle.LaskentaJaTuki.Tukitoimet;
import LaurasBossPuzzle.LaskentaJaTuki.Laskenta;


public class Main {

    public static void main(String[] args) {
        
        Tukitoimet tukitoimet = new Tukitoimet();
        
        System.out.println("Tavoitetila:");
        tulostaPuzzle(Vakiot.TAVOITETILA);
              
        System.out.println("Generoitu lähtötilanne:");
        int[][] puzzle = tukitoimet.luoPuzzleSekoittamalla();
        tulostaPuzzle(puzzle);   
        
        System.out.println("Lyhimmän reitin siirrot:");
        Laskenta laskenta = new Laskenta();    
        
        int liikkeidenLkm = laskenta.idaStar(puzzle) - 1;               
        for (int i=0; i<liikkeidenLkm+2; i++) {
            int[][] vaihe = laskenta.otaPinosta();
            tulostaPuzzle(vaihe);            
        }    

        System.out.println("MSiirtoja yhteensä:" + liikkeidenLkm);        
               
    }
    
    public static void tulostaPuzzle(int[][] puzzle) {
            
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
