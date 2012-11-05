package us.jsy.euler_;

import us.jsy.euler.Function;
import us.jsy.euler.FunctionTest;



public class P1Test extends FunctionTest<Long, Long> {
	protected void setUp() throws Exception {
		System.out.println("P1Test");
		this.function = new Function[] {new P1(), new P1Basic()};
		this.input = new Long[]{10L, 1000L};
		this.output = new Long[]{23L, 233168L};
	}

}
