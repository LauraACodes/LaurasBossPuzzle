package TukitoimetTest;

import LaurasBozzPuzzle.Tukitoimet;
import LaurasBozzPuzzle.Vakiot;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TukitoimetTest {
    
    Tukitoimet tukitoimi;
    int[][] sijainnit;
    
    public TukitoimetTest() {
    }
    
    @Before
    public void setUp() {
        this.tukitoimi = new Tukitoimet();
        this.sijainnit = new int[17][2];
    }
  /*
    @Test
    public void osaaSelvittaaJosSiirtoYLOSMahdollinen() {
        sijainnit[16][0] = 0;
        sijainnit[16][1] = 1;
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(sijainnit);
        assertTrue(mahdSiirrot.contains(1));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoYLOSEiOleMahdollinen() {
        sijainnit[16][0] = 0;
        sijainnit[16][1] = 0;
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(sijainnit);
        assertFalse(mahdSiirrot.contains(1));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoALASMahdollinen() {
        sijainnit[16][0] = 0;
        sijainnit[16][1] = 2;
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(sijainnit);
        assertTrue(mahdSiirrot.contains(2));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoALASEiOleMahdollinen() {
        sijainnit[16][0] = 0;
        sijainnit[16][1] = 3;
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(sijainnit);
        assertFalse(mahdSiirrot.contains(2));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoOIKEALLEMahdollinen() {
        sijainnit[16][0] = 2;
        sijainnit[16][1] = 0;
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(sijainnit);
        assertTrue(mahdSiirrot.contains(3));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoOIKEALLEEiOleMahdollinen() {
        sijainnit[16][0] = 3;
        sijainnit[16][1] = 0;
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(sijainnit);
        assertFalse(mahdSiirrot.contains(3));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoVASEMMALLEMahdollinen() {
        sijainnit[16][0] = 1;
        sijainnit[16][1] = 0;
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(sijainnit);
        assertTrue(mahdSiirrot.contains(4));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoVASEMMALLEEiOleMahdollinen() {
        sijainnit[16][0] = 0;
        sijainnit[16][1] = 0;
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(sijainnit);
        assertFalse(mahdSiirrot.contains(4));    
    }
    
    @Test
    public void josLahtokohtanaOnRatkaisuManhattanPalauttaaNolla() {
        int etaisyys = Tukitoimet.laskeManhattan(Vakiot.TAVOITEKOORD);
        assertEquals(0, etaisyys);
    }

    @Test
    public void josPuuttuuVainYksiSiirtoManhattanPalauttaaYksi() {
        int[][] annetutSijainnit = {
            {100,100},
            {0,0},{1,0},{2,0},{3,0},
            {0,1},{1,1},{2,1},{3,1},
            {0,2},{1,2},{2,2},{3,2},  
            {0,3},{1,3},{3,3},{2,3}
        };
        
        int etaisyys = Tukitoimet.laskeManhattan(annetutSijainnit);
        assertEquals(2, etaisyys);
    }*/
}