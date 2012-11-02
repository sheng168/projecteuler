package jmx

trait LongValueMBean {
  def getValue: Long
//  def setValue(value: Long)
}

class LongValue(value: => Long, name: String)  extends LongValueMBean {
	import java.lang.management.ManagementFactory;
	
//	import javax.management.InstanceAlreadyExistsException;
//	import javax.management.MBeanRegistrationException;
	import javax.management.MBeanServer;
//	import javax.management.MalformedObjectNameException;
//	import javax.management.NotCompliantMBeanException;
	import javax.management.ObjectName;
  
  		val mbs = ManagementFactory.getPlatformMBeanServer();

			mbs.registerMBean(this, new ObjectName(name));

  def getValue: Long = value
//  def setValue(value: Long) = {}
}

/*
package reuse.jmx;

public interface LongValueMBean {

	public abstract long getValue();

	public abstract void setValue(long value);

}
package reuse.jmx;

import java.util.concurrent.atomic.AtomicLong;

public class LongValue implements LongValueMBean {
	AtomicLong value;

	public LongValue(AtomicLong value, String objectName) {
		this.value = value;
		MBeanHelper.register(this, objectName);
	}
	
	@Override
	public long getValue() {
		return value.get();
	}

	@Override
	public void setValue(long value) {
		this.value.set(value);
	}
}

*/