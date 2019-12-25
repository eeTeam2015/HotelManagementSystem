package com.studentcui.hotel.controller;

import com.studentcui.hotel.po.Book;
import com.studentcui.hotel.po.RoomType;
import com.studentcui.hotel.service.BookService;
import com.studentcui.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Controller
public class BookController {

    @Autowired(required = false)
    private BookService bookService;

    //预定查询
    @RequestMapping("/query.action")
    public String queryaction(Date checkin, Date checkout, HttpServletRequest request, HttpServletResponse response, Model model){
        List<RoomType> roomTypeList = bookService.findAllRoomType();
        List<Book> books = new ArrayList<>();
        for(RoomType type:roomTypeList){
            //现在的空房间
            int nowvacant = bookService.countvacant(type.getName());
            //预定订单中日期冲突的房间数量
            int bookroomNum = bookService.cntConflict(type.getName(), checkin, checkout);
            if(nowvacant-bookroomNum>0){
                Book book = new Book();
                book.setName(type.getName());
                book.setNumber(nowvacant-bookroomNum);

                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try
                {
                    long diff = checkout.getTime() - checkin.getTime();//这样得到的差值是微秒级别
                    long days = diff / (1000 * 60 * 60 * 24);
                    book.setSumprice((int) days*type.getPrice());
                    request.getSession().setAttribute("SUMPRICE",(int) days*type.getPrice());
                    books.add(book);
                }catch (Exception e)
                {
                }
            }
        }
        model.addAttribute("list", books);
        model.addAttribute("checkin", checkin);
        model.addAttribute("checkout", checkout);
        return "bookQuery";
    }

}
