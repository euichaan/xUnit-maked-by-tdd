package xunit;

public class XUnitTest {
	public static void main(String[] args) {
		TestSuite suite = TestCaseTest.suite();
		TestResult result = new TestResult(); // 결과 수집
		suite.run(result);
		System.out.println(result.getSummary());

		// TestSuite 중첩 = Composite pattern
		TestSuite suite2 = new TestSuite();
		suite2.add(new TestCaseTest("testTemplateMethod"));
		suite2.add(suite);
		TestResult result2 = new TestResult(); // 결과 수집
		suite2.run(result2);
		System.out.println(result2.getSummary());
	}
}
