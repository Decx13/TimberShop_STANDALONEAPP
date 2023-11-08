package lk.ijse.timbershop.dao.custom.impl;

import lk.ijse.timbershop.dao.custom.SupplierOrderDAO;
import lk.ijse.timbershop.to.SupplierOrder;
import lk.ijse.timbershop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierOrderDAOImpl implements SupplierOrderDAO {
    @Override
    public boolean add(SupplierOrder supplierOrder) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO SupplierOrder VALUES (?,?,?)";
        return(Boolean) CrudUtil.execute(sql,new Object[]{supplierOrder.getS_orderId(),supplierOrder.getSupplierId(),supplierOrder.getDate()});

    }

    @Override
    public boolean update(SupplierOrder obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("update function not available");
    }

    @Override
    public boolean delete(String obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("delete function not available");
    }

    @Override
    public SupplierOrder search(String ID) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("search function not available");
    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT S_orderId FROM SupplierOrder ORDER BY S_orderId DESC LIMIT 1";
        ResultSet result = (ResultSet)CrudUtil.execute(sql, new Object[0]);
        return result.next() ? generateNextOrderId(result.getString(1)) : generateNextOrderId(result.getString((String)null));

    }

    @Override
    public String generateNextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("W0");
            int id = Integer.parseInt(split[1]);
            ++id;
            return "W0" + id;
        } else {
            return "0001";
        }
    }
}
