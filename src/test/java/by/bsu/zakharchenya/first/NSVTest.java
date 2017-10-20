package by.bsu.zakharchenya.first;

import by.bsu.zakharchenya.third.NSV;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static by.bsu.zakharchenya.first.BSV.onScreen;
import static by.bsu.zakharchenya.second.DSV.bernulli;
import static by.bsu.zakharchenya.second.DSV.geometr;

/**
 * Created by Linaelias Velore on 17.10.2017.
 */
public class NSVTest extends Assert implements TestService {
    private static List<Double> arr1, arr2, arr3;

    public static final double lambda = 10, a = 0.1, b=0.02;
    public static final int N = 1000;

    @BeforeClass
    public static void init(){
        arr1 = new NSV(lambda).exp(N); onScreen(arr1, "Экспоненциальное:");
        arr2 = new NSV(a, b).ravn(N); onScreen(arr2, "Равномерное:");
    }


    @Test
    public void expKolmogorovTest(){
        assertEquals(kolmogorovTest(arr1), true);
    }

    @Test
    public void ravnKolmogorovTest(){
        assertEquals(kolmogorovTest(arr2), true);
    }


}
