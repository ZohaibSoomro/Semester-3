public class BubbleSort{
	public static void main(String[] args) {
		int array[]={3,2,6,9,32,1,4};
		for (int g:array) {
			System.out.print(g+" ");
		}
		System.out.println();
		bubbleSort(array);
		for (int g:array) {
			System.out.print(g+" ");
		}

	}
	public static void bubbleSort(int array[]){
		int size=array.length;
		for (int i=0;i<size;i++) {
			for (int j=0;j<size-i-1;j++) {
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
	}
}