package lk.ijse.timbershop.service;

import lk.ijse.timbershop.service.custom.impl.*;

public class ServiceFactory {
    private static  ServiceFactory serviceFactory;
    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        if(serviceFactory==null)serviceFactory=new ServiceFactory();
        return serviceFactory;


    }
    public <T extends SuperService>T getService(ServiceType serviceType){
        switch (serviceType){
            case ITEM:return (T)new ItemServiceImpl();
            case CUSTOMER: return (T)new CustomerServiceImpl();
            case EMPLOYEE:return (T)new EmployeeServiceImpl();
            case SUPPLIER:return (T)new SupplierServiceImpl();
            case ADDSAMPLE:return (T)new AddSampleServiceImpl();
            case LOGINFORM:return (T)new LoginFormServiceImpl();
            case ORDERFORM:return (T)new OrderFormServiceImpl();
            case REQFURNITURE:return (T)new ReqFurnitureServiceImpl();
            case CUSTOMERORDER:return(T)new CustomerOrderServiceImpl();
            case MONTHLYINCOME:return(T)new MonthlyIncomeServiceImpl();
            case SUPPLIERORDER:return (T)new SupplierOrderServiceImpl();
            case CUSTOMERORDERPLACE:return (T)new CustomerOrderPlaceServiceImpl();
            case SUPPLIERORDERPLACE:return (T)new SupplierOrderPlaceServiceImpl();
        }
        return null;
    }
}
