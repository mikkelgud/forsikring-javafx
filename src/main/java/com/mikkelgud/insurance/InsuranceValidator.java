package com.mikkelgud.insurance;

public class InsuranceValidator {
    //Only validating one thing so only one message i needed
    private static final String MESSAGE_NO_EMPTY_FIELDS = "Venligst fyll ut alle feltetene i registreringen";


    public BoatInsurance createNewBoatInsurance(String currentPersonId, String insuranceYearlyPayment, String insuranceAmount, String insuranceInfo, String boatType, String length, String model, String engineType, String enginePower) throws InvalidInsurancePropertiesException {

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

        return new BoatInsurance(currentPersonId, insuranceYearlyPayment, insuranceAmount, insuranceInfo, boatType, length, model, engineType, enginePower);
    }


    public HouseInsurance createNewHouseInsurance(String currentPersonId, String insuranceYearlyPayment, String insuranceAmount,
                                                  String insuranceInfo, String housingSize, String insurancePremiumBuilding,
                                                  String insurancePremiumInnbo, String houseType, String buildingMaterial) throws InvalidInsurancePropertiesException {

        if (!isPresent(housingSize)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(insurancePremiumBuilding)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(insurancePremiumInnbo)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(houseType)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(buildingMaterial)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }

        String insuranceBP = "300 000";
        String insuranceHG = "100 000";

        return new HouseInsurance(currentPersonId, housingSize, insurancePremiumBuilding, insurancePremiumInnbo, houseType,
                buildingMaterial, insuranceYearlyPayment, insuranceAmount, insuranceInfo, insuranceBP, insuranceHG);
    }

    private boolean isPresent(String stringToValidate) {
        return stringToValidate != null && !stringToValidate.isEmpty();
    }
}