/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Origin_Site;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
/**
 *画面系の処理や表示を簡略化するためのヘルパークラス。
 * @author 長島 奨
 */
public class JumsHelper {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }

    //リンクを定数として設定
    private final String homeURL = "top.jsp";
    private final String loginURL = "login.jsp";    
    private final String logoutURL = "Login";
    private final String cartURL = "Cart";
    private final String registerURL = "registration.jsp";   
    
    //トップページへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }  
    
    //ログインへのリンクを返却
    public String login() {
        return "<a href=\""+loginURL+"\">ログイン</a>";
    }
    //ログアウトへのリンクを返却
    public String logout() {
        return "<a href=\""+logoutURL+"\">ログアウト</a>";
    }
    //カートへのリンクを返却
    public String cart() {
        return "<a href=\""+cartURL+"\">カート</a>";
    }
    //ユーザー新規登録へのリンクを返却
    public String register() {
        return "<a href=\""+registerURL+"\">会員登録する</a>";
    }
    
    /**
     * 入力されたデータのうち未入力項目がある場合、
     * チェックリストに従いどの項目が未入力なのかhtml文を返却する
     * @param chkList UserDataBeansで生成されるリスト。未入力要素の名前が格納されている
     * @return 未入力の項目に対応する文字列
     */ 
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("mail")){
                    output += "メールアドレス";
                }
                if(val.equals("password")){
                    output +="パスワード";
                }
                if(val.equals("name")){
                    output +="氏名";
                }
                if(val.equals("address")) {
                    output +="住所";
                }
                output +="が未記入です。<br>";
            }
        return output;
    }
    
    /**
     * 購入確認画面での発送方法を選択するラジオボタンの数字を日本語に変換
     * @param i
     * @return 発送方法（日本語）
     */
    public String exTypenum(int i) {
        switch(i) {
            case 1:
                return "宅配便";
            case 2:
                return "メール便";
            case 3:
                return "その他";
        }
        return "";
    }
    /*検索画面の下部のページリンクを取得【キーワード検索】*/
    public static final String pages_user(HttpServletRequest request){
        String query = request.getAttribute("query").toString();
        int page = Integer.parseInt(request.getAttribute("page").toString());
        int result = Integer.parseInt(request.getAttribute("totalresults").toString());
        String first = "<a href=\"Search_user?query="+ query +"&page=" + 1 +"\">最初</a>";
        String back = "<a href=\"Search_user?query="+ query +"&page=" + (page - 1) +"\">戻る</a>";
        String next = "<a href=\"Search_user?query="+ query +"&page=" + (page + 1) +"\">次へ</a>";
        String end = "<a href=\"Search_user?query="+ query +"&page=" + 50 +"\">最後</a>";
        
        String pages = "";
        //現在のページから表示するページリンク数
        int left  = 3;
        int right = 3;
        //最大ページ数
        int max = 50;
        if(result / 20 <= max){
            max = (int) Math.ceil(result / 20.0) ;
        }
        
        //表示されるリンク数が合計7になるように調整
        if(page - left < 1){
            right -= page - left;
        }
        if(max - page < right){
            left += right - (max - page) ;
        }
        
        for(int i = -left ; i <= right; i++){            
            //現在のページにはリンクを貼らない
            if(page + i <= 0){ continue;}
            if(page + i > max){ break;}
            if( i == 0 ){
                pages += "<a disabled style=\"cursor:default\">" + page +"</a>";
                continue;
            }
            pages += "<a href=\"Search_user?query=" + query + "&page=" + (page + i) +"\">" + (page + i) +"</a>";
        }
        
        return "<div id=\"page\" align=\"center\">" + first + back + pages + next + end + "</div>";
        
    }

