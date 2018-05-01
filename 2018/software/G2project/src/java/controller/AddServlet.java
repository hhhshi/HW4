package controller;

import dbHelper.AddQuery;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bookmarks;

@WebServlet(name = "AddServlet", urlPatterns = {"/addBookmark"})
public class AddServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
               //Pass Execution on to doPost
                    doPost(request, response);
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
        
        //get the data
        String page_name = request.getParameter("page_name");
        String page_url = request.getParameter("url");
        String username = request.getParameter("username");
        int cat = Integer.parseInt (request.getParameter("cat"));
        String note = request.getParameter("note");
        Calendar calendar = Calendar.getInstance();
        Timestamp date_saved = new java.sql.Timestamp(calendar.getTime().getTime());
        Timestamp date_modified = new java.sql.Timestamp(calendar.getTime().getTime());
        
        
        //set up a bookmark object
        Bookmarks bookmark = new Bookmarks();
        bookmark.setPage_name(page_name);
        bookmark.setUrl(page_url);
        bookmark.setUsername(username);
        bookmark.setCat(cat);
        bookmark.setNote(note);
        bookmark.setDate_saved(date_saved);
        bookmark.setDate_modified(date_modified);
        
        //set up an addQuery object
        AddQuery aq = new AddQuery();
        
        //pass the leader to addQuery to add to the database
        aq.doAdd(bookmark);
        
        
        //pass execution control to the ReadServlet
        String url = "/read";
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward (request, response);
        
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
