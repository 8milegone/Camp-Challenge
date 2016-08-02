/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 8mile_000
 */
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
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try {
            /*課題4:前回の課題1で作成したテーブルからprofileID=1の情報を取得し、画面に取得した情報を表示してください*/
            out.println("課題4");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "");
            db_st = db_con.prepareStatement("select * from profiles where profilesID = ? ;");
            //作成したprofilesの中のprofilesIDのデータを呼び出し。
            db_st.setInt(1,1);
            db_data = db_st.executeQuery();                                     //executeQueryメソッドでデータベースにSQLを実施
            while(db_data.next()){
                out.println("ID"+db_data.getInt("profilesID")+"<br>");          //profilesIDが1の情報をそれぞれ呼び出し
                out.println("名前"+db_data.getString("name")+"<br>");
                out.println("電話番号"+db_data.getString("tell")+"<br>");
                out.println("年齢"+db_data.getInt("age")+"<br>");
                out.println("生年月日"+db_data.getString("birthday")+"<br>");
            }
            db_data.close();
            db_st.close();
            db_con.close();
        } catch (SQLException e_sql) {                                          
            out.println("接続時にエラーが発生しました："+ e_sql.toString());    //Mysqlの例外処理を記載
        } catch (Exception e) {        
            out.println("接続時にエラーが発生しました："+ e.toString());        //Mysql以外の例外処理を記載
        }
        finally {                                                               //例外処理の最終処理を記載
            if (db_data != null) {
                try {
                    db_data.close();
                }catch (Exception e_data) {
                    System.out.println(e_data.getMessage());
                }
            }
            if (db_st != null) {
                try {
                    db_st.close();
                }catch (Exception e_st) {
                    System.out.println(e_st.getMessage());
                }
            }
            if (db_con != null) {
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
