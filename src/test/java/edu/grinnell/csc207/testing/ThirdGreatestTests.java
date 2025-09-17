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
	
	@Test
	public void oneElement(){
		int[] arr = {1};
		assertEquals(1, Functions.thirdGreatest(arr));
	}

	@Test
	public void twoElement() {
		int[] arr = {2,1};
		assertEquals(2, Functions.thirdGreatest(arr));
 	}

	@Test
	public void threeElement(){
		int[] arr = {2, 6, 4};
		assertEquals(2, Functions.thirdGreatest(arr));
	}

	@Test
	public void multiple(){
		int[] arr = {1, 5, 4, 56, 2};
		assertEquals(4, Functions.thirdGreatest(arr));
	}

	@Test
	public void duplicates(){
		int[] arr = {3, 4, 4, 6, 1};
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
		
	// TODO: add additional property tests here!
	@Property
	public boolean mulitpleElements(@ForAll @IntRange(min=4, max=20) int k){
		int[] arr = {3, 2, 1, k, 30, 40};
		return Functions.thirdGreatest(arr) == k;
	}

	@Property
	public boolean twoElements(@ForAll @IntRange(max=20) int k){
		int[] arr = {k, 30};
		return Functions.thirdGreatest(arr) != k;
	}

	@Property
	public boolean least(@ForAll @IntRange(max=5) int k){
		int[] arr = {k, 6, 7, 8};
		return Functions.thirdGreatest(arr) == 6;
	}
}
