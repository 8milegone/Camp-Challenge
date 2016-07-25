/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camp.basic.Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 8mile_000
 */
public class Task3 extends HttpServlet {

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
            /*課題3 2016年11月4日 10時0分0秒のタイムスタンプを作成し、「年-月-日 時:分:秒」で表示してください。*/
            Date time = new Date();
            Calendar past =Calendar.getInstance();
            past.set(2016,10,4,10,0,0);
            Date pasttime = past.getTime();     //Date型の値取得する為にCalendarクラスを利用
            
            past.setTime(pasttime);
            int yy = past.get(Calendar.YEAR);
            int mm = past.get(Calendar.MONTH)+1; //現在の月の前月が表示されないように+1を追加
            int dd = past.get(Calendar.DAY_OF_MONTH);
            int hh = past.get(Calendar.HOUR_OF_DAY);
            int min = past.get(Calendar.MINUTE);
            int ss = past.get(Calendar.SECOND);     
            out.println(yy+"年"+mm+"月"+dd+"日"+hh+"時"+min+"分"+ss+"秒"+"(Calendarクラスを利用して取得)"+"<br>");
            
            SimpleDateFormat past2 = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");//文字列だがyyyyやMMなどは非常に重要 年や月などは変更可能
            String past2date = past2.format(pasttime);
            out.print(past2date+"(SimpleDateFormatクラスを利用して取得)");
            } catch(Exception e) {
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
