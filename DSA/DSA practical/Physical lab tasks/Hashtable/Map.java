public interface Map{
	Object putLinearly(Object key,Object value);
	Object putQuadraticly(Object key,Object value);
	Object get(Object key);
	Object remove(Object key);
	int size();
}