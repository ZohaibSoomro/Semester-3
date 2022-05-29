public class LinkedQueue{
	int size;
	Node head=new Node(null);

	private class Node{
		Object data;
		Node prev,next;
		Node(Object d){
			data=d; prev=next=this;
		}
		Node(Object d,Node p,Node n){
			data=d; prev=p; next=n;
		}
	}
	public boolean add(Object obj){
		head.prev=head.prev.next=new Node(obj,head.prev,head);
		size++;
		return true;
	}
	public Object first(){
		if(size==0) throw new IllegalStateException("Queue is empty!");
		return head.next.data;
	}
	public Object remove(){
		if(size==0) throw new IllegalStateException("Queue is empty!");
		Object obj=head.next.data;
		head.next=head.next.next;
		head.next.prev=head;
		--size;
		return obj;
	}
	public  int size(){
		return size;
	}
	public Object[] toArray(){
		if(size==0) throw new IllegalStateException("Queue is empty!");
		Node p=head;
		Object[] array= new Object[size];
		int counter=0;
		while((p=p.next)!=head)
			array[counter++]=p.data;
		return array;
	}
	public void printData(){
		if(size==0) throw new IllegalStateException("Queue is empty!");
		Node p=head;
		while((p=p.next)!=head)
			System.out.print(p.data+" ");
		System.out.println();
	}
	public boolean reverseQueue(){
		if(size==0) return false;
		Node p=head,temp;
		do{
			temp=p.next;
			p.next=p.prev;
			p.prev=temp;
			p=p.prev;
		}while(p!=head);
		return true;
	}
	public static void main(String[] args) {
		LinkedQueue queue= new LinkedQueue();
		queue.add(2);
		queue.add(4);
		queue.add(5);
		queue.add(8);
		queue.printData();
		Object array[]= queue.toArray();
		for (int i=0;i<array.length;i++) 
			System.out.print(array[i]+" ");
		System.out.println();
		queue.reverseQueue();
		queue.printData();
	}
}