package by.bsu.zakharchenya.first;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static by.bsu.zakharchenya.first.BSV.*;

public class BSVTest extends Assert implements TestService {
    public static final double KVANTIL = 0.773373, DELTA_HI = 16.92, DELTA_K = 1.63;
    public static final int N = 1000;
    private static  List<Double> arr1, arr2, ar1;

    @BeforeClass
    public static void init(){
        arr1 = mmm(N);
        arr2 = mkm(N); onScreen(arr2, "Rjyuhe'ynysq");

        ar1 = mmm(N);
    }

    @Ignore
    @Test
    public void mmmMomentTest(){
        assertTrue(momentTest(arr1));
    }

    @Ignore
    @Test
    public void mkmMomentTest(){
        assertTrue(momentTest(arr2));
    }

    @Test
    public void mmmHiTest(){
        assertTrue(hiTest(arr1));
    }

    @Test
    public void mkmHiTest(){
        assertTrue(hiTest(arr2));
    }

    @Test
    public void mmmKolmogorovTest(){
        assertTrue(kolmogorovTest(arr1));
    }

    @Test
    public void mkmKolmogorovTest(){
        assertTrue(kolmogorovTest(arr2));
    }

    @Ignore
    @Test
    public void mmmMomentTest2(){
        assertTrue(momentTest(ar1));
    }



    @Test
    public void mmmHiTest2(){
        assertTrue(hiTest(ar1));
    }



    @Test
    public void mmmKolmogorovTest2(){
        assertTrue(kolmogorovTest(ar1));
    }


}
