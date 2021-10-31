package TukitoimetTest;

import LaurasBozzPuzzle.tuki.Tukitoimet;
import LaurasBozzPuzzle.tuki.Vakiot;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class TukitoimetTest {
        
    public TukitoimetTest() {
    }
  
    @Test
    public void osaaSelvittaaJosSiirtoYLOSMahdollinen() {
        int[][] puzzle = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,14,15,16}
        };
        
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(puzzle);
        assertTrue(mahdSiirrot.contains(1));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoYLOSEiOleMahdollinen() {
        int[][] puzzle = {
            {1,2,3,16}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,14,15,4}
        };
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(puzzle);
        assertFalse(mahdSiirrot.contains(1));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoALASMahdollinen() {
        int[][] puzzle = {
            {1,2,3,16}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,14,15,4}
        };
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(puzzle);
        assertTrue(mahdSiirrot.contains(2));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoALASEiOleMahdollinen() {
        int[][] puzzle = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,14,15,16}
        };
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(puzzle);
        assertFalse(mahdSiirrot.contains(2));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoOIKEALLEMahdollinen() {
        int[][] puzzle = {
            {1,2,16,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,14,15,3}
        };
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(puzzle);
        assertTrue(mahdSiirrot.contains(3));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoOIKEALLEEiOleMahdollinen() {
        int[][] puzzle = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,14,15,16}
        };
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(puzzle);
        assertFalse(mahdSiirrot.contains(3));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoVASEMMALLEMahdollinen() {
        int[][] puzzle = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,14,15,16}
        };
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(puzzle);
        assertTrue(mahdSiirrot.contains(4));    
    }

    @Test
    public void osaaSelvittaaJosSiirtoVASEMMALLEEiOleMahdollinen() {
        int[][] puzzle = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {16,14,15,13}
        };
        ArrayList<Integer> mahdSiirrot = Tukitoimet.selvitaMahdSiirrot(puzzle);
        assertFalse(mahdSiirrot.contains(4));    
    }
    
    @Test
    public void osaaSiirtaaYlos() {
        int[][] puzzleAlussa = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {16,14,15,13}
        };
        int[][] puzzlenTulisiOllaLopussa = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {16,10,11,12}, 
            {9,14,15,13}
        };
        
        int[][] siirretty = Tukitoimet.teeSiirto(puzzleAlussa, 1);
        
        assertTrue(Tukitoimet.onkoSama(siirretty, puzzlenTulisiOllaLopussa));    
    }

    @Test
    public void osaaSiirtaaAlas() {
        int[][] puzzleAlussa = {
            {1,2,3,16}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {4,14,15,13}
        };
        int[][] puzzlenTulisiOllaLopussa = {
            {1,2,3,8}, 
            {5,6,7,16}, 
            {9,10,11,12}, 
            {4,14,15,13}
        };
        
        int[][] siirretty = Tukitoimet.teeSiirto(puzzleAlussa, 2);
        
        assertTrue(Tukitoimet.onkoSama(siirretty, puzzlenTulisiOllaLopussa));    
    }

    @Test
    public void osaaSiirtaaOikealle() {
        int[][] puzzleAlussa = {
            {1,2,16,3}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {4,14,15,13}
        };
        int[][] puzzlenTulisiOllaLopussa = {
            {1,2,3,16}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {4,14,15,13}
        };
        
        int[][] siirretty = Tukitoimet.teeSiirto(puzzleAlussa, 3);
        
        assertTrue(Tukitoimet.onkoSama(siirretty, puzzlenTulisiOllaLopussa));    
    } 
    
    @Test
    public void osaaSiirtaaVasemmalle() {
        int[][] puzzleAlussa = {
            {1,2,3,16}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {4,14,15,13}
        };
        int[][] puzzlenTulisiOllaLopussa = {
            {1,2,16,3}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {4,14,15,13}
        };
        
        int[][] siirretty = Tukitoimet.teeSiirto(puzzleAlussa, 4);
        
        assertTrue(Tukitoimet.onkoSama(siirretty, puzzlenTulisiOllaLopussa));    
    } 
        
    @Test
    public void josLahtokohtanaOnRatkaisuManhattanPalauttaaNolla() {
        int etaisyys = Tukitoimet.laskeManhattan(Vakiot.TAVOITETILA);
        assertEquals(0, etaisyys);
    }

    @Test
    public void josPuuttuuVainYksiSiirtoManhattanPalauttaaYksi() {
        int[][] puzzle = {
            {1,2,3,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,14,16,15}
        };
        
        int etaisyys = Tukitoimet.laskeManhattan(puzzle);
        assertEquals(1, etaisyys);
    }
    
    @Test
    public void inversioLaskeeOikein() {
        
        int[][] puzzle = {
            {3,2,1,4}, 
            {5,6,7,8}, 
            {9,10,11,12}, 
            {13,16,14,15}
        };
        
        int inv = Tukitoimet.laskeInversiot(puzzle);
        assertEquals(3, inv);
            
    }
    
    @Test
    public void puzzlenLuontiPalauttaaPuzzlenJollaRatkaisu() {
        int[][] luotuPuzzle = Tukitoimet.luoPuzzleSekoittamalla(); 
        int inv = Tukitoimet.laskeInversiot(luotuPuzzle);
        int[] tyhjanXY = Tukitoimet.palautaTyhja(luotuPuzzle);
        boolean onkoRatkaisu = false;
        if ((tyhjanXY[0] == 1 | tyhjanXY[0] == 3) && inv % 2 == 0) {
            onkoRatkaisu = true;
        }
        
        if ((tyhjanXY[0] == 0 | tyhjanXY[0] == 2) && inv % 2 != 0) {
            onkoRatkaisu = true;
        }
        
        assertTrue(onkoRatkaisu);
    }
    
    @Test
    public void puzzlenSatunnainenLuontiPalauttaaPuzzlenJossaJokainenNumeroKerran() {
        int[][] luotuPuzzle = Tukitoimet.luoPuzzleSatunnaisesti();
        boolean jokainenLoytyy = true;
        for (int i = 1; i < 17; i++) {
            boolean loytyikoTama = false;
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    if (luotuPuzzle[x][y] == i) {
                        loytyikoTama = true;
                    }
                }
            }
            if (!loytyikoTama) {
                jokainenLoytyy = false;
            }
        }
        assertTrue(jokainenLoytyy);
    }
    
    @Test
    public void palauttaaTrueJosPuzzletOnSamat() {
        int[][] luotuPuzzle = Tukitoimet.luoPuzzleSekoittamalla(); 
        assertTrue(Tukitoimet.onkoSama(luotuPuzzle, luotuPuzzle));
    }
    
    @Test
    public void palauttaaFalseJosPuzzletOnEri() {
        int[][] luotuPuzzle = Tukitoimet.luoPuzzleSekoittamalla(); 
        assertFalse(Tukitoimet.onkoSama(luotuPuzzle, Vakiot.TAVOITETILA));
    }
}
