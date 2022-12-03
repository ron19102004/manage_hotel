package model.objects;

public class CustomerModel {
    private String name_customer;
    private String CCCD_customer;
    private String number_room;
    private String time_update;
    private String time_in, time_out;

    public CustomerModel(){};
    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getCCCD_customer() {
        return CCCD_customer;
    }

    public void setCCCD_customer(String CCCD_customer) {
        this.CCCD_customer = CCCD_customer;
    }

    public String getNumber_room() {
        return number_room;
    }

    public void setNumber_room(String number_room) {
        this.number_room = number_room;
    }

    public String getTime_update() {
        return time_update;
    }

    public void setTime_update(String time_update) {
        this.time_update = time_update;
    }

    public String getTime_in() {
        return time_in;
    }

    public void setTime_in(String time_in) {
        this.time_in = time_in;
    }

    public String getTime_out() {
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out = time_out;
    }

    public void display() {
        System.out.println("Tên khách hàng: " + this.getName_customer());
        System.out.println("Số CCCD: " + this.getCCCD_customer());
        System.out.println("Số phòng: " + this.getNumber_room());
        System.out.println("Ngày vào: " + this.getTime_in());
        System.out.println("Ngày ra: " + this.getTime_out());
        System.out.println("Thời gian cập nhật cuối cùng: " + this.getTime_update());
    }
}
