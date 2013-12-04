package be.kdg.webapps102.mvc.controller;

import be.kdg.webapps102.mvc.model.Product;
import be.kdg.webapps102.mvc.model.ProductList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;

public class VoegToeServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id;
        try
        {
            String productId = request.getParameter("productId");
            id = Integer.parseInt(productId);
        }
        catch (NumberFormatException e)
        {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product-id moet een getal zijn");
            return;
        }
        String beschrijving = readBeschrijving(request);
        addProduct(id, beschrijving);
        redirect(response);
    }

    private String readBeschrijving(HttpServletRequest request)
    {
        return request.getParameter("beschrijving");
    }

    private void addProduct(int id, String beschrijving)
    {
        ProductList productList = findModel();
        Product product = new Product(id, beschrijving);
        productList.add(product);
    }

    private void redirect(HttpServletResponse response) throws IOException
    {
        response.sendRedirect("ToonProductenServlet");
    }

    private ProductList findModel()
    {
        ServletContext servletContext = getServletContext();
        ProductList productList = (ProductList) servletContext.getAttribute("productListMVC");
        if (productList == null)
        {
            productList = ProductList.create();
            servletContext.setAttribute("productListMVC", productList);
        }
        return productList;
    }
}
