/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;


import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yoshikawatoshio
 */
public class Task2 extends HttpServlet {

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
            //課題2:前回の課題1で作成したテーブルに自由なメンバー情報を格納する処理を構築してください
            out.println("課題2");
            Class.forName("com.mysql.jdbc.Driver").newInstance();   
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");    
            //Mysqlのアドレス,ユーザー名,パスを記載
            db_st = db_con.prepareStatement("insert into profiles values( ?, ?, ?, ?, ?)");        //格納するデータ
            db_st.setInt(1,0);
            db_st.setString(2,"長島 奨");
            db_st.setString(3,"070-1111-2222");
            db_st.setInt(4,28);
            db_st.setString(5,"1987-09-20");
            
            db_st.executeUpdate();                                              //executeUpdateメソッドでデータベースを更新
            
            db_st.close();
            db_con.close();    
            
            } catch ( SQLException e_sql ) {
                out.println("接続時にエラーが発生しました："+ e_sql.toString() );//Mysqlの例外処理を記載
            } catch ( Exception e ) {
                out.println("接続時にエラーが発生しました：" + e.toString() );//Mysql以外の例外処理を記載
            }finally{
            if ( db_con != null ) {                                             //例外処理の最終処理を記載
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