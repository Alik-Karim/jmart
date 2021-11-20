package com.AbdulMalikKarimAJmartMR;

public class Product extends Serializable
{
    public int accountId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public double discount;
    public ProductCategory category;
    public double price;
    public byte shipmentPlans;

    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans) {
        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }

    @Override
    public String toString(){
        return "Name: " + this.name +
                "\nWeight: " + this.weight +
                "\nconditionUsed: " + this.conditionUsed +
                "\npriceTag: " + this.price +
                "\ncategory: " + this.category +
                "\nrating: " + this.discount +
                "\nstoreId: " + this.accountId;
    }
}
