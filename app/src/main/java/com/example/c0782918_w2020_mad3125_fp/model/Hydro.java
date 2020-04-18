package com.example.c0782918_w2020_mad3125_fp.model;

import java.util.Date;

public class Hydro extends Bill {

    private String agencyName;
    private int unitsConsumed;

    public Hydro(String billID, BillType billType, String billDate, String agencyName, int unitsConsumed) {
        super(billID, billType, billDate);

        this.agencyName = agencyName;
        this.unitsConsumed = unitsConsumed;
        this.billTotal = getBillTotal();
    }

    @Override
    public Double getBillTotal() {
        double billAmount = 0.0;

        billAmount = 5.0 * this.unitsConsumed;

        return billAmount;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(int unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }
}
