/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Origin_Site;

/**
 * Cartのアイテム情報を定義するメソッド
 * @author 長島 奨
 */
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class CartData implements Serializable {
    private String itemcode;/*アイテムのJANコード*/
    private String itemname;/*カートに入れたアイテム名*/
    private int quantity;   /*アイテムカートの個数*/
    private String imgurl;  /*アイテムの画像URL*/
    private int price;      /*アイテムの価格*/
    private String newDate; /*カート追加日時*/
    
    CartData(ItemDataclass id,int qty){
        this.itemcode = id.getItemcode();   /*ItemDataclassから情報取得*/
        this.itemname = id.getName();       /*ItemDataclassから情報取得*/
        this.quantity = qty;
        this.imgurl = id.getImageurl();     /*ItemDataclassから情報取得*/
        this.price = id.getPrice();         /*ItemDataclassから情報取得*/       
    }
    
    CartData(CartDataDTO cdd){
        this.setItemcode(cdd.getItemcode());
        this.itemcode = cdd.getItemcode();
        this.itemname = cdd.getItemname();
        this.quantity = cdd.getQuantity();
        this.imgurl = cdd.getImgurl();
        this.price = cdd.getPrice();
        //DBから引き上げたタイムスタンプを読みやすい形へ変換
        this.newDate = new SimpleDateFormat("yyyy年MM月dd日").format(cdd.getNewdate());
    }
    
    public String getItemcode(){ return this.itemcode;}
    public void setItemcode(String ic){ this.itemcode = ic;}
    
    public String getItemname(){ return this.itemname;}
    public void setItemname(String name){ this.itemname = name;}
    
    public int getQuantity(){ return this.quantity;}
    public void setQuantity(int qty){ this.quantity = qty;}
    
    public String getImgurl(){ return this.imgurl;}
    public void setImgurl(String img){ this.imgurl = img;}
    
    public int getPrice(){ return this.price;}
    public void setPrice(int price){ this.price = price;}
    
    public String getNewdate(){ return this.newDate;}
    

}