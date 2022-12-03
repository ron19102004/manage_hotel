package model.objects;

public class RoomModel {
    private String number_room;
    private String description;
    private int price;
    private byte status_room;
    public RoomModel(){}
    public String getNumber_room() {
        return number_room;
    }

    public void setNumber_room(String number_room) {
        this.number_room = number_room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte getStatus_room() {
        return status_room;
    }

    public void setStatus_room(byte status_room) {
        this.status_room = status_room;
    }
    public void displayAllInfo(){
        String stt = (this.getStatus_room() == 0 ) ? "Còn trống" : "Đã có người thuê";
        System.out.println("Số phòng: " + this.getNumber_room());
        System.out.println("Giá phòng: " + this.getPrice());
        System.out.println("Trạng thái phòng: " + stt);
        System.out.println("Mô tả: " + this.getDescription());
    }
}
