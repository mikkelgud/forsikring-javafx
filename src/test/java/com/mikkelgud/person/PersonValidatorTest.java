package com.mikkelgud.person;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

public class PersonValidatorTest {

    private static PersonValidator personValidator;
    private final String aValidFirstName = "Mikkel";
    private final String aValidLastName = "Gudmundsen";
    private final String aValidBillingAddress = "Hus A, 0779 Oslo";
    private final String[] invalidNames = new String[]{null, ""};

    @BeforeClass
    public static void setup() {
        personValidator = new PersonValidator();
    }

    @Test
    public void shouldThrowExceptionIfEmptyFirstName() {

        for (String invalidName : invalidNames) {
            try {
                personValidator.createNew(invalidName, aValidLastName, aValidBillingAddress);
                fail();
            } catch (InvalidPersonPropertiesException expectedException) {
                Assert.assertEquals(
                        "Expected that exception message should regard non-empty first name.",
                        PersonValidator.MESSAGE_NO_EMPTY_FIRSTNAME,
                        expectedException.getMessage());
            }
        }
    }

    @Test
    public void shouldThrowExceptionIfEmptyLastName() {

        for (String invalidName : invalidNames) {
            try {
                personValidator.createNew(aValidFirstName, invalidName, aValidBillingAddress);
                fail();
            } catch (InvalidPersonPropertiesException expectedException) {
                Assert.assertEquals(
                        "Expected that exception message should regard non-empty last name.",
                        PersonValidator.MESSAGE_NO_EMPTY_LASTNAME,
                        expectedException.getMessage());
            }
        }
    }

    @Test
    public void shouldThrowExceptionIfEmptyBillingAddress() {

        for (String invalidName : invalidNames) {
            try {
                personValidator.createNew(aValidFirstName, aValidLastName, invalidName);
                fail("Expected create new throw exception");
            } catch (InvalidPersonPropertiesException expectedException) {
                Assert.assertEquals(
                        "Expected that exception message should regard non-empty billing address.",
                        PersonValidator.MESSAGE_NO_EMPTY_BILLING_ADDRESS,
                        expectedException.getMessage());
            }
        }
    }

    @Test
    public void shouldThrowExceptionIfTooShortFirstName() {
        try {
            personValidator.createNew("ab", aValidLastName, aValidBillingAddress);
            fail();
        } catch (InvalidPersonPropertiesException expectedException) {
            Assert.assertEquals(
                    "Expected that exception message should regard too short first name.",
                    PersonValidator.MESSAGE_TOO_SHORT_FIRSTNAME,
                    expectedException.getMessage());
        }
    }
}