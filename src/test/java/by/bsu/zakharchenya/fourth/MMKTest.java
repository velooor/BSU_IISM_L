package by.bsu.zakharchenya.fourth;

import org.junit.Assert;
import org.junit.Test;

public class MMKTest extends Assert {
    private double expected = -0.34;

    public static final double lambda = 10, a = 0.1, b=0.02;
    public static final int N = 1000;

    @Test
    public void expKolmogorovTest(){
        double result =MMK.mkk(N);
        System.out.println(result);
        assertEquals(expected,result,0.01);
    }

    @Test
    public void expKolmogorovTest1(){
        double result =MMK.mkk(N*10);
        System.out.println(result);
        assertEquals(expected,result,0.01);
    }

    @Test
    public void expKolmogorovTest2(){
        double result =MMK.mkk(N*100);
        System.out.println(result);
        assertEquals(expected,result,0.01);
    }

    @Test
    public void expKolmogorovTest3(){
        double result =MMK.mkk(N*N);
        System.out.println(result);
        assertEquals(expected,result,0.01);
    }

    @Test
    public void expKolmogorovTest4(){
        double result =MMK.mkk(N*N*10);
        System.out.println(result);
        assertEquals(expected,result,0.01);
    }

    @Test
    public void expKolmogorovTest5(){
        double result =MMK.mkk(N*N*20);
        System.out.println(result);
        assertEquals(expected,result,0.01);
    }
}