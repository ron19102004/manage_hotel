package controller.listObjectController;

import DataAccessObject.RoomDataAccessObject;
import controller.objectController.RoomController;
import model.objects.RoomModel;

import java.util.ArrayList;

public class ListRoomController {
       private ArrayList<RoomModel> roomModels;

       public ListRoomController(){
           this.roomModels = new ArrayList<RoomModel>();
       }
       public void addInfoRoom(){
           RoomModel roomModel = new RoomModel();
           RoomController roomController = new RoomController(roomModel);
           roomController.createRoom();
           RoomDataAccessObject.getInstance().create(roomModel);
       }

}
