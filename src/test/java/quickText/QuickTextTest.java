package quickText;

import base.BaseTest;
import org.testng.annotations.Test;

public class QuickTextTest extends BaseTest {

    @Test
    public void testNewQuickText() {
        var quickTextPage = pageTransporter.navigateToQuickTextPage();
        quickTextPage.clickNewQuickText();
        quickTextPage.setQuickText("new selenium text");
        System.out.println("test is progress..!!!");
    }
}
