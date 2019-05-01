package com.mikkelgud.Insurance;

public class InsuranceValidator {
    //Only validating one thing so only one message i needed
    private static final String MESSAGE_NO_EMPTY_FIELDS = "Venligst fyll ut alle feltetene i registreringen";

    public BoatInsurance createNewBoatInsurance(String insuranceYearlyPayment, String insuranceAmount, String insuranceInfo, String boatType, String length, String model, String engineType, String enginePower) throws InvalidInsurancePropertiesException {

        if (!isPresent(boatType)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(length)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(model)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(engineType)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(enginePower)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }

        return new BoatInsurance(boatType, length, model, engineType, enginePower, insuranceYearlyPayment, insuranceAmount, insuranceInfo);
    }

    private boolean isPresent(String stringToValidate) {
        return stringToValidate != null && !stringToValidate.isEmpty();
    }

//    private boolean isIntegerPresent(int intToValidate) {
//        if (intToValidate > 0) return true;
//        else return false;
//    }
}