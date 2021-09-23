
package LaurasBozzPuzzle;


public class Main {

    public static void main(String[] args) {
        
        Tukitoimet tukitoimet = new Tukitoimet();
        
        
        System.out.println("Tavoitetila:");
        tulostaPuzzle(Vakiot.TAVOITETILA);
              
        System.out.println("Generoitu lähtötilanne:");
        /*int[][] puzzle = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,16,14,15}
        };*/
        int[][] puzzle = tukitoimet.luoPuzzleSekoittamalla();
        tulostaPuzzle(puzzle);        
        //int[] testi = tukitoimet.palautaTyhja(puzzle);
        //System.out.println("x = " + testi[0] + ", y = " + testi[1]);          
        
        int manhattan = tukitoimet.laskeManhattan(puzzle);
        System.out.println("Manhattan = " + manhattan);
        Laskenta laskenta = new Laskenta();
        
        int liikkeidenLkm = laskenta.idaStar(puzzle) - 1;
        System.out.println("Mooveja yht:" + liikkeidenLkm);
        

        
        
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
