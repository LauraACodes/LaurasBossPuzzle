package tukitoimet;

import LaurasBozzPuzzle.Tukitoimet;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TukitoimetTest {
    Tukitoimet tukitoimi;
    
    public TukitoimetTest() {
        this.tukitoimi = new Tukitoimet();
    }
   

    @Test
    public void osaaSelvittaaJosSiirtoYLOSMahdollinen() {
        int[][] sijainnit = new int[16][2];
        sijainnit[16][0] = 0;
        sijainnit[16][1] = 1;
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(sijainnit);
        assertTrue(mahdSiirrot.contains(1));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoYLOSEiOleMahdollinen() {
        int[][] sijainnit = new int[16][2];
        sijainnit[16][0] = 0;
        sijainnit[16][1] = 0;
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(sijainnit);
        assertFalse(mahdSiirrot.contains(1));    
    }
}
