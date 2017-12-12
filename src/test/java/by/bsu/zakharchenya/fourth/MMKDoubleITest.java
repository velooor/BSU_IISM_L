package by.bsu.zakharchenya.fourth;

import org.junit.Assert;
import org.junit.Test;


public class MMKDoubleITest extends Assert {
    private double expected = 0.67;

    public static final int N = 1000;

    @Test
    public void expKolmogorovTest(){
        double result =MMK.mmkDoubleI(-1., 1., 0., 2., N*5);
        System.out.println(result);
        assertEquals(expected,result,1);
    }

    @Test
    public void expKolmogorovTest1(){
        double result =MMK.mmkDoubleI(-1., 1., 0., 2., N*10);
        System.out.println(result);
        assertEquals(expected,result,0.01);
    }

    @Test
    public void expKolmogorovTest2(){
        double result =MMK.mmkDoubleI(-1., 1., 0., 2., N*100);
        System.out.println(result);
        assertEquals(expected,result,0.01);
    }

    @Test
    public void expKolmogorovTest3(){
        double result =MMK.mmkDoubleI(-1., 1., 0., 2., N*N);
        System.out.println(result);
        assertEquals(expected,result,0.01);
    }

    @Test
    public void expKolmogorovTest4(){
        double result =MMK.mmkDoubleI(-1., 1., 0., 2., N*N);
        System.out.println(result);
        assertEquals(expected,result,0.01);
    }

    @Test
    public void expKolmogorovTest5(){
        double result =MMK.mmkDoubleI(-1., 1., 0., 2., N*N*10);
        System.out.println(result);
        assertEquals(expected,result,0.01);
    }
}