public class FibonacciSeries{
	public static int fibonacciSeries(int n){
		if(n==0)
			return 0;
		if(n<3)
			return 1;
		return fibonacciSeries(n-1)+fibonacciSeries(n-2);

	}
	public static void main(String[] args) {
		System.out.println("Fibonacci Series of first 10 whole numbers: \n");
		for (int i=1;i<10;i++)
		 System.out.print(fibonacciSeries(i)+" ");
	}
}