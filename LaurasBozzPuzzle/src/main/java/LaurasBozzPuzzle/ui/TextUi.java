
package LaurasBozzPuzzle.ui;

import LaurasBozzPuzzle.laskenta.IDAStarArrayDeQuella;
import LaurasBozzPuzzle.laskenta.IDAStarOmallaPinolla;
import LaurasBozzPuzzle.tuki.Tukitoimet;
import LaurasBozzPuzzle.tuki.Vakiot;
import LaurasBozzPuzzle.suorituskyky.SuorituskyvynTestaus;
import java.util.Scanner;

/**
 * Luokassa on ohjelman käyttöliittymän toiminnot
 */
public class TextUi {
    
    private Scanner scanner;
    int[][] puzzle;
    
    public TextUi() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Metodi käynnistää ohjelman ja kysyy, haluaako käyttäjä
     * nähdä miten IDA* toimii vai
     * testata ratkaisijan suorituskykyä.
     */
    public void start() {
        
        System.out.println("Tervetuloa 15-puzzlen ratkaisijaan!\n");
        System.out.println("Haluatko...");
        System.out.println("(1) Nähdä miten IDA* toimii käytännössä?");
        System.out.println("(2) Testata ratkaisijan suorituskykyä?");

        int valinta = scanner.nextInt();

        if (valinta == 1) {
            System.out.println("Tavoitetila:");
            tulostaPuzzle(Vakiot.TAVOITETILA);
            
            lahtoTilanteenLuonti();
            idaStarKomennot();
        }

        if (valinta == 2) {      
            testaaSuorituskykya();
        }
      
    }
    /**
     * Metodi hoitaa käytännössä controllerin tehtäviä kutsumalla eri
     * ratkaisijoita ja kertoo niiden tulokset.
     */
    public void idaStarKomennot() {

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
        
        naytaSiirrot(laskenta, liikkeidenLkm);
    }
    /**
     * Metodi kysyy haluaako käyttäjä sekoittamalla vai satunnaisesti 
     * luodun lähtötilanteen ja kutsuu vastaavia metodeja luomaan 
     * löhtötilanteen. Lopussa metodi tulostaa sen.
     */
    public void lahtoTilanteenLuonti() {
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
    
    /**
     * Metodi kutsuu satunnaisen pelilaudan luovaa metodia niin kauan
     * kunnes ratkaistavissa oleva pelilauta onnistutaan luomaan.
     */
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
    
    /**
     * Metodi näyttää pyydettäessä ratkaisun eri siirrot.
     * 
     * @param laskenta
     * @param liikkeidenLkm 
     */
    public void naytaSiirrot(IDAStarArrayDeQuella laskenta, int liikkeidenLkm) {
        
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
    
    /**
     * Metodi käynnistää ja raporoi suorituskyvyn testauksen tulokset.
     */
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
    
    /**
     * Metodi tulostaa sille annetun pelilaudan
     * @param puzzle 
     */
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
