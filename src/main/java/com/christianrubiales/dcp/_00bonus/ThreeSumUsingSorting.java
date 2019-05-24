package com.christianrubiales.dcp._00bonus;

import java.util.Arrays;

public class ThreeSumUsingSorting implements ThreeSum {

	@Override
	public boolean hasThreeSum(int[] array, int sum) {
		Arrays.sort(array);
		
		for (int i = 0; i < array.length - 2; i++) {
			int j = i + 1;
			int k = array.length - 1;
			
			while (j < k) {
				if (array[i] + array[j] + array[k] == sum) {
					return true;
				} else if (array[i] + array[j] + array[k] < sum) {
					j++;
				} else {
					k--;
				}
			}
		}
		
		return false;
	}

}
