package com.mikkelgud.insurance;

public class InsuranceValidator {
    private static final String MESSAGE_MUST_REGISTRATE_A_USER = "Vennligst merk av en registrert person";
    private static final String MESSAGE_NO_EMPTY_FIELDS = "Venligst fyll ut alle feltetene i registreringen";
    private static final String MESSAGE_ONLY_EMPTY_FIELDS = "Vennligst Kryss av minst ett felt!";
    private static final String MESSAGE_LENGTH_NOT_A_NUMBER = "Vennligst påse at lengden er et helttall";
    private static final String MESSAGE_NOT_A_NUMBER = "Nummer må skrives inn som heltall";
    private static final int NUMBER_OF_WORLD_PARTS = 6;

    public BoatInsurance createNewBoatInsurance(String currentPersonId, String insuranceYearlyPayment, String insuranceAmount, String insuranceInfo, String boatType, String length, String model, String engineType, String enginePower) throws InvalidInsurancePropertiesException {

        if (!isPresent(currentPersonId)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_MUST_REGISTRATE_A_USER);
        }
        if (!isPresent(boatType)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }
        if (!isNumber(length)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_LENGTH_NOT_A_NUMBER);
        }
        if (!isPresent(model)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }
        if (!isPresent(engineType)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }
        if (!isNumber(enginePower)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NOT_A_NUMBER);
        }
        return new BoatInsurance(currentPersonId, insuranceYearlyPayment, insuranceAmount, insuranceInfo, boatType, length, model, engineType, enginePower);
    }

    public HouseInsurance createNewHouseInsurance(String currentPersonId, String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo, String housingAddress, String yearBuilt, String housingType, String buildingMaterial, String housingState, String housingSize) throws InvalidInsurancePropertiesException {
        if (!isPresent(currentPersonId)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_MUST_REGISTRATE_A_USER);
        }
        if (!isNumber(housingSize)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NOT_A_NUMBER);
        }
        if (!isNumber(yearBuilt)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NOT_A_NUMBER);
        }
        if (!isPresent(housingAddress)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }
        return new HouseInsurance(currentPersonId, insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo, housingAddress, yearBuilt, housingType, buildingMaterial, housingState, housingSize);
    }

    public CabinInsurance createNewCabinInsurance(String currentPersonID, String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo, String address, String buildingMaterial, String housingState, String cabinSize, String buildingType, String yearBuilt, String insurancePriceBuilding, String insurancePriceHouseholdGoods) throws InvalidInsurancePropertiesException {

        if (!isPresent(currentPersonID)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_MUST_REGISTRATE_A_USER);
        }
        if (!isPresent(address)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
    }
        if (!isNumber(cabinSize)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NOT_A_NUMBER);
    }
        if (!isNumber(yearBuilt)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NOT_A_NUMBER);
    }
        return new CabinInsurance(currentPersonID, insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo, address, buildingMaterial, housingState, cabinSize, buildingType, yearBuilt, insurancePriceBuilding, insurancePriceHouseholdGoods);
    }

    public TravelInsurance createNewTravelInsurance(String currentPersonId, String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverage, boolean southAmerica, boolean northAmerica, boolean asia, boolean oseania, boolean africa, boolean europe) throws InvalidInsurancePropertiesException {
        boolean[] travelInsuranceBooleans = new boolean[NUMBER_OF_WORLD_PARTS];
        travelInsuranceBooleans[0] = europe;
        travelInsuranceBooleans[1] = asia;
        travelInsuranceBooleans[2] = northAmerica;
        travelInsuranceBooleans[3] = southAmerica;
        travelInsuranceBooleans[4] = oseania;
        travelInsuranceBooleans[5] = africa;

        if (!isPresent(currentPersonId)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_MUST_REGISTRATE_A_USER);
        }
        if (!isAtLeastOneMarked(travelInsuranceBooleans)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_ONLY_EMPTY_FIELDS);
        }
        return new TravelInsurance(currentPersonId, insuranceYearlyPayment, insuranceAmount, insuranceCoverage, europe, asia, northAmerica, southAmerica, oseania, africa);
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

    private boolean isAtLeastOneMarked(boolean[] booleansToValidate) {
        for (boolean e : booleansToValidate) {
            if (e == true) return true;
        }
        return false;
    }
}