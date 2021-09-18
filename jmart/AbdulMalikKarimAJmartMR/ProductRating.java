package AbdulMalikKarimAJmartMR;


/**
 * Write a description of class ProductRating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductRating
{
    long total;
    long count;

    /**
     * Constructor for objects of class ProductRating
     */
    public ProductRating()
    {
        total = 0;
        count = 0;
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
        return count;
    }
    
    public long getTotal(){
        return total;
    }
}
    
    
    

