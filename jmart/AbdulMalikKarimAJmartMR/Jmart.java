package AbdulMalikKarimAJmartMR;


import java.text.SimpleDateFormat;
import java.util.Date;

class Jmart {
    public static void main(String[] args) {
        System.out.println(Shipment.Duration.KARGO.getEstimatedArrival(new Date()));
        Account account = new Account(212," Acong"," aslabnetlab@gmail.com "," OOPsusahbet ");
        account.validate();
        
        System.out.println("Hello from Eclipe!");
    }
}
