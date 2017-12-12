package by.bsu.zakharchenya.temp;

public class Uniform extends RandomValue {

    private double a;
    private double b;
    private int k;

    public Uniform(int n, double _a, double _b, int _k, int indikator){
        super(n);
        a = _a;
        b = _b;
        k = _k;
        double[] x = new MKM(count, k, indikator).getArr();
        for(int i =0; i<count;i++){
            arr[i] = (b-a)*x[i]+a;
        }
    }

    public double density(){
        return 1/(b-a);
    }

}
