public class InsertionSort{
	public static void insertionSort(int array[]){
		for (int i=1;i<array.length;i++) {
			int temp=array[i];
			int j=i-1;
			while(j>=0){
				if(array[j]>temp){
					array[j+1]=array[j];
				}
				else 
					break;
				j=j-1;
			}
			array[j+1]=temp;
		}
	}
	public static void main(String[] args) {
		int array[]={2,5,1,3,7,0,4};
		System.out.print("Before Sorting: ");
		for (int g:array) {
			System.out.print(g+" ");
		}
		insertionSort(array);
		System.out.print("\nAfter Sorting: ");
		for (int g:array) {
			System.out.print(g+" ");
		}
	}
}