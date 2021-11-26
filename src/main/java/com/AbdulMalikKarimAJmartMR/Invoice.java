package com.AbdulMalikKarimAJmartMR;

import java.util.Date;
import java.util.ArrayList;
import com.AbdulMalikKarimAJmartMR.dbjson.Serializable;

public abstract class Invoice extends Serializable
{
    public int buyerId;
    public int complaintId;
    public final Date date;

    public int productId;
    public Rating rating;
    public enum Status{
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY,
        COMPLAINT, FINISHED, FAILED, DELIVERED
    }
    enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
    class Record{
        public Date date;
        public String message;
        public Status status;
    }
    protected Invoice(int buyerId, int productId){
//        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.complaintId = -1;
    }
    public abstract double getTotalPay(Product product);
}
