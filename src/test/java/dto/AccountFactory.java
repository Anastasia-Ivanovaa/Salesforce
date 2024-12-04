package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

    public static Account getAccount(String ratingOption, String accountNumber, String typeOption, String ownershipOption,
                                     String industryOption, String employees, String annualRevenue, String date,
                                     String customerPriorityOption, String slaOption, String slaSerialNumber,
                                     String upsellOpportunityOption, String activeOption) {
        Faker faker = new Faker();
        return new Account(
                faker.company().name(),
                ratingOption,
                faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().cellPhone(),
                accountNumber,
                faker.internet().url(),
                faker.company().url(),
                faker.company().suffix(),
                typeOption,
                ownershipOption,
                industryOption,
                employees,
                annualRevenue,
                faker.company().suffix(),
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
                date,
                customerPriorityOption,
                slaOption,
                slaSerialNumber,
                upsellOpportunityOption,
                activeOption,
                faker.weather().description()
        );
    }
}
