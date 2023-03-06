package xunit;

public class TestCaseTest extends TestCase {
	public TestCaseTest(String name) {
		super(name);
	}

	public void testTemplateMethod() {
		WasRun wasRun = new WasRun("testMethod");
		wasRun.run();
		Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
	}

	public void testResult() {
		WasRun wasRun = new WasRun("testMethod");
		TestResult result = wasRun.run();
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
		TestResult result = wasRun.run();
		Assert.assertEquals("1 run, 1 failed", result.getSummary());
	}
}
