package xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase {
	protected final String name;

	public TestCase(String name) {
		this.name = name;
	}

	public void run(TestResult result) {
		result.testStarted();
		setUp();

		try {
			Method method = getClass().getMethod(name);
			method.invoke(this); // 어느 오브젝트의 메소드인지
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			// throw new RuntimeException(e);
			result.testFailed();
		}

		tearDown();
	}

	public void setUp() {
	}

	public void tearDown() {
	}
}
