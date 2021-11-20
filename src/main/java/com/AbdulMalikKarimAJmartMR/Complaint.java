package com.AbdulMalikKarimAJmartMR;

import com.AbdulMalikKarimAJmartMR.dbjson.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Complaint extends Serializable
{
    public final Date date;
    public String desc;

    public Complaint(int id, String desc)
    {
//        super(id);
        this.desc = desc;
        this.date = new Date();
    }
    
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        String formattedDate = formatter.format(this.date);  
        return
        "Complaint{date=" + formattedDate + ", desc='" +this.desc+ "'}";
    }
    
    
}
