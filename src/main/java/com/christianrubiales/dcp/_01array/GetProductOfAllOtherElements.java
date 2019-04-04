package com.christianrubiales.dcp._01array;

public class GetProductOfAllOtherElements {

	// naive O(n) time O(n) space
	static int[] getProductOfAllOtherElements(int[] elements) {
		int[] result = new int[elements.length];		
		
		int product = 1;
		for (int i : elements) {
			product *= i;
		}
		
		for (int i = 0; i < elements.length; i++) {
			result[i] = product / elements[i];
		}
		
		return result;
	}

	// O(n) time O(n) space
	static int[] getProductOfAllOtherElementsWithoutDivision(int[] elements) {
		int[] result = new int[elements.length];
		int[] prefix = new int[elements.length];
		int[] suffix = new int[elements.length];
		
		prefix[0] = elements[0];
		for (int i = 1; i < elements.length; i++) {
			prefix[i] = prefix[i - 1] * elements[i];
		}
		
		suffix[suffix.length - 1] = elements[elements.length -1];
		for (int i = elements.length - 2; i > -1; i--) {
			suffix[i] = suffix[i + 1] * elements[i];
		}
		
		for (int i = 0; i < elements.length; i++) {
			if (i == 0) {
				result[i] = suffix[i + 1];
			} else if (i == elements.length - 1) {
				result[i] = prefix[i - 1];
			} else {
				result[i] = prefix[i - 1] * suffix[i + 1];
			}
		}
		
		return result;
	}

	/*
	 * x = a * b * c
	 * log(x) = log(a * b * c)
	 * log(x) = log(a) + log(b) + log(c)
	 * x = 10 ^ (log(a) + log(b) + log(c))
	 * O(1) additional space
	 * @see https://www.geeksforgeeks.org/product-array-puzzle-set-2-o1-space/
	 */
	static int[] getProductOfAllOtherElementsWithoutDivisionConstant(int[] elements) {
		int[] result = new int[elements.length];
		
		double sum = 0;
		for (int i : elements) {
			sum += Math.log10(i);
		}
		
		double epsilon = 1e-9;
		for (int i = 0; i < elements.length; i++) {
			result[i] = (int) (epsilon + Math.pow(10, sum - Math.log10(elements[i])));
		}
		
		return result;
	}
}
