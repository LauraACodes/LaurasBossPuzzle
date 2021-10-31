
package LaurasBozzPuzzle.suorituskyky;

import LaurasBozzPuzzle.laskenta.IDAStarArrayDeQuella;
import LaurasBozzPuzzle.laskenta.IDAStarOmallaPinolla;
import LaurasBozzPuzzle.tuki.Tukitoimet;
import java.io.FileWriter;

/**
 * Luokan metodien avulla testataan miten nopeasti IDA* toimii ArrayDeQuella 
 * verrattuna OmaPino-tietorakenteeseen.
 */
public class SuorituskyvynTestaus {
    
    long[][] arrayDeQueStats;
    long arrayDeQueSumma;
    long[][] omaPinoStats;
    long omaPinoSumma;
    
    public SuorituskyvynTestaus() {
        this.arrayDeQueStats = new long[100][2];
        this.omaPinoStats = new long[100][2];
        this.arrayDeQueSumma = 0;
        this.omaPinoSumma = 0;
    }
    
    /**
     * Metodi luo sekoittamalla sata lähtötilannetta ja ratkaisee jokaisen tilanteen kahdella tavalla. 
     * Ratkaisuun kuluneet ajat ja ratkaisun vaatimien liikkeiden määrä tilastoidaan.
     */
    public void testaaSekoitettu() {
        System.out.println("Aloitetaan suorituskyvyn testaus.\n");
        System.out.println("Ohjelma luo sekoittamalla lähtötilanteen sata kertaa.");
        System.out.println("Tämän jälkeen ohjelma ratkaisee jokaisen tilanteen ensin");
        System.out.println("ArrayDeQueta käyttäen ja tämän jälkeen omaa Pinoa käyttäen.");
        System.out.println("Ohjelma tilastoi käytetyn ajan ja löydetyn reitin pituuden.");
        System.out.println("Ohjelman suoritus KESTÄÄ jopa PUOLI TUNTIA eli malttia!\n");
        
        for (int i = 0; i < 100; i++) {
            System.out.println("Testejä jäljellä: " + (100 - i));
            int[][] puzzle = Tukitoimet.luoPuzzleSekoittamalla();
            
            //ratkaisee ArrayDeQuella
            IDAStarArrayDeQuella laskentaADQ = new IDAStarArrayDeQuella();
            long ajanottoAlkaa = System.nanoTime();
            int liikkeidenLkm = laskentaADQ.idaStar(puzzle) - 1;
            long ajanottoLoppuu = System.nanoTime();
            long kestoMs = (ajanottoLoppuu - ajanottoAlkaa) / 1000000;    
            arrayDeQueStats[i][0] = kestoMs;
            arrayDeQueStats[i][1] = liikkeidenLkm;
            arrayDeQueSumma += kestoMs;
            
            //ratkaisee omallaPinolla
            IDAStarOmallaPinolla laskentaPino = new IDAStarOmallaPinolla();
            ajanottoAlkaa = System.nanoTime();
            liikkeidenLkm = laskentaPino.idaStar(puzzle) - 1;
            ajanottoLoppuu = System.nanoTime();
            kestoMs = (ajanottoLoppuu - ajanottoAlkaa) / 1000000;    
            omaPinoStats[i][0] = kestoMs;
            omaPinoStats[i][1] = liikkeidenLkm;
            omaPinoSumma += kestoMs;    
        }
        
    }
    
    /**
     * Metodi tallentaa kertyneet statistiikat tiedostoon.
     * @throws Exception 
     */
    public void tallennaTiedostoon() throws Exception {
        FileWriter kirjoittaja = new FileWriter("suorituskykyTulokset.txt");
        
        kirjoittaja.write("ADQ Statistiikka: \n");
        kirjoittaja.write("\n");
        kirjoittaja.write("[aika(Ms)][siirtojenLkm]\n");
        for (int i = 0; i < 100; i++) {
            kirjoittaja.write(arrayDeQueStats[i][0] + "," + arrayDeQueStats[i][1] + "\n");
        }
        kirjoittaja.write("\n");                        
        kirjoittaja.write("OmanPinon Statistiikka: \n");
        kirjoittaja.write("[aika(Ms)][siirtojenLkm]\n");
        for (int i = 0; i < 100; i++) {
            kirjoittaja.write(omaPinoStats[i][0] + "," + omaPinoStats[i][1] + "\n");
        }
        
        kirjoittaja.close();
    }
    
    public long[][] getArrayDeQueStats() {
        return this.arrayDeQueStats;
    }

    public long[][] getOmaPinoStats() {
        return this.omaPinoStats;
    }
        
    public long getADQKAAika() {
        return arrayDeQueSumma / 100;
    }
    
    public long getOmaPKAAika() {
        return omaPinoSumma / 100;
    }
}
