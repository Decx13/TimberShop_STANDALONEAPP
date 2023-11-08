package lk.ijse.timbershop.service.custom;

import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.to.SupplierOrderPlace;

import java.sql.SQLException;

public interface SupplierOrderPlaceService extends SuperService {
    boolean SupplierPlaceOrder(SupplierOrderPlace supplierOrderPlace) throws SQLException, ClassNotFoundException;
}
