import java.util.*;

public class Pair<K extends Comparable<K>,V extends Comparable<V>> implements Comparable<Pair<K,V>>{
	private K key;
	private V value;
	
	public Pair(K key,V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "[" + key + ", " + value + "]";
	}
	
	public static <K extends Comparable<K>,V extends Comparable<V>> Pair<V,K> swap(Pair<K,V> pair){
		Pair<V,K> p = new Pair<V, K>(pair.value, pair.key);
		return p;
	}
	
	public static <K extends Comparable<K>,V extends Comparable<V>> void printListOfPairs(List<Pair<K,V>> list) {
		Collections.sort(list);
		for (Pair<K,V> p: list) {
			System.out.println(p);
		}
	}

	@Override
	public int compareTo(Pair<K, V> p) {
		return value.compareTo(p.value);
	}
}
