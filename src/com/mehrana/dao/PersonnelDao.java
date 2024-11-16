package com.mehrana.dao;

import com.mehrana.entity.Personnel;
import com.mehrana.utils.DataStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PersonnelDao {

    private DataStore dataStore;

    public PersonnelDao(DataStore dataStore) {
        this.dataStore = new DataStore();
    }

    public PersonnelDao() {
        this.dataStore = new DataStore();
    }


    public void add(Personnel personnel) {
        String sql = "INSERT INTO personnel(userName, nationalCode, phoneNumber, email) VALUES(?,?,?,?)";
        try (Connection connection = DbHandler.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, personnel.getUserName());
            statement.setString(2, personnel.getNationalCode());
            statement.setString(3, personnel.getPhoneNumber());
            statement.setString(4, personnel.getEmail());
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dataStore.addPersonnel(personnel);
    }

    public List<Personnel> findAll() {
        return dataStore.findAll();
    }

    public Personnel findByNationalCode(String nationalCode) {
        return dataStore.findByNationalCode(nationalCode);
    }


//    public Personnel findByUserName(String userName) {
//        return dataStore.findByUserName(userName);
//    }

}
