package us.jsy.euler;

import junit.framework.TestCase;

public class FunctionTest<F, T> extends TestCase {
	protected Function<F, T>[] function;
	protected F[] input;
	protected T[] output;
	
	public void testApply() {
		for (Function<F, T> f : function) {
			for (int i = 0; i < input.length; i++) {
				F in = input[i];
				T out = output[i];
				
				T actual = f.apply(in);
				
				assertEquals(f + " input " + in, out, actual);
			}

		}
	}

}
