package by.bsu.zakharchenya.first;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static by.bsu.zakharchenya.first.BSV.*;
import static by.bsu.zakharchenya.first.BSV.k;
import static by.bsu.zakharchenya.second.DSV.bernulli;
import static by.bsu.zakharchenya.second.DSV.binom;
import static by.bsu.zakharchenya.second.DSV.geometr;


public class DSVTest extends Assert implements TestService {
    public static final double KVANTIL = 0.773373, DELTA_HI = 16.92, DELTA_K = 1.63;
    private static List<Double> arr1, arr2, arr3;

    public static final double P = 0.5;
    public static final int M = 50, N = 1000;

    @BeforeClass
    public static void init(){
        arr1 = bernulli(P, N); onScreen(arr1, "Бернулли:");
        //arr2 = binom(M, P, N); onScreen(arr2, "Биномиальное:");
        arr3 = geometr(P, N); onScreen(arr3, "Геометрическое:");
    }


    @Test
    public void bernulliHiTest(){
        assertEquals(hi2BernulliTest(arr1, P), true);
    }

    @Test
    public void geomHiTest(){
        assertEquals(hi2GeomTest(arr3, P), true);
    }
}
