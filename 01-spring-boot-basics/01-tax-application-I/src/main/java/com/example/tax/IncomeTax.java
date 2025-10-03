package com.example.tax;

public class IncomeTax implements Tax {
    /*
    1. Create the following attributes.
        a. taxableAmount (double)
        b. taxAmount (double)
        c. isTaxPayed (boolean)
    2. Make this class an implementation of Tax interface and override the interface methods.
    3. Using constructor initialize the isTaxPayed boolean false.
     */

    double taxableAmount;
    double taxAmount;
    boolean isTaxPayed;

    public IncomeTax() {
        this.isTaxPayed = false;
    }

    @Override
    public void setTaxableAmount(int amount) {
        this.taxableAmount = amount;
    }

    @Override
    public void calculateTaxAmount() {
        if(taxableAmount < 300000){
            taxAmount = 0;
        } else if (taxableAmount < 600000) {
            taxAmount = taxableAmount * 0.05;
        } else if (taxableAmount < 900000) {
            taxAmount = taxableAmount * 0.1;
        } else if (taxableAmount < 1200000) {
            taxAmount = taxableAmount * 0.15;
        } else if (taxableAmount < 1500000) {
            taxAmount = taxableAmount * 0.2;
        } else {
            taxAmount = taxableAmount * 0.3;
        }
    }

    @Override
    public double getTaxAmount() {
        return this.taxAmount;
    }

    @Override
    public String getTaxType() {
        return "income";
    }

    @Override
    public boolean isTaxPayed() {
        return isTaxPayed;
    }

    @Override
    public void payTax() {
        isTaxPayed = true;
        System.out.println("Hi, your " + getTaxType() + " tax is paid.");
    }
}
