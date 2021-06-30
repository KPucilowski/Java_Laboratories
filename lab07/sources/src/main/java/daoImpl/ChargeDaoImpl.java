package daoImpl;

import daoInterfaces.ChargeDao;
import tools.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChargeDaoImpl implements ChargeDao {
    @Override
    public ResultSet getAllCharges() {
        try {
            ResultSet rs = Connector.statement.executeQuery("select * from Charge");
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
