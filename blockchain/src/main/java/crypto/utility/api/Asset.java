//package crypto.utility.api;
//
//import javax.persistence.*;
//import java.time.Instant;
//
//@Entity
//public class Asset {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    @Column(name="time")
//    private long acquisition;
//    private String symbol;
//    private double quantity;
//    @Column(name="cost_bases")
//    private double cost;
//    private String account;
//
//    public Asset() {
//    }
//
//    public Asset(String symbol, double quantity, double cost, String account) {
//        this.acquisition = Instant.now().getEpochSecond();
//        this.symbol = symbol;
//        this.quantity = quantity;
//        this.cost = cost;
//        this.account = account;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public long getAcquisition() {
//        return acquisition;
//    }
//
//    public String getSymbol() {
//        return symbol;
//    }
//
//    public void setSymbol(String symbol) {
//        this.symbol = symbol;
//    }
//
//    public double getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(double quantity) {
//        this.quantity = quantity;
//    }
//
//    public double getCost() {
//        return cost;
//    }
//
//    public void setCost(double cost) {
//        this.cost = cost;
//    }
//
//    public String getAccount() {
//        return account;
//    }
//
//    public void setAccount(String account) {
//        this.account = account;
//    }
//
//    @Override
//    public String toString() {
//        return "Lot{" +
//                "id=" + id +
//                ", acquisition=" + acquisition +
//                ", symbol='" + symbol + '\'' +
//                ", quantity=" + quantity +
//                ", cost=" + cost +
//                ", account='" + account + '\'' +
//                '}';
//    }
//}
