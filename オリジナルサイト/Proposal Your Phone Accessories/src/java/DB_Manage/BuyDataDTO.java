/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Manage;

/**
 *
 * @author 8mile_000
 */
import Origin_Site.CartData;
import java.sql.Timestamp;

/**
 * BuyDataDAOと情報をやりとりするクラス
 * 可変性のためにDBの型と一致させているので、表示の際はBuyDataを使うこと
 * @author user1
 */
public class BuyDataDTO {
    private int buyID;
    private int userID;
    private String itemcode;
    private String itemname;
    private String imgurl;
    private int price;
    private int quantity;
    private int dispatch;
    private Timestamp buyDate;

    public BuyDataDTO(){}
    
    public BuyDataDTO(int userID,int type,CartData cd){
        this.userID   = userID;
        this.itemcode = cd.getItemcode();
        this.itemname = cd.getItemname();
        this.imgurl   = cd.getImgurl();
        this.price    = cd.getPrice();
        this.quantity = cd.getQuantity();
        this.dispatch = dispatch;
    }
        
    public int getBuyID(){ return this.buyID;}
    public void setBuyID(int buyid){ this.buyID = buyid;}
    
    public int getUserID(){ return this.userID;}
    public void setUserID(int userid){ this.userID = userid;}
    
    public String getItemcode(){ return this.itemcode;}
    public void setItemcode(String itemcode){ this.itemcode = itemcode;}
    
    public String getItemname(){ return this.itemname;}
    public void setItemname(String itemname){ this.itemname = itemname;}
    
    public String getImgurl(){ return this.imgurl;}
    public void setImgurl(String imgurl){ this.imgurl = imgurl;}
    
    public int getPrice(){ return this.price;}
    public void setPrice(int price){ this.price = price;}
    
    public int getQuantity(){ return this.quantity;}
    public void setQuantity(int qty){ this.quantity = qty;}
    
    public int getDispatch(){ return this.dispatch;}
    public void setDispatch(int dispatch){ this.dispatch = dispatch;}
    
    public Timestamp getBuydate(){ return this.buyDate;}
    public void setBuydate(Timestamp bd){ this.buyDate = bd;}
    
    
}