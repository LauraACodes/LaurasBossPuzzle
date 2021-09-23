
package LaurasBozzPuzzle;

import java.util.ArrayList;
import java.util.Random;

public class Tukitoimet {

    public int[][] luoPuzzleSekoittamalla() {
        int[][] puzzle = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,14,15,16}
        };
                   
        Random random = new Random();        
        for (int i = 0; i < 50; i++) {
            ArrayList<Integer> mahdollisetSiirrot = selvitaMahdSiirrot(puzzle);
            int valittu = random.nextInt(mahdollisetSiirrot.size());
            int siirtoNro = mahdollisetSiirrot.get(valittu);
            puzzle = teeSiirto(puzzle, siirtoNro);
        }
        
        return puzzle;
    }
    
    public static int laskeManhattan(int[][] puzzle) {
        int etaisyys = 0;
        
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                int palanArvo = puzzle[x][y];
                //Tässä on virhe!
                int xnEro = Math.abs(x - Vakiot.TAVOITEKOORD[palanArvo][0]);
                int ynEro = Math.abs(y - Vakiot.TAVOITEKOORD[palanArvo][1]);
                etaisyys = etaisyys + xnEro + ynEro;

            }
        }
        
        return etaisyys;
    }
 
    public boolean onkoSama(int[][] puzzle1, int[][] puzzle2) {
        
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (puzzle1[x][y] != puzzle2[x][y]) {
                    return false;
                }
            }
        }
        
        return true;
    }
        
    public static ArrayList<Integer> selvitaMahdSiirrot(int[][] puzzle) {

        int[] tyhjanXY= palautaTyhja(puzzle);
        int tyhjanX = tyhjanXY[0];
        int tyhjanY = tyhjanXY[1];
        
        ArrayList<Integer> siirrot = new ArrayList<>();
        // 1=ylös, 2=alas, 3=oikea, 4=vasuri
        if (tyhjanX > 0) {
            siirrot.add(1);
        }
        
        if (tyhjanX < 3) {
            siirrot.add(2);
        }

        if (tyhjanY < 3) {
            siirrot.add(3);
        }
        
        if (tyhjanY > 0) {
            siirrot.add(4);
        }
        
        return siirrot;
    }
 
    public static int[] palautaTyhja(int[][] puzzle) {
        int[] tyhjanXY = new int[2];

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (puzzle[x][y] == 16) {
                    tyhjanXY[0] = x;
                    tyhjanXY[1] = y;
                }
            }
        }
        
        return tyhjanXY;
    }
    public int[][] teeSiirto(int[][] puzzle, int siirtoNro) {
        int[][] uusiPuzzle = new int[4][4];
        
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                uusiPuzzle[x][y] = puzzle[x][y];
            }
        }
        
        int[] tyhjanXY= palautaTyhja(puzzle);
        int tyhjanX = tyhjanXY[0];
        int tyhjanY = tyhjanXY[1];
     
        
        //yasuri
        if (siirtoNro == 4) {
            int siirtyva = puzzle[tyhjanX][(tyhjanY - 1)];
            uusiPuzzle[tyhjanX][tyhjanY] = siirtyva;
            uusiPuzzle[tyhjanX][tyhjanY - 1] = 16;
        }
        //oikea
        if (siirtoNro == 3) {
            int siirtyva = puzzle[tyhjanX][(tyhjanY + 1)];
            uusiPuzzle[tyhjanX][tyhjanY] = siirtyva;
            uusiPuzzle[tyhjanX][tyhjanY + 1] = 16;
        }
        //alas
        if (siirtoNro == 2) {
            int siirtyva = puzzle[tyhjanX + 1][(tyhjanY)];
            uusiPuzzle[tyhjanX][tyhjanY] = siirtyva;
            uusiPuzzle[tyhjanX + 1][tyhjanY] = 16;
        }        
        //ylös
        if (siirtoNro == 1) {
            int siirtyva = puzzle[tyhjanX - 1][(tyhjanY)];
            uusiPuzzle[tyhjanX][tyhjanY] = siirtyva;
            uusiPuzzle[tyhjanX - 1][tyhjanY] = 16;
        }  
     
        return uusiPuzzle;
    }    
    
    // Tämä on apuna kun tarkastelen miten ohjelma toimii
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
    
    public static int laskeInversiot(int[][] puzzle) {
        int[] taulukko = new int[15];
        int n = 0;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (puzzle[x][y] != 16) {
                    taulukko[n] = puzzle[x][y];
                    n++;
                }
            }
        }
              
        int inversiot = 0;
            for (int i = 0; i < 15; i++) {  
                for (int j = 0; j < 15; j++) {
                    if (i < j && taulukko[j] < taulukko[i]) {
                        inversiot++;
                    }
                }
            }
        return inversiot;        
    }
}
