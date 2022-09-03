import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPageObject {

    static SelenideElement
            name = $("#firstName"),
            surname = $("#lastName"),
            emailLock = $("#userEmail"),
            radioButton = $("[for=gender-radio-1]"),
            phone = $("#userNumber"),
            subjectsLock = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submitButton = $("#submit"),

    thankYOu = $("#modal-title h4");

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().phoneNumber();
    String subjects = faker.pokemon().name();

    public void fillForm() {
        fillName();
        fillSurname();
        fillEmail();
        fillPhoneNumber();
        clickRadioButton();
        fillSubjects();
        clickHobbies();
        fillAddress();
        clickState();
        clickCity();
    }

    public void clickButton() {
        submitButton.click();
    }

    public void assertForm() {
        thankYOu.shouldHave(Condition.text("Thanks for submitting the form"));
    }

    private void fillName() {
        name.setValue(firstName);
    }

    private void fillSurname() {
        surname.setValue(lastName);
    }

    private void fillEmail() {
        emailLock.setValue(email);
    }

    private void clickRadioButton() {
        radioButton.click();
    }

    private void fillPhoneNumber() {
        phone.setValue(phoneNumber);
    }

    private void fillSubjects() {
        subjectsLock.setValue(subjects);
    }

    private void clickHobbies() {
        hobbies.find(new ByText("Sports")).click();
    }

    private void fillAddress() {
        currentAddress.setValue("Moscow");
    }

    private void clickState() {
        state.click();
        state.find(new ByText("NCR")).click();
    }

    private void clickCity() {
        city.click();
        city.find(new ByText("Delhi")).click();
    }


}
