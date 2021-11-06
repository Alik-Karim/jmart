package AbdulMalikKarimAJmartMR;


import java.util.HashMap;
import java.util.Map;

public class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    
    protected Serializable(int id){
        this.id = id;
    }
    
    protected Serializable()
    {
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }
    
    @Override
    public int compareTo(Serializable other) {
        return Integer.compare(this.id, other.id);
    }

    public boolean equals(Object o){
        if(o instanceof Serializable){
            Serializable or = (Serializable) o;
            if (this.id == or.id){
                return true;
            }
            return false;
        }
        else {
            return true;
        }
    }

    public boolean equals(Serializable r){
        if(this.id == r.id){
            return true;
        }
        else {
            return false;
        }
    }

    public static <T extends Serializable> int setClosingId(Class<T> clazz, int id) {
    	return mapCounter.getOrDefault(clazz, id);
    }

    public static <T extends Serializable> int getClosingId(Class<T> clazz) {
    	return mapCounter.get(clazz);
    }
    
}
