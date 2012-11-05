package us.jsy.euler;

public class Combination {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object[][] funcs = { { "hello" }, { "world" } };
		Object[][] param = { { 100, 23 }, { 1000, 233168L } };

		product(funcs, param);
	}

	public static Object[][] product(Object[][] a, Object[][] b) {
		Object[][] c = new Object[a.length * b.length][];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			Object[] x = a[i];
			for (int j = 0; j < b.length; j++) {
				Object[] y = b[j];
				
				Object[] z = new Object[x.length + y.length];
				System.arraycopy(x, 0, z, 0, x.length);
				System.arraycopy(y, 0, z, x.length, y.length);
				
				c[k++] = z;
			}
		}
		
		return c;
	}

	public static Object[][] product(String[] args) {
		return null;
	}
}
