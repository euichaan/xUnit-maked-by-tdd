package xunit;

public class XUnitTest {
	public static void main(String[] args) {
		TestSuite suite = TestCaseTest.suite();
		TestResult result = new TestResult(); // 결과 수집
		suite.run(result);
		System.out.println(result.getSummary());
	}
}
