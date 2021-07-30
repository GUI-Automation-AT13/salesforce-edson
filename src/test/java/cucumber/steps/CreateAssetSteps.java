package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.utils.DateString;
import core.utils.ToEntity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesforce.ui.entity.QuickText;
import salesforce.ui.pages.quicktext.QuickTextPage;

import java.util.Map;

import static core.utils.LoadFiles.envValues;

public class CreateAssetSteps {

    protected QuickTextPage quickTextPage;
    QuickText quickText;
    DateString nowDate = new DateString();
    String newNameQuickText;

    private BaseUtil base;

    public CreateAssetSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^I login to salesforce site as an? (.*?) user$")
    public void iLoginToSalesforceSite(final String userType) {
        base.loginPage.loginSuccessful(envValues.getUser(), envValues.getPassword());
    }

    @And("^I navigate to (.*?) page$")
    public void iNavigateToQuickTextPage(final String endpoint) {
        base.pageTransporter.navigateToAnyPage(endpoint);
    }

    @When("I create a new quickText with fields")
    public void iCreateANewQuickTextWithFields(Map<String, String> table) throws JsonProcessingException {
        quickTextPage = new QuickTextPage();
        var formNewQuickText = quickTextPage.clickNewQuickText();

        quickText = ToEntity.convert(table, QuickText.class);

        newNameQuickText = quickText.getName() + nowDate.dateToString();
        quickText.setName(newNameQuickText);

        base.bodyQuickText = formNewQuickText.createQuickText(table.keySet(), quickText);
    }

    @Then("Validate successful message of creating that is display")
    public void validateASuccessfulMessageOfCreatingIsDisplay() {
        base.softAssert.assertEquals(base.bodyQuickText.getToastMessage(), base.toastMessage.quickTextSuccessfulCreated(quickText.getName()), "Name Quick Text is not created");
    }

    @And("Validate the title matches")
    public void validateTheTitleMatches() {
        base.softAssert.assertEquals(base.bodyQuickText.getTitle(), quickText.getName(),
                "Title name Quick Text is not same");
    }

    @And("Validate only the mandatory parameters filled")
    public void ValidateTheFormWithMandatoryFields() {
        base.softAssert.assertEquals(base.bodyQuickText.getFormName(), quickText.getName(),
                "Form name Quick Text is not same");
        base.softAssert.assertEquals(base.bodyQuickText.getFormMessage(), quickText.getMessage(),
                "Message Quick Text is not same");
    }

    @And("Validate all filled fields")
    public void ValidateTheFormWithAllFields() {
        base.softAssert.assertEquals(base.bodyQuickText.getFormName(), quickText.getName(),
                "Form name Quick Text is not same");
        base.softAssert.assertEquals(base.bodyQuickText.getFormMessage(), base.bodyQuickText.finalMessage(quickText.getRelatedTo(), quickText.getField(), quickText.getMessage()),
                "Message Quick Text is not same");
        base.softAssert.assertEquals(base.bodyQuickText.getFormCategory(), quickText.getCategory(),
                "Category Quick Text is not same");
        base.softAssert.assertEquals(base.bodyQuickText.getFormChannel(), base.bodyQuickText.finalChannel(quickText.getChannel()),
                "Channel Quick Text is not same");
        base.softAssert.assertEquals(base.bodyQuickText.getFormIncludeChannel(), "True",
                "Include Channel Quick Text is not same");
    }

    @And("Validate the quickText in the quickText Home")
    public void ValidateQuickTextHomeMatches() {
        var quickTextPage = base.pageTransporter.navigateToQuickTextPage();
        base.softAssert.assertEquals(quickTextPage.getAnNameOfContent(newNameQuickText), newNameQuickText, "Name of the quick text home is not same");
    }
}
