package salesforce.quickText;

import salesforce.base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class QuickTextTest extends BaseTest {

    @Test
    public void testNewQuickTextJustWithParamsNecessary() {
        String nameQuickText = "new selenium text";
        String messageQuickText = "message for selenium text";
        var quickTextPage = pageTransporter.navigateToQuickTextPage();
        var formNewQuickText = quickTextPage.clickNewQuickText();
        formNewQuickText.setName(nameQuickText);
        formNewQuickText.setMessage(messageQuickText);
        var bodyQuickText = formNewQuickText.clickSaveBtn();
        assertEquals(bodyQuickText.getTextName(), nameQuickText, "Name Quick Text is not same");
    }
}
