package controller.sortOfCustomer;

import model.objects.CustomerModel;

import java.util.Comparator;

public class sortByNameIncrement implements Comparator<CustomerModel> {
    @Override
    public int compare(CustomerModel o1, CustomerModel o2) {
        String[] str1 = o1.getName_customer().split("\\s");
        String[] str2 = o2.getName_customer().split("\\s");
        return -str1[str1.length-1].compareTo(str2[str2.length-1]);
    }
}
