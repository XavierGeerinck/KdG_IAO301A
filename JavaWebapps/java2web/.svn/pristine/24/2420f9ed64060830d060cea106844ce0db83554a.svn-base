package be.kdg.webapps103.servlets;

import be.kdg.webapps103.mvc.model.Product;
import be.kdg.webapps103.mvc.model.ProductList;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DispatcherDemo")
public class DispatcherDemo extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ProductList productList = findModel();
        productList.add(new Product(100, "nog een product"));

        request.setAttribute("attribuut", "hello world");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DispatcherServlet");
        if (dispatcher == null)
        {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "kan niet forwarden");
        }
        dispatcher.forward(request, response);
    }

    private ProductList findModel()
    {
        ServletContext servletContext = getServletContext();
        ProductList productList = (ProductList) servletContext.getAttribute("productList");
        if (productList == null)
        {
            productList = ProductList.create();
            servletContext.setAttribute("productList", productList);
        }
        return productList;
    }
}
