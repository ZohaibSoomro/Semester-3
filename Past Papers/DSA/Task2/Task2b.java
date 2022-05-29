public class Task2b{
	int size;
	Node top;
	private class Node{
		Object data;
		Node next;
		Node(Object d,Node n){
			data=d;
			next=n;
		}
	}

	public boolean insert(Object obj){
		top=new Node(obj,top);
		size++;
		return true;
	}

	public String toString(){
		if(size==0) return "[]";
		Node p=top;
		String buf="["+p.data;
		while((p=p.next)!=null)
			buf+=","+p.data;
		return buf+"]";
	}

	public String search(Object target){
		if(size==0) return target+" Not Found!";
		Node p=top;
		while(p!=null){
			if(p.data.equals(target))
				return target+" Found";
			p=p.next;
		}
		return target+" not found!";
	}
	public static void main(String[] args) {
		Task2b list=new Task2b();
		list.insert("biscuits");
		list.insert("patties");
		list.insert("samosa");
		list.insert("sandwich");
		list.insert("cakes");
		list.insert("bread");
		Task2b list2=new Task2b();
		list2.insert("pepsi");
		list2.insert("juice");
		list2.insert("water");
		list2.insert("coffee");
		list2.insert("milk");
		list2.insert("icecream");
		list2.insert("yogurt");

		System.out.println(list.search("samosa"));
		System.out.println(list2.search("coffee"));
	}
}