public class CompareProbing{
	public static void main(String[] args) {
		HashTable table=new HashTable(7,0.5F);		//for linear probing
		HashTable table2=new HashTable(7,0.5F);	//for quadratic probing
		table.putLinearly("PK","PAKISTAN");
		table2.putQuadraticly("PK","PAKISTAN");

		table.putLinearly("1","INDIA");
		table2.putQuadraticly("IN","INDIA");

		table.putLinearly("PT","SOUTH KOREA");
		table2.putQuadraticly("PT","SOUTH KOREA");

		table.putLinearly("JP","IRAN");
		table2.putQuadraticly("JP","IRAN");

		table.putLinearly("AT","MALAYSIA");
		table2.putQuadraticly("AT","MALAYSIA");

		table.putLinearly("1","FRANCE");
		table2.putQuadraticly("PK","FRANCE");

		table.putLinearly("1","USA");
		table2.putQuadraticly("PK","USA");

		table.putLinearly("PK","UK");
		table2.putQuadraticly("PK","UK");

		table.putLinearly("2","ENGLAND");
		table2.putQuadraticly("2","ENGLAND");

		table.putLinearly("1","SINGAPORE");
		table2.putQuadraticly("PK","SINGAPORE");

	}
}