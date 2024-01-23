package runnable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

public class TestNgRunner {

	 public static void main(String[] args) {
	        runTestNGSuite();
	    }

	    public static void runTestNGSuite() {
	        // Create a TestNG object
	        TestNG testNG = new TestNG();

	        // Create a list of XmlSuite objects
	        List<XmlSuite> suites = new ArrayList<>();

	        // Add your TestNG XML suite files or configure programmatically
	        // Example:
	        XmlSuite suite = new XmlSuite();
	        suite.setSuiteFiles(Collections.singletonList("C:\\Users\\wbox42\\eclipse-workspace\\WaitListMeSynchronised\\testng.xml"));

	        suites.add(suite);

	        // Set the list of suites to the TestNG object
	        testNG.setXmlSuites(suites);

	        // Run the TestNG suite
	        testNG.run();
	    }
}
