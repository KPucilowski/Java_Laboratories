package daoInterfaces;

import objects.Instalation;

import java.sql.ResultSet;

public interface InstalationDao {
    public ResultSet getAllInstalations();
    public Instalation getInstalationID(int ID);
    public void addInstalation(Instalation instalation);
    public void removeInstalation(int ID);
    public void editInstalation(Instalation instalation);
}
