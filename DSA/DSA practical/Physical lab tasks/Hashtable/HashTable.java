public class HashTable implements Map{
	private Entry entries[];
	int size,used;
	float loadFactor;
	private final Entry NIL= new Entry(null,null);

	HashTable(int capacity,float loadFactor){
		entries=new Entry[capacity];
		this.loadFactor=loadFactor;
	}
	HashTable(int capacity){
		this(capacity,0.75F);
	}
	HashTable(){
		this(101);
	}private class Entry{
		Object key,value;
		Entry(Object key,Object value){
			this.key=key;
			this.value=value;
		}
	
	}
	public int hash(Object key){
		if(key==null) throw new NullPointerException();
		return (key.hashCode() & 0x7FFFFFFF) % entries.length;
	}

	public Object putLinearly(Object key,Object value){
		if(used>loadFactor*entries.length) reHash();
		int h=hash(key);
		for (int i=0;i<entries.length;i++) {
			int j= nextProbe(h,i);
			if (entries[j]==null) {
				entries[j]=new Entry(key,value);
				System.out.println(i+" Collisions occured for (key,value): ("+key+","+value+")");
				size++;
				used++;
				return null;
			}
			if(entries[j]==NIL) continue;
			if(entries[j].key.equals(key)){
				Object oldValue=entries[j].value;
				entries[j].value=value;
				System.out.println(i+" Collisions occured for (key,value): ("+key+","+value+")");
				return oldValue;
			}
		}
		throw new IllegalStateException("Table Overflow!");
	}

	public Object putQuadraticly(Object key,Object value){
		if(used>loadFactor*entries.length) reHash();
		int h=hash(key);
		for (int i=0;i<entries.length;i++) {
			int j= nextProbe(h,i*i);				//quadratic probing
			if (entries[j]==null) {
				entries[j]=new Entry(key,value);
				System.out.println(i+" Collisions occured for (key,value): ("+key+","+value+")");
				size++;
				used++;
				return null;
			}
			if(entries[j]==NIL) continue;
			if(entries[j].key.equals(key)){
				Object oldValue=entries[j].value;
				entries[j].value=value;
			    System.out.println(i+" Collisions occured for (key,value): ("+key+","+value+")+ Old Value("+oldValue+")Updated");
				return oldValue;
			}
		}
		throw new IllegalStateException("Table Overflow!");
	}

	public int nextProbe(int h,int i){
		return (h+i)%entries.length;			
	}

	public Object get(Object key){
		int h=hash(key);

		for (int i=0;i<entries.length;i++) {
			int j= nextProbe(h,i);
			if (entries[j]==null)break;
			if(entries[j]==NIL) continue;
			if(entries[j].key.equals(key))
				return entries[j].value;			
		}
		throw new IllegalStateException("Value Not Found!");
	}

	public int size(){
		return size;
	}

	public Object remove(Object key){
		int h=hash(key);

		for (int i=0;i<entries.length;i++) {
			int j= nextProbe(h,i);

			if (entries[j]==null)break;
			if(entries[j]==NIL) continue;

			if(entries[j].key.equals(key)){
				Object oldValue=entries[j].value;
				entries[j]=NIL;
				--size;
				return oldValue;
			}		
		}
		throw new IllegalStateException("Value Not Found!");
	}

	public void reHash(){
		Entry oldEntries[] = entries;
		entries= new Entry[2*oldEntries.length+1];
		for (int k=0;k<oldEntries.length;k++) {
			if(oldEntries[k]==null || oldEntries[k]==NIL)
				continue;

			int h= hash(oldEntries[k].key);
			for (int i=0;i<entries.length;i++) {
				int j=nextProbe(h,i);				
				if (entries[j]==null) {
					entries[j]=oldEntries[k];
					break;
				}
			}
		}
		used=size;
	}

	public int capacity(){
		return entries.length;
	}

	public static void main(String[] args) {
		HashTable table=new HashTable(7,0.5F);
		table.putQuadraticly("PK","PAKISTAN");
		table.putQuadraticly("IN","INDIA");
		table.putQuadraticly("SK","SOUTH KOREA");
		table.putQuadraticly("ID","INDONESIA");
		table.putQuadraticly("IN","IRAN");	//updating value of ke "IN"


		System.out.println(table.get("IN"));
		
	}
}