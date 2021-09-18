package AbdulMalikKarimAJmartMR;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    private static int idCounter;
    public int id;
    public String name;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductRating rating;
    
    public Product (String name,int weight,boolean conditionUsed, PriceTag priceTag){
        this.idCounter = idConter++;
        this.name = name;
        this.weight = wight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
    }
}
