package com.mehrana.service;

import com.mehrana.dao.PersonnelDao;
import com.mehrana.entity.Personnel;
import com.mehrana.utils.DataStore;

import java.util.List;

public class PersonnelService {
    private PersonnelDao personnelDao = new PersonnelDao();

    public void save(Personnel personnel) {
        if (personnelDao == null) {
            personnelDao = new PersonnelDao(new DataStore());
        }
        personnelDao.add(personnel);
    }

    public List<Personnel> getAllPersonnel() {
        List<Personnel> personnelList = personnelDao.findAll();
        for (Personnel p : personnelList) {
            System.out.println(p);
        }
        return personnelList;
    }



    public Personnel getNationalCode(String nationalCode) {
        return personnelDao.findByNationalCode(nationalCode);
    }
}
