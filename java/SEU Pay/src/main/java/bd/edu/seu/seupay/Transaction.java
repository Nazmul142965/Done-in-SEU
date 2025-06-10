package bd.edu.seu.seupay;

public class Transaction {
    private String mobile;
    private String type;
    private double amount;

    public Transaction(String mobile, String type, double amount) {
        this.mobile = mobile;
        this.type = type;
        this.amount = amount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
