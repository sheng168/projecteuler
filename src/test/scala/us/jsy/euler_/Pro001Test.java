package us.jsy.euler_;

import junit.framework.Test;
import junit.framework.TestCase;


public class Pro001Test extends TestCase {
	P1 pro001 = new P1();
	
	public void testSum35() {
		assertEquals(23, pro001.sum35(10));
	}

	public void testSum35_1000() {
		assertEquals(23, pro001.sum35(1000000000));
	}
}
