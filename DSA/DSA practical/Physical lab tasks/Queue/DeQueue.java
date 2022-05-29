public class DeQueue{
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

	public void addAtLast(Object object){
		start.prev=start.prev.next=new Node(object,start.prev,start);
		size++;
	}

	public void addAtFirst(Object object){
		start.next=start.next.prev=new Node(object,start,start.next);
		size++;
	}

	public Object first(){
		if(size==0) throw new IllegalStateException("Queue is Empty!");
		return start.next.data;
	}

	public Object last(){
		if(size==0) throw new IllegalStateException("Queue is Empty!");
		return start.prev.data;
	}
	
	public Object removeFirst(){
		if(size==0) throw new IllegalStateException("Queue is Empty!");
		Object obj=start.next.data;
		--size;
		start.next=start.next.next;
		start.next.prev=start;
		return obj;
	}

	public Object removeLast(){
		if(size==0) throw new IllegalStateException("Queue is Empty!");
		Object obj=start.prev.data;
		start.prev=start.prev.prev;
		start.prev.next=start;
		--size;
		return obj;
	}

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

	public static void main(String[] args) {
		DeQueue queue= new DeQueue();
		queue.addAtLast(123);
		queue.addAtLast(23);
		queue.addAtFirst(56);
		System.out.println(queue);
		queue.addAtLast("Hello!");
		System.out.println(queue);
		System.out.println(queue.removeLast());
		System.out.println(queue);
		System.out.println(queue.removeFirst());
		System.out.println(queue);
	}
}