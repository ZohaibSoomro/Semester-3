public class Factorial{
	public static int fact(int n){
		if(n<2)
			return 1;
		return n*fact(n-1);
	}

	public static void main(String[] args) {
		for (int i=2;i<=10;i++) {
			System.out.println(i+"! = "+fact(i));
		}
	}
}