public class LinkedQueue implements Queue{
	Node start=new Node(null);
	int size;
	private class Node{
		private Object data;
		private Node prev,next;

		Node(Object data){
			this.data=data;
			prev=next=this;
		}
		Node(Object data,Node p, Node n){
			this.data=data;
			prev=p;
			next=n;
		}
	}

	@Override
	public void add(Object object){
		start.prev=start.prev.next=new Node(object,start.prev,start);
		size++;
	}
	@Override
	public Object first(){
		if(size==0) throw new IllegalStateException("Queue is Empty!");
		return start.next.data;
	}
	@Override
	public Object remove(){
		if(size==0) throw new IllegalStateException("Queue is Empty!");
		Object obj=start.next.data;
		--size;
		start.next=start.next.next;
		start.next.prev=start;
		return obj;
	}
	@Override
	public int size(){
		return size;
	}

	public String toString(){
		if(size==0) return "[]";
		String buff= "[";
		for (Node p=start.next;p!=start;p=p.next) 
			buff+=p.data+",";
		return buff+"\b]";
	}

	public boolean equals(LinkedQueue queue){
		if(this.size()!=queue.size()) return false;
		for (Node p=start.next,q=queue.start.next;p!=start;p=p.next,q=q.next) {
			if(!p.data.equals(q.data))
				return false;
		}
		return true;
	}

	public LinkedQueue clone(){
		if(size==0) return new LinkedQueue();
		LinkedQueue queue = new LinkedQueue();
		for (Node p=start.next;p!=start;p=p.next)
			queue.add(p.data);
		return queue;
	}

	public Object removeBottomElement(){
		if(size==0) throw new IllegalStateException("Queue is Empty!");
		Object obj=start.prev.data;
		start.prev=start.prev.prev;
		start.prev.next=start;
		--size;
		return obj;
	}
	public Stack toStack(){
		if(size==0) throw new IllegalStateException("Queue is Empty!");
		Stack stack= new ArrayStack(size);
		for (Node p=start.next;p!=start;p=p.next)
			stack.push(p.data);
		return stack;
	}

	public void reverse(){
		Node p=start,temp;
		do{
			temp=p.next;
			p.next=p.prev;
			p.prev=temp;
			p=p.prev;
		}while(p!=start);
	}

	public ArrayQueue toArrayQueue(){
		if(size==0) return new ArrayQueue(0);
		ArrayQueue queue= new ArrayQueue();
		for (Node p=start.next;p!=start;p=p.next)
			queue.add(p.data);
		return queue;
	}

	public Object[] toArray(){
		if(size==0) return new Object[0];
		Object array[]= new Object[size];
		int count=0;
		for (Node p=start.next;p!=start;p=p.next)
			array[count++]=p.data;
		return array;
	}

	public static void main(String[] args) {
		LinkedQueue queue= new LinkedQueue();
		queue.add(123);
		queue.add(23);
		queue.add(56);
		queue.add("Hello!");
		System.out.println(queue.toString());
		
		/*LinkedQueue queue2= new LinkedQueue();
		queue2.add(45);
		queue2.add(656);
		ystem.out.println(queue);
		System.out.println(queue.toString());
		System.out.println(queue.equals(queue2));
		System.out.println(queue.clone().toString());
		System.out.println(queue.removeBottomElement());
		System.out.println(queue.toStack());*/
		queue.reverse();
		System.out.println(queue);
		/*System.out.println(queue.toArrayQueue().toString());
		Object array[]=queue.toArray();
		for (int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");*/
	}

}