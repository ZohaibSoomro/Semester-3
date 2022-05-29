import java.util.Arrays;
public class ArrayQueue implements Queue{
	int size;
	Object array[];
	public ArrayQueue(){
		this(10);
	}
	public ArrayQueue(int capacity){
		array=new Object[capacity];
	}
	@Override
	public void add(Object object){
		if(size==array.length) resizeArray();
		array[size++]= object;
	}
	@Override
	public Object first(){
		if(size==0) throw new IllegalStateException("Queue is Empty!");
		return array[0];
	}
	@Override
	public Object remove(){
		if(size==0) throw new IllegalStateException("Queue is Empty!");
		Object obj=array[0];
		System.arraycopy(array,1,array,0,--size);
		array[size]=null;
		return obj;
	}
	@Override
	public int size(){
		return size;
	}

	public String toString(){
		if(size==0) return "[]";
		String buff= "["+array[0];
		for (int i=1;i<size;i++) 
			buff+=","+array[i];
		return buff+"]";
	}

	public boolean equals(ArrayQueue queue){
		if(this.size()!=queue.size()) return false;
		for (int i=0;i<size();i++) {
			if(!array[i].equals(queue.array[i]))
				return false;
		}
		return true;
	}

	public ArrayQueue clone(){
		if(size==0) return new ArrayQueue();
		ArrayQueue queue = new ArrayQueue();
		for (int i=0;i<size();i++)
			queue.add(array[i]);
		return queue;
	}

	public Object removeBottomElement(){
		if(size==0) throw new IllegalStateException("Queue is Empty!");
		Object obj=array[--size];
		array[size]=null;
		return obj;
	}
	public Stack toStack(){
		if(size==0) throw new IllegalStateException("Queue is Empty!");
		Stack stack= new ArrayStack(size);
		for (int i=0;i<size();i++)
			stack.push(array[i]);
		return stack;
	}

	public void reverse(){
		if(size==0) return;
		for (int i=0;i<size/2;i++) {
			Object temp=array[i];
			array[i]=array[size-i-1];
			array[size-i-1]=temp;
		}
	}

	public LinkedQueue toLinkedQueue(){
		if(size==0) return new LinkedQueue();
		LinkedQueue queue= new LinkedQueue();
		for (int i=0;i<size();i++)
			queue.add(array[i]);
		return queue;
	}

	public void resizeArray(){
		array= Arrays.copyOf(array,array.length*2);
	}


	public static void main(String[] args) {
		ArrayQueue queue= new ArrayQueue();
		queue.add(123);
		queue.add(23);
		queue.add(56);
		queue.add("Hello!");
		queue.add("Hi!");
		ArrayQueue queue2= new ArrayQueue();
		queue2.add(45);
		queue2.add(656);
		System.out.println(queue.toString());
		System.out.println(queue.equals(queue2));
		System.out.println(queue.clone().toString());
		System.out.println(queue.removeBottomElement());
		System.out.println(queue.toStack());
		queue.reverse();
		System.out.println(queue);
		System.out.println(queue.toLinkedQueue().toString());


	}
}