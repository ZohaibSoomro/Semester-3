public class LinkedStack implements Stack {
	Node start;
	int size;

	private class Node{
		Object data;
		Node next=this;
		Node(Object d,Node n){
			data=d;
			next=n;
		}
	}

	private class RPN{
		public RPN(String array[],LinkedStack stack){
			for (int i=0;i<array.length;i++){
				String input=array[i];
				if (isAnOperator(input)) {
					double lastElem=Double.parseDouble((String)stack.pop());
					double scndLstElem=Double.parseDouble((String)stack.pop());
					double result=evaluate(scndLstElem,lastElem,input);
					stack.push(result+"");
				}
				else{
					stack.push(input);
				}
			}

		}
		public boolean isAnOperator(String op){
			return(op.length()==1 && "+-/*".indexOf(op)>=0);
		}
		public double evaluate(double x,double y, String op){
			double z=0;
			switch(op){
				case "+":
				z=x+y;
				break;

				case "-":
				z=x-y;
				break;

				case "/":
				z=x/y;
				break;

				case "*":
				z=x*y;
				break;
			}
			System.out.println(x+" "+op+" "+y+" = "+z);
			return z;

		}
	}

	public void reversePolishNotation(String array[]){
		new RPN(array,this);
	}

	public Object pop(){
		if(size==0) throw new IllegalStateException("Stack is empty!");
		Object obj=start.data;
		--size;
		start=start.next;
		return obj;
	}
	public Object peek(){
		if(size==0) throw new IllegalStateException("Stack is empty!");
		return start.data;
	}
	public void push(Object obj){
		start=new Node(obj,start);
		size++;
	}
	public int size(){
		return size;
	}
	public String toString(){
		if(size==0) return "[]";
		Node p=start;
		String str="["+p.data;
		while((p=p.next)!=null)
			str+=","+p.data;
		return str+"]";
	} 



	public static void main(String[] args) {
		LinkedStack stack= new LinkedStack();
		
		//System.out.println(stack);
		String src="7 2 + 4 5 - * 9 /";
		//String array[]= src.split("[ ]");
		//String array[]= src.split(" ");
		String array[]= src.split("[\\s]");
		stack.reversePolishNotation(array);
	}
}