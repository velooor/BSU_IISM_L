package by.bsu.zakharchenya.fourth;

import java.util.List;

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
            //row.set(i, g(row.get(i)));
            a += f(row.get(i))/Math.exp(-row.get(i));
        }
        return a/n;
    }

}


/*

int main()
{
        int point_a = -1;
        int point_b = 1;
        int number_of_random=0;
        double s=0;
        double x;
        double y;
        printf("how much random points? ");
        scanf("%ld",&number_of_random);
        srand((unsigned)time(NULL));
        for (int i=0;i<number_of_random;i++)
        {
             x = 2.0*rand()/RAND_MAX-1.0; //генерируем x в интервале [-1,1]
             y = 2.0*rand()/RAND_MAX-1.0; //генерируем y в интервале [-1,1]
//если сгенерированное число попало в площадь, ограниченную кривой
//на данной координате значение интеграла увеличивается на 1
             if(fabs(y)<func(x)) s+=1
        }
//Делим полученное значение интеграла на общее число "выбросов"
//метода монте-карло
        s=s/(double)number_of_random*(point_b-point_a);
        printf("\nintegral %f \n",s);
        return 0;
}






double bv(double[] a, double[] b, double c,int m,int n){
        int i, tmp;
        double result = c;
        for (i =0;i<n; i++)
        result +=b[i]*a[i];
        tmp=(int)(result/m);
        result -=((double)tmp)*((double)m);
        for(i=1;i<n;i++)
            a[i-1]=a[i];
        a[n-1]=result;
        return result/m;
    }
    // exponential variate p(x )=lexp(-lx),x>=0
    double ev(double 1,double a) {
        return –log(1-a)/1;
    }
    double avg(double*a,int n){
        double s=0;
        for(int i=0;i<n;i++)
            s+=*(a+i);
        return s/n;
    }
    double var(double*a,int n){
        double s=0,s=2;
        for(int i=0;i<n;i++){
            s+=a[i];
            s2+=a[i]*a[i];
        }
        return(s2-s*s/n)/(n-1);
    }
    void main() {
        int i,j;
    const int n=1000;
        double a[2][n];//two pseudorandom sequences
        double b[2][n];//coefficients
        double c[2];    //increment
        int m[2]           //modules

        //initial values
        srand((unsigned) time (NULL) );
        for(j=0;j<2;j++){
            m[j] =RAND_MAX-rand();
            for(i=0;i<n;i++){
                a[j][i]=rand()%m[j];
                b[j][i]=rand();
            }
            c[j]=rand();
        }

        //computation
        double tmp;
    double*A =new double[n];
    double*x =new double[n];
    double*y =new double[n];
        ofstream out(“integral.txt”);
        for(j=1;j<=5;j++){
            for(i=0;i<n;i++){
                do{
                    do{
                        x[i]=ev(2,dv(a[0],b[0],c[0],m[0],n));
                        y[i]=ev(0.5,dv(a[1],b[1],c[1],m[1],n));
                    }
                    while(x[i]-y[i]==0);
                    tmp= 1+log(pow(y[i]-x[i],2));
                }
                while(tmp<0);
                A[i]=sqrt(tmp);
            }
            out<<avg(A,n)<<”\n”;
            out<<var(A,n)<<”\n”;
            out<<0.6745*sqrt(var(A,n)/n)<<”\n\n”;
        }
    }

 */


