package by.bsu.zakharchenya.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BSV {

    public static final long M = 2147483648L;
    public static final int BETA = 268435459, K = 256, k = 10;


    public static List<Double> mkm(int n) { //мультипликативный конгруэнтный метод
        List<Double> row = new ArrayList<Double>();
        long alpha = (long) BETA;
        for (int i = 0; i < n; i++) {
            alpha = (alpha * BETA) % M;
            row.add(alpha * (1.0 / M));
            //System.out.print(row.get(i) + ", ");
        }
        //System.out.println("\n\n");
        return row;
    }

    public static List<Double> mmm(int n) { //метод Макларена-Марсельи
        long temp = (long) BETA;
        //System.out.println("Метод Макларена-Марсельи:");
        List<Double> row = new ArrayList<Double>();
        List<Double> v = new ArrayList<Double>();
        List<Double> c = new ArrayList<Double>();
        List<Double> b = new ArrayList<Double>();
        Random r = new Random();
        for (int i = 0; i < n + K; i++) {
            temp = (temp * BETA) % M;
            b.add(temp * (1.0 / M));
        }

        for (int i = 0; i < n; i++)
            c.add(r.nextDouble());


        for (int i = 0; i < K; i++)
            v.add(b.get(i));

        for (int i = 0; i < n; i++) {
            int s = (int) (c.get(i) * K);
            row.add(v.get(s));
            v.set(s, b.get(i + K));
            //System.out.print(row.get(i) + ", ");
        }
        //System.out.println("\n\n");
        return row;
    }

    public static void onScreen(List<Double> row, String head) {
        System.out.println(head);
        row.forEach(r -> System.out.print(r+", "));
        System.out.println("\n\n");
    }

}
