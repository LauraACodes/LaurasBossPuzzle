
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
    
    public int laskeManhattan(int[][] puzzle) {
        int etaisyys = 0;
        
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                int palanArvo = puzzle[x][y];
                /*System.out.println("etäisyys alussa = " + etaisyys);
                System.out.println("x, y = " + x + "," + y);
                System.out.println("PalanArvo = " + palanArvo);
                System.out.println("Haetaan tavoitekoordinaatti on: x " + Vakiot.TAVOITEKOORD[palanArvo][0] + ", y=" + Vakiot.TAVOITEKOORD[palanArvo][1]);
                System.out.println("xn erotus = " + Math.abs(x - Vakiot.TAVOITEKOORD[palanArvo][0]));*/
                int xnEro = Math.abs(x - Vakiot.TAVOITEKOORD[palanArvo][0]);
                int ynEro = Math.abs(y - Vakiot.TAVOITEKOORD[palanArvo][1]);
                etaisyys = etaisyys + xnEro + ynEro;
                /*System.out.println("yn erotus = " + Math.abs(y - Vakiot.TAVOITEKOORD[palanArvo][1]));
                //etaisyys = etaisyys + Math.abs(y - Vakiot.TAVOITEKOORD[palanArvo][1]);
                System.out.println("etaisyys = " + etaisyys);*/
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
        
    public ArrayList<Integer> selvitaMahdSiirrot(int[][] puzzle) {
        //etsitään tyhja = 16. Saisiko tän tuotua suoraan? Vähintään omaksi metodiksi..     
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
 /*
    public ArrayList<Integer> selvitaMahdSiirrot(int[][] sijainnit) {
        ArrayList<Integer> siirrot = new ArrayList<>();
        // 1=ylös, 2=alas, 3=oikea, 4=vasuri
        if (sijainnit[16][1] > 0) {
            siirrot.add(1);
        }
        
        if (sijainnit[16][1] < 3) {
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
            int siirtyva = puzzle[tyhjaX][(tyhjaY - 1)];
            uudetSijainnit[siirtyva][1] = tyhjaY;
            uudetSijainnit[16][1] = (tyhjaY - 1);
        }
        //alas
        if (siirtoNro == 2) {
            int siirtyva = puzzle[tyhjaX][(tyhjaY + 1)];
            uudetSijainnit[siirtyva][1] = tyhjaY;
            uudetSijainnit[16][1] = (tyhjaY + 1);
        }
        //oikealle
        if (siirtoNro == 3) {
            int siirtyva = puzzle[(tyhjaX) + 1][tyhjaY];
            uudetSijainnit[siirtyva][0] = tyhjaX;
            uudetSijainnit[16][0] = (tyhjaX + 1);
        }        
        //vasuriin
        if (siirtoNro == 4) {
            int siirtyva = puzzle[(tyhjaX) - 1][tyhjaY];
            uudetSijainnit[siirtyva][0] = tyhjaX;
            uudetSijainnit[16][0] = (tyhjaX - 1);
        }  
     
        return uudetSijainnit;
    }*/
    public int[] palautaTyhja(int[][] puzzle) {
        int[] tyhjanXY = new int[2];

        //etsitään tyhja = 16. Saisiko tän tuotua suoraan? Vähintään omaksi metodiksi..
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
    
    public int[][] paivitaPuzzle(int[][] sijainnit) {
        int[][] uusiPuzzle = new int[4][4];
        
        for (int i = 1 ; i <= 16; i++) {
            int x = sijainnit[i][0];
            int y = sijainnit[i][1];
            uusiPuzzle[x][y] = i;
        }
        
        return uusiPuzzle;
    }
    
    
    public int[][] paivitaSijainnit(int[][] puzzle) {
        int[][] uudetSijainnit = new int[17][2];
        
        for (int i = 0 ; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int x = puzzle[i][j];
                uudetSijainnit[x][0] = i;
                uudetSijainnit[x][1] = j;
            }
        }
        
        return uudetSijainnit;
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
}
