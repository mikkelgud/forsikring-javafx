package com.mikkelgud.Insurance;

public class InsuranceValidator {
    private static final String MESSAGE_NO_EMPTY_FIELDS = "Venligst fyll ut alle feltetene i registreringen";

    public BoatInsurance createNewBoatInsurance(String boatType, String length, String model, String engineType, String enginePower) throws InvalidInsurancePropertiesExcepetion {

        if (!isPresent(boatType)) {
            throw new InvalidInsurancePropertiesExcepetion(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(length)) {
            throw new InvalidInsurancePropertiesExcepetion(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(model)) {
            throw new InvalidInsurancePropertiesExcepetion(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(engineType)) {
            throw new InvalidInsurancePropertiesExcepetion(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(enginePower)) {
            throw new InvalidInsurancePropertiesExcepetion(MESSAGE_NO_EMPTY_FIELDS);
        }

        return new BoatInsurance(boatType, length, model, engineType, enginePower);
    }

    private boolean isPresent(String stringToValidate) {
        return stringToValidate != null && !stringToValidate.isEmpty();
    }

//    private boolean isIntegerPresent(int intToValidate) {
//        if (intToValidate > 0) return true;
//        else return false;
//    }
}