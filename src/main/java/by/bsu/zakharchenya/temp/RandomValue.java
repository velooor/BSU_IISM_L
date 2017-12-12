package by.bsu.zakharchenya.temp;

public abstract class RandomValue {
    protected double[] arr;
    protected int count;

    public RandomValue(int n) {
        count = n;
        arr = new double[count];
    }

    public double[] getArray() {
        return arr;
    }
}
