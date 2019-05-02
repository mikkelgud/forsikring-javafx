package com.mikkelgud.insurance;

public class InsuranceValidator {
    //Only validating one thing so only one message i needed
    private static final String MESSAGE_NO_EMPTY_FIELDS = "Venligst fyll ut alle feltetene i registreringen";
    private static final String MESSAGE_ONLY_EMPTY_FIELDS = "Kryss av minst ett felt!";

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
                                                  String insuranceInfo,String insuranceAddress, String yearBuilt, String housingSize, String insurancePremiumBuilding,
                                                  String insurancePremiumInnbo, String houseType, String buildingMaterial) throws InvalidInsurancePropertiesException {

        if (!isPresent(housingSize)) {
            throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
        }

        if (!isPresent(yearBuilt)) {
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

        return new HouseInsurance(currentPersonId,insuranceYearlyPayment, insuranceAmount, insuranceInfo, insuranceAddress,
                yearBuilt, housingSize, insurancePremiumBuilding, insurancePremiumInnbo, houseType, buildingMaterial,
                insuranceBP, insuranceHG);
    }

    public CabinInsurance createNewCabinInsurance(String currentPersonID, String insuranceYearlyPayment, String insuranceAmount,
                                                  String insuranceCoverageInfo, String address, String buildingMaterial,
                                                  String housingState, String cabinSize, String yearBuilt,
                                                  String insurancePriceBuilding, String insurancePriceHouseholdGoods) throws InvalidInsurancePropertiesException {
    if(!isPresent(insuranceYearlyPayment)){
        throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
    }

    if (!isPresent(insuranceAmount)) {
        throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
    }

    if (!isPresent(insuranceCoverageInfo)){
        throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
    }

    if (!isPresent(address)){
        throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
    }

    if(!isPresent(buildingMaterial)){
        throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
    }

    if(!isPresent(housingState)){
        throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
    }

    if(!isPresent(cabinSize)){
        throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
    }

    if(!isPresent(yearBuilt)){
        throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
    }

    if(!isPresent(insurancePriceBuilding)){
        throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
    }

    if(!isPresent(insurancePriceHouseholdGoods)){
        throw new InvalidInsurancePropertiesException(MESSAGE_NO_EMPTY_FIELDS);
    }
    return new CabinInsurance(insuranceYearlyPayment,insuranceAmount,
            insuranceCoverageInfo, address, buildingMaterial,
            housingState, cabinSize, yearBuilt,
            insurancePriceBuilding, insurancePriceHouseholdGoods);

    }

    public TravelInsurance createNewTravelinsurance(){
        return null;
    }


    private boolean isPresent(String stringToValidate) {
        return stringToValidate != null && !stringToValidate.isEmpty();
    }
}