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
        var bodyQuickText = formNewQuickText.setName(nameQuickText)
                .setMessage(messageQuickText)
                .clickSaveBtn();
        assertEquals(bodyQuickText.getToastMessage(), toastMessage.quickTextSuccessfulCreated(nameQuickText), "Name Quick Text is not created");
        assertEquals(bodyQuickText.getTitle(), nameQuickText, "Title Name Quick Text is not same");
        assertEquals(bodyQuickText.getFormName(), nameQuickText, "Name Quick Text is not same");
    }

    //@Test
    public void testNewQuickTextWithAllParams() {
        String nameQuickText = "new selenium text 7";
        String messageQuickText = "message for selenium text";

        String relatedToOption = "Account";
        String fieldOption = "Account Number";

        String categoryComboBox = "Category";
        String categoryOption = "FAQ";

        String channel = "Phone";

        var quickTextPage = pageTransporter.navigateToQuickTextPage();
        var formNewQuickText = quickTextPage.clickNewQuickText();
        var bodyQuickText = formNewQuickText.setName(nameQuickText)
                .insertMergeField(relatedToOption, fieldOption)
                .setMessage(messageQuickText)
                .chooseComboBoxOption(categoryComboBox, categoryOption)
                .chooseChannel(channel)
                .clickCheckBtn()
                .clickSaveBtn();

        assertEquals(bodyQuickText.getToastMessage(), toastMessage.quickTextSuccessfulCreated(nameQuickText), "Name Quick Text is not created");
        assertEquals(bodyQuickText.getTitle(), nameQuickText, "Title Name Quick Text is not same");
        assertEquals(bodyQuickText.getFormName(), nameQuickText, "Name Quick Text is not same");
    }
}
