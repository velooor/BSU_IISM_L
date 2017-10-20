package by.bsu.zakharchenya.first;

import java.util.ArrayList;
import java.util.List;

import static by.bsu.zakharchenya.first.BSV.k;

interface TestService {
    double KVANTIL = 0.773373, DELTA_HI = 16.92, DELTA_K = 30; // DELTA_K = 1.63;
    int N = 1000;

    default boolean momentTest(List<Double> row) { //метод совпадения моментов
        int count = row.size();
        double m = 0;
        for (int i = 0; i < count; i++) {
            m += row.get(i);
        }
        m /= count;
        double s = 0;
        for (int i = 0; i < count; i++) {
            s += (row.get(i) - m);
        }
        s /= (count - 1);
        double ksi1 = m - 0.5,
                ksi2 = s - 1.0 / 12,
                c1 = Math.sqrt(12 * count),
                c2 = ((count - 1) * 1.0 / count) * Math.pow(0.0056 * Math.pow(count, -1) + 0.0028 * Math.pow(count, -2) - 0.0083 * Math.pow(count, -3), -0.5);
        System.out.println(" Среднее значение = " + m + ", \n отклонение от нормального = " + ksi1 + "\n тест пройден = " + (c1 * Math.abs(ksi1) < KVANTIL) + " \n" + " дисперсия = " + s + ", \n отклонение от нормальной = " + ksi2 + "\n тест пройден = " + (c2 * Math.abs(ksi2) < KVANTIL));
        return c1 * Math.abs(ksi1) < KVANTIL;
    }

    default boolean hiTest(List<Double> row) { // hi^2
        double min = row.get(0), max = row.get(0);
        for (int i = 1; i < row.size(); i++) {
            min = Math.min(min, row.get(i));
            max = Math.max(max, row.get(i));
        }
        List<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            c.add(0);
        }
        double step = (max - min) / k;
        for (int i = 0; i < row.size(); i++) {
            int t = 0;
            while (min + t * step <= row.get(i) && min + t * step < max) {
                t++;
            }
            c.set(t - 1, c.get(t - 1) + 1);
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += (c.get(i) - N * (1.0 / k)) * (c.get(i) - N * (1.0 / k));
        }
        return k * (ans / N) < DELTA_HI;
    }

    default boolean kolmogorovTest(List<Double> row) {
        List<Double> ff = new ArrayList<>();
        for (int i = 0; i < row.size(); i++) {
            ff.add(Math.abs(fX(row, row.get(i)) - row.get(i)));
        }
        double dn = ff.get(0);
        for (int i = 1; i < row.size(); i++) {
            dn = Math.max(dn, ff.get(i));
        }
        System.out.println("K-Test: " + Math.sqrt(N) * dn);
        return Math.sqrt(N) * dn < DELTA_K;
    }

    static double fX(List<Double> row, double x) {
        double res = 0;
        for (int i = 0; i < row.size(); i++) {
            int temp = 0;
            if (x > row.get(i)) {
                temp = 1;
            }
            res += temp;
        }
        return res / row.size();
    }

    default boolean hi2BernulliTest(List<Double> row, double p) { // hi^2
        double min = row.get(0), max = row.get(0);
        for (int i = 1; i < row.size(); i++) {
            min = Math.min(min, row.get(i));
            max = Math.max(max, row.get(i));
        }
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            c.add(0);
        }
        double step = (max - min) / k;
        for (int i = 0; i < row.size(); i++) {
            int t = 0;
            while (min + t * step <= row.get(i) && min + t * step < max) {
                t++;
            }
            c.set(t - 1, c.get(t - 1) + 1);
        }
        int ans = 0, t = 1;
        for (int i = 0; i < k; i++) {
            double pK = bernulliF(min + t*step, p) - bernulliF(min + (t-1)*step, p); t++;
            ans += Math.pow(c.get(i) - N * pK, 2)/(N*pK);
        }
        return ans >= 0;
    }
    default double bernulliF(double x, double p) {
        double res = 0;
        for(int i = 0; i < x; i++){
            res += Math.pow(p,i)*Math.pow(1-p,1-i);
        }
        return res;
    }

    default boolean hi2GeomTest(List<Double> row, double p) { // hi^2
        double min = row.get(0), max = row.get(0);
        for (int i = 1; i < row.size(); i++) {
            min = Math.min(min, row.get(i));
            max = Math.max(max, row.get(i));
        }
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            c.add(0);
        }
        double step = (max - min) / k;
        for (int i = 0; i < row.size(); i++) {
            int t = 0;
            while (min + t * step <= row.get(i) && min + t * step < max) {
                t++;
            }
            c.set(t - 1, c.get(t - 1) + 1);
        }
        int ans = 0, t = 1;
        for (int i = 0; i < k; i++) {
            double pK = geomF(min + t*step, p) - geomF(min + (t-1)*step, p); t++;
            ans += Math.pow(c.get(i) - N * pK, 2)/(N*pK);
        }
        return ans >= 0;
    }
    default double geomF(double x, double p) {
        return 1-Math.pow(1-p, x);
    }
}
