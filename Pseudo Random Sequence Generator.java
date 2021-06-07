import java.io.*;
import java.util.*;
import java.lang.*;
class miniproject
{

    static double polynomial(int poly[], int n, double x)
    {
        // Initialize result
        double result = poly[0];

        // Evaluate value of polynomial
        for (int i=1; i<n; i++)
            result = result*x + poly[i];

        return result;
    }

    static int[] prsg(int poly[],double a,double b,int n,int l) //Using proposed algorithm of regula falsi method
      {
         int[] seq;
         seq = new int[l];
         double m,m1,m2;
         double x= a - ((polynomial(poly,poly.length,a)*(b-a))/(polynomial(poly,poly.length,b)-(polynomial(poly,poly.length,a))));
         int k,i;
         for(i=0;i<l;i++)
         {
            seq[i]=(int)((Math.floor(Math.abs(polynomial(poly,poly.length,x))*100000)%(Math.pow(2,n))));
            m = (Math.floor(Math.abs(polynomial(poly,poly.length,x))*1000)%4);
            if(m==0||m==3)
            {
               m1=1/(1-(Math.abs(polynomial(poly,poly.length,x))-Math.floor(Math.abs(polynomial(poly,poly.length,x)))));
               m2=1/(1+(Math.abs(polynomial(poly,poly.length,x))-Math.floor(Math.abs(polynomial(poly,poly.length,x)))));
            }
            else
             {
               m1=1/(1+(Math.abs(polynomial(poly,poly.length,x))-Math.floor(Math.abs(polynomial(poly,poly.length,x)))));
               m2=1/(1-(Math.abs(polynomial(poly,poly.length,x))-Math.floor(Math.abs(polynomial(poly,poly.length,x)))));
             }
             x= a - (polynomial(poly,poly.length,a)*(b-a)*m1)/(m2*polynomial(poly,poly.length,b)-(m1*polynomial(poly,poly.length,a)));
          }
          return seq;
       }

    // Driver program
    public static void main (String[] args) throws IOException
    {
        int[] poly;
        int i,d,n,l;
        double vara;
        double varb;
        FileWriter x= new FileWriter("input.txt"); // creates a file to contain the sequence bits

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the highest degree of polynomial:");
        d= sc.nextInt();
        System.out.println("Enter the polynomial:");
        poly=new int[d+1];
        for(i=0;i<d+1;i++)
        poly[i]=sc.nextInt();
        System.out.println("Enter two initial points:");
        vara=sc.nextDouble();
        varb=sc.nextDouble();
        System.out.println("Enter bit length of each term:");
        n=sc.nextInt();
        System.out.println("Enter length of sequence:");
        l=sc.nextInt();
        int res[]=prsg(poly,vara,varb,n,l);
        for(i=0;i<res.length;i++)
        {
           System.out.println(res[i]);
           x.write(String.valueOf((res[i])));
        }
        x.close();
    }
}
