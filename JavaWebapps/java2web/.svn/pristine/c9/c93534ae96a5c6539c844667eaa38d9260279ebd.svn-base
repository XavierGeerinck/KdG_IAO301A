package be.kdg.webapps102.servlets;

import be.kdg.webapps102.mvc.model.Product;
import be.kdg.webapps102.mvc.model.ProductList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String attribuut = (String) request.getAttribute("attribuut");
        ProductList productList = findModel();

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body><h1>" + attribuut + ":</h1><table border=\"1\"><tr><th>productId</th><th>description</th></tr>");
        for (int i = 0; i < productList.size(); i++)
        {
            Product product = productList.getProduct(i);
            out.print("<tr><td>");
            out.print(product.getId());
            out.print("</td><td>");
            out.print(product.getDescription());
            out.println("</td></tr>");
        }
        out.println("</body></html>");
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
