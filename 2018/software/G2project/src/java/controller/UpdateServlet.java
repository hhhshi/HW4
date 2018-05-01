package controller;

import dbHelper.UpdateQuery;
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

@WebServlet(name = "UpdateServlet", urlPatterns = {"/updateBookmark"})
public class UpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
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
            
            // Pass execution on to doPost
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
            
        //get the form data and set up a Bookmark Object
        int bookmark_ID = Integer.parseInt(request.getParameter("bookmark_id"));
        String page_name = request.getParameter("page_name");
        String page_url = request.getParameter("url");
        String username = request.getParameter("username");
        int cat = Integer.parseInt(request.getParameter("cat"));
        String note = request.getParameter("note");
        Calendar calendar = Calendar.getInstance();
        Timestamp date_modified = new java.sql.Timestamp(calendar.getTime().getTime());
        
        Bookmarks bookmark = new Bookmarks();
        bookmark.setBookmark_ID(bookmark_ID);
        bookmark.setPage_name(page_name);
        bookmark.setUrl(page_url);
        bookmark.setUsername(username);
        bookmark.setCat(cat);
        bookmark.setNote(note);
        bookmark.setDate_modified(date_modified);
        
        //create an UpdateQuery object and use it to update the leader
        UpdateQuery uq =new UpdateQuery();
        uq.doUpdate(bookmark);
        
        //pass control to the ReadServlet
        String url = "/read";
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
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
