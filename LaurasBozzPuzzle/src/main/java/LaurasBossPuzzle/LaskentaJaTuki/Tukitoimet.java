
package LaurasBossPuzzle.LaskentaJaTuki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Tukitoimet-luokka tarjoaa Laskennan tarvitsemat työkalut,
 * mm luo puzzlen, selvittää mitkä siirrot ovat mahdollisia ja laskee herustiikat.
 */
public class Tukitoimet {
    
/**
 * Metodi luo uuden Puzzlen sekoittamalla eli metodin luomilla puzzleilla on 
 * aina ratkaisu.
 * 
 * @return sekoittamalla luodun puzzlen 
 */
    public static int[][] luoPuzzleSekoittamalla() {
        int[][] puzzle = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,14,15,16}
        };
                   
        Random random = new Random();        
        for (int i = 0; i < 200; i++) {
            ArrayList<Integer> mahdollisetSiirrot = selvitaMahdSiirrot(puzzle);
            int valittu = random.nextInt(mahdollisetSiirrot.size());
            int siirtoNro = mahdollisetSiirrot.get(valittu);
            puzzle = teeSiirto(puzzle, siirtoNro);
        }
        
        return puzzle;
    }
    
    /**
     * Tämä luo Puzzlen satunnaisesti, EI TOIMI VIELÄ
     * @return 
     */
    public static int[][] luoPuzzleSatunnaisesti() {
        int[][] puzzle = new int[4][4];
        
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 1; i < 17; i++) {
            lista.add(i);
        }
        
        Collections.shuffle(lista);
        
        //Joo-o, tästä toteutuksesta voi antaa moukkua. Aivot jumittui juuri.
        puzzle[0][0] = lista.get(0);
        puzzle[0][1] = lista.get(1);    
        puzzle[0][2] = lista.get(2);
        puzzle[0][3] = lista.get(3); 
        
        puzzle[1][0] = lista.get(4);
        puzzle[1][1] = lista.get(5);    
        puzzle[1][2] = lista.get(6);
        puzzle[1][3] = lista.get(7); 
        
        puzzle[2][0] = lista.get(8);
        puzzle[2][1] = lista.get(9);    
        puzzle[2][2] = lista.get(10);
        puzzle[2][3] = lista.get(11); 
        
        puzzle[3][0] = lista.get(12);
        puzzle[3][1] = lista.get(13);    
        puzzle[3][2] = lista.get(14);
        puzzle[3][3] = lista.get(15); 
              
        return puzzle;
    }
  
    
    /**
     * Metodi laskee parametrinä annetun tilanteen (puzzlen) Manhattan etäisyyden.
     * 
     * @param puzzle
     * @return Manhattan etäisyys
     */
    public static int laskeManhattan(int[][] puzzle) {
        int etaisyys = 0;
        
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                int palanArvo = puzzle[x][y];

                if (palanArvo != 16) {
                    int xnEro = Math.abs(x - Vakiot.TAVOITEKOORD[palanArvo][0]);
                    int ynEro = Math.abs(y - Vakiot.TAVOITEKOORD[palanArvo][1]);
                    etaisyys = etaisyys + xnEro + ynEro;
                }
            }
        }
        
        return etaisyys;
    }
    
    /**
     * Metodi vertailee kahta tilannetta (puzzle), ovatko ne samat.
     * 
     * @param puzzle1
     * @param puzzle2
     * @return false jos eivät ole samat, true jos ovat samat
     */
    public static boolean onkoSama(int[][] puzzle1, int[][] puzzle2) {
        
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (puzzle1[x][y] != puzzle2[x][y]) {
                    return false;
                }
            }
        }
        
        return true;
    }

    /**
     * Metodi luo listan parametrinä annetun puzzlen mahdollisista siirroista
     * (1=ylös, 2=alas, 3=oikea, 4=vasuri).
     * 
     * @param puzzle
     * @return lista mahdollisista siirroista
     */
    public static ArrayList<Integer> selvitaMahdSiirrot(int[][] puzzle) {

        int[] tyhjanXY= palautaTyhja(puzzle);
        int tyhjanX = tyhjanXY[0];
        int tyhjanY = tyhjanXY[1];
        
        ArrayList<Integer> siirrot = new ArrayList<>();

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
 
    /**
     * Metodi etsii annetusta puzzlesta tyhjän ruudun (16) koordinaatit.
     * @param puzzle
     * @return tyhjän ruudun koordinaatit yksiulotteisena taulukkona.
     */
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
    
    /**
     * Metodi tekee pyydetyn siirron annettuun puzzleen.
     * @param puzzle
     * @param siirtoNro
     * @return puzzle, johon on tehty pyydetty siirto
     */
    public static int[][] teeSiirto(int[][] puzzle, int siirtoNro) {
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

    /**
     * Metodi laskee annetun puzzlen inversiot. Metodia voidaan käyttää kun 
     * tarkestellaan onko puzzlella ratkaisua vai ei.
     * @param puzzle
     * @return annetun puzzlen inversioiden määrä
     */
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
    /**
     * Metodi tarkastaa, onko parametrina annettu puzzle ratkaistavissa.
     * @param puzzle
     * @return true jos puzzle on ratkaistavissa, false jos ei. 
     */
    public static boolean loytyykoRatkaisu(int[][] puzzle) {
        boolean ratkaisuLoytyy = false;
        
        int inv = laskeInversiot(puzzle);
        int[] tyhjanXY = palautaTyhja(puzzle);

        if ((tyhjanXY[0] == 1 | tyhjanXY[0] == 3) && inv % 2 == 0) {
            ratkaisuLoytyy = true;
        }
        
        if ((tyhjanXY[0] == 0 | tyhjanXY[0] == 2) && inv % 2 != 0) {
            ratkaisuLoytyy = true;
        }        
        
        return ratkaisuLoytyy;
    }

}
