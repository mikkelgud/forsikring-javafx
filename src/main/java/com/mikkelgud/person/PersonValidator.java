package com.mikkelgud.person;

public class PersonValidator {

    private static final int MIN_LENGTH_LASTNAME = 3;
    private static final int MIN_LENGTH_FIRSTNAME = 2;
    private static final int MIN_LENGTH_BILLINGADDRESS = 3;

    public static final String MESSAGE_NO_EMPTY_FIRSTNAME = "Personen må ha et fornavn.";
    public static final String MESSAGE_NO_EMPTY_LASTNAME = "Personen må ha et etternavn.";
    public static final String MESSAGE_NO_EMPTY_BILLING_ADDRESS = "Personen må ha en fakturaadresse.";

    public static final String MESSAGE_TOO_SHORT_FIRSTNAME = String.format("Lengden på fornavnet må være større enn %d.", MIN_LENGTH_FIRSTNAME);
    public static final String MESSAGE_TOO_SHORT_LASTNAME = String.format("Lengden på etternavnet må være større enn %d.", MIN_LENGTH_LASTNAME);
    public static final String MESSAGE_TOO_SHORT_BILLING_ADDRESS = String.format("Lengden på faktureringsadressen må være større enn %d.", MIN_LENGTH_BILLINGADDRESS);

    public Person createNew(String firstName, String lastName, String billingAddress) throws InvalidPersonPropertiesException {

        if (!isPresent(firstName)) {
            throw new InvalidPersonPropertiesException(MESSAGE_NO_EMPTY_FIRSTNAME);
        }

        if (!isPresent(lastName)) {
            throw new InvalidPersonPropertiesException(MESSAGE_NO_EMPTY_LASTNAME);
        }

        if (!isPresent(billingAddress)) {
            throw new InvalidPersonPropertiesException(MESSAGE_NO_EMPTY_BILLING_ADDRESS);
        }

        if (!hasValidLength(firstName, MIN_LENGTH_FIRSTNAME)) {
            throw new InvalidPersonPropertiesException(MESSAGE_TOO_SHORT_FIRSTNAME);
        }

        if (!hasValidLength(lastName, MIN_LENGTH_LASTNAME)) {
            throw new InvalidPersonPropertiesException(MESSAGE_TOO_SHORT_LASTNAME);
        }

        if (!hasValidLength(billingAddress, MIN_LENGTH_BILLINGADDRESS)) {
            throw new InvalidPersonPropertiesException(MESSAGE_TOO_SHORT_BILLING_ADDRESS);
        }

        return new Person(firstName, lastName, billingAddress);
    }


    private boolean hasValidLength(String stringToValidate, int minLength) {
        return stringToValidate.length() >= minLength;
    }

    private boolean isPresent(String stringToValidate) {
        return stringToValidate != null && !stringToValidate.isEmpty();
    }
}
