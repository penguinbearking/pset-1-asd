import java.util.ArrayList;
import java.util.List;

public class SimpleArrayListTest {
	
	public static void main(String[] args) {
		
		SimpleArrayList a1 = new SimpleArrayList();
		SimpleArrayList a2 = new SimpleArrayList(20);
		
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		
		SimpleArrayList a3 = new SimpleArrayList(l);
		
		printAll(a1,a2,a3);
		
		a1.add("p");
		a1.add("q");
		a1.add(1, "r");
		a1.add("d");
		System.out.println(a1.contains("r"));
		System.out.println(a1.contains("b"));
		System.out.println(a1.get(2));
		System.out.println(a1.indexOf("q"));
		System.out.println(a1.isEmpty());
		System.out.println(a2.isEmpty());
		a1.add("x");
		a1.remove(3);
		a1.add("w");
		a1.remove("w");
		a1.set(1, "a");
		a1.ensureCapacity(15);
		printone(a1);
		try {
			a1.set(13, "f");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		a1.trimToSize();
		printone(a1);
		try {
			a1.add(7, "g");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		printone(a1);
		
		



		
	}
	
	public static void printAll(SimpleArrayList a1, SimpleArrayList a2, SimpleArrayList a3) {
		System.out.println(a1.toString() + "; Size " + a1.size() + "; Length " + a1.length());
		System.out.println(a2.toString() + "; Size " + a2.size() + "; Length " + a2.length());
		System.out.println(a3.toString() + "; Size " + a3.size() + "; Length " + a3.length());

	}
	
	public static void printone(SimpleArrayList a1) {
		System.out.println(a1.toString() + "; Size " + a1.size() + "; Length " + a1.length());
	}

}
