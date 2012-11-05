package us.jsy.euler_;

import us.jsy.euler.LongFunction;

/**
 * 

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.

 * @author shengyu
 *
 */
public class P1 implements LongFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long sum35(long below) {
		return sumDivBy(3, below)+sumDivBy(5, below)-sumDivBy(15, below);
	}
	
	public long sum35_(long below) {
		long sum = 0;
		for (int i = 0; i < below; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		
		return sum;
	}
	
	long sumDivBy(long n, long below) {
		long p = (below-1) / n;
		return n * p * (p+1) / 2;
	}

	@Override
	public Long apply(Long in) {
		return sum35(in);
	}
}

class P1Basic implements LongFunction {
	public long sum35(long below) {
		long sum = 0;
		for (int i = 0; i < below; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		
		return sum;
	}

	@Override
	public Long apply(Long in) {
		return sum35(in);
	}
}
