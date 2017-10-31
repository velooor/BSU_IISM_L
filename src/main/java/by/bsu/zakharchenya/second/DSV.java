package by.bsu.zakharchenya.second;

import java.util.ArrayList;
import java.util.List;

import static by.bsu.zakharchenya.first.BSV.mmm;


public class DSV {


    public static List<Double> bernulli(double p, int n) { // распределение Бернулли
        List<Double> row = mmm(n);
        for(int i = 0; i < row.size(); i++){
            row.set(i, f(row.get(i), p));
        }
        return row;
    }

    public static List<Double> geometr(double p, int n) { // распределение Геометрическое
        List<Double> row = mmm(n);
        for(int i = 0; i < row.size(); i++){
            row.set(i, Math.ceil(Math.log(row.get(i))/Math.log(1-p)));
        }
        return row;
    }

    public static List<Double> binom(int m, double p, double n) { // биномиальное распределение
        List<Double> row;
        List<Double> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            row = mmm(m);
            double xTemp = 0;
            for(int j = 0; j < m; j++){
                xTemp += f(p - row.get(j));
            }
            result.add(xTemp);
        }
        return result;
    }


    private static double f(double z){
        return (z <= 0) ? 0 : 1;
    }
    private static double f(double a, double p){
        return (a <= p) ? 1 : 0;
    }
}
