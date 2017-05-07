package com.cyj.service;

import com.cyj.dao.AdminDao;
import com.cyj.model.AdminModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/31.
 */
@Service
public class AdminService {
    @Resource
    private AdminDao adminDao;

    public AdminModel findAdminById(int id) {
        return adminDao.findModelById(id);
    }

    public AdminModel findModelByNT(String NT) {
        return adminDao.findModelByNT(NT);
    }

    public boolean adminValid(String NT, String password) {
        AdminModel model = adminDao.findModelByNT(NT);
        String pwd = model.getPassword();
        if(pwd.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean changePassword(String newpsw, AdminModel model) {
        return (adminDao.updatePassword(newpsw, model.getNT()) == 1);
    }
}
