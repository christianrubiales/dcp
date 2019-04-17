package com.christianrubiales.dcp._00bonus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class TwoSumBenchmarkUtil {

	static final String TESTFILE = "src/test/resources/com/christianrubiales/dcp/_00bonus/TwoSumTestFile.txt";
	static final int LINES = 1000;
	static final int MAX_ELEMENTS = 10000;
	static final int MAX_VALUE = Integer.MAX_VALUE / 2;
	static final String ENCODING = "UTF-8";
	
	public static void main(String[] args) throws IOException {
//		generateTestFile();
//		benchmark(new TwoSumUsingSorting());
//		benchmark(new TwoSumUsingHashMap());
		benchmark(new TwoSumUsingSet());
	}

	static void generateTestFile() throws IOException {
		Random random = new Random();
		File file = new File(TESTFILE);
		List<String> lines = new ArrayList<>();
		
		for (int i = 0; i < LINES; i++) {
			
			int items = random.nextInt(MAX_ELEMENTS) + 1;
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < items; j++) {
				builder.append(random.nextInt(MAX_VALUE));
				if (j != items - 1) {
					builder.append(',');
				}
			}
			lines.add(builder.toString());
		}
		FileUtils.writeLines(file, lines);
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
	
	static void benchmark(TwoSum twosum) throws FileNotFoundException {
		List<List<Integer>> data = getTestData(new File(TESTFILE));

		System.out.println("Starting...");
		long start = System.currentTimeMillis();
		for (List<Integer> line : data) {
			// build array
			int[] array = new int[line.size()];
			for (int i = 0; i < line.size(); i++) {
				array[i] = line.get(i);
			}
			
			if (line.size() > 1) {
				int i = 0;
				int j = line.size() - 1;
				twosum.hasTwoSum(array, i + j);
			} else {
				twosum.hasTwoSum(array, -1);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Elapsed: " + (end - start) + "ms");
	}
}
