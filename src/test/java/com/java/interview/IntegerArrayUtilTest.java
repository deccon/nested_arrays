package com.java.interview;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit tests for {@link IntegerArrayUtil}
 *
 */
public class IntegerArrayUtilTest  {
	
	private IntegerArrayUtil integerArrayUtil;
	private Integer[] standardArray;
	private Object[] nestedArray;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp(){
		integerArrayUtil = new IntegerArrayUtil();
	}
	
	@Test
	public void testFlattenStandardArray() {
		standardArray = new Integer[] { 1, 2, 3 };

		Integer[] result = integerArrayUtil.flatten(standardArray);
		
		Assert.assertEquals("Result array size not as expected", standardArray.length, result.length);
	}
	
	@Test
	public void testFlattenNestedArray() {
		
		nestedArray = new Object[]{1, 2, 3, 4,
						new Integer[]{5},
						new Integer[]{6, 7, 8}, 9, 10};
		
		Integer[] result = integerArrayUtil.flatten(nestedArray);
		
		Assert.assertEquals("Result array size not as expected", 10, result.length);
	}
	
	
	@Test
	public void testFlattenNullArray() {

		Integer[] result = integerArrayUtil.flatten(standardArray);
		
		Assert.assertTrue("Result array size should be zero", result.length == 0);
	}
	
	@Test
	public void testFlattenNonIntegerArray() { 
		Object[] nonIntArray = new Object[]{ 1, 2, 3, 4, new String[]{"5"} };
		
		thrown.expect(IllegalArgumentException.class);
	    thrown.expectMessage("Input must be integer or nested arrays of integers");
		
		Integer[] result = integerArrayUtil.flatten(nonIntArray);
	}

}
