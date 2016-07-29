package Task;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.objects.NativeFunction.function;

/**
 *
 * @author 8mile_000
 */
public class TaskAnswer1 extends HttpServlet {

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
        
        
        PrintWriter out = response.getWriter();
        try {
            request.setCharacterEncoding("UTF-8");
            
        String Q1 = request.getParameter("myQ1");
        String Q2 = request.getParameter("myQ2");
        String Q3 = request.getParameter("myQ3");
        String Q4 = request.getParameter("myQ4");
        out.println("選んだ食べ物によってあなたの性格をお伝えします。");
        out.println("<br>");
        
        HttpSession hs = request.getSession(true);
        String select ="選んだのが";
       
       if(Q1!=null){
            out.println(select+"スイーツ"+"なら");
            out.println("自分に甘い性格です。");
            out.println("<br>");
        }
         
        if(Q2!=null){
            out.println(select+"焼肉"+"なら");
            out.println("小さなことにくよくよせず、大きな行動にでることができる性格です。");
            
            out.println("<br>");
        }
        
        if(Q3!=null){
            out.println(select+"寿司"+"なら");
            out.println("慎重に物事を分析してから目標に向かい頑張る性格です。");
        
            out.println("<br>");
        }
        
        if(Q4!=null){
            out.println(select+"犬"+"なら");
            out.println("小学校の図書館で「はだしの元」を1度は読んだことがある性格です。");
            
            out.println("<br>");
        }    
        } finally {
            out.close();
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
