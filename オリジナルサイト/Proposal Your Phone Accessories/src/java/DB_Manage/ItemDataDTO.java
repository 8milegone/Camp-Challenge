/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Manage;

import Origin_Site.ItemDataclass;
import java.sql.Timestamp;
import javax.servlet.http.HttpServlet;

/**
 * ItemDataDAOと情報をやりとりするクラス
 * 可変性のためにDBの型と一致させているので、表示の際はItemDataを使うこと
 * @author 8mile_000
 */
public class ItemDataDTO extends HttpServlet {
    private int ItemID;
    private int UserID;
    private String itemcode;
    private String itemname;
    private String imgurl;
    private int price;
    private int quantity;
    private int type;
    private Timestamp buyDate;

    public ItemDataDTO(){}
    
    public ItemDataDTO(int UserID,int type,ItemDataclass cd){
        this.ItemID   = ItemID;
        this.UserID   = UserID;
        this.itemcode = cd.getItemcode();
        this.itemname = cd.getName();
        this.imgurl   = cd.getImageurl();
        this.price    = cd.getPrice();
        this.type     = type;
    }
        
    public int getItemID(){ return this.ItemID;}
    public void setItemID(int itemid){ this.UserID = itemid;}
    
    public int getUserID(){ return this.UserID;}
    public void setUserID(int userid){ this.UserID = userid;}
    
    public String getItemcode(){ return this.itemcode;}
    public void setItemcode(String itemcode){ this.itemcode = itemcode;}
    
    public String getItemname(){ return this.itemname;}
    public void setItemname(String itemname){ this.itemname = itemname;}
    
    public String getImgurl(){ return this.imgurl;}
    public void setImgurl(String imgurl){ this.imgurl = imgurl;}
    
    public int getPrice(){ return this.price;}
    public void setPrice(int price){ this.price = price;}
    
    public int getType(){ return this.type;}
    public void setType(int type){ this.type = type;}
   
}
