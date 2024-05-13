import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class demoqaPracticeForm {

    public String webAddress = "https://demoqa.com/";

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1500";



    }

    @Test
    void fillUpPracticeForm() {
      open("https://demoqa.com/automation-practice-form");
      $(".text-center").shouldHave(text("Practice Form"));
      $(".practice-form-wrapper>h5").shouldHave(text("Student Registration Form"));



    }
}
