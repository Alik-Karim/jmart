package com.AbdulMalikKarimAJmartMR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Shipment
{
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MM dd yyyy");
    public static final Plan INSTANT = new Plan((byte) (1));
    public static final Plan SAME_DAY = new Plan((byte) (1 << 1));
    public static final Plan NEXT_DAY = new Plan((byte) (1 << 2));
    public static final Plan REGULER = new Plan((byte) (1 << 3));
    public static final Plan KARGO = new Plan((byte) (1 << 4));

    public String address;
    public int cost;
    public byte plan;
    public String receipt;

    public Shipment(String address, int cost, byte plan, String receipt)
    {
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }

    public String getEstimatedArrival(Date reference) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(reference);
        if (isDuration(Shipment.NEXT_DAY))
            cal.add(Calendar.DATE, 1);
        if (isDuration(Shipment.REGULER))
            cal.add(Calendar.DATE, 2);
        if (isDuration(Shipment.KARGO))
            cal.add(Calendar.DATE, 5);
        return ESTIMATION_FORMAT.format(cal.getTime());
    }

    public boolean isDuration(Plan reference) {
        return (plan & reference.bit) != 0;
    }

    public boolean isDuration(byte object, Plan reference) {
        return (object & reference.bit) != 0;
    }

    public static class Plan {
        public final byte bit;
        private Plan(byte bit) {
            this.bit = bit;
        }
    }
}

