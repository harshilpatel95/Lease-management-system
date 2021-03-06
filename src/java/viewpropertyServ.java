/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Addproperty;
import model.Login;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Drashti
 */
public class viewpropertyServ extends HttpServlet {

    private Object HibernateUtil;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Addproperty> array = new ArrayList<>();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            Session se = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = se.beginTransaction();
            
            HttpSession hs = request.getSession();
            Login l = (Login) hs.getAttribute("loginid");
            
            Criteria c = se.createCriteria(Addproperty.class);
            c.add(Restrictions.eq("lid", l));
            List<Addproperty> al = c.list();
            Iterator<Addproperty> it1 = al.iterator();
            while (it1.hasNext()) {
                Addproperty im = it1.next();
                im.getPropertytype();
                im.getPropertyname();
                im.getWantto();
                im.getSelectcity();
                im.getAddress();
                im.getSaleprice();
                im.getRate();
                im.getPhoto();
                im.getDescription();
                im.getName();
                im.getEmailid();
                im.getContact();
                
                array.add(im);
            }
            request.setAttribute("array", array);
            RequestDispatcher rd = request.getRequestDispatcher("viewpro.jsp");
            rd.forward(request, response);
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
