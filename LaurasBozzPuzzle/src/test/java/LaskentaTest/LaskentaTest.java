
package LaskentaTest;

import LaurasBossPuzzle.LaskentaJaTuki.Laskenta;
import LaurasBossPuzzle.LaskentaJaTuki.Tukitoimet;
import static org.junit.Assert.assertEquals;
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
}
