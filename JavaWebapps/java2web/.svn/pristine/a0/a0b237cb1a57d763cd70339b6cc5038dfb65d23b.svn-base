package be.kdg.webapps102.mvc.view;

import be.kdg.webapps102.mvc.model.Product;
import be.kdg.webapps102.mvc.model.ProductList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToonProductenServlet extends HttpServlet
{
    private ProductList productList;

    @Override
    public void init() throws ServletException
    {
        productList = findModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        productList = findModel();
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>ProductenLijst</title></head><body><h1>Producten:</h1><table border=\"1\"><tr><th>product id</th><th>omschrijving</th></tr>");
        List<Product> sortedProducts = retrieveSortedProducts();
        for (Product product : sortedProducts)
        {
            out.print("<tr><td>" + product.getId() + "</td><td>" + product.getDescription() + "</td></tr>");
        }
        out.println("</table><a href=\"../mvcIndex.html\">Terug naar menu</a></body></html>");
    }

    private ProductList findModel()
    {
        ServletContext servletContext = getServletContext();
        ProductList products = (ProductList) servletContext.getAttribute("productListMVC");
        if (products == null)
        {
            products = ProductList.create();
            servletContext.setAttribute("productListMVC", products);
        }
        return products;
    }

    private List<Product> retrieveSortedProducts()
    {
        List sortedProducts = new ArrayList<Product>(productList.getProducts());
        Collections.sort(sortedProducts, new ProductNameComparator());
        return sortedProducts;
    }

    private static class ProductNameComparator implements Comparator<Product>
    {
        @Override
        public int compare(Product product1, Product product2)
        {
            String description1 = product1.getDescription();
            String description2 = product2.getDescription();
            return description1.compareTo(description2);
        }
    }
}
