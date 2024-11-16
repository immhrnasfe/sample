package com.mehrana.service;

import com.mehrana.dao.LeaveDao;
import com.mehrana.dao.PersonnelDao;
import com.mehrana.entity.Leave;
import com.mehrana.entity.Personnel;

public class LeaveService {

    private final LeaveDao leaveDAO = new LeaveDao();
    private final PersonnelDao personnelDao = new PersonnelDao();


    public void saveLeave(Leave leave, Personnel personnel) {
        leaveDAO.addLeave(leave, personnel);
    }

//        public List<Leave> getAllLeave(Personnel personnel) {
//            return leaveDAO.getLeavesByPersonnel(personnel);
//        }
       /* public void saveLeave(Leave leave, Personnel personnel) {
            Personnel personnel1 = personnelDao.findByNationalCode(personnel.getNationalCode());
            if (personnel1 == null) {
                System.out.println("NationalCode not found.");
            } else {
                leave.setPersonnel(personnel1);
                leaveDAO.addLeave(leave, personnel1);
            } */
}
