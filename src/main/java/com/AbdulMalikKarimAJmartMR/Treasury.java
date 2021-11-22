package com.AbdulMalikKarimAJmartMR;


/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Treasury
{
    public final double COMMISSION_MULTIPLIER = 0.05;
    public final double BOTTOM_PRICE = 20000.0;
    public final double BOTTOM_FEE = 1000.0;
    
    double discount;
    double price;

    public Treasury(double price, double discount) {
    }

    public double getAdjustedPrice(){
        return getAdminFee() + getDiscountedPrice();
    }
    
    public double getAdminFee(){
        double discountedPrice = getDiscountedPrice();
        if (discountedPrice < BOTTOM_PRICE)
            return BOTTOM_FEE;
        return COMMISSION_MULTIPLIER * discountedPrice;
    }
    
    private double getDiscountedPrice(){
        if(this.discount >= 100.0) return 0.0;
        double cut = price * discount / 100.0;
        return price - cut;
    }
}
