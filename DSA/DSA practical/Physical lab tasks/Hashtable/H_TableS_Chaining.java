public class H_TableS_Chaining{
	private Entry entries[];
	int size;
	float loadFactor;

	H_TableS_Chaining(int capacity,float loadFactor){
		entries=new Entry[capacity];
		this.loadFactor=loadFactor;
	}
	H_TableS_Chaining(int capacity){
		this(capacity,0.75F);
	}
	H_TableS_Chaining(){
		this(101);
	}
	private class Entry{
		Object key,value;
		Entry next;				//linkedlist
		Entry(Object key,Object value){
			this.key=key;
			this.value=value;
			next=this;
		}
		Entry(Object key,Object value,Entry next){
			this.key=key;
			this.value=value;
			this.next=next;
		}
	}
	public int hash(Object key){
		if(key==null) throw new NullPointerException();
		return (key.hashCode() & 0x7FFFFFFF) % entries.length;
	}

	public Object put(Object key,Object value){
		if(size>loadFactor*entries.length) reHash();
		int h=hash(key);
		Entry entry=entries[h];
		while(entry!=null){
			if(entry.key.equals(key)){
				Object oldValue=entry.value;
				entry.value=value;
				return oldValue;
			}
			entry=entry.next;
		}
		entries[h]=new Entry(key,value,entries[h]);
		size++;
		return null;
	}

	public Object get(Object key){
		int h=hash(key);
		Entry entry=entries[h];
		while(entry!=null){
			if (entry.key.equals(key)) 
				return entry.value;
			entry=entry.next;
		}
		return new String("Value Not Found!");
	}

	public int size(){
		return size;
	}

	public Object remove(Object key){
		int h=hash(key);
		Entry entry=entries[h];
		if(entry==null) return null;
		if(entries[h].key.equals(key)){
			Object obj=entries[h].value;
		 	entries[h]=entries[h].next;
			size--;
			return obj;
		}
		while(entry.next!=null){
			if (entry.next.key.equals(key)){
				Object obj=entry.next.value;
				entry.next=entry.next.next;
				size--;
				return obj;
			}
			entry=entry.next;
		}
		return null;
	}

	public void reHash(){
		Entry oldEntries[] = entries;
		entries= new Entry[2*oldEntries.length+1];
		for (int k=0;k<oldEntries.length;k++) {
			for (Entry entry=oldEntries[k];entry!=null;entry=entry.next) {
				int h=hash(entry.key);
				//entry.next=entries[h];
				entries[h]=entry;
			}
		}
	}

	public int capacity(){
		return entries.length;
	}

	public static void main(String[] args) {
		H_TableS_Chaining table=new H_TableS_Chaining(5,0.5F);
		table.put("PK","PAKISTAN");
		table.put("IN","INDIA");
		table.put("SK","SOUTH KOREA");
		table.put("ID","INDONESIA");
		table.put("IN","IRAN");	//updating value of ke "IN"
		//table.remove("PK");
		table.put("2","ENGLAND");
		table.put("PT","SOUTH KOREA");
		table.put("JP","IRAN");
		table.put("AT","MALAYSIA");
		table.put("1","FRANCE");
		table.put("1","USA");
		table.put("PK","UK");
		table.put("2","ENG");
		table.put("1","SINGAPORE");
		table.put("1","INDIA");
		


		System.out.println(table.get("AT"));
		
	}
}