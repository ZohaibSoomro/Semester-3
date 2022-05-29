import java.util.Arrays;
public class ArrayStack implements Stack {
	int size;
	Object array[];

	public ArrayStack(){
		this(10);
	}
	public ArrayStack(int capacity){
		array=new Object[capacity];
	}

	public void push(Object obj){
		if(size==array.length) resizeArray();
		array[size++]= obj;
	}
	public Object peek(){
		if(size==0) throw new IllegalStateException("Stack is Empty!");
		return array[size-1];
	}
	public Object pop(){
		if(size==0) throw new IllegalStateException("Stack is Empty!");
		Object obj=array[--size];
		array[size]=null;
		return obj;
	}
	public int size(){
		return size();
	}

	public String toString(){
		if(size==0) return "[]";
		String buff= "["+array[--size];
		for (int i=size-1;i>=0;i--) 
			buff+=","+array[i];
		return buff+"]";
	}
	public void resizeArray(){
		array= Arrays.copyOf(array,array.length*2);
	}
}