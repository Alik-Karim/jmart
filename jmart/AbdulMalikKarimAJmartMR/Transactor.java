package AbdulMalikKarimAJmartMR;


public interface Transactor
{
 //   public String time = "Time";
//   public int buyerId;
//    public int storeId;
//    public Rating rating = Rating.NONE;
    
//    public enum Rating{
//        NONE,BAD,NEUTRAL,GOOD
//    }
    
//    protected Transaction(int id,int buyerId,int storeId){
//        super(id);
//        this.buyerId = buyerId;
//        this.storeId = storeId;
//    }
//    
//    protected Transaction(int id,Account buyer,Store store){
//        super(id);
//        this.buyerId =buyer.id;
//        this.storeId = store.id;
//    }
    
    public default boolean validate() {
        return false;
    }

    public default Invoice perform() {
        return null;
    }
}
