import java.util.Random;
public  class TimingInSort{

	public static void main(String[] args) {
		int array[]= new int[100000];
		Random rand=new Random();
		for (int i=0;i<array.length;i++)
			array[i]=rand.nextInt(100000);
		long t1,t2;
		t1=System.nanoTime();
		bubbleSort(array);
		t2=System.nanoTime();
		System.out.println("\n\nTiming in bubble sort: "+(t2-t1));
		
		t1=System.nanoTime();
		insertionSort(array);
		t2=System.nanoTime();
		System.out.println("\n\nTiming in insertion sort: "+(t2-t1));
	}

	public static void insertionSort(int array[]){
		for (int i=1;i<array.length;i++) {
			int temp=array[i];
			int j=i-1;
			while(j>=0){
				if(array[j]<temp){
					array[j+1]=array[j];
				}
				else 
					break;
				j=j-1;
			}
			array[j+1]=temp;
		}
	}

	public static void bubbleSort(int array[]){
		int size=array.length;
		for (int i=0;i<size;i++) {
			for (int j=0;j<size-i-1;j++) {
				if(array[j]<array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
	}

	
}