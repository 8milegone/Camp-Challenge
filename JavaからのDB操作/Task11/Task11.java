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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 8mile_000
 */
public class Task11 extends HttpServlet {

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
        //JSPから各データを更新できるように変数を宣言
        String id = request.getParameter("alloverdrive");
        int i = Integer.parseInt(id);
        String n = request.getParameter("name");
        String t = request.getParameter( "tell" );
        String age = request.getParameter( "age" );
        int a = Integer.parseInt( age );                                        //文字列からデータ型に変換 
        String y = request.getParameter( "year" );
        String m = request.getParameter( "month" );
        String d = request.getParameter( "day" );
        System.out.println(y+m+d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf);                                                //確認の為に生年月日を出力指示 
            
            Connection db_con = null;
            PreparedStatement db_st = null;                                     //今回はSELECT*FROMではないので"ResultSet db_data = null;"はなし
        
        try {
            /*課題11:profileIDで指定したレコードの、profileID以外の要素をすべて上書きできるフォームを作成してください*/
            out.println("課題11"+"<br>");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","root","");
            db_st = db_con.prepareStatement("update profiles set name =?, tell =?, age =?, birthday =? where profilesID =?;");
            //データを更新できるようにupdateで表現
            
            db_st.setString(1, n);                                              //各データの更新
            db_st.setString(2,t);
            db_st.setInt(3,a);
            db_st.setDate(4, new java.sql.Date(sdf.parse(y + "-" + m + "-" + d).getTime()));
            db_st.setInt(5, i);                                                 //WHEREから指定するIDの情報を取得
            
            int x = db_st.executeUpdate();                                      //もし更新に成功したら"success"
            if(x != 0){                                                         //失敗したら"failed"を表示
               out.println("success");
            }else{
                out.println("failed");
            }
             db_st.executeUpdate();
            
            out.println("profilesID:"+i+"<br>");                                       //更新後の各データを画面に表示させる。
            out.println("名前:"+n+"<br>");
            out.println("電話番号:"+t+"<br>");
            out.println("年齢:"+a+"<br>");
            out.println("生年月日:"+new java.sql.Date(sdf.parse(y+"-"+m+"-"+d).getTime()));
            
            
            db_st.close();
            db_con.close();
            
            
        } catch (SQLException e_sql) {                                          //Mysqlの例外処理を記載
                out.println("接続時にエラーが発生しました："+e_sql.toString());
            } catch (Exception e) {                                             //Mysql以外の例外処理を記載
                out.println("接続時にエラーが発生しました："+e.toString());
            } finally {                                                         //例外処理の最終処理を記載
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