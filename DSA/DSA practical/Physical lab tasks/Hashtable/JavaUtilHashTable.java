import java.util.*;
public class JavaUtilHashTable{
	public static void main(String[] args) {
		Hashtable<Object,Object> table= new Hashtable<Object,Object>();
		table.put("PK","Pakistan");    //#1
		table.put("2","India");    
		table.put(3,56);    
		table.put(4,150);

		System.out.println(table.isEmpty());   //#2
		System.out.println(table.toString());   //#3    
		System.out.println(table.size());   	//#4
		System.out.println(table.get("4"));     //#5     

	}
}