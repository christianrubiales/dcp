package com.christianrubiales.dcp._00bonus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreeSumBenchmarkUtil {

	static final String TESTFILE = "src/test/resources/com/christianrubiales/dcp/_00bonus/TwoSumTestFile.txt";
	static final int LINES = 1000;
	static final int MAX_ELEMENTS = 10000;
	static final int MAX_VALUE = Integer.MAX_VALUE / 2;
	static final String ENCODING = "UTF-8";
	
	public static void main(String[] args) throws FileNotFoundException {
//		benchmark(new ThreeSumUsingSorting());
		benchmark(new ThreeSumUsingHashMap());
	}

	static List<List<Integer>> getTestData(File file) throws FileNotFoundException {
		List<List<Integer>> data = new ArrayList<>();
		
		String line;
		String[] array;
		try (Scanner in = new Scanner(file)) {
			while (in.hasNextLine()) {
				List<Integer> list = new ArrayList<>();
				data.add(list);
				line = in.nextLine();
				array = line.split(",");
				for (String s : array) {
					list.add(Integer.parseInt(s));
				}
			}
		}
		
		return data;
	}

	static void benchmark(ThreeSum threeSum) throws FileNotFoundException {
		List<List<Integer>> data = getTestData(new File(TESTFILE));

		System.out.println("Starting...");
		long start = System.currentTimeMillis();
		for (List<Integer> line : data) {
			// build array
			int[] array = new int[line.size()];
			for (int i = 0; i < line.size(); i++) {
				array[i] = line.get(i);
			}
			
			if (line.size() > 2) {
				int i = line.size() - 3;
				int j = line.size() - 2;
				int k = line.size() - 1;
				threeSum.hasThreeSum(array, i + j + k);
			} else {
				threeSum.hasThreeSum(array, -1);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Elapsed: " + (end - start) + "ms");
	}
}
