
package LaskentaTest;

import LaurasBossPuzzle.LaskentaJaTuki.Laskenta;
import LaurasBossPuzzle.LaskentaJaTuki.Tukitoimet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class LaskentaTest {
    
    Laskenta laskenta;
    Tukitoimet tukitoimi;
    
    public LaskentaTest() {
    }
    
    
    @Before
    public void setUp() {
        this.tukitoimi = new Tukitoimet();
        this.laskenta = new Laskenta();
    }
    
    @Test
    public void loytaaLyhimmanHelppoCase() {
        int[][] puzzle = {
            {1,2,3,4}, 
            {5,6,16,8}, 
            {9,10,7,12}, 
            {13,14,11,15}
        };
        
        int liikkeidenLkm = laskenta.idaStar(puzzle);
        assertEquals(3, liikkeidenLkm);
    }
    
    @Test
    public void ratkaisuEiTuhannellaYrityksellaOleYli80() {
        boolean eiOleYli80 = true;
        for (int i = 0; i < 1000; i++) {
            Tukitoimet tukit = new Tukitoimet();
            Laskenta lask = new Laskenta();
            int[][] puzzle = tukit.luoPuzzleSekoittamalla();
            int ratkaisunPituus = lask.idaStar(puzzle);
            if (ratkaisunPituus > 80) {
                eiOleYli80 = false;
            }
        }
        assertTrue(eiOleYli80);
    }
}
