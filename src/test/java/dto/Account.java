package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private final String accountName;
    private final String ratingOption;
    private final String phone;
    private final String fax;
    private final String accountNumber;
    private final String website;
    private final String accountSite;
    private final String tickerSymbol;
    private final String typeOption;
    private final String ownershipOption;
    private final String industryOption;
    private final String employees;
    private final String annualRevenue;
    private final String sicCode;
    private final String billingStreet;
    private final String billingCity;
    private final String billingState;
    private final String billingZip;
    private final String billingCountry;
    private final String shippingStreet;
    private final String shippingCity;
    private final String shippingState;
    private final String shippingZip;
    private final String shippingCountry;
    private final String slaExpirationDate;
    private final String customerPriorityOption;
    private final String slaOption;
    private final String slaSerialNumber;
    private final String upsellOpportunityOption;
    private final String activeOption;
    private final String description;
}



