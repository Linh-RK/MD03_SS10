package com.ex01.ex01;

import model.ra.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    protected static final List<User> users = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        users.add(new User(1,"Mai Văn Hoàn", "1983-08-20","Hà Nội","img"));
        users.add(new User(2,"Nguyễn Văn Nam", "1983-08-21","Bắc Giang","img"));
        users.add(new User(3,"Nguyễn Thái Hoà", "1983-08-22","Nam Định","img"));
        users.add(new User(4,"Trần Đăng Khoa", "1983-08-17","Hà Tây","img"));
        users.add(new User(5,"Nguyễn Đình Thi", "1983-08-19","Hà Nội","img"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",users);
        req.getRequestDispatcher("user.jsp").forward(req,resp);
    }
}
