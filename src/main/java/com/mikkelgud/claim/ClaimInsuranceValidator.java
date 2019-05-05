package com.mikkelgud.claim;

public class ClaimInsuranceValidator {
    private static final String MESSAGE_MUST_REGISTRATE_A_USER = "Vennligst merk registrer en person før du oppretter en forsikring";
    private static final String MESSAGE_NO_EMPTY_FIELDS = "Venligst fyll ut alle feltetene i registreringen";
    private static final String MESSAGE_NOT_A_NUMBER = "Nummer må skrives inn som heltall";


    public ClaimInsurance createNewClaimInsurance(int insuranceId, String currentPersonId, String damageType, String dateOfRegistration, String descriptionOfDamage, String taxationValue, String witnesses, String moneyBack) throws InvalidClaimRegistrationException {
        if (!isPresent(currentPersonId)) {
            throw new InvalidClaimRegistrationException(MESSAGE_MUST_REGISTRATE_A_USER);
        }
        if (!isPresent(damageType)) {
            throw new InvalidClaimRegistrationException(MESSAGE_NO_EMPTY_FIELDS);
        }
        if (!isPresent(dateOfRegistration)) {
            throw new InvalidClaimRegistrationException(MESSAGE_NO_EMPTY_FIELDS);
        }
        if (!isPresent(descriptionOfDamage)) {
            throw new InvalidClaimRegistrationException(MESSAGE_NO_EMPTY_FIELDS);
        }
        if (!isNumber(taxationValue)) {
            throw new InvalidClaimRegistrationException(MESSAGE_NOT_A_NUMBER);
        }
        if (!isPresent(witnesses)) {
            throw new InvalidClaimRegistrationException(MESSAGE_NO_EMPTY_FIELDS);
        }
        return new ClaimInsurance(insuranceId, currentPersonId, damageType, dateOfRegistration, descriptionOfDamage, taxationValue, witnesses, moneyBack);
    }

    private boolean isPresent(String stringToValidate) {
        return stringToValidate != null && !stringToValidate.isEmpty();
    }

    private boolean isNumber(String stringToValidate) {
        try {
            Integer.parseInt(stringToValidate);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


}
