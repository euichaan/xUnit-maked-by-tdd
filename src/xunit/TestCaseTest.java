package xunit;

import xunit.annotation.Test;

public class TestCaseTest extends TestCase {
	public TestCaseTest(String name) {
		super(name);
	}

	public static TestSuite suite() {
		return new TestSuite(TestCaseTest.class);
	}

	@Test
	public void testTemplateMethod() {
		WasRun wasRun = new WasRun("testMethod");
		TestResult result = new TestResult();
		wasRun.run(result);
		Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
	}

	@Test
	public void testResult() {
		WasRun wasRun = new WasRun("testMethod");
		TestResult result = new TestResult();
		wasRun.run(result);
		Assert.assertEquals("1 run, 0 failed", result.getSummary());
	}

	@Test
	public void testFailedResultFormatting() {
		// 테스트가 실패했을 때
		TestResult result = new TestResult();
		result.testStarted();
		result.testFailed();
		Assert.assertEquals("1 run, 1 failed", result.getSummary());
	}

	@Test
	public void testFailedResult() {
		// 실패하는 테스트로 Result를 받아오는 지 확인
		WasRun wasRun = new WasRun("testBrokenMethod");
		TestResult result = new TestResult();
		wasRun.run(result);
		Assert.assertEquals("1 run, 1 failed", result.getSummary());
	}

	@Test
	public void testSuite() {
		TestSuite suite = new TestSuite();
		suite.add(new WasRun("testMethod"));
		suite.add(new WasRun("testBrokenMethod"));
		TestResult result = new TestResult(); // 각각 run을 호출하지 않아도 suite에서 한번에 run 할 수 있도록
		suite.run(result);
		Assert.assertEquals("2 run, 1 failed", result.getSummary());
	}
}
