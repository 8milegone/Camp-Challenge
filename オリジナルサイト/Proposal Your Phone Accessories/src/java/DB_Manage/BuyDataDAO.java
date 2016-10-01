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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author 長島 奨
 */
public class BuyDataDAO {
    
    public static BuyDataDAO getInstance(){
        return new BuyDataDAO();
    }
    
    //購入履歴を挿入
    public void insert(int userID, String itemCode, int dispatch) throws SQLException, FileNotFoundException,IllegalMonitorStateException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO buy_t(userID,itemCode,dispatch,buyDate) VALUES(?,?,?,?)");
            st.setInt(1, userID);
            st.setString(2,itemCode);
            st.setInt(3,dispatch);
            st.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("buydata insert completed");
            
            
        }finally{
            if(con != null){
                con.close();
            }
        }
    }

    //ユーザIDから購入履歴を取得    
    public ArrayList search(int userID) throws SQLException, FileNotFoundException,IllegalMonitorStateException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * FROM buy_t WHERE userID = ?");
            st.setInt(1,userID);
            ResultSet rs = st.executeQuery();
            
            
            ArrayList<BuyDataDTO> history = new ArrayList<BuyDataDTO>();
            while(rs.next()){
                BuyDataDTO bdd = new BuyDataDTO();
                bdd.setBuyID(rs.getInt(1));
                bdd.setUserID(rs.getInt(2));
                bdd.setItemcode(rs.getString(3));
                bdd.setDispatch(rs.getInt(4));
                bdd.setBuydate(rs.getTimestamp(5));
                history.add(bdd);
            }
            
            
            return history;
        }finally{
            if(con != null){
                con.close();
            }
        }
        
    }
    
}
