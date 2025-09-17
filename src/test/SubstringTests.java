package edu.grinnell.csc207.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;


public class SubstringTests {
    @Test
	public void equalStringsTest() {
		String a = "hello";
        String b = "hello";
		assertEquals(0, Functions.substringIndex(a, b));
	}

    @Test
	public void uppercaseTest() {
		String a = "Hello";
        String b = "hello";
		assertEquals(-1, Functions.substringIndex(a, b));
	}

    @Test
	public void largeSubstringTest() {
		String a = "Hello";
        String b = "hello there";
		assertEquals(-1, Functions.substringIndex(a, b));
	}

    @Test
	public void singleLetterTest() {
		String a = "elk";
        String b = "l";
		assertEquals(1, Functions.substringIndex(a, b));
	}

    @Test
	public void substringTest() {
		String a = "halloween";
        String b = "low";
		assertEquals(3, Functions.substringIndex(a, b));
	}

    // property tests??
}
