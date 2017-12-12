package by.bsu.zakharchenya.temp;

public class MKM {
    public MKM(int n, int _m, int indikator){
        amount = n;
        m = _m;
        arr = new double[amount];
        double M = Math.pow(2, 31);
        double alfaS0 = 0.;
        if (indikator  ==0) {
             alfaS0 = Math.pow(2, m) + 3;
        }
        else {
             alfaS0 = Math.pow(5, 2*m+1);
        }
        double beta = alfaS0;
        double alfaS, alfa;
        for(int i = 0; i<n;i++){
            alfaS = beta*alfaS0 - M*(int)(beta*alfaS0/M);
            alfa = alfaS/M;
            arr[i]=alfa;
            alfaS0 = alfaS;
        }
    }

    public double[] getArr(){
        return arr;
    }

    private int amount;
    private int m;
    private double[]arr;
}
