package com.studentcui.hotel.service.impl;

import com.studentcui.hotel.dao.ManagerMapper;
import com.studentcui.hotel.po.Manager;
import com.studentcui.hotel.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public Manager findManager(String managername, String password) {
        Manager manager = managerMapper.findManager(managername, password);
        return manager;
    }
}
