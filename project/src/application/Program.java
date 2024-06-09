package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("Garen");
		list.add("Darius");
		list.add("Ashe");
		list.add("Lux");
		list.add("Jax");
		list.add("Caitlyn");
		list.add("Braum");
		list.add("Nautilus");

		list.add(2, "Soraka");
		list.remove("Lux");
		list.remove(1);

		System.out.println(list.size());
		for (String c : list) {
			System.out.println(c);
		}

		list.removeIf(c -> c.charAt(0) == 'B');

		System.out.println("-------------------------");
		for (String c : list) {
			System.out.println(c);
		}

		System.out.println("-------------------------");
		List<String> result = list.stream().filter(c -> c.charAt(0) == 'C').collect(Collectors.toList());
		for (String c : result) {
			System.out.println(c);
		}
	}

}
