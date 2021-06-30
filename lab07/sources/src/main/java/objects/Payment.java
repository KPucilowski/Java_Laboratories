package objects;

public class Payment {
    int PaymentId;
    int Prize;
    int InstalationId;
    String PaymentDate;

    public Payment(int paymentId, int prize, int instalationId, String paymentDate) {
        PaymentId = paymentId;
        Prize = prize;
        InstalationId = instalationId;
        PaymentDate = paymentDate;
    }

    public int getPaymentId() {
        return PaymentId;
    }

    public int getPrize() {
        return Prize;
    }

    public int getInstalationId() {
        return InstalationId;
    }

    public String getPaymentDate() {
        return PaymentDate;
    }
}
