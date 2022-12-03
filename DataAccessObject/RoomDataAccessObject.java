package DataAccessObject;

import database.JDBCUtil;
import model.objects.RoomModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RoomDataAccessObject implements DataAccessObjectInterface<RoomModel>{
    public static RoomDataAccessObject getInstance(){
        return new RoomDataAccessObject();
    }
    @Override
    public void create(RoomModel roomModel) {
        try{
            Connection connection = JDBCUtil.getConnection();
            String sql = "insert into room (number_room,price,status_room,description_room) " +
                    "VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,roomModel.getNumber_room());
            preparedStatement.setInt(2,roomModel.getPrice());
            preparedStatement.setInt(3,roomModel.getStatus_room());
            preparedStatement.setString(4, roomModel.getDescription());
            int checkCreate = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
    }
    @Override
    public void delete(RoomModel roomModel) {
        try{
            Connection connection = JDBCUtil.getConnection();
            String sql = "delete from room where number_room = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,roomModel.getNumber_room());
            int check = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
    }

    @Override
    public void edit(RoomModel roomModel) {
    }

    @Override
    public ArrayList<RoomModel> selectAll() {
        return null;
    }

}
