/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author yoshikawatoshio
 */
public class Task10 extends HttpServlet {

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
        
        request.setCharacterEncoding("UTF-8"); 
        String remdb = request.getParameter("deletedb");                        //削除フォームは"deletedb"で指定
        int id = Integer.parseInt( remdb ); 
            Connection db_con = null;
            PreparedStatement db_st = null;
            
            try
            {
            /*課題10:profileIDで指定したレコードを削除できるフォームを作成してください*/
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","root","");
            
           
            db_st = db_con.prepareStatement("delete from profiles where profilesID = ?");
            db_st.setInt(1,id);                                                 //profilesID
            int d = db_st.executeUpdate();                                      //データベースから削除した件数を変数で表現
                if(d != 0){    
                    out.println("データベースから"+d+"件のレコードを削除しました。");    
                }
            //1件でも削除していれば画面上に削除件数を表示する。
            db_st.close();
            db_con.close();
            } catch (SQLException e_sql) {
                out.println("接続時にエラーが発生しました："+e_sql.toString());
            } catch (Exception e) {
                out.println("接続時にエラーが発生しました："+e.toString());
            } finally {
                if (db_con != null){
                    try {
                        db_con.close();
                    } catch (Exception e_con) {
                        System.out.println(e_con.getMessage());
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