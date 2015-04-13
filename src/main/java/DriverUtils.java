import org.openqa.selenium.By;

public class DriverUtils {

    public static boolean isElementExists(By locator){

        return MozillaBrowser.getInstacne().findElements(locator).size()>0;
    }
}
