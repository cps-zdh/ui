package listeners;

import java.util.Iterator;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;


/**
 * 
 * @author fs
 * @version 1.0.0
 * @description 监听执行用例数量
 * @date 2018年8月22日 上午9:54:52
 */
public class TestListener implements ITestListener{
	
	/**
     * 输出正文字段
     */
    public static int failCount;
    public static int successCount;
    public static int count;
    public static int skipCount;
	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Iterator<ITestResult> listOfFailedTests = context.getFailedTests()
				.getAllResults().iterator();
		while(listOfFailedTests.hasNext()) {
			ITestResult failedTest = listOfFailedTests.next();
			ITestNGMethod method = failedTest.getMethod();
			if(context.getFailedTests().getResults(method).size()>1) {
				listOfFailedTests.remove();
			}else {
				if(context.getPassedTests().getResults(method).size()>0) {
					listOfFailedTests.remove();
				}
			}
		}
	/*	TestListener.count = context.getAllTestMethods().length;
		System.out.println("onfinsh总数----------"+TestListener.count);
		TestListener.failCount = context.getFailedTests().getAllResults().size();
		System.out.println("onfinsh失败----------"+TestListener.failCount);
		TestListener.successCount = context.getPassedTests().getAllResults().size();
		System.out.println("onfinsh成功---------"+TestListener.successCount);
		TestListener.skipCount = context.getSkippedTests().getAllResults().size();
		System.out.println("onfinsh略过----------"+TestListener.skipCount);
		
		*/
		
	}
	
	

}
