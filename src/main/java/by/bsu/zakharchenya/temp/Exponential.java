package by.bsu.zakharchenya.temp;

public class Exponential extends RandomValue{

    private double lambda;

    public Exponential(int n, double lambda){
        super(n);
        this.lambda = lambda;
        /*double[]a = new double[count];
        for(int i =0; i<count;i++){
            a[i] = Math.random();
        }*/
        double[] a = new MKM(count, 5, 1).getArr();
        for(int i =0; i<count;i++) {
            arr[i] = (-Math.log(a[i])) / lambda;
        }

    }

    public double[]getArr(){
        return arr;
    }

    public double F(double x){
        return 1 - Math.pow(Math.E, -lambda*x);
    }

    public double density(double x){
        return lambda*Math.pow(Math.E, -lambda*x);
    }
}
