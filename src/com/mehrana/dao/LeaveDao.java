package com.mehrana.dao;

import com.mehrana.entity.Leave;
import com.mehrana.entity.Personnel;
import com.mehrana.utils.DataStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaveDao {

    private DataStore dataStore = new DataStore();

    public void addLeave(Leave leave, Personnel personnel) {
        String sql = "INSERT INTO leave (startDate, endDate, cancellEarlySoon) values (?,?,?,?,?,?)";
        try (Connection connection = DbHandler.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, leave.getStartDate());
            preparedStatement.setDate(2, leave.getEndDate());
            preparedStatement.setDate(3,leave.getCancelEarlyDate());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dataStore.addLeave(leave, personnel);
    }


//    public List<Leave> getLeavesByPersonnel(Personnel personnel) {
//        return dataStore.findLeavesByPersonnel(personnel);
//
//    }
}
