/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Origin_Site;

import java.io.Serializable;

/**
 * 商品データを保持するクラス
 * @author user1
 */
public class ItemDataclass implements Serializable{
    
    public String name; //商品名
    public String imageurl; //画像URL
    public String bigimageurl; //画像URL
    public int price; //価格
    public String itemurl; //商品URL
    public String itemcode; //商品コード
    public String description; //商品説明
    public String storename; //販売店名
    public double favorite;//レビューの星の個数
    public int reviewer; //評価
    public String caption;
    public String add1;
    public String add2;
    public String add3;
    
    public ItemDataclass(){}

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the imageurl
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * @param imageurl the imageurl to set
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * @return the bigimageurl
     */
    public String getBigimageurl() {
        return bigimageurl;
    }

    /**
     * @param bigimageurl the bigimageurl to set
     */
    public void setBigimageurl(String bigimageurl) {
        this.bigimageurl = bigimageurl;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the itemurl
     */
    public String getItemurl() {
        return itemurl;
    }

    /**
     * @param itemurl the itemurl to set
     */
    public void setItemurl(String itemurl) {
        this.itemurl = itemurl;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the storename
     */
    public String getStorename() {
        return storename;
    }

    /**
     * @param storename the storename to set
     */
    public void setStorename(String storename) {
        this.storename = storename;
    }

    /**
     * @return the favorite
     */
    public double getFavorite() {
        return favorite;
    }

    /**
     * @param favorite the favorite to set
     */
    public void setFavorite(double favorite) {
        this.favorite = favorite;
    }

    /**
     * @return the reviewer
     */
    public int getReviewer() {
        return reviewer;
    }

    /**
     * @param reviewer the reviewer to set
     */
    public void setReviewer(int reviewer) {
        this.reviewer = reviewer;
    }

    /**
     * @return the caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * @param caption the caption to set
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * @return the add1
     */
    public String getAdd1() {
        return add1;
    }

    /**
     * @param add1 the add1 to set
     */
    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    /**
     * @return the add2
     */
    public String getAdd2() {
        return add2;
    }

    /**
     * @param add2 the add2 to set
     */
    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    /**
     * @return the add3
     */
    public String getAdd3() {
        return add3;
    }

    /**
     * @param add3 the add3 to set
     */
    public void setAdd3(String add3) {
        this.add3 = add3;
    }
}