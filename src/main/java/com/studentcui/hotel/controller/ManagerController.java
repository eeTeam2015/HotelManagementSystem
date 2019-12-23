package com.studentcui.hotel.controller;

import com.studentcui.hotel.po.Manager;
import com.studentcui.hotel.service.ManagerService;
import com.studentcui.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String loginaction(String managername, String password, Model model, HttpSession session){
        Manager manager = managerService.findManager(managername,password);
        if(manager!=null){
            session.setAttribute("MANAGER_SESSION", manager);
            model.addAttribute("list", roomService.findAllRoom());
            return "room";
        }
        model.addAttribute("msg", "账号或密码输入错误，请重新输入！");
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/insertRoom", method = RequestMethod.POST)
    public String insertaction(String roomid, String roomtype, HttpServletResponse response, Model model){
        try {
            roomService.insertRoom(roomid, roomtype);
        }
        catch (Exception e){
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            try {
                PrintWriter out = response.getWriter();
                out.print("<script>alert('添加失败！');</script>");
            } catch (Exception e2) {

            }
        }
        model.addAttribute("list", roomService.findAllRoom());
        return "room";
    }
}
