package AbdulMalikKarimAJmartMR;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon
{
    public String name;
    public int code;
    public double cut;
    public Type type;
    public double minimum;
    private boolean used;
    
    public Coupon(String name, int code, Type type, double cut, double minimum){
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
    
    public boolean canApply(PriceTag pricetag){
        if(pricetag.getAdjustedPrice() >= minimum & used == false){
            return true;
        }else{
            return false;
        }
    }
    
    public double apply(PriceTag pricetag){
        this.used = true;
        if(this.type == Type.DISCOUNT){
            return (pricetag.getAdjustedPrice()*((100 - this.cut)/100));
        }else{
            return (pricetag.getAdjustedPrice() - this.cut);
        }
    }
    
    public enum Type
    {
        DISCOUNT, REBATE
    }

}
