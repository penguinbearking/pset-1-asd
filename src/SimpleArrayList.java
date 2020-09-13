import java.util.List;

public class SimpleArrayList {
	
	private String[] arr;
	private static final int INIT_CAP = 10;
	private int size;
	
	public SimpleArrayList() {
		arr = new String[INIT_CAP];
		size = 0;
	}
	
	public SimpleArrayList(int n) {
		arr = new String[n];
		size = 0;
	}
	
	public SimpleArrayList(List<String> l) {
		arr = l.stream().toArray(String[]::new);
		size = l.size();
	}
	
	public void add(int idx, String s) {
		ensureOpenIndex();
		checkIdxBounds(idx, size);
		
		
		for(int i = arr.length-2; i > idx-1; i--) {
			arr[i+1] = arr[i];
		}
		arr[idx] = s;
		
		size ++;
	}
	
	public boolean add(String s) {
		ensureOpenIndex();
		arr[size] = s;
		size ++;
		return true;
	}
	
	public void clear() {
		for(int i = 0; i < size; i++) {
			arr[i] = null;
		}
		size = 0;
	}
	
	public boolean contains(String s) {
		for(int i = 0; i < size; i++) {
			if(arr[i].equals(s)) { return true; }
		}
		return false;
	}
	
	public String get(int idx) {
		checkIdxBounds(idx, size);
		
		return arr[idx];
	}
	
	public int indexOf(String s) {
		for(int i = 0; i < size; i++) {
			if(arr[i].equals(s)) { return i; }
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return (size==0);
	}
	
	public String remove(int idx) {
		checkIdxBounds(idx, size);
		String el = arr[idx];
		for(int i = idx; i < size-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[size-1] = null;
		size --;
		return el;
	}
	
	public boolean remove(String s) {
		int idx = indexOf(s);
		if(idx != -1) {
			remove(idx);
			return true;
		}
		return false;
	}
	
	public String set(int idx, String s) {
		checkIdxBounds(idx, size);
		String el = arr[idx];
		arr[idx] = s; 
		return el;
	}
	
	public int size() {
		return size;
	}
	
	public void trimToSize() {
		String[] tmp = new String[size];
		for(int i = 0; i < size; i++) {
			tmp[i] = arr[i]; 
		}
		arr = tmp;
	}
	
	public String toString() {
		String str = "[";
		for(int i = 0; i < size-1; i++) {
			str += arr[i];
			str += ", ";
		}
		if(size != 0) {
			str += arr[size-1];
		}
		str += "]";
		return str;
	}
	
	public void ensureCapacity(int min) {
		if(min > size) {
			String[] temp = new String[min];
			for(int i = 0; i < arr.length; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
	}

	
	public int length() {
		return arr.length;
	}
		
	
	private void ensureOpenIndex() {
		if(size+1 > arr.length) {
			String[] temp = new String[arr.length+INIT_CAP];
			for(int i = 0; i < arr.length; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
	}
	
	
	private void checkIdxBounds(int idx, int size) {
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
		}
	}

}
