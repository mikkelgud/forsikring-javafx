
package com.mikkelgud.Insurance;

import java.time.LocalDateTime;


public class TravelInsurance extends GeneralInsurance {

    public TravelInsurance(String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo) {
        super(insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo);
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return null;
    }
}
    

