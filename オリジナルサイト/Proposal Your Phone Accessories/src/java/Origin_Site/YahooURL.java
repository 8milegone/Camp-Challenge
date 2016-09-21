/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Origin_Site;

import DB_Manage.UserData;
import DB_Manage.UserDataDAO;
import DB_Manage.UserDataDTO;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Yahoo Shopping APIのURLをまとめたクラス
 * @author 長島 奨
 */
public class YahooURL {
    // YahooショッピングAPIのID・ベースURL・リクエストURL   保守性を保つ為にfinalStringにする
    //アプリケーションID

/**
 * Yahoo!ショッピングAPIのベースURL
 */
//アプリケーションID
    private static final String APP_ID = "dj0zaiZpPW1vUU1ESlAzZFo5TSZzPWNvbnN1bWVyc2VjcmV0Jng9OTc-";
    //商品検索結果のURL
    private static final String BASE_URL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
    //商品詳細のURL
    private static final String CODE_URL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup";
    //商品レビュー
    private static final String Review_URL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/reviewSearch";

    /**
     * @param query キーワード検索語句
     * @param offset 
     * @return 検索結果のJsonファイルURL
     * @throws  UnsupportedEncodingException "UTF-8"というエンコード形式がない時の例外
     */
    public static String querySearch_main(String query,int offset) throws UnsupportedEncodingException{
        query = java.net.URLEncoder.encode(query,"UTF-8");
        /*スマホアクセサリー全般のIDを指定*/
        String category ="38346";
        return BASE_URL + "?appid=" + APP_ID + "&query=" + query +"&category_id="+ category + "&offset=" + offset;    
    }
    /**
     * @param category カテゴリー検索語句
     * @return 商品の詳細情報が記載されたJsonファイルURL
     * @throws  UnsupportedEncodingException "UTF-8"というエンコード形式がない時の例外
     */
    public static String querySearch_user(String query,String category,int offset) throws UnsupportedEncodingException, SQLException{
         query = java.net.URLEncoder.encode(query,"UTF-8");
         category = java.net.URLEncoder.encode(category,"UTF-8");
            return BASE_URL+"?appid=" + APP_ID + "&query=" +query+ "&category_id=" + category + "&offset=" + offset;
    }

    /*
     * @param itemcode アイテム詳細
     * @return 商品の詳細情報が記載されたJsonファイルURL
     * @throws  UnsupportedEncodingException "UTF-8"というエンコード形式がない時の例外
     */
    public static String itemDetail(String itemcode) throws UnsupportedEncodingException{
        itemcode = java.net.URLEncoder.encode(itemcode, "UTF-8");
        return CODE_URL+"?appid="+APP_ID + "&itemcode="+ itemcode + "&responsegroup=large" + "&image_size=300";
    }
}
