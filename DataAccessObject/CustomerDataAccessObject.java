package DataAccessObject;

import controller.objectController.CustomerController;
import database.JDBCUtil;
import model.objects.CustomerModel;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDataAccessObject implements DataAccessObjectInterface<CustomerModel>{
    public static CustomerDataAccessObject getInstance(){
        return new CustomerDataAccessObject();
    }
    @Override
    public void create(CustomerModel customerModel) {
        try{
            Connection connection = JDBCUtil.getConnection();
            String sql = "insert into customer (cccd_customer, name_customer, number_room, time_in, time_out, time_update) " +
                    "VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,customerModel.getCCCD_customer());
            preparedStatement.setString(2, customerModel.getName_customer());
            preparedStatement.setString(3, customerModel.getNumber_room());
            preparedStatement.setString(4, customerModel.getTime_in());
            preparedStatement.setString(5, customerModel.getTime_out());
            preparedStatement.setString(6, customerModel.getTime_update());
            int checkCreate = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
    }
    @Override
    public void delete(CustomerModel customerModel) {
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "delete from customer where cccd_customer=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,customerModel.getCCCD_customer());
            int checkDel = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
    }

    @Override
    public void edit(CustomerModel customerModel) {

    }
    @Override
    public ArrayList<CustomerModel> selectAll() {
        ArrayList<CustomerModel> customerModels = new ArrayList<CustomerModel>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from customer";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String cccd_customer = resultSet.getNString("cccd_customer");
                String name_customer = resultSet.getNString("name_customer");
                String number_room = resultSet.getNString("number_room");
                String time_in = resultSet.getNString("time_in");
                String time_out = resultSet.getNString("time_out");
                String time_update = resultSet.getNString("time_update");

                CustomerModel customerModel = new CustomerModel();
                CustomerController customerController = new CustomerController(customerModel);
                customerController.createCustomer(cccd_customer,name_customer,number_room,time_in,time_out,time_update);
                customerModels.add(customerModel);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
        return customerModels;
    }
}
