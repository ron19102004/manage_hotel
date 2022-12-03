package controller.sortOfCustomer;

import model.objects.CustomerModel;

import java.util.Comparator;

public class sortByRoomDecrement implements Comparator<CustomerModel> {

    @Override
    public int compare(CustomerModel o1, CustomerModel o2) {
        if(Integer.parseInt(o1.getNumber_room())>Integer.parseInt(o2.getNumber_room())){
            return -1;
        } else return 1;
    }
}
