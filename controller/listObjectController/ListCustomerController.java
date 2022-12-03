package controller.listObjectController;

import DataAccessObject.CustomerDataAccessObject;
import controller.objectController.CustomerController;
import controller.sortOfCustomer.*;
import model.objects.CustomerModel;

import java.util.ArrayList;
import java.util.Collections;

public class ListCustomerController {
    private ArrayList<CustomerModel> customerModels;

    public ListCustomerController(){
        this.customerModels = CustomerDataAccessObject.getInstance().selectAll();
    }
    public void addCustomerIntoDatabase(){
        CustomerModel customerModel = new CustomerModel();
        CustomerController customerController = new CustomerController(customerModel);

    }
    public void deleteCustomerRoom(){}
    public void displayAllCustomer(){
        for(CustomerModel customerModel : this.customerModels){
            customerModel.display();
        }
    }
    public void sortCustomerByRoomDecrement(){
        Collections.sort(this.customerModels, new sortByRoomDecrement());
    }
    public void sortCustomerByRoomIncrement(){
        Collections.sort(this.customerModels, new sortByRoomIncrement());
    }
    public void sortCustomerByNameDecrement(){Collections.sort(this.customerModels,new sortByNameDecrement());}
    public void sortCustomerByNameIncrement(){Collections.sort(this.customerModels, new sortByNameIncrement());}
    public void sortCustomerByTimeInDecrement(){Collections.sort(this.customerModels, new sortByTimeInDecrement());}
    public void sortCustomerByTimeInIncrement(){Collections.sort(this.customerModels, new sortByTimeInIncrement());}
    public void sortCustomerByTimeOutDecrement(){}
    public void sortCustomerByTimeOutIncrement(){}


}
