package edu.grinnell.csc207.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class ThirdGreatestTests {
	
	@Test
	public void exampleUnitTest() {
		int[] arr = { 3, 8, 4, 7, 2 };
		assertEquals(4, Functions.thirdGreatest(arr));
	}

	// not sure how to test an empty array... do i have to in java?
	// @Test
	// public void nullUnitTest() {
	// 	int[] arr = {  };
	// 	assertEquals(IllegalArgumentException(), Functions.thirdGreatest(arr));
	// }
	
	@Test
	public void arr1UnitTest() {
		int[] arr = { 3 };
		assertEquals(3, Functions.thirdGreatest(arr));
	}

	@Test
	public void arr3UnitTest() {
		int[] arr = { 3, 2, 1 };
		assertEquals(1, Functions.thirdGreatest(arr));
	}

	@Test
	public void arr7UnitTest() {
		int[] arr = { 4, 5, 97, 86, 54, 3 , 2 };
		assertEquals(54, Functions.thirdGreatest(arr));
	}

	@Test
	public void sameArrUnitTest() {
		int[] arr = { 4, 4, 4, 4, 4, 4, 4 };
		assertEquals(4, Functions.thirdGreatest(arr));
	}
	
	@Property
	public boolean examplePropertyTest(@ForAll @IntRange(min = 1, max = 1000) int sz,
									   @ForAll int k) {
		int[] arr = new int[sz];
		for (int i = 0; i < sz; i++) {
			arr[i] = k;
		}
		return Functions.thirdGreatest(arr) == k;
	}
		
	// property test for length-1 arrs
	@Property
	public boolean arr1PropertyTest(@ForAll @IntRange(min = 1, max = 1000) int k) {
		int[] arr = new int[1];
		arr[0] = k;
		return Functions.thirdGreatest(arr) == k;
	}

}
