/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camp.basic.Task;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 8mile_000
 */
public class Task7 extends HttpServlet {
    public static void main(){
    String Answer = method();
    System.out.println(Answer);
    }
    
    public static String method(){
    String message ="きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
    String Remessage = message.replace('I','い').replace('U','う');
    return Remessage;
    }
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
            /*課題7 以下の文章の「I」⇒「い」に、「U」⇒「う」に入れ替える処理を作成し、結果を表示してください。
              「きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます」*/
            String message ="きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
            /*文字列の置換(replace()) String変数.replace("置換前文字列","置換後文字列を使用します*/
            String Remessage = message.replace('I','い').replace('U','う');     //置換させたい文字が2箇所なのでreplace().replace()で表現
            out.println(Remessage);
            
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
