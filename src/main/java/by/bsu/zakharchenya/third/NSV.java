package by.bsu.zakharchenya.third;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static by.bsu.zakharchenya.first.BSV.mmm;

/**
 * Created by Linaelias Velore on 17.10.2017.
 */
public class NSV {
    private double lambda;
    private double a;
    private double b;

    public NSV(double lambda) {
        this.lambda = lambda;
    }

    public NSV(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public List<Double> exp(int n) { // экспоненциальное распределение
        List<Double> row = mmm(n);
        List<Double> result = new ArrayList<>();
        row.forEach(alpha -> result.add(f0(alpha)));
        return result;
    }

    public List<Double> ravn(int n) { // равномерное распределение
        List<Double> row = mmm(n);
        List<Double> result = new ArrayList<>();
        row.forEach(alpha -> result.add(f1(alpha)));
        return result;
    }

    private double f0(double alpha){
        return (-1*(1/lambda))*Math.log(1-alpha);
    }
    private double f1(double alpha){
        return (b-a)*alpha+a;
    }
}
