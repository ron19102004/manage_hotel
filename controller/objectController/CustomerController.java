package controller.objectController;

import model.RegexModel;
import model.objects.CustomerModel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class CustomerController {
    private CustomerModel customerModel;

    public CustomerController(CustomerModel customerModel){
        this.customerModel = customerModel;
    }
    public void createCustomer(){
        this.customerModel.setName_customer(this.setNameCustomer());
        this.customerModel.setCCCD_customer(this.setCCCDCustomer());
        this.customerModel.setNumber_room(this.setNumberRoom());
        this.customerModel.setTime_in(this.setTimeIn());
        this.customerModel.setTime_out(this.setTimeOut());
        this.customerModel.setTime_update(this.setTimeUpdate());

    }
    public void createCustomer(String cccd_customer, String name_customer, String number_room, String time_in, String time_out, String time_update){
        this.customerModel.setName_customer(name_customer);
        this.customerModel.setCCCD_customer(cccd_customer);
        this.customerModel.setNumber_room(number_room);
        this.customerModel.setTime_in(time_in);
        this.customerModel.setTime_out(time_out);
        this.customerModel.setTime_update(time_update);
    }
    public String setNameCustomer(){
        Scanner sc = new Scanner(System.in);
        String name;
        while (true) {
            System.out.print("Nhập tên khách hàng: ");
            name = sc.nextLine().trim().toLowerCase();
            if (RegexModel.isAlphabet(name)) {
                break;
            } else {
                System.out.println("Lỗi nhập tên không hợp lệ");
            }
        }
        return name;
    }
    public String setCCCDCustomer(){
        Scanner sc = new Scanner(System.in);
        String cccd;
        while (true){
            System.out.print("Nhập CCCD: ");
            cccd = sc.nextLine().trim();
            if(RegexModel.isNumber(cccd)&&(cccd.length()==12)){
                break;
            } else {
                System.out.println("Lỗi nhập số căn cước công dân.");
            }
        }
        return cccd;
    }
    public String setNumberRoom(){
        Scanner sc = new Scanner(System.in);
        String numberRoom;
        while (true){
            System.out.print("Nhập số phòng :");
            numberRoom = sc.nextLine().trim();
            if(RegexModel.isNumber(numberRoom)&&Integer.parseInt(numberRoom)>0&&Integer.parseInt(numberRoom)<=50){
                break;
            } else {
                System.out.println("Lỗi nhập số.");
            }
        }
        return numberRoom;
    }
    public String setTimeUpdate(){
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        return localDate + "|" + localTime;
    }
    public String setTimeIn(){
        Scanner sc = new Scanner(System.in);
        String timeIn;
        while (true){
            System.out.print("Nhập ngày vào:");
            timeIn = sc.nextLine().trim();
            if(RegexModel.dateRegex(timeIn)){
                String[] time = timeIn.split("[-/|]");
                timeIn = time[2] +"/"+ time[1]+"/"+ time[0];
                break;
            }
        }
        return timeIn;
    }
    public String setTimeOut(){
        Scanner sc = new Scanner(System.in);
        String timeOut;
        while (true){
            System.out.print("Nhập ngày ra:");
            timeOut = sc.nextLine().trim();
            if(RegexModel.dateRegex(timeOut)){
                String[] time = timeOut.split("[-/|]");
                timeOut = time[2] +"/"+ time[1]+"/"+ time[0];
                break;
            }
        }
        return timeOut;
    }
}
