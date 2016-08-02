/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yoshikawatoshio
 */
public class Task9 extends HttpServlet {

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
        
        
        request.setCharacterEncoding( "UTF-8" );
        //JSPから各データを更新できるように変数を宣言
        String id = request.getParameter( "id" );
        int i = Integer.parseInt( id );                                         //文字列からデータ型に変換
        String n = request.getParameter( "name" );
        String t = request.getParameter( "tell" );
        String age = request.getParameter( "age" );
        int a = Integer.parseInt( age );                                        //文字列からデータ型に変換
        String y = request.getParameter( "year" );
        String m = request.getParameter( "month" );
        String d = request.getParameter( "day" );
        System.out.println(y+m+d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         System.out.println(sdf);  
        Connection db_con = null;              
        PreparedStatement db_st = null;

        
        try {
            /* 課題9:フォームからデータを挿入できる処理を構築してください。*/
            out.println("課題9");
            Class.forName("com.mysql.jdbc.Driver").newInstance();                                              
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");   
                System.out.println("no.1");
            db_st = db_con.prepareStatement("insert into profiles value( ?, ?, ?, ?, ? )");//追加したいデータは5つ。
            //データを追加できるようにinsertで表現
            System.out.println("no.2");
            db_st.setInt(1, i);
            System.out.println("no.3");
            db_st.setString(2, n);
            System.out.println("no.4");
            db_st.setString(3, t);
            System.out.println("no.5");
            db_st.setInt(4, a);   
            System.out.println("no.6");
            db_st.setDate(5, new java.sql.Date(sdf.parse(y + "-" + m + "-" + d).getTime())); //非常に重要な構文なので覚えること
            System.out.println("no.7");
            //宣言した変数からデータを格納していく。
            
            int x = db_st.executeUpdate();
            if(x != 0){
               out.println("success");
            }else{
                out.println("failed");
            }
            
            db_st.close(); 
            db_con.close();
            
            } catch ( SQLException e_sql ) {
                out.println("接続時にエラーが発生しました："+ e_sql.toString() );
            } catch ( Exception e ) {
                out.println("接続時にエラーが発生しました：" + e.toString() );
            }finally{
            if ( db_con != null ) {
                try {
                    db_con.close();
                } catch ( Exception e_con ) {
                    System.out.println( e_con.getMessage() );
                }
            }
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