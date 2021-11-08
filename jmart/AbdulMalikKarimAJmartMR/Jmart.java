package AbdulMalikKarimAJmartMR;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Jmart
{
    public static List<Product> read(String filepath) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext()){
                products.add(gson.fromJson(reader, Product.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {
        return list.stream().filter(a -> a.category == category).collect(Collectors.toList());
    }

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
        if(minPrice == 0) list.stream().filter(a -> a.price <= maxPrice).collect(Collectors.toList());
        if(maxPrice == 0) list.stream().filter(a -> a.price >= minPrice).collect(Collectors.toList());
        return list.stream().filter(a -> a.price >= minPrice).filter(a -> a.price <= maxPrice).collect(Collectors.toList());
    }

    public static void main (String[] args){
        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);

        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);

        try{
            List<Product> list = read("D:\\download\\OOP prak\\jmart\\jmart\\AbdulMalikKarimAJmartMR\\randomProductList.json ");
            List<Product> filtered = filterByPrice(list, 20000.0, 25000.0);
            filtered.forEach(product -> System.out.println(product.price));
            
            List<Product> nameFiltered = filterByName(list, "gtx", 1, 5);
            nameFiltered.forEach(product -> System.out.println(product.name));

            List<Product> accountFiltered = filterByAccountId(list, 1, 0, 5);
            accountFiltered.forEach(product -> System.out.println(product.name));
        }catch (Throwable t)
        {
            t.printStackTrace();
        }
    }
    
    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        return list.stream().filter(a -> pred.predicate(a)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> predicate = a -> (a.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {
        Predicate<Product> predicate = a -> (a.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }
}

