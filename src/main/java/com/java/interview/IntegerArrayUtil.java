package com.java.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * IntegerArrayUtil class holds utility methods to transform integer arrays
 * 
 */
public class IntegerArrayUtil {

	/**
	 * Flatten will take an arbitrarily nested arrays of integers and flatten the contents
	 * <p>Example: [[1,2,[3]],4] → [1,2,3,4]
	 *
	 * @param input - arbitrarily nested arrays
	 * @return result - flattened array of integers
	 */
	public Integer[] flatten(Object[] input) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		if(input != null){
			for(Object number: input) {
				flattenElement(number, result);
			}
		} 

		return result.toArray(new Integer[result.size()]);
	}

	private void flattenElement(Object number, List<Integer> result) {
		if(number instanceof Integer) {					
			result.add((Integer) number);
		} else if(number instanceof Object[]) {
			Integer[] flattenNest = flatten((Object[]) number);
			result.addAll(Arrays.asList(flattenNest));
		} else {
			throw new IllegalArgumentException("Input must be integer or nested arrays of integers");
		}
	}
}
