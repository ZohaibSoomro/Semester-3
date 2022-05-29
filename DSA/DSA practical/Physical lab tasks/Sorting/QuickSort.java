public class QuickSort{
	public static void quickSort(int a[], int p,int q){
		if((q-p)<2) return;
		int j=partition(a,p,q);
		quickSort(a,p,j);
		quickSort(a,j+1,q);
	}
	public static int partition(int a[], int p,int q){
		int pivot=a[p];
		int i=p,j=q;
		while(i<j){
			while(j>i && a[--j]>=pivot);
			if(j>i) a[i]=a[j];
			while(i<j && a[++i]<=pivot);
			if(i<j) a[j]=a[i];
	
		}
		a[j]=pivot;
		return j;
	}
	public static void main(String[] args) {
		int array[]={2,5,1,3,7,0,4};
		System.out.print("Before Sorting: ");
		print(array);
		
		quickSort(array,0,array.length);

		System.out.print("\nAfter Sorting: ");
		print(array);
	}
	public static void print(int[] array){
		for (int g:array) {
			System.out.print(g+" ");
		}
	}
}