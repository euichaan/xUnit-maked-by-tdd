package xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WasRun {
	private final String name;
	public boolean wasRun;

	public WasRun(String name) {
		this.name = name;
	}

	public void testMethod() {
		wasRun = true;
	}

	public void run() {
		try {
			Method method = getClass().getMethod(name);
			method.invoke(this); // 어느 오브젝트의 메소드인지
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
