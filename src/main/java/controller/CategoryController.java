package controller;

import model.CategoryModel;
import model.ProductModel;
import service.category.CategoryService;
import service.category.ICategory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "/CategoryController",
        value = "/category"
)
public class CategoryController extends HttpServlet {
    private ICategory category = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "update":
                showFromEdit(req, resp);
                break;
            case "remove":
                remove(req, resp);
                break;
            default:
                showAll(req, resp);
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/products/create.jsp");
        List<CategoryModel> list = category.showAll();
        req.setAttribute("list", list);
        dispatcher.forward(req, resp);
    }

    private void showFromEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("products/update.jsp");
        int index = Integer.parseInt(req.getParameter("id"));
        CategoryModel categoryModel = category.findById(index);
        req.setAttribute("edit", categoryModel);
        requestDispatcher.forward(req, resp);
    }


    private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("products/list.jsp");
        List<CategoryModel> list = category.showAll();
        req.setAttribute("category", list);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "remove":
                remove(req, resp);
                break;
            default:
                showAll(req, resp);
        }
    }
    private void update(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategoryName(name);
        category.update(categoryModel);
        showAll(req, resp);
    }
    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        CategoryModel categoryModel = new CategoryModel(name);
        category.create(categoryModel);
        showAll(req, resp);
    }

    private void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        category.remove(id);
        req.setAttribute("message", "Xóa Thành Công");
        showAll(req, resp);
    }
}

