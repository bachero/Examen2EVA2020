import java.util.*;

public class PairMain {

	public static void main(String[] args) {
		Pair<String,Integer> p = new Pair<String, Integer>("hello", 1);
		Pair<Integer,String> p2 = Pair.swap(p);
		System.out.println(p);
		System.out.println(p2);

		Pair<String, Integer> p3 = new Pair<String,Integer>("bye",0);
		Pair<String, Integer> p4 = new Pair<String, Integer>("afternoon",5);
		Pair<String, Integer> p5 = new Pair<String, Integer>("evening",3);
		
		List<Pair<String,Integer>> list = new ArrayList<>();
		list.add(p);
		list.add(p3);
		list.add(p4);
		list.add(p5);
	}

}
