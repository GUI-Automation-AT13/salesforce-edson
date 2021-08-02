package salesforce.quickText;

import core.utils.DateString;
import salesforce.base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class QuickTextTest extends BaseTest {

    DateString nowDate = new DateString();

    String nameQuickText = "New name selenium" + nowDate.dateToString();
    String messageQuickText = "Message for quick text";

    String relatedToOption = "Account";
    String fieldOption = "Account Number";

    String categoryComboBox = "Category";
    String categoryOption = "FAQ";

    String channel = "Phone";

    @Test
    public void testNewQuickTextJustWithParamsNecessary() {
        var quickTextPage = pageTransporter.navigateToQuickTextPage();
        var formNewQuickText = quickTextPage.clickNewQuickText();
        var bodyQuickText = formNewQuickText.setName(nameQuickText)
                .setMessage(messageQuickText)
                .clickSaveBtn();
        assertEquals(bodyQuickText.getToastMessage(), toastMessage.quickTextSuccessfulCreated(nameQuickText), "Name Quick Text is not created");
        assertEquals(bodyQuickText.getTitle(), nameQuickText, "Title Name Quick Text is not same");
        assertEquals(bodyQuickText.getFormName(), nameQuickText, "Name Quick Text is not same");
    }

    @Test
    public void testNewQuickTextWithAllParams() {

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
        assertEquals(bodyQuickText.getFormMessage(), bodyQuickText.finalMessage(relatedToOption, fieldOption, messageQuickText), "Message Quick Text is not same");
        assertEquals(bodyQuickText.getFormCategory(), categoryOption, "Category Quick Text is not same");
        assertEquals(bodyQuickText.getFormChannel(), bodyQuickText.finalChannel(channel), "Channel Quick Text is not same");
        assertEquals(bodyQuickText.getFormIncludeChannel(), "False", "Include Channel Quick Text is not same");

        quickTextPage = pageTransporter.navigateToQuickTextPage();
        assertEquals(quickTextPage.getAnNameOfContent(nameQuickText), nameQuickText, "Name of the quick text home is not same");
    }
}
