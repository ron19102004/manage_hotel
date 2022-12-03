package controller.sortOfCustomer;

import model.objects.CustomerModel;

import java.util.Comparator;

public class sortByTimeInDecrement implements Comparator<CustomerModel> {
    @Override
    public int compare(CustomerModel o1, CustomerModel o2) {
        String[] str1 = o1.getTime_in().split("[-/|]");
        String[] str2 = o2.getTime_in().split("[-/|]");
        int result = 0;
        if(Integer.parseInt(str1[0]) > Integer.parseInt(str2[0])){
            result = -1;
        } else if (Integer.parseInt(str1[0]) == Integer.parseInt(str2[0])){
            if(Integer.parseInt(str1[1]) > Integer.parseInt(str2[1])){
                result = -1;
            } else if (Integer.parseInt(str1[1]) == Integer.parseInt(str2[1])) {
                if(Integer.parseInt(str1[2]) > Integer.parseInt(str2[2])){
                    result = -1;
                } else if (Integer.parseInt(str1[2]) < Integer.parseInt(str2[2])){
                    result = 1;
                }
            }
        } else result = 1;
        return result;
    }
}
