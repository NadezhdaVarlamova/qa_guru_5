package gmail.com.varlamvanadia1996.tests;

import com.github.javafaker.Faker;
import gmail.com.varlamvanadia1996.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = "Female",
            phone = faker.phoneNumber().subscriberNumber(10),
            year = String.valueOf(faker.number().numberBetween(1990, 2020)),
            month = "March",
            day = String.valueOf(faker.number().numberBetween(1, 31)),
            subjects = "Maths",
            hobbiesSports = "Sports",
            hobbiesReading = "Reading",
            hobbiesMusic = "Music",
            fileName = "test.txt",
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal";

    @Test
    void successTests (){
        registrationPage.openPage("https://demoqa.com/automation-practice-form")
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .typeGender(gender)
                .typePhone(phone);
        registrationPage.calendarComponent.setDae(year, month, day);
        registrationPage.typeSubject(subjects)
        .typeHobbies(hobbiesSports)
        .typeHobbies(hobbiesReading)
        .typeHobbies(hobbiesMusic)
        .uploadPicture(fileName)
        .setAddress(address)
        .selectStateAndCity(state, city)
        .submitForm()
        .checkResults(firstName, lastName, userEmail, gender, phone,day + " " + month + "," + year, subjects, hobbiesSports + ", " + hobbiesReading + ", " + hobbiesMusic, fileName, address, state, city);
    }
}
