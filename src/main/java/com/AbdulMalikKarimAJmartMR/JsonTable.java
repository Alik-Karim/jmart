<<<<<<< HEAD:src/main/java/com/AbdulMalikKarimAJmartMR/JsonTable.java
package com.AbdulMalikKarimAJmartMR;


import com.google.gson.Gson;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;

public class JsonTable<T> extends Vector<T> {
    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T> clazz, String filepath) throws IOException {
        this.filepath = filepath;
        try {
            Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] result = readJson(arrayType, filepath);
            if(result != null) {
                Collections.addAll(this, result);
            }
        } catch (FileNotFoundException e) {
            File f = new File(filepath);
            File f1 = f.getParentFile();
            if(f1 != null) {
                f.mkdir();
            }
            f.createNewFile();
        }
    }

    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException {
        Reader reader = new FileReader(filepath);
        return gson.fromJson(reader, clazz);
    }

    public void writeJson() throws IOException {
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException {
        FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }
=======
package AbdulMalikKarimAJmartMR;


import com.google.gson.Gson;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;

public class JsonTable<T> extends Vector<T> {
    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T> clazz, String filepath) throws IOException {
        this.filepath = filepath;
        try {
            Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] result = readJson(arrayType, filepath);
            if(result != null) {
                Collections.addAll(this, result);
            }
        } catch (FileNotFoundException e) {
            File f = new File(filepath);
            File f1 = f.getParentFile();
            if(f1 != null) {
                f.mkdir();
            }
            f.createNewFile();
        }
    }

    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException {
        Reader reader = new FileReader(filepath);
        return gson.fromJson(reader, clazz);
    }

    public void writeJson() throws IOException {
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException {
        FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }
>>>>>>> 9ed44e9e3460aa338b29b5eb82801e8165c149c9:jmart/AbdulMalikKarimAJmartMR/JsonTable.java
}