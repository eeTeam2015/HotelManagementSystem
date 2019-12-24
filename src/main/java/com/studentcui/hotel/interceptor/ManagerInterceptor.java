package com.studentcui.hotel.interceptor;

import com.studentcui.hotel.po.Manager;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ManagerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  Object handler) throws Exception {
        HttpSession session = request.getSession();
        Manager manager = (Manager) session.getAttribute("MANAGER_SESSION");
        if(manager != null){
            return true;
        }
        return false;
    }
}
