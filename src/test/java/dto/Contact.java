package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {

    private final String phone;
    private final String homePhone;
    private final String salutationOption;
    private final String firstName;
    private final String lastName;
    private final String mobile;
    private final String title;
    private final String otherPhone;
    private final String department;
    private final String fax;
    private final String birthdate;
    private final String email;
    private final String assistant;
    private final String leadSourceOption;
    private final String asstPhone;
    private final String mailingStreet;
    private final String mailingCity;
    private final String mailingState;
    private final String mailingZip;
    private final String mailingCountry;
    private final String otherStreet;
    private final String otherCity;
    private final String otherState;
    private final String otherZip;
    private final String otherCountry;
    private final String languages;
    private final String levelOption;
    private final String description;
}
