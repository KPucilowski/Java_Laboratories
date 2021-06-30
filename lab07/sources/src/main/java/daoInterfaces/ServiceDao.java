package daoInterfaces;

import objects.Instalation;
import objects.Service;

import java.sql.ResultSet;

public interface ServiceDao {
    public ResultSet getAllServices();
    public Service getServicesID(int ID);
    public void addService(Service service);
    public void removeService(int ID);
    public void editService(Service service);

}
