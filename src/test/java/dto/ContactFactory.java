package dto;

import com.github.javafaker.Faker;

public class ContactFactory {

    public static Contact getContact(String salutationOption, String date, String leadSourceOption, String levelOption) {

        Faker faker = new Faker();
        return new Contact(faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().phoneNumber(),
                salutationOption,
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().phoneNumber(),
                faker.company().name(),
                faker.phoneNumber().phoneNumber(),
                faker.company().profession(),
                faker.phoneNumber().cellPhone(),
                date,
                faker.internet().emailAddress(),
                faker.name().fullName(),
                leadSourceOption,
                faker.phoneNumber().phoneNumber(),
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.address().country(),
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.address().country(),
                faker.programmingLanguage().name(),
                levelOption,
                faker.weather().description()
        );
    }
}
