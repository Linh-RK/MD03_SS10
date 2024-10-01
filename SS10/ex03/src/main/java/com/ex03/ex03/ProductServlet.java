package com.ex03.ex03;

import model.ra.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private static final List<Product> productList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        productList.add(new Product(1,"Bim bim","img",1200.0,12));
        productList.add(new Product(2,"Coca cola","img",1500.0,5));
        productList.add(new Product(3,"Khoai tây","img",2000.0,9));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "edit":
                int idEdit = Integer.parseInt(req.getParameter("id"));
                Product product = productList.stream().filter(p->p.getId() == idEdit).findFirst().orElse(null);
                if (product != null) {
                    req.setAttribute("product", product);
                    req.getRequestDispatcher("edit.jsp").forward(req, resp);
                }
                break;
            case  "delete":
                int idDelete = Integer.parseInt(req.getParameter("id"));
                Product productDel = productList.stream().filter(p -> p.getId() == idDelete).findFirst().orElse(null);
                if (productDel != null) {
                    productList.remove(productDel);
                    showAllProducts(req, resp);
                }
                break;
            case "add":
                req.getRequestDispatcher("add.jsp").forward(req, resp);
            default:
                showAllProducts(req, resp);
                break;
        }
    }

    private int getNewID() {
        int id = productList.stream().mapToInt(p -> p.getId()).max().orElse(0);
        return id+1;
    }

    protected void showAllProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productList",productList);
        req.getRequestDispatcher("productList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action)
        {
            case "edit":
            {
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                String img = req.getParameter("img");
                double price = Double.parseDouble(req.getParameter("price"));
                int stock = Integer.parseInt(req.getParameter("stock"));

                Product product = new Product(id,name,img,price,stock);
                Product oldProduct = productList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
                if (oldProduct != null) {
                    productList.set(productList.indexOf(oldProduct), product);
                    showAllProducts(req, resp);
                }
                break;
            }
            case "add":
                int idAdd = getNewID();
                String productName = req.getParameter("name");
                String img = req.getParameter("img");
                double price = Double.parseDouble(req.getParameter("price"));
                int stock = Integer.parseInt(req.getParameter("stock"));
                Product newProduct = new Product(idAdd, productName, img, price, stock);
                productList.add(newProduct);
                showAllProducts(req, resp);
            default:
                showAllProducts(req, resp);
                break;
        }
    }
}
