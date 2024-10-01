package com.ex02.ex02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CaculatorServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("calculator.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Double first = Double.parseDouble(req.getParameter("first"));
            Double second = Double.parseDouble(req.getParameter("second"));
            String operator = req.getParameter("calculate");

            Double result = null;
            switch (operator) {
                case "add":
                    result = first + second;
                    break;
                case "sub":
                    result = first - second;
                    break;
                case "mul":
                    result = first * second;
                    break;
                case "div":
                    if (second != 0) {
                        result = first / second;
                    } else {
                        req.setAttribute("error", "Không thể chia cho 0.");
                    }
                    break;
                default:
                    req.setAttribute("error", "Số không hợp lệ.");
                    break;
            }

            req.setAttribute("first", first);
            req.setAttribute("second", second);
            req.setAttribute("operator", operator);
            req.setAttribute("result", result);

        } catch (NumberFormatException e) {
            req.setAttribute("error", "Vui lòng nhập số hợp lệ.");
        }
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
