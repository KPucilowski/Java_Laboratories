package objects;

public class Charge {
    int ChargeId;
    int Prize;
    int InstalationId;
    String ChargeData;

    public Charge(int chargeId, int prize, int instalationId, String chargeData) {
        ChargeId = chargeId;
        Prize = prize;
        InstalationId = instalationId;
        ChargeData = chargeData;
    }

    public int getChargeId() {
        return ChargeId;
    }

    public int getPrize() {
        return Prize;
    }

    public int getInstalationId() {
        return InstalationId;
    }

    public String getChargeData() {
        return ChargeData;
    }
}
