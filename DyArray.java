
public class DyArray<E> {
	
	private static final int DEFAULT_INITIAL_SIZE = 10;
	
	private int size;
	private E[] con;
	
	public DyArray(){
		con = (E[]) new Object[DEFAULT_INITIAL_SIZE];
	}
	
	public DyArray(int newSize) {
		if(newSize < 0) {
			throw new IllegalArgumentException("negative size");
		}
		con = (E[]) new Object[DEFAULT_INITIAL_SIZE+newSize];
	}
	
	public DyArray(E[] data) {
		if(data == null) {
			throw new IllegalArgumentException("null data");
		}
		size = data.length;
		con = (E[]) new Object[DEFAULT_INITIAL_SIZE+data.length];
		System.arraycopy(data, 0, con, 0, data.length);
	}
	
	public E get(int index) {
		return con[index];
	}
	
	public void add(E newData) {
		insert(size, newData);
	}
	
	public void insert(int index, E newData) {
		if(size == con.length) {
			resize(con.length*4);
		}
		for(int i=size; index<i; i--) {
			con[i]=con[i-1];
		}
		con[index]=newData;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	private void resize(int newSize) {
		E[] newList = (E[]) new Object[newSize];
		System.arraycopy(con, 0, newList, 0, con.length);
		con = newList;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		if(size == 0) {
			result.append("[]");
			return result.toString();
		}else {
			result.append("[");
			result.append(con[0]);
			for(int i=1; i<size; i++) {
				result.append(",");
				result.append(con[i]);
			}
			result.append("]");
			return result.toString();
		}
		
	}
}
