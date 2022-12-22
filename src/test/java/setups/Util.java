package setups;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Util {

	public static AndroidDriver driver;

	private static Dimension windowSize;
	private static Duration SCROLL_DUR = Duration.ofSeconds(2);
	private static double SCROLL_RATIO = 0.8;
	private static int ANDROID_SCROLL_DIVISOR = 3;

	public Util(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public static void scrollDown() {
		Dimension dimension = driver.manage().window().getSize();
		int scrollStart = (int) (dimension.getHeight() * 0.5);
		int scrollEnd = (int) (dimension.getHeight() * 0.2);

		try {
			(new TouchAction(driver)).press(PointOption.point(0, scrollStart))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd))
					.release().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void scrollNClick(String Text) {
		boolean flag = false;

		// List<MobileElement> values =
		// driver.findElements(By.className("android.widget.TextView"));

		List<MobileElement> listItems1 = driver.findElementsByClassName("android.widget.TextView");
		while (true) {
			for (int i = 0; i < listItems1.size(); i++) {
				String el = listItems1.get(i).getText();
				System.out.println("" + el);

				if (el.equals(Text)) {
					listItems1.get(i).click();
					flag = true;
					break;
				}
			}
			if (flag)
				break;
			else
				scrollDown();
		}
	}

	public static void scrollNClick(MobileElement el) {
		int retry = 0;
		while (retry <= 5) {
			try {
				el.click();
				break;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				scrollDown();
				retry++;
			}
		}
	}

	public static void scrollIntoView(String Text) {
		// https://developer.android.com/reference/androidx/test/uiautomator/UiSelector

		String mySelector = "new UiSelector().text(\"" + Text + "\").instance(0)";
		String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + mySelector
				+ ");";
		driver.findElementByAndroidUIAutomator(command);

		/*
		 * ((AndroidDriver<MobileElement>)
		 * AppDriver.getDriver()).findElementByAndroidUIAutomator(
		 * "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
		 * + Text + "\").instance(0))").click();
		 */
	}

	public enum ScrollDirection {
		UP, DOWN, LEFT, RIGHT
	}

	private static Dimension getWindowSize() {
		if (windowSize == null) {
			windowSize = driver.manage().window().getSize();
		}
		return windowSize;
	}

	public static void scroll(ScrollDirection dir, double distance) {
		if (distance < 0 || distance > 1) {
			throw new Error("Scroll distance must be between 0 and 1");
		}
		Dimension size = getWindowSize();
		Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
		int top = midPoint.y - (int) ((size.height * distance) * 0.5);
		int bottom = midPoint.y + (int) ((size.height * distance) * 0.5);
		int left = midPoint.x - (int) ((size.width * distance) * 0.5);
		int right = midPoint.x + (int) ((size.width * distance) * 0.5);
		if (dir == ScrollDirection.UP) {
			swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
		} else if (dir == ScrollDirection.DOWN) {
			swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
		} else if (dir == ScrollDirection.LEFT) {
			swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
		} else {
			swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
		}
	}

	protected static void swipe(Point start, Point end, Duration duration) {
		boolean isAndroid = driver instanceof AndroidDriver<?>;

		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence swipe = new Sequence(input, 0);
		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		if (isAndroid) {
			duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR);
		} else {
			swipe.addAction(new Pause(input, duration));
			duration = Duration.ZERO;
		}
		swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		((AppiumDriver<?>) driver).perform(ImmutableList.of(swipe));
	}

	public static void click(By byEl) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(byEl)).click();
	}

	public static void sendKeys(By byEl, String text) {
		waitForEl(byEl);
		driver.findElement(byEl).sendKeys(text);
	}

	public static void waitForEl(By byEl) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(byEl));
	}

}
