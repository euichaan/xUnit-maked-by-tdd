package xunit;

public class TestCaseTest extends TestCase {
	public TestCaseTest(String name) {
		super(name);
	}

	public static TestSuite suite() {
		// suite.add(new TestCaseTest("testTemplateMethod"));
		// suite.add(new TestCaseTest("testResult"));
		// suite.add(new TestCaseTest("testFailedResultFormatting"));
		// suite.add(new TestCaseTest("testFailedResult"));
		// suite.add(new TestCaseTest("testSuite"));

		return new TestSuite(TestCaseTest.class);
	}

	public void testTemplateMethod() {
		WasRun wasRun = new WasRun("testMethod");
		TestResult result = new TestResult();
		wasRun.run(result);
		Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
	}

	public void testResult() {
		WasRun wasRun = new WasRun("testMethod");
		TestResult result = new TestResult();
		wasRun.run(result);
		Assert.assertEquals("1 run, 0 failed", result.getSummary());
	}

	public void testFailedResultFormatting() {
		// 테스트가 실패했을 때
		TestResult result = new TestResult();
		result.testStarted();
		result.testFailed();
		Assert.assertEquals("1 run, 1 failed", result.getSummary());
	}

	public void testFailedResult() {
		// 실패하는 테스트로 Result를 받아오는 지 확인
		WasRun wasRun = new WasRun("testBrokenMethod");
		TestResult result = new TestResult();
		wasRun.run(result);
		Assert.assertEquals("1 run, 1 failed", result.getSummary());
	}

	public void testSuite() {
		TestSuite suite = new TestSuite();
		suite.add(new WasRun("testMethod"));
		suite.add(new WasRun("testBrokenMethod"));
		TestResult result = new TestResult(); // 각각 run을 호출하지 않아도 suite에서 한번에 run 할 수 있도록
		suite.run(result);
		Assert.assertEquals("2 run, 1 failed", result.getSummary());
	}
}
