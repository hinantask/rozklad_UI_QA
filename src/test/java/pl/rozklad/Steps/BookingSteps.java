package pl.rozklad.Steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.rozklad.Pages.BookingPage;
import pl.rozklad.Utilities.BrowserUtils;
import pl.rozklad.Utilities.Driver;

public class BookingSteps {

    BookingPage bookingPage=new BookingPage();
    WebDriverWait wait=new WebDriverWait(Driver.get(),7);

    @Given("User navigate to {string} webpage")
    public void user_navigate_to_webpage(String webpage)  {

        Driver.get().get(webpage);

    }

    @Given("User should be able to accept webpage message")
    public void user_should_be_able_to_accept_webpage_message() {

       BrowserUtils.waitForVisibility(bookingPage.acceptAlert,5);
       BrowserUtils.clickWithJS(bookingPage.acceptAlert);

    }

    @When("User input data {string} box departure destination")
    public void user_input_data_box_departure_destination(String departure) {

        BrowserUtils.clickWithJS( bookingPage.fromStation);
        bookingPage.fromStation.sendKeys(departure);

    }

    @Then("User input data {string} box connection place")
    public void user_input_data_box_connection_place(String connectionPlace) {

        BrowserUtils.waitForVisibility(bookingPage.viaStationButton,5);
        BrowserUtils.clickWithJS( bookingPage.viaStationButton);
        BrowserUtils.waitForVisibility(bookingPage.connectionBox,5);
        BrowserUtils.clickWithJS( bookingPage.connectionBox);
        bookingPage.connectionBox.sendKeys(connectionPlace);

    }

    @Then("User input data {string} box connection time")
    public void user_input_data_box_connection_time(String connctionTime) {

        BrowserUtils.waitForVisibility(bookingPage.connectionTime,5);
        BrowserUtils.clickWithJS(bookingPage.connectionTime);
        bookingPage.connectionTime.sendKeys(connctionTime);

    }

    @When("User input data {string} box arrival destination")
    public void user_input_data_box_arrival_destination(String arrival) {

        wait.until(ExpectedConditions.elementToBeClickable(bookingPage.toStation));
        BrowserUtils.clickWithJS(bookingPage.toStation);
        bookingPage.toStation.sendKeys(arrival);

    }

    @When("User input data {string} box which date will be travelled")
    public void user_input_data_box_which_date_will_be_travelled(String date) {

     bookingPage.selectDate(date);

    }

    @Given("User input data {string} box which time will be travelled")
    public void user_input_data_box_which_time_will_be_travelled(String time) {

        BrowserUtils.waitForVisibility(bookingPage.time,5);
        BrowserUtils.clickWithJS(bookingPage.time);
        bookingPage.time.sendKeys(time);

    }

    @Given("User can click search connection button")
    public void user_can_click_search_connection_button() {

       // BrowserUtils.waitForVisibility(bookingPage.searchButton,5);
        BrowserUtils.clickWithJS(bookingPage.searchButton);

    }

    @Given("Verify that user can not move next page, title should not changed")
    public void verify_that_user_can_not_move_next_page_title_should_not_changed() {

        BrowserUtils.waitFor(5);
        wait.until(ExpectedConditions.visibilityOf(bookingPage.resultPageDate));
        String actualTitle=Driver.get().getTitle();
        String expectedTitle="https://rozklad-pkp.pl/en";
        bookingPage.assertionMessage();
        Assert.assertEquals(expectedTitle,actualTitle);
        BrowserUtils.waitFor(2);

    }

}