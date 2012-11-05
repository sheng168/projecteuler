package us.jsy.euler_;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import us.jsy.euler.LongFunction;
import us.jsy.euler.Combination;

@RunWith(Parameterized.class)
public class P1ParamTest {
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] values = new Object[][] { 
				{ 10, 23 }, 
				{ 1000, 233168L }, 
				{ 1000000, 233333166668L }, 
//				{ 10000000, 2333333316666668L },
				{ 100000000, 2333333316666668L },
				{ 1000000000, 233333333166666668L },
				};
		Object[][] funcs = { { new P1() }, { new P1Basic() } };

		return Arrays.asList(Combination.product(values, funcs));
	}

	private LongFunction func = new P1();
	
	private long fInput;

	private long fExpected;

	public P1ParamTest(long input, long expected, LongFunction f) {
		this.fInput = input;
		this.fExpected = expected;
		func = f;
	}

	@Test
	public void test() {
		System.out.println(func + " " + fInput + " " + fExpected);
		
		Object actual = func.apply(fInput);
		assertEquals(fExpected, actual);
	}
}