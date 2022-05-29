public class MergeSort{
	public static void mergeSort(int a[], int p,int q){
		if((q-p)<2) return;
		int m=(p+q)/2;
		mergeSort(a,p,m);
		mergeSort(a,m,q);
		merge(a,p,m,q);
	}
	public static void merge(int a[], int p,int m,int q){
		if(a[m-1]<=a[m]) return;
		int i=p,j=m,k=0;
		int mergedArray[]=new int[q-p];
		while(i<m & j<q){
			if(a[i]<a[j])
				mergedArray[k++]=a[i++];
			else
				mergedArray[k++]=a[j++];
		}
		if (i<m) 
			System.arraycopy(a,i,a,p+k,m-i);
		System.arraycopy(mergedArray,0,a,p,k);

	}
	public static void main(String[] args) {
		int array[]={2,5,1,3,7,0,4};
		System.out.print("Before Sorting: ");
		print(array);
		
		mergeSort(array,0,array.length);

		System.out.print("\nAfter Sorting: ");
		print(array);
	}
	public static void print(int[] array){
		for (int g:array) {
			System.out.print(g+" ");
		}
	}
}