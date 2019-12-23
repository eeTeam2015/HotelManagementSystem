package com.studentcui.hotel.service;

import com.studentcui.hotel.po.Manager;
import org.springframework.stereotype.Service;

public interface ManagerService {
    public Manager findManager(String managername, String password);
}
