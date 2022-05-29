public class TowerOfHanoi{
	public static void towerOfHanoi(int n,char src,char dst,char aux){
		if(n==1){
			System.out.println("Disk "+n+" moved from "+src+" to "+dst);
			return;
		}
		towerOfHanoi(n-1,src,aux,dst);
		System.out.println("Disk "+n+" moved from "+src+" to "+dst);
		towerOfHanoi(n-1,aux,dst,src);
	}

	public static void main(String[] args) {

	 java.util.Scanner scan= new java.util.Scanner(System.in);
		System.out.print("Enter no of disks: ");
		int n=scan.nextInt();
		towerOfHanoi(n,'A','B','C');
	}
}