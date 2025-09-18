package edu.grinnell.csc207.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class SumTests {
    @Test
	public void single(){
		assertEquals(1, Functions.sum(1));
	}

    @Test
	public void multiElement(){
		assertEquals(6, Functions.sum(3));
	}

    @Property
	public boolean positiveElement(@ForAll @IntRange(min=0, max=100) int k){
		return Functions.sum(k) == (k*(k+1))/2;
	}

	@Property
	public boolean lastElement(@ForAll @IntRange(min=0, max=100) int k){
		return Functions.sum(k) == (Functions.sum(k-1) + k);
	}
}