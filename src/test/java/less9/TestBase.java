package less9;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * An abstract class with helper methods for use within tests.
 */
public abstract class TestBase
{
	protected WebDriver driver;

	/**
	 * Creates a reader for a resource in the relative path.
	 * @param relativePath path to the file relative to the {@code /src/test/resources} directory, starting with a slash {@code /}
	 * @return a reader of the resource
	 */
	public static Reader getReader( final String relativePath )
	{
		try
		{
			return new InputStreamReader( TestBase.class.getResourceAsStream( relativePath ), "UTF-8" );
		}
		catch ( UnsupportedEncodingException e )
		{
			throw new IllegalStateException( "Unable to read input", e );
		}
	}

	/**
	 * Creates a {@link java.io.File File} instance from a resource in the relative path.
	 * @param relativePath path to the file relative to the {@code /src/test/resources} directory, starting with a slash {@code /}
	 * @return a File instance of the resource by relative path
	 */
	public static File getFile( final String relativePath )
	{
		return new File(TestBase.class.getResource( relativePath ).getFile());
	}
	//      Selenium setup
	// -----------------------------
	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\ASTON JAVA\\less9\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.mts.by/");
	}

	@BeforeEach
	public void navigateToHome() {
		if (!driver.getCurrentUrl().equals("https://www.mts.by/")) {
			driver.get("https://www.mts.by/");
		}
	}
	@AfterEach
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}


}
