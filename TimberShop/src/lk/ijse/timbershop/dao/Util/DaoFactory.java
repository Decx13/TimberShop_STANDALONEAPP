package lk.ijse.timbershop.dao.Util;

import lk.ijse.timbershop.dao.SuperDAO;
import lk.ijse.timbershop.dao.custom.SupplierDAO;
import lk.ijse.timbershop.dao.custom.SupplierOrderDAO;
import lk.ijse.timbershop.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;


    private DaoFactory(){ }

    public static DaoFactory getInstance(){
        if(daoFactory==null)daoFactory=new DaoFactory();
        return daoFactory;
    }
    public <T extends SuperDAO>T getDao(DaoType daoType){
        switch (daoType){
            case CUSTOMER:return(T)new CustomerDAOImpl();
            case SUPPLIERORDER:return (T)new SupplierOrderDAOImpl();
            case CUSTOMERORDER:return (T)new CustomerOrderDAOImpl();
            case REQFURNITURE:return (T)new ReqFurnitureDAOImpl();
            case SUPPLIER:return (T)new SupplierDAOImpl();
            case EMPLOYEE:return (T)new EmployeeDAOImpl();
            case ITEM:return (T)new ItemDAOImpl();
            case USER:return (T)new UserDAOImpl();
            case INCOME:return (T)new IncomeDAOImpl();
            case FURNITURE:return (T)new FurnitureDAOImpl();
            case CORDERDETAIL:return (T)new CorderDetailDAOImpl();
            case SORDERDETAIL:return (T)new SorderDetailDAOImpl();

        }
        return null;

    }

}
