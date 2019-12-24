package com.studentcui.hotel.controller;

import com.studentcui.hotel.po.Manager;
import com.studentcui.hotel.po.Room;
import com.studentcui.hotel.service.ManagerService;
import com.studentcui.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private RoomService roomService;

    //登录检验
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String loginaction(String managername, String password, Model model, HttpSession session) {
        Manager manager = managerService.findManager(managername, password);
        if (manager != null) {
            session.setAttribute("MANAGER_SESSION", manager);
            //List<Room> l = roomService.findAllRoom();
            model.addAttribute("list", roomService.findAllRoom());
            return "room1";
        }
        model.addAttribute("msg", "账号或密码输入错误，请重新输入！");
        return "login";
    }

    //登录界面控制器
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //房间管理页面控制器
    @GetMapping("/room1")
    public String room1(Model model) {
        model.addAttribute("list", roomService.findAllRoom());
        return "room1";
    }

    //入住页面控制器
    @GetMapping("/room2")
    public String room2(Model model) {
        model.addAttribute("list", roomService.findCheckin());
        return "room2";
    }

    //退房页面控制器
    @GetMapping("/room3")
    public String room3(Model model){
        model.addAttribute("list", roomService.findCheckout());
        return "room3";
    }

    //添加房间
    @RequestMapping(value = "/insertRoom", method = RequestMethod.POST)
    public String insertaction(String roomid, String roomtype, HttpServletResponse response, Model model) {
        try {
            roomService.insertRoom(roomid, roomtype);
        } catch (Exception e) {
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            try {
                PrintWriter out = response.getWriter();
                out.print("<script>alert('添加失败！');</script>");
            } catch (Exception e2) {

            }
        }
        model.addAttribute("list", roomService.findAllRoom());
        return "room1";
    }

    //删除房间
    @RequestMapping("/deleteRoom")
    public String deleteaction(String roomid, Model model, HttpServletResponse response) {
        try {
            if(roomService.deleteRoom(roomid) == 0){
                response.setCharacterEncoding("utf-8");
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                try {
                    PrintWriter out = response.getWriter();
                    out.print("<script>alert('删除失败！');</script>");
                } catch (Exception e2) {

                }
            }
        } catch (Exception e) {
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            try {
                PrintWriter out = response.getWriter();
                out.print("<script>alert('删除失败！');</script>");
            } catch (Exception e2) {

            }
        }
        model.addAttribute("list", roomService.findAllRoom());
        return "room1";
    }

    //入住检验
    @RequestMapping(value = "checkin.action", method = RequestMethod.POST)
    public String checkinaction(HttpServletRequest request, Model model, HttpServletResponse response) {
        try {
            Room room = new Room();
            room.setId(Integer.parseInt(request.getParameter("roomid")));
            room.setGuestname(request.getParameter("guestname"));
            room.setGuestid(request.getParameter("guestid"));
            java.util.Date date = new java.util.Date();
            Date dt = new Date(date.getTime());
            room.setCheckin(dt);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int days = Integer.parseInt(request.getParameter("days"));
            calendar.add(Calendar.DATE, days);
            room.setCheckout(new Date(calendar.getTime().getTime()));
            room.setState("已入住");
            roomService.checkin(room);
        } catch (Exception e) {
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            try {
                PrintWriter out = response.getWriter();
                out.print("<script>alert('入住失败！');</script>");
            } catch (Exception e2) {

            }
        }
        model.addAttribute("list",roomService.findCheckin());
        return "room2";
    }

    //退房检验
    @RequestMapping("/checkout.action")
    public String checkoutaction(String roomid, Model model, HttpServletResponse response){
        try {
            if(roomService.checkout(roomid) == 0){
                response.setCharacterEncoding("utf-8");
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                try {
                    PrintWriter out = response.getWriter();
                    out.print("<script>alert('退房失败！');</script>");
                } catch (Exception e2) {

                }
            }
        } catch (Exception e){
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            try {
                PrintWriter out = response.getWriter();
                out.print("<script>alert('退房失败！');</script>");
            } catch (Exception e2) {

            }
        }
        model.addAttribute("list",roomService.findCheckout());
        return "room3";
    }

    //退出登录
    @RequestMapping("/quit")
    public String quit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("MANAGER_SESSION");
        return "login";
    }
}
