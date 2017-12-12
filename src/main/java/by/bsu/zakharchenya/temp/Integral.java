package by.bsu.zakharchenya.temp;

import static java.lang.Math.*;


public class Integral {
    private int count;

    public Integral(int m){
        count = m;
    }

    private double g(double x){
        return pow(E, -x*x);
    }

    public double MonteKarloEvaluation(){
        double ksi;
        double sum = 0.;
        Exponential exponential = new Exponential(count, 2);
        double []y = exponential.getArr();
        for(int i =0; i<count;i++){
            ksi = g(y[i])/exponential.density(y[i]);
            sum += ksi;
        }
        return sum/count;

    }
}
