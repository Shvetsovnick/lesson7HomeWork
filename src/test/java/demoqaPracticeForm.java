import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class demoqaPracticeForm {

    public String webAddress = "https://demoqa.com/";

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1500";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillUpPracticeForm() {
        Configuration.holdBrowserOpen = true;
        String firstName = "Nickolas";
        String lastName = "Usovilas";
        String email = "nickusolovich@mail.ua";
        String phone = "3071112222";
        String birthDay = "28 May 1981";


      open("/automation-practice-form");
      //verify that you are on the right page
      $(".text-center").shouldHave(text("Practice Form"));
      $(".practice-form-wrapper>h5").shouldHave(text("Student Registration Form"));

      //fill up the form
      $("#firstName").setValue(firstName);
      $("#lastName").setValue(lastName);
      $("#userEmail").setValue(email);
//      $("#gender-radio-2").shouldBe(visible);
      $("#userNumber").setValue(phone);
      $("#dateOfBirthInput").click();
      $("#dateOfBirthInput").clear();


      $(".react-datepicker__month-select > option[value = '4']").click();
      $(".react-datepicker__year-select > option[value = '1981']").click();
      $("[aria-label='Choose Thursday, May 28th, 1981']").click();




    }
}
