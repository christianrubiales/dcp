package com.christianrubiales.dcp._18randomizedAlgorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PickRandomElementFromStream {

	// reservoir sampling of size 1
	static int random(Iterator<Integer> iterator) {
		int result = 0;
		Random random = new Random();
		int n = 0;
		
		while (iterator.hasNext()) {
			n++;
			int next = iterator.next();
			int r = random.nextInt(n);
			if (r == 0) {
				result = next;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			List<Integer> list = new ArrayList<>();
			
			for (int j = 0; j < 10; j++) {
				list.add(j);
			}

			System.out.println(random(list.iterator()));
		}

	}

}