/*検索画面の下部のページリンクを取得【カテゴリー検索】*/
    public static final String pages_category(HttpServletRequest request){
        String query = request.getAttribute("query").toString();
        int page = Integer.parseInt(request.getAttribute("page").toString());
        int result = Integer.parseInt(request.getAttribute("totalresults").toString());
        String search_method = request.getAttribute("search_method").toString();
        String first = "<a href=\""+ search_method +"?query="+ query +"&page=" + 1 +"\">最初</a>";
        String back = "<a href=\""+ search_method +"?query="+ query +"&page=" + (page - 1) +"\">戻る</a>";
        String next = "<a href=\""+ search_method +"?query="+ query +"&page=" + (page + 1) +"\">次へ</a>";
        String end = "<a href=\""+ search_method +"?query="+ query +"&page=" + 50 +"\">最後</a>";
        
        String pages = "";
        //現在のページから表示するページリンク数
        int left  = 3;
        int right = 3;
        //最大ページ数
        int max = 50;
        if(result / 20 <= max){
            max = (int) Math.ceil(result / 20.0) ;
        }
        
        //表示されるリンク数が合計7になるように調整
        if(page - left < 1){
            right -= page - left;
        }
        if(max - page < right){
            left += right - (max - page) ;
        }
        
        for(int i = -left ; i <= right; i++){            
            //現在のページにはリンクを貼らない
            if(page + i <= 0){ continue;}
            if(page + i > max){ break;}
            if( i == 0 ){
                pages += "<a disabled style=\"cursor:default\">" + page +"</a>";
                continue;
            }
            pages += "<a href=\""+ search_method +"?query=" + query + "&page=" + (page + i) +"\">" + (page + i) +"</a>";
        }
        
        return "<div id=\"page\" align=\"center\">" + first + back + pages + next + end + "</div>";
        
    }
/*検索画面の下部のページリンクを取得【価格検索】*/
    public static final String pages_price(HttpServletRequest request){
        String query = request.getAttribute("query").toString();
        int page = Integer.parseInt(request.getAttribute("page").toString());
        int result = Integer.parseInt(request.getAttribute("totalresults").toString());
        String search_method = request.getAttribute("search_method").toString();
        String fromprice = request.getAttribute("fromprice").toString();
        String toprice = request.getAttribute("toprice").toString();
        
        String first = "<a href=\""+ search_method +"?query="+ query +"&fromprice="+ fromprice +"&toprice="+ toprice +"&page=" + 1 +"\">最初</a>";
        String back = "<a href=\""+ search_method +"?query="+ query +"&fromprice="+ fromprice +"&toprice="+ toprice +"&page=" + (page - 1) +"\">戻る</a>";
        String next = "<a href=\""+ search_method +"?query="+ query +"&fromprice="+ fromprice +"&toprice="+ toprice +"&page=" + (page + 1) +"\">次へ</a>";
        String end = "<a href=\""+ search_method +"?query="+ query +"&fromprice="+ fromprice +"&toprice="+ toprice +"&page=" + 50 +"\">最後</a>";
        
        String pages = "";
        //現在のページから表示するページリンク数
        int left  = 3;
        int right = 3;
        //最大ページ数
        int max = 50;
        if(result / 20 <= max){
            max = (int) Math.ceil(result / 20.0) ;
        }
        
        //表示されるリンク数が合計7になるように調整
        if(page - left < 1){
            right -= page - left;
        }
        if(max - page < right){
            left += right - (max - page) ;
        }
        
        for(int i = -left ; i <= right; i++){            
            //現在のページにはリンクを貼らない
            if(page + i <= 0){ continue;}
            if(page + i > max){ break;}
            if( i == 0 ){
                pages += "<a disabled style=\"cursor:default\">" + page +"</a>";
                continue;
            }
            pages += "<a href=\""+ search_method +"?query=" + query + "&fromprice="+ fromprice +"&toprice="+ toprice +"&page=" + (page + i) +"\">" + (page + i) +"</a>";
        }
        
        return "<div id=\"page\" align=\"center\">" + first + back + pages + next + end + "</div>";
        
    }
}