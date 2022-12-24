package 화이팅;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P1 {

	public static void main(String[] args) {
		String temp = "11001111011";
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(temp.split("0")));
		List<Integer> al2 = null;

		al2 = al.stream().map(n -> n.length()).sorted().collect(Collectors.toList());
		System.out.println(al2.size()==0? 0 : al2.get(al2.size()-1));
	}

}
