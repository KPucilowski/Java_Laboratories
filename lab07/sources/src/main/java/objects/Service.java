package objects;

import java.sql.ResultSet;

public class Service {
    int ServiceId;
    int Prize;
    String ServiceType;
    public Service(int serviceId, int prize, String serviceType) {
        ServiceId = serviceId;
        Prize = prize;
        ServiceType = serviceType;
    }

    public int getServiceId() {
        return ServiceId;
    }

    public void setServiceId(int serviceId) {
        ServiceId = serviceId;
    }

    public int getPrize() {
        return Prize;
    }

    public void setPrize(int prize) {
        Prize = prize;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }
}
