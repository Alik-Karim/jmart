package AbdulMalikKarimAJmartMR;


/**
 * Write a description of class ProductRating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductRating
{
    private long total;
    private long count;

    /**
     * Constructor for objects of class ProductRating
     */
    public ProductRating()
    {
        this.total = 0;
        this.count = 0;
    }

    public void insert(int rating)
    {
        total =+ rating;
        count ++;
    }
    
    public double getAverage(){
        if(count !=0){
            return total/count;
        }else{
            return 0;
        }
    }
    
    public long getCount(){
        return this.count;
    }
    
    public long getTotal(){
        return this.total;
    }
}
    
    
    

