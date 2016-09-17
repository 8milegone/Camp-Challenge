/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Manage;

import base.DBManager;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;

/**
 * DBのsort_tへの操作内容を記述している。
 * @author 8mile_000
 */
public class ItemDataDAO extends HttpServlet {
    
    public static ItemDataDAO getInstance(){
        return new ItemDataDAO();
    }
    
    //sort_tへアイテム情報を挿入
    public void insert(int ItemID, int UserID, String itemCode, int type) throws SQLException, FileNotFoundException,IllegalMonitorStateException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO sort_t(ItemID,UserID,itemCode,type) VALUES(?,?,?,?)");
            st.setInt(1, ItemID);
            st.setInt(2,UserID);
            st.setString(3,itemCode);
            st.setInt(4,type);
            st.executeUpdate();
            System.out.println("ItemData insert completed");
            
        }finally{
            if(con != null){
                con.close();
            }
        }
    }

    //ユーザIDからアイテム情報を取得    
    public void search(int UserID) throws SQLException, FileNotFoundException,IllegalMonitorStateException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * FROM sort_t WHERE UserID = ?");
            st.setInt(1,UserID);
            ResultSet rs = st.executeQuery();
        
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
}
