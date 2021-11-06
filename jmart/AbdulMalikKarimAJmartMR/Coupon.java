package AbdulMalikKarimAJmartMR;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Coupon extends Serializable
{
    public String name;
    public int code;
    public double cut;
    public Type type;
    public double minimum;
    private boolean used;
    
    public Coupon(int id,String name, int code, Type type, double cut, double minimum){
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
    }
    
    public boolean isUsed(){
        return used;
    }
    
    public boolean canApply(Treasury priceTag){
        if (used || priceTag.getAdjustedPrice() < minimum)
            return false;
        return true;
    }
    
    public double apply(Treasury priceTag){
        used = true;
        double adjustedPrice = priceTag.getAdjustedPrice();
        switch (type)
        {
            case REBATE:
                if (adjustedPrice >= cut) return 0.0;
                return adjustedPrice - cut;
            case DISCOUNT:
                if (cut >= 100.0) return 0.0;
                return adjustedPrice - adjustedPrice * cut;
        }
        return 0.0;
    }
    
    public enum Type
    {
        DISCOUNT, REBATE
    }

}
