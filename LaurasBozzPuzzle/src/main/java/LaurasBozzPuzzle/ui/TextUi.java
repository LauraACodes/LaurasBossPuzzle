
package LaurasBozzPuzzle.ui;

import LaurasBossPuzzle.LaskentaJaTuki.Laskenta;
import LaurasBossPuzzle.LaskentaJaTuki.Tukitoimet;
import LaurasBossPuzzle.LaskentaJaTuki.Vakiot;
import java.util.Scanner;

public class TextUi {
    
    private Scanner scanner;
    Laskenta laskenta;
    int[][] puzzle;
    
    public TextUi() {
        this.scanner = new Scanner(System.in);
        this.laskenta = new Laskenta();
    }
    
    public void start() {
        /*int[][] puzzle = {
            {7,5,10,2}, 
            {14,3,12,1}, 
            {16,13,6,15}, 
            {9,4,11,8}
        };*/
               
        System.out.println("Tavoitetila:");
        tulostaPuzzle(Vakiot.TAVOITETILA);
        
        System.out.println("Haluatko...");
        System.out.println("(1) Sekoittamalla luodun lähtötilanteen?");
        System.out.println("(2) Satunnaisesti luodun lähtötilanteen?");

        // Tähän täytyy tuoda joku syötteen validointi!!
        int valinta = scanner.nextInt();

        if (valinta == 1) {
            this.puzzle = Tukitoimet.luoPuzzleSekoittamalla();
        }

        if (valinta == 2) {      
            satunnaisenLuonninValikot();
        }

        System.out.println("Generoitu lähtötilanne:");
        tulostaPuzzle(puzzle);   
        
        System.out.println("Lyhimmän reitin siirrot:");
        Laskenta laskenta = new Laskenta();    
        
        long ajanottoAlkaa = System.nanoTime();
        int liikkeidenLkm = laskenta.idaStar(puzzle) - 1;               
        long ajanottoLoppuu = System.nanoTime();
        long kestoMs = (ajanottoLoppuu - ajanottoAlkaa) / 1000000;
        /*for (int i=0; i<liikkeidenLkm+2; i++) {
            int[][] vaihe = laskenta.otaPinosta();
            tulostaPuzzle(vaihe);            
        } */  
        
        System.out.println("Siirtoja yhteensä:" + liikkeidenLkm);        
        System.out.println("Ratkaisun etsiminen kesti: " + kestoMs + " millisekunttia");
               
    }
    
    public void satunnaisenLuonninValikot() {
        
        while (true) {
            
            this.puzzle = Tukitoimet.luoPuzzleSatunnaisesti();
            boolean onkoRatkaistavissa = Tukitoimet.loytyykoRatkaisu(puzzle);
                
            if (onkoRatkaistavissa) {
                break;
            }
           
            System.out.println("Alta löytyvä lähtötilanne ei ole ratkaistavissa:");
            tulostaPuzzle(puzzle);  
            System.out.println("Yritetään uudelleen...");

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
