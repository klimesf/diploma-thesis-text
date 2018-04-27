class BillingAddress {

    @NotBlank(message = "country is compulsory")
    private String country;

    @NotBlank(message = "city is compulsory")
    private String city;

    @NotBlank(message = "street is compulsory")
    private String street;

    @NotBlank(message = "postalCode is compulsory")
    private String postalCode;

    /* ... */

}
