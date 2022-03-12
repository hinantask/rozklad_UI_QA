package pl.rozklad.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.rozklad.Utilities.BrowserUtils;
import pl.rozklad.Utilities.Driver;

public class BookingPage {
    {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "//button[contains(text(),'ZGADZAM SIĘ')]")
    public WebElement acceptAlert;

    @FindBy(id = "from-station")
    public WebElement fromStation;

    @FindBy(xpath = "(//img[@src='/img/content/icons/main/plus.png'])[2]")
    public WebElement viaStationButton;

    @FindBy(id = "wcag-via")
    public WebElement connectionBox;

    @FindBy(id = "hour2")
    public WebElement connectionTime;

    @FindBy(id = "to-station")
    public WebElement toStation;

    @FindBy(css = ".data-filed")
    public WebElement dateButton;

    @FindBy(xpath = "(//table[@class='ui-datepicker-calendar']//td)[25]")
    public WebElement date;

    @FindBy(css = ".btn.btn-default.pick-date")
    public WebElement selectDateButton;

    @FindBy(id = "hour")
    public WebElement time;

    @FindBy(id = "singlebutton")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='data-filed']/span[2]")
    public WebElement resultPageDate;


    public void selectDate(String date) {

        BrowserUtils.waitForVisibility(dateButton,5);
        BrowserUtils.clickWithJS(dateButton);
        String datepicker = "(//table[@class='ui-datepicker-calendar']//td)[" + date + "]";
        WebElement bookingPageDate = Driver.get().findElement(By.xpath(datepicker));
        System.out.println("Feature file date = " + date);
        BrowserUtils.clickWithJS(bookingPageDate);
        BrowserUtils.waitForVisibility(selectDateButton,5);
        BrowserUtils.clickWithJS(selectDateButton);


        }

        public void assertionMessage(){

            System.out.println("Resultpage date = " + resultPageDate.getText());
            System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");

            System.out.println("Explanation for Bug01");
            System.out.println("There is a bug because with wrong inputs title should NOT change and page can NOT move next page");
            System.out.println("There is a bug because date can NOT inputted with the same date in feature file " +
                    "with automation, system shows one previous day's date in result page");

            System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");

            System.out.println("Explanation for Bug02");
            System.out.println("There is a bug because stay time 00:00 is a logic error, it doesn't make sense" +
                    " can able to input that value");

            System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");

            System.out.println("Explanation for Bug03");
            System.out.println("There is a bug because previous-old dates can NOT chosen from current date");

        }
}

