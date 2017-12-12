package by.bsu.zakharchenya.fourth;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MMKsystemSolveTest extends Assert {
    private double expectedF = 1.5;
    private double expectedS = 7.07;

    public static final int N = 1000;

    private double [][]A = {{.6, -.2}, {.3, 0.1}};
    private double[] f = {2., 6.};

    @Test
    public void systemSolveTest1(){
        double[] result =MMK.solve(A, f, N, N*20);
        System.out.println(Arrays.toString(result));
        assertEquals(expectedF+expectedS, result[0]+result[1], 0.5);
    }

    @Test
    public void systemSolveTest2(){
        double[] result =MMK.solve(A, f, N*10, N*20);
        System.out.println(Arrays.toString(result));
        assertEquals(expectedF+expectedS, result[0]+result[1], 0.5);
    }

    @Test
    public void systemSolveTest3(){
        double[] result =MMK.solve(A, f, N*100, N*200);
        System.out.println(Arrays.toString(result));
        assertEquals(expectedF+expectedS, result[0]+result[1], 0.5);
    }

    @Test
    public void systemSolveTest4(){
        double[] result =MMK.solve(A, f, N*N, N*2000);
        System.out.println(Arrays.toString(result));
        assertEquals(expectedF+expectedS, result[0]+result[1], 0.5);
    }

    @Test
    public void systemSolveTest5(){
        double[] result =MMK.solve(A, f, N*N, N*2000);
        System.out.println(Arrays.toString(result));
        assertEquals(expectedF+expectedS, result[0]+result[1], 0.5);
    }

    @Test
    public void systemSolveTest6(){
        double[] result =MMK.solve(A, f, N*N*10, N*2000);
        System.out.println(Arrays.toString(result));
        assertEquals(expectedF+expectedS, result[0]+result[1], 0.5);
    }
}