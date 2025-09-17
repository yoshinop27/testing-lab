package edu.grinnell.csc207.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class LucasTests {
    @Test
	public void input0() {
		assertEquals(2, Functions.lucas(0));
	}

    @Test
	public void input1() {
		assertEquals(1, Functions.lucas(1));
	}

    @Test
	public void input4() {
		assertEquals(7, Functions.lucas(4));
	}

    @Test
	public void input5() {
		assertEquals(11, Functions.lucas(5));
	}

    @Property
	public boolean lucasNumbersEquation(@ForAll @IntRange(min=2, max=1000) int k) {
		int prev2 = k-1;
        int prev1 = k-2;
		return Functions.lucas(k) == (Functions.lucas(prev2) + Functions.lucas(prev1));
	}

    @Property
	public boolean biggerThanZero(@ForAll @IntRange(min=2, max=1000) int k) {
		return (Functions.lucas(k) > 0);
	}
}
