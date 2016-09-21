/* 
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Origin_Site;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 
 * @author 長島　奨
 */
public class YahooAPI {
    static String result ="";
    
    /**
     * ユーザーが検索フォームから直接キーワードを入力して検索した際の処理
     * @param query
     * @return 文字列での検索結果
     */
    public static String getResult(String query) {
        
        try{
            //URLの作成
            URL url = new URL(query);
            System.out.println("url..."+url);
            //接続用HttpURLConnectionオブジェクト作成
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            //リクエストメソッドの設定
            con.setRequestMethod("GET");
            // リダイレクトを自動で許可しない設定
            con.setInstanceFollowRedirects(false);
            //接続
            con.connect();
            //検索に入力されたキーワードをまとめて読み込む
            BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            while (true){
                String line = bf.readLine();
                if ( line == null ){ break; }
                responseBuilder.append(line);                 
            }
        bf.close();
        //切断
        con.disconnect();
        result =responseBuilder.toString();
        
        }catch(Exception e) {
        }
        return result;
    }
}
