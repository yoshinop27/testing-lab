package edu.grinnell.csc207.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class SortTests {
    @Test
	public void arr1Test() {
		int[] arr = {1};
        Functions.sort(arr);
		assertEquals(1, arr[0]);
	}

    @Test
	public void arr2Test() {
		int[] arr = {1, 0};
        Functions.sort(arr);
		assertEquals(true, arr[0] < arr[1]);
	}

    @Test
	public void arrTest() {
		int[] arr = {1, 5, 3, 9};
        Functions.sort(arr);
		assertEquals(true, (arr[0] < arr[1]));
        assertEquals(true, (arr[1] < arr[2]));
        assertEquals(true, (arr[2] < arr[3]));
	}

    // test if last arr element is always greater than or equal to first element
    @Property
	public boolean firstLastPropertyTest(@ForAll @IntRange(min = 1, max = 1000) int sz) {
		int[] arr = new int[sz];
        if (arr[0] <= arr[sz-1]) {
            return true;
        } else {return false;}
	}
		
	// property test for random adjacent elements
    @Property
	public boolean adjElmsPropertyTest(@ForAll @IntRange(min = 1, max = 1000) int sz) {
		int[] arr = new int[sz];
		for (int i = 0; i < (sz-1); i++) {
			if (!(arr[i] <= arr[i+1])) {
                return false;
            }
		}
		return true;
	}
}
