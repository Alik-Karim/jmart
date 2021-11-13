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
//        System.out.println("account id:" + new Account(null, null, null, -1).id);
//        System.out.println("account id:" + new Account(null, null, null, -1).id);
//        System.out.println("account id:" + new Account(null, null, null, -1).id);

        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);

        try{
        	//filter price
            List<Product> list = read("D:\\download\\OOP prak\\jmart\\jmart\\AbdulMalikKarimAJmartMR\\randomProductList.json ");
            List<Product> filtered = filterByPrice(list, 20000.0, 25000.0);
            filtered.forEach(product -> System.out.println(product.price));
            //filter name
            List<Product> filteredName = filterByName(list, "gtx", 1, 5);
            filteredName.forEach(product -> System.out.println(product.name));
            //filter account
            List<Product> filteredAccount = filterByAccountId(list, 1, 0, 5);
            filteredAccount.forEach(product -> System.out.println(product.name));
        }catch (Throwable t)
        {
            t.printStackTrace();
        }
        
        try{
            String filepath = "D:\\download\\OOP prak\\jmart\\jmart\\AbdulMalikKarimAJmartMR\\account.json";

            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "email", "password"));
            tableAccount.writeJson();

            tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.forEach(account -> System.out.println(account.toString()));

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
            if(page<0){
                page = 0;
            }
            if(pageSize<0){
                pageSize = 0;
            }
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

