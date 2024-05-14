import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
        String birthDay = "28 May,1981";
        String curentAddress = "123 New Road ln";


      open("/automation-practice-form");
      //verify that you are on the right page
      $(".text-center").shouldHave(text("Practice Form"));
      $(".practice-form-wrapper>h5").shouldHave(text("Student Registration Form"));

      //fill up the form
      $("#firstName").setValue(firstName);
      $("#lastName").setValue(lastName);
      $("#userEmail").setValue(email);

      //Select the right radio button
      $("#gender-radio-1 + label").click();
      $("#gender-radio-1").shouldBe(selected);

      //Enter the phone number
      $("#userNumber").setValue(phone);

      //Select DOB from drop-down calendar
      $("#dateOfBirthInput").click();
      $(".react-datepicker__month-select > option[value = '4']").click();
      $(".react-datepicker__year-select > option[value = '1981']").click();
      $("[aria-label='Choose Thursday, May 28th, 1981']").click();

      //Select subject
      $("#subjectsContainer").click();
      $("#subjectsInput").setValue("Com");
      $(byText("Computer Science")).click();
      $("#subjectsContainer").shouldHave(text("Computer Science"));

      //Select hobbies
      $("#hobbies-checkbox-1 + label").click();

      //Upload file
      File uploadPicture = new File("C:/Users/Nicko/Desktop/testPhoto.jpg");
      $("#uploadPicture").uploadFile(uploadPicture);

      //currentAddress form set up
        $("#currentAddress").setValue(curentAddress);
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Lucknow")).click();

        //click Submit button
        $("#submit").click();

        //verify the result matching entered data
        $$("td").findBy(text("Student Name"))
                .sibling(0)
                .shouldHave(text(firstName + " " + lastName));
        $$("td").findBy(text("Student Email"))
                .sibling(0)
                .shouldHave(text(email));
        $$("td").findBy(text("Gender"))
                .sibling(0)
                .shouldHave(text("Male"));
        $$("td").findBy(text("Mobile"))
                .sibling(0)
                .shouldHave(text(phone));
        $$("td").findBy(text("Date of Birth"))
                .sibling(0)
                .shouldHave(text(birthDay));
        $$("td").findBy(text("Subjects"))
                .sibling(0)
                .shouldHave(text("Computer Science"));
        $$("td").findBy(text("Hobbies"))
                .sibling(0)
                .shouldHave(text("Sports"));
        $$("td").findBy(text("Picture"))
                .sibling(0)
                .shouldHave(text("testPhoto.jpg"));
        $$("td").findBy(text("Address"))
                .sibling(0)
                .shouldHave(text(curentAddress));
        $$("td").findBy(text("State and City"))
                .sibling(0)
                .shouldHave(text("Uttar Pradesh Lucknow"));










    }
}
