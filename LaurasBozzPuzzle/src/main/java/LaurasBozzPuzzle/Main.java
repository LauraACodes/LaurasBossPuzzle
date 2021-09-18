
package LaurasBozzPuzzle;


public class Main {

    public static void main(String[] args) {
        
        Tukitoimet tukitoimet = new Tukitoimet();
        
        System.out.println("Tavoitetila:");
        tulostaPuzzle(Vakiot.TAVOITETILA);
              
        System.out.println("Generoitu lähtötilanne:");
        tulostaPuzzle(tukitoimet.luoPuzzle());
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
