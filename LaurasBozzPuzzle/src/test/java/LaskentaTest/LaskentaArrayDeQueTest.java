
package LaskentaTest;

import LaurasBozzPuzzle.laskenta.IDAStarArrayDeQuella;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class LaskentaArrayDeQueTest {
    
    IDAStarArrayDeQuella laskenta;
    
    public LaskentaArrayDeQueTest() {
    }
    
    
    @Before
    public void setUp() {
        this.laskenta = new IDAStarArrayDeQuella();
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
    public void loytaaLyhimmanVaikeampiCase() {
        int[][] puzzle = {
            {5,1,2,4}, 
            {16,6,3,7}, 
            {9,10,11,8}, 
            {13,14,15,12}
        };
        
        int liikkeidenLkm = laskenta.idaStar(puzzle);
        assertEquals(7, liikkeidenLkm);
    }
}
