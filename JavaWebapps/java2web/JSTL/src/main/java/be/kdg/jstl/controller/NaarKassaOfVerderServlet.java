/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.jstl.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wouter
 */
@WebServlet("/NaarKassaOfVerderServlet")
public class NaarKassaOfVerderServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getParameter("submit");
        if ("Naar Kassa".equals(action))
        {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("mvc.jsp");
        } else
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/toonCatalogus.jsp");
            dispatcher.forward(request, response);
        }
    }
}
