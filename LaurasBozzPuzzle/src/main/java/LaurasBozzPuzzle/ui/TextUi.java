
package LaurasBozzPuzzle.ui;

import LaurasBozzPuzzle.LaskentaJaTuki.IDAStarArrayDeQuella;
import LaurasBozzPuzzle.LaskentaJaTuki.IDAStarOmallaPinolla;
import LaurasBozzPuzzle.LaskentaJaTuki.Tukitoimet;
import LaurasBozzPuzzle.LaskentaJaTuki.Vakiot;
import LaurasBozzPuzzle.Suorituskyky.SuorituskyvynTestaus;
import java.util.Scanner;

public class TextUi {
    
    private Scanner scanner;
    IDAStarArrayDeQuella laskenta;
    int[][] puzzle;
    
    public TextUi() {
        this.scanner = new Scanner(System.in);
        this.laskenta = new IDAStarArrayDeQuella();
    }
    
    public void start() {
        
        System.out.println("Tervetuloa 15-puzzlen ratkaisijaan!\n");
        System.out.println("Haluatko...");
        System.out.println("(1) Nähdä miten IDA* toimii käytännössä?");
        System.out.println("(2) Testata ratkaisijan suorituskykyä?");

        int valinta = scanner.nextInt();

        if (valinta == 1) {
            System.out.println("Tavoitetila:");
            tulostaPuzzle(Vakiot.TAVOITETILA);
            
            lahtotilanteenLuonti();
            idaStarKaytannossa();
        }

        if (valinta == 2) {      
            testaaSuorituskykya();
        }
      
    }
    
    public void idaStarKaytannossa() {

        System.out.println("Ratkaisija etsii ratkaisun IDA*-algoritmilla hyödyntäen heuristiikkana Manhattan-etäisyyksiä. ");
        System.out.println("Ensin ratkaisu etsitään hyödyntäen Javan valmista ArrayDeQueata.");
        System.out.println("Tämän jälkeen ratkaisu etsitään hyödyntäen Lauran rakentamaa omaa pinoa.\n");
        
        IDAStarArrayDeQuella laskenta = new IDAStarArrayDeQuella();    
        
        long ajanottoAlkaa = System.nanoTime();
        int liikkeidenLkm = laskenta.idaStar(puzzle) - 1;               
        long ajanottoLoppuu = System.nanoTime();
        long kestoMs = (ajanottoLoppuu - ajanottoAlkaa) / 1000000;

        System.out.println("Ratkaisu ArrayDeQueuella");        
        System.out.println("Siirtoja yhteensä:" + liikkeidenLkm);        
        System.out.println("Ratkaisun etsiminen kesti: " + kestoMs + " millisekunttia\n");

        IDAStarOmallaPinolla laskentaOma = new IDAStarOmallaPinolla();
        ajanottoAlkaa = System.nanoTime();
        liikkeidenLkm = laskentaOma.idaStar(puzzle) - 1;               
        ajanottoLoppuu = System.nanoTime();
        kestoMs = (ajanottoLoppuu - ajanottoAlkaa) / 1000000;       

        System.out.println("Ratkaisu Omalla Pinolla");        
        System.out.println("Siirtoja yhteensä:" + liikkeidenLkm);        
        System.out.println("Ratkaisun etsiminen kesti: " + kestoMs + " millisekunttia\n");   
        
        siirtojenNayttaminen(laskenta, liikkeidenLkm);
    }
    
    public void lahtotilanteenLuonti() {
        System.out.println("Haluatko...");
        System.out.println("(1) Sekoittamalla luodun lähtötilanteen?");
        System.out.println("(2) Satunnaisesti luodun lähtötilanteen?");

        int valinta = scanner.nextInt();

        if (valinta == 1) {
            this.puzzle = Tukitoimet.luoPuzzleSekoittamalla();
        }

        if (valinta == 2) {      
            satunnaisenLuonninValikot();
        }

        System.out.println("Generoitu lähtötilanne:");
        tulostaPuzzle(puzzle);         
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
    
    public void siirtojenNayttaminen(IDAStarArrayDeQuella laskenta, int liikkeidenLkm) {
        
        System.out.println("Haluatko nähdä siirrot?");
        System.out.println("(1) Kyllä haluan");
        System.out.println("(2) En halua");

        int haluaakoSiirrot = scanner.nextInt();
        
        if (haluaakoSiirrot == 1) {
            for (int i = 0; i < liikkeidenLkm + 2; i++) {
                int[][] vaihe = laskenta.otaPinosta();
                tulostaPuzzle(vaihe);            
            }   
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
