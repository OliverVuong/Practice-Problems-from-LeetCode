import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
  public static void test() {
    Result result = JUnitCore.runClasses(Test99_RecoverBST.class);
    
    if (result.wasSuccessful()) {
        System.out.println("All " + result.getRunCount() + " tests passed");
    } else {
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString() /*+ "\n" + failure.getTrace()*/);
        }  
    }
  }
}