package AbdulMalikKarimAJmartMR;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

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

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
        List<Product> products = new ArrayList<>();
        for(Product product : list){
            if(product.category.equals(category)){
                products.add(product);
            }
        }
        return products;
    }

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
        List<Product> products = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(minPrice <= 0.0){
                if(list.get(i).price <= maxPrice){
                    products.add(list.get(i));
                }
            }else if(maxPrice <= 0.0){
                if(list.get(i).price >= minPrice){
                    products.add(list.get(i));
                }
            }else{
                if(list.get(i).price >= minPrice && list.get(i).price <= maxPrice){
                    products.add(list.get(i));
                }
            }
        }
        return products;
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
        }catch (Throwable t)
        {
            t.printStackTrace();
        }
    }
}

