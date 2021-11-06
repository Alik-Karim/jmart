package AbdulMalikKarimAJmartMR;

public class Product extends Serializable
{
    private static int idCounter = 0;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public Treasury priceTag;
    public ProductCategory category ;
    public ProductRating rating;
    public int storeId;
    public Shipment.MultiDuration multiDuration;

    public Product(int id, int storeId, String name, 
    int weight, boolean conditionUsed, Treasury priceTag,
    ProductCategory category, Shipment.MultiDuration multiDuration){
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
        this.multiDuration = multiDuration;
    }

    public boolean read(String content){
        return false;
    }

    public String toString() {
        return 
        "Name: " + this.name +
        "\nWeight: " + this.weight +
        "\nconditionUsed: " + this.conditionUsed +
        "\npriceTag: " + this.priceTag +
        "\ncategory: " + this.category +
        "\nrating: " + this.rating +
        "\nstoreId: " + this.storeId;
    }
    
}
