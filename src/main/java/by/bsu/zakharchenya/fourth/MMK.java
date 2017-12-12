package by.bsu.zakharchenya.fourth;

import by.bsu.zakharchenya.temp.Uniform;

import java.util.Arrays;
import java.util.List;

import static by.bsu.zakharchenya.first.BSV.mkm;
import static by.bsu.zakharchenya.first.BSV.mmm;

/**
 * Monte-Karlo method
 */
public class MMK {
    private static double lambda = 1;
    public static double g(double alpha){
        return -(1/lambda)*Math.log(alpha);
    }
    public static double f(double x){
        return (x*Math.log(x))/(1+Math.pow(x,3));
    }

    public static double mkk(int n){
        List<Double> row = mmm(n);
        row.forEach(alpha -> g(alpha));
        double a = 0;
        for (int i = 0; i < n; i++) {
            a += f(row.get(i))/Math.exp(-row.get(i));
        }
        return a/n;
    }


    private static double g(double x, double y){
        return Math.signum(x*x-y*y+2);
    }

    public static double z(double alpha, double a, double b){
        return (b-a)*alpha+a;
    }
    public static double density(double a, double b){
        return 1/(b-a);
    }

    public static double mmkDoubleI(double a1, double b1, double a2, double b2, int count){
        double sum = 0.;
        double ksi;

        List<Double> row1 = mkm(count);
        row1.forEach(alpha -> z(alpha, a1 , b1));
        List<Double> row2 = mkm(count);
        row2.forEach(alpha -> z(alpha, a2 , b2));

        for(int i =0; i<count;i++){
            ksi = g(row1.get(i), row2.get(i))/(density(a1,b1)*density(a2,b2));
            sum += ksi;
        }
        return sum/count;

    }





    public static double[] solve(double[][]_A, double[]_f, int _N, int m) {
        int size = _A.length;
        double[][] A = new double[size][size];
        for (int i = 0; i < size; i++) {
            A[i] = new double[size];
            for (int j = 0; j < size; j++) {
                A[i][j] = _A[i][j];
            }
        }
        double[] f = Arrays.copyOf(_f, _f.length);
        int chainLength = _N;
        int implementations = m;

        if(!lambdaChecker(size, A)) {
            throw new IllegalArgumentException("[ ATTENTION ] Lambda checker returned false result! Calculating interrupted...");
        }

        double alpha;
        double[] x = new double[size];
        double[] pi = new double[size];
        double[][] p = new double[size][size];
        double[][] h = new double[size][size];

        for(int i = 0; i<size;i++) {
            for(int j = 0; j <size;j++) {
                if(i == j) h[i][j] = 1;
                else h[i][j] = 0;
            }
        }
        for(int i = 0; i<size;i++) {
            x[i] = 0.;
        }
        for (int i = 0; i < size; i++) {
            pi[i] = (double) 1 / size;
        }
        for(int i =0; i<size;i++) {
            p[i] = new double[size];
            for (int j = 0; j < size; j++) {
                p[i][j] = (double) 1 / size;
            }
        }
        for(int j = 0; j<size;j++) {
            int[] chain = new int[chainLength + 1];
            double[] weights = new double[chainLength + 1];
            double[] ksi = new double[implementations];
            for(int i  = 0; i<implementations; i++) {
                ksi[i] = 0.;
            }
            for (int i = 0; i < implementations; i++) {
                alpha = Math.random();
                if (alpha < 0.5) chain[0] = 0;
                else chain[0] = 1;
                for (int k = 1; k <= chainLength; k++) {
                    alpha = Math.random();
                    if (alpha < 0.5) chain[k] = 0;
                    else chain[k] = 1;
                }
                if (pi[chain[0]] > 0) weights[0] = h[j][chain[0]] / pi[chain[0]];
                else weights[0] = 0.;
                for (int k = 1; k <= chainLength; k++) {
                    if (p[chain[k - 1]][chain[k]] > 0)
                        weights[k] = weights[k - 1] * A[chain[k - 1]][chain[k]] / p[chain[k - 1]][chain[k]];
                    else weights[k] = 0.;
                }
                for (int k = 0; k <= chainLength; k++) {
                    ksi[i] += weights[k] * f[chain[k]];
                }
            }
            for (int i = 0; i < implementations; i++) {
                x[j] += ksi[i];
            }
            x[j]/=implementations;
        }
        return x;
    }
    public static boolean lambdaChecker(int size, double[][] A){
        double sum;
        double max  = Double.MIN_VALUE;
        for(int i = 0; i<size;i++){
            sum = 0.;
            for(int j = 0; j<size;j++){
                sum += Math.abs(A[i][j]);
            }
            if (sum > max) max = sum;
        }
        return max < 1;
    }
}
