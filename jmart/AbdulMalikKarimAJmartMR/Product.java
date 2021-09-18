package AbdulMalikKarimAJmartMR;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    private static int idCounter = 0;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductRating rating;
    public ProductCategory category;
    
    public Product (String name,int weight,boolean conditionUsed, PriceTag priceTag, ProductCategory category){
        id = idCounter;
        idCounter++;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        ProductRating rating =new ProductRating();
        this.priceTag = priceTag;
        this.category = category;
        
    }
}
