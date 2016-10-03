/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Manage;

/**
 *
 * @author 長島 奨
 */
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * BuyDataDTOから購入履歴表示用に変換するクラス。
 * BuyDataDTOにユーザからの情報を書き込むことはないので読み取り専用クラスとする。
 * @author 長島 奨
 */
public class BuyData {
    private String itemcode;
    private int buyID;
    private int userID;
    private int dispatch;
    private Timestamp buydate;
    
    //BuyDataDTO経由でのみ使用できる
    public BuyData(){
        this.itemcode = "";
        this.dispatch = 0;
        //タイムスタンプ型を読みやすい形に
        this.buydate = null;
    }
    
    
    
    
    //送られてきた整数を対応する文字列に変換
    public static String typeToString(int type){ 
        switch(type){
            case 1:
                return "はこBOON";
            case 2:
                return "日本郵便";
            case 3:
                return "ヤマト運輸";
            case 4:
                return "佐川急便";
            default:
                return "";
        }
    }
    
    

    /**
     * @return the itemcode
     */
    public String getItemcode() {
        return itemcode;
    }

    /**
     * @param itemcode the itemcode to set
     */
    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    /**
     * @return the buyID
     */
    public int getBuyID() {
        return buyID;
    }

    /**
     * @param buyID the buyID to set
     */
    public void setBuyID(int buyID) {
        this.buyID = buyID;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the dispatch
     */
    public int getDispatch() {
        return dispatch;
    }

    /**
     * @param dispatch the type to set
     */
    public void setDispatch(int dispatch) {
        this.dispatch = dispatch;
    }

    /**
     * @return the buydate
     */
    public Timestamp getBuydate() {
        return buydate;
    }

    /**
     * @param buydate the buydate to set
     */
    public void setBuydate(Timestamp buydate) {
        this.buydate = buydate;
    }
    
    public ArrayList DTOBD2Mapping(ArrayList<BuyDataDTO> bddList){ 
        ArrayList<BuyData>BDList = new ArrayList<BuyData>();
        for(int i=0; i<bddList.size();i++){
            BuyData bd = new BuyData();
            bd.setBuyID(bddList.get(i).getBuyID());
            bd.setUserID(bddList.get(i).getUserID());
            bd.setItemcode(bddList.get(i).getItemcode());
            bd.setDispatch(bddList.get(i).getDispatch());
            bd.setBuydate(bddList.get(i).getBuydate());
            
            BDList.add(bd);
        } return BDList;
    } 
        
}
