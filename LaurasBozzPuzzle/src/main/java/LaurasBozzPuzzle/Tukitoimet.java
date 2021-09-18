
package LaurasBozzPuzzle;

import java.util.ArrayList;
import java.util.Random;

public class Tukitoimet {

    public int[][] luoPuzzle() {
        int[][] puzzle = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,14,15,0}
        };
        
        int[][] sijainnit = {
            {100,100},
            {0,0},{1,0},{2,0},{3,0},
            {0,1},{1,1},{2,1},{3,1},
            {0,2},{1,2},{2,2},{3,2},  
            {0,3},{1,3},{2,3},{3,3}
        };
             
        Random random = new Random();        
        for (int i=0; i<50; i++) {
            ArrayList<Integer> mahdollisetSiirrot = selvitaMahdSiirrot(sijainnit);
            int valittu = random.nextInt(mahdollisetSiirrot.size());
            int siirtoNro = mahdollisetSiirrot.get(valittu);
            sijainnit = teeSiirto(sijainnit, puzzle, siirtoNro);
            puzzle = paivitaPuzzle(sijainnit);
        }
        
        return puzzle;
    }
    
    public ArrayList<Integer> selvitaMahdSiirrot(int[][] sijainnit) {
        ArrayList<Integer> siirrot = new ArrayList<>();
        // 1=ylös, 2=alas, 3=oikea, 4=vasuri
        if (sijainnit[16][1] > 0){
            siirrot.add(1);
        }
        
        if (sijainnit[16][1] < 3){
            siirrot.add(2);
        }

        if (sijainnit[16][0] < 3) {
            siirrot.add(3);
        }
        
        if (sijainnit[16][0] > 0) {
            siirrot.add(4);
        }
        
        return siirrot;
    }
    
    public int[][] teeSiirto(int[][] sijainnit, int[][] puzzle, int siirtoNro) {
        int[][] uudetSijainnit = sijainnit;
        int tyhjaX = sijainnit[16][0];
        int tyhjaY = sijainnit[16][1];
     
        
        //ylös
        if (siirtoNro == 1) {
            int siirtyva = puzzle[tyhjaX][(tyhjaY-1)];
            uudetSijainnit[siirtyva][1] = tyhjaY;
            uudetSijainnit[16][1] = (tyhjaY-1);
        }
        //alas
        if (siirtoNro == 2) {
            int siirtyva = puzzle[tyhjaX][(tyhjaY+1)];
            uudetSijainnit[siirtyva][1] = tyhjaY;
            uudetSijainnit[16][1] = (tyhjaY+1);
        }
        //oikealle
        if (siirtoNro == 3) {
            int siirtyva = puzzle[(tyhjaX)+1][tyhjaY];
            uudetSijainnit[siirtyva][0] = tyhjaX;
            uudetSijainnit[16][0] = (tyhjaX+1);
        }        
        //vasuriin
        if (siirtoNro == 4) {
            int siirtyva = puzzle[(tyhjaX)-1][tyhjaY];
            uudetSijainnit[siirtyva][0] = tyhjaX;
            uudetSijainnit[16][0] = (tyhjaX-1);
        }  
     
        return uudetSijainnit;
    }
    
    public int[][] paivitaPuzzle(int[][] sijainnit) {
        int[][] uusiPuzzle = new int[4][4];
        
        for (int i=1 ; i<=16; i++) {
            int x = sijainnit[i][0];
            int y = sijainnit[i][1];
            uusiPuzzle[x][y] = i;
        }
        
        return uusiPuzzle;
    }
    
        public static void tulostaPuzzle(int[][] puzzle) {
            
        StringBuilder stringB = new StringBuilder("");
        for (int i = 0; i <= 16; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("i = " + i + "j= " + j);
                stringB.append(puzzle[i][j]);
                stringB.append(" ");
                if (j == 1) {
                    stringB.append("\n");
                }
            }
        }
        System.out.println(stringB);
                   
    }
}
