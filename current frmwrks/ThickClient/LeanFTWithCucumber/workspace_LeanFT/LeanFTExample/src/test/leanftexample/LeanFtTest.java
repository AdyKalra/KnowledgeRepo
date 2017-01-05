package test.leanftexample;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.report.Reporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/features/"},
		//features={"src/test/resources/features/GoogleSomething.feature"},
		format = {"pretty", "html:target/report"}
)

public class LeanFtTest {

	private static Process runtimeEnv;

	@BeforeClass
	public static void initTest() throws Exception {
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		try {
			config.setServerAddress(new URI("ws://localhost:5095"));
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		startLeanFTRuntimeEnv();
		SDK.init(config);
		Reporter.init();
	}

	@AfterClass
	public static void finishTest() throws Exception {
		//Generate the report and cleanup the SDK usage.
		Reporter.generateReport();
		SDK.cleanup();
		stopLeanFTRuntimeEnv();
	}

	private static void startLeanFTRuntimeEnv() throws IOException {
		runtimeEnv = new ProcessBuilder("C:\\Program Files (x86)\\HP\\LeanFT\\bin\\LFTRuntime.exe").start();
	}

	private static void stopLeanFTRuntimeEnv() throws IOException {
		runtimeEnv.destroy();
	}
}
 