
package LaurasBozzPuzzle.ui;

import LaurasBossPuzzle.laskentaJaTuki.LaskentaArrayDeQuella;
import LaurasBossPuzzle.laskentaJaTuki.LaskentaOmallaPinolla;
import LaurasBossPuzzle.laskentaJaTuki.Tukitoimet;
import LaurasBossPuzzle.laskentaJaTuki.Vakiot;
import LaurasBossPuzzle.suorituskyky.SuorituskyvynTestaus;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextUi {
    
    private Scanner scanner;
    LaskentaArrayDeQuella laskenta;
    int[][] puzzle;
    
    public TextUi() {
        this.scanner = new Scanner(System.in);
        this.laskenta = new LaskentaArrayDeQuella();
    }
    
    public void start() {
        
        System.out.println("Tavoitetila:");
        tulostaPuzzle(Vakiot.TAVOITETILA);
        
        System.out.println("Haluatko...");
        System.out.println("(1) Nähdä miten IDA* toimii käytännössä?");
        System.out.println("(2) Testata suorituskykyä?");

        // Tähän täytyy tuoda joku syötteen validointi!!
        int valinta = scanner.nextInt();

        if (valinta == 1) {
            idaStarKaytannossa();
        }

        if (valinta == 2) {      
            testaaSuorituskykya();
        }
      
    }
    
    public void testaaSuorituskykya() {
        SuorituskyvynTestaus sKyky = new SuorituskyvynTestaus();
        sKyky.testaaSekoitettu();
        long arrayDQKestoKA = sKyky.getADQKAAika();
        long omaPinoKestoKA = sKyky.getOmaPKAAika();
        System.out.println("ArrayDeQuella kesti keskimäärin " + arrayDQKestoKA + " Ms");
        System.out.println("OmallaPinolla kesti keskimäärin " + omaPinoKestoKA + " Ms");
        
        try {
            sKyky.tallennaTiedostoon();
            System.out.println("\nTilastot on tallennettu 'suorituskykyTulokset.txt' tiedostoon.");
        } catch (Exception ex) {
            System.out.println("Tallennus ei onnistunut");;
        }
        
    }
    
    
    public void idaStarKaytannossa() {
        
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
        LaskentaArrayDeQuella laskenta = new LaskentaArrayDeQuella();    
        
        long ajanottoAlkaa = System.nanoTime();
        int liikkeidenLkm = laskenta.idaStar(puzzle) - 1;               
        long ajanottoLoppuu = System.nanoTime();
        long kestoMs = (ajanottoLoppuu - ajanottoAlkaa) / 1000000;
        /*for (int i=0; i<liikkeidenLkm+2; i++) {
            int[][] vaihe = laskenta.otaPinosta();
            tulostaPuzzle(vaihe);            
        } */  
        System.out.println("Ratkaisu ArrayDeQueuella");        
        System.out.println("Siirtoja yhteensä:" + liikkeidenLkm);        
        System.out.println("Ratkaisun etsiminen kesti: " + kestoMs + " millisekunttia");

        LaskentaOmallaPinolla laskentaOma = new LaskentaOmallaPinolla();
        ajanottoAlkaa = System.nanoTime();
        liikkeidenLkm = laskentaOma.idaStar(puzzle) - 1;               
        ajanottoLoppuu = System.nanoTime();
        kestoMs = (ajanottoLoppuu - ajanottoAlkaa) / 1000000;       

        System.out.println("Ratkaisu Omalla Pinolla");        
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
