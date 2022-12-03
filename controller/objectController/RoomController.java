package controller.objectController;

import model.RegexModel;
import model.objects.RoomModel;

import java.util.Scanner;

public class RoomController {
    private RoomModel roomModel;

    public RoomController(RoomModel roomModel){
        this.roomModel = roomModel;
    }
    public void createRoom(){
        this.roomModel.setNumber_room(this.setNumberRoom());
        this.roomModel.setPrice(this.setPriceRoom());
        this.roomModel.setStatus_room(this.setStatusRoom());
        this.roomModel.setDescription(this.setDescription());
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
                System.out.println("Lỗi nhập số phòng.");
            }
        }
        return numberRoom;
    }
    public int setPriceRoom(){
        Scanner sc = new Scanner(System.in);
        String price;
        while (true){
            System.out.print("Nhập giá phòng: ");
            price = sc.nextLine().trim();
            if(RegexModel.isNumber(price)&&Integer.parseInt(price) > 0){
                break;
            } else {
                System.out.println("Lỗi nhập giá phòng.");
            }
        }
        return Integer.parseInt(price);
    }
    public byte setStatusRoom(){
        Scanner sc = new Scanner(System.in);
        String stt;
        while (true){
            System.out.println("Vui lòng trả lời có hoặc không");
            System.out.print("Phòng còn trống hay không ? ");
            stt = sc.nextLine().trim().toLowerCase();
            if(!stt.isBlank()&&RegexModel.isAlphabet(stt)){
                if(stt.equals("có")||stt.equals("co")||stt.equals("c")){
                    stt = "0";
                    break;
                } else if (stt.equals("không")||stt.equals("khong")||stt.equals("k")||stt.equals("hk")||stt.equals("kh")) {
                    stt ="1";
                    break;
                } else {
                    System.out.println("Câu trả lời của bạn không hợp lệ");
                }
            } else {
                System.out.println("Lỗi nhập câu trả lời.");
            }
        }
        return Byte.parseByte(stt);
    }
    public String setDescription(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mô tả: ");
        return sc.nextLine().trim();
    }
}
