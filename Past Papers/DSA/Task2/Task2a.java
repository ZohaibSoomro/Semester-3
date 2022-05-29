public class Task2a {
	public static int binarSearch(int array[],int target){
		int p=0;
		int q=array.length-1;
		while(p<=q){
			int mid=(p+q)/2;
			if(array[mid]==target)
				return mid;
			if(array[mid]<target)
				p=mid+1;
			else
				q=mid-1;
		}
		return -1;
	}

	public static void main(String[] args) {
		
		int array[]= {1,15,33,42,43,45,67,73,75,77,89,95};
		int target=95;
		System.out.println("Index of "+target+" is "+binarSearch(array,target));
		target=47;
		System.out.println("Index of "+target+" is "+binarSearch(array,target));
	}
}