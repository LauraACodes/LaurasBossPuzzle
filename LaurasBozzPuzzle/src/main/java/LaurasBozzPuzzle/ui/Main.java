
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
        /*int[][] puzzle = {
            {1,2,3,4}, 
            {5,6,16,8}, 
            {9,10,7,12}, 
            {13,14,11,15}
        };*/
        int[][] puzzle = tukitoimet.luoPuzzleSekoittamalla();
        tulostaPuzzle(puzzle);        
       
        
        int manhattan = tukitoimet.laskeManhattan(puzzle);
        System.out.println("Manhattan = " + manhattan);
        Laskenta laskenta = new Laskenta();
        
        int liikkeidenLkm = laskenta.idaStar(puzzle) - 1;
        System.out.println("Mooveja yht:" + liikkeidenLkm);
        
        for (int i=0; i<liikkeidenLkm+1; i++) {
            int[][] vaihe = laskenta.otaPinosta();
            tulostaPuzzle(vaihe);            
        }
        
               
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
