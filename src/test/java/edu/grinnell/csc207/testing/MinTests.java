package edu.grinnell.csc207.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class MinTests {
    @Test
	public void single(){
        int[] arr = {1};
		assertEquals(1, Functions.min(arr));
	}

    @Test
	public void multiElement(){
        int[] arr = {4, 5, 1};
		assertEquals(1, Functions.min(arr));
	}

    @Test
	public void negative(){
        int[] arr = {4, 5, 1, -3};
		assertEquals(-3, Functions.min(arr));
	}

    @Property
	public boolean oneElement(@ForAll int k){
        int[] arr = {k};
		return Functions.min(arr) == k;
	}

	@Property
	public boolean multiElement(@ForAll @IntRange(min=0, max=10) int k){
        int[] arr = {12, 17, k};
		return Functions.min(arr) == k;
	}
}