/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camp.basic.Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 8mile_000
 */
@WebServlet(name = "Task4", urlPatterns = {"/Task4"})
public class Task4 extends HttpServlet {

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
            /*課題4 2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）
              を表示してください。*/
         Calendar jan = Calendar.getInstance();     //1月用のインスタンスを生成
         Calendar dec = Calendar.getInstance();     //12月用のインスタンスを生成
         
         jan.set(2015,1,1,0,0,0);       //1月の時刻を設定
         dec.set(2015,12,31,23,59,59);      //12月の時刻を設定
         
         long tsjan = jan.getTimeInMillis();     //1月のタイムスタンプをミリ秒で取得
         long tsde = dec.getTimeInMillis();      //12月のタイムスタンプをミリ秒で取得
         
         long answer = (tsde - tsjan);     //1月と12月の差分を取得
         
         String message1=(answer+"ミリ秒"+"<br>");
         String message2=("2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）は"+"<br>");
         
         out.println(message2+message1+"です。");
     }  catch(Exception e) {
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
