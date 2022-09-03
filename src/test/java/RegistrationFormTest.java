import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTest {

    RegistrationFormPageObject service = new RegistrationFormPageObject();

    @BeforeEach
    void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void fillFormTest() {
        service.fillForm();
        service.clickButton();
        service.assertForm();
    }
}
