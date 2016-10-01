package Origin_Site;
 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import net.arnx.jsonic.JSON;

/**
 * カテゴリー検索から取得したJson文字列を解析するクラスです
 * Jsonコードへ変換しアイテム情報を取得
 * 取得したデータから指定ワード(機種名や各カテゴリーの判定ワード)でさらに選定して情報取得
 * 取得したデータを持ち回りアイテム情報として設定
 * ※Yahoo! Shoppingのレビュー検索のAPIからオリジナルサイト作成に向けたアイテム情報の取得を
 * カテゴリや検索キーワードの指定からアイテム情報の取得をしています。 
 */

public class JsonParse {
   Map<String, Map<String, Object>> root;
   
   public JsonParse(String json){
        root = JSON.decode(json);
}

/*検索結果の合計数(ユーザー入力での検索時)*/
   public int getTotalResults(){
        return Integer.valueOf(root.get("ResultSet").get("totalResultsAvailable").toString());                     
    }
   
 /**
 * アイテム検索のアイテム名からカテゴリキーワードに一致している情報を抜粋する
 * JSONテキストをパースして、Productインスタンスの該当フィールドに追加
 *
 * @param product
 * @param jsonText
 */
/*【ケース】男性目線*/
public ArrayList Parse_keywordsearch() throws Exception{
    
    ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();
//    Map<String, Map<String, Object>> json = JSON.decode(jsonText);
    //下記のif文でStringからintへ型変換の条件付けを行うためにObjectを利用する。
//    Map<String,Map<String,ArrayList>> review = JSON.decode(jsonText);
//    //アイテム格納データが配列で格納されているので宣言もArrayListを利用する。

    if( !Integer.valueOf((String) root.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
    for(int i = 0; i < ((BigDecimal) root.get("ResultSet").get("totalResultsReturned")).intValue(); i++){    
        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));
        //アイテムの画像URLの取得
            String imgurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
        //アイテムのURLを取得
            String url =result.get("Url").toString();
        //名前を取得
            String Name = result.get("Name").toString();
            System.out.println(Name);
        //価格を取得
            String price_s = ((Map<String, Object>)result.get("Price")).get("_value").toString();
        //アイテムのレビュー評価を取得
            String Favorite = ((Map<String,Object>)result.get("Review")).get("Rate").toString();
        //アイテムコードを取得
            String itemcode = result.get("Code").toString();
        //アイテムの詳細説明を取得
            String caption = result.get("Description").toString();
        //アイテムの見出しを取得
            String headline = result.get("Headline").toString();
            
            ItemDataclass item = new ItemDataclass();
            
            int price =Integer.parseInt(price_s);
            double favorite = Double.parseDouble(Favorite);
      
            item.setName(Name);
            item.setImageurl(imgurl);
            item.setPrice(price);
            item.setItemurl(url);
            item.setFavorite(favorite);
            item.setItemcode(itemcode);
            item.setCaption(caption);
            item.setHeadline(headline);
            array.add(item);
            }
        }   return array;
    }

/*【ケース】女性目線*/
public ArrayList Parse_keywordsearch_ladys() throws Exception{
    
    ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();

    if( !Integer.valueOf((String) root.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
    for(int i = 0; i < Integer.valueOf(root.get("ResultSet").get("totalResultsAvailable").toString()); i++){    
        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));
        //アイテムの画像URLの取得
            String imgurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
        //アイテムのURLを取得
            String url =result.get("Url").toString();
        //名前を取得
            String Name = result.get("Name").toString();
        //価格を取得
            String price_s = ((Map<String, Object>)result.get("Price")).get("_value").toString();
        //アイテムのレビュー評価を取得
            String Favorite = ((Map<String,Object>)result.get("Review")).get("Rate").toString();
        //アイテム名を作成しこの文字列内からキーワード検索を行う。
            String Target = Name;
        //アイテムコードを取得
            String itemcode = result.get("Code").toString();
        //検索キーワードを設定
            Pattern p = Pattern.compile("カワイイ|オシャレ|レディース|かわいい");
            
        
        /*Matcherメソッドを使用して上で作成したTargetからキーワード検索ワードの結果を変数 m として作成*/
            Matcher m = p.matcher(Target);
            System.out.println(m);
            ItemDataclass item = new ItemDataclass();
            if (m == null){
                throw new Exception("検索結果がありませんでした");
            }
            int start = m.start(); //文字列の最初を指定
            int end = m.end(); //文字列の最後を指定
      
            /*System上で該当アイテムを検索キーワードを[]で表示し確認できるようにする*/
            String str  = Target.substring(0, start) + "【" + m.group() + "】"
                            + Target.substring(end, Target.length());
            System.out.println("○ [アイテム名]: "+ Name); //検索キーワードを[]で表示
            System.out.println("該当箇所[アイテム名とレビュー本文]: "+str);
      
            int price =Integer.parseInt(price_s);
            double favorite = Double.parseDouble(Favorite);
      
            item.setName(Name);
            item.setImageurl(imgurl);
            item.setPrice(price);
            item.setItemurl(url);
            item.setFavorite(favorite);
            item.setItemcode(itemcode);
            array.add(item);
    }   return array;
        }else{
            throw new Exception("検索結果がありませんでした"); 
        }
}
/*【ケース】機能性を重視*/
public ArrayList Parse_keywordsearch_function() throws Exception{
    
    ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();

    if( !Integer.valueOf((String) root.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
    for(int i = 0; i < Integer.valueOf(root.get("ResultSet").get("totalResultsAvailable").toString()); i++){    
        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));
        //アイテムの画像URLの取得
            String imgurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
        //アイテムのURLを取得
            String url =result.get("Url").toString();
        //名前を取得
            String Name = result.get("Name").toString();
        //価格を取得
            String price_s = ((Map<String, Object>)result.get("Price")).get("_value").toString();
        //アイテムのレビュー評価を取得
            String Favorite = ((Map<String,Object>)result.get("Review")).get("Rate").toString();
        //アイテム名を作成しこの文字列内からキーワード検索を行う。
            String Target = Name;
        //アイテムコードを取得
            String itemcode = result.get("Code").toString();
        //検索キーワードを設定
            Pattern p = Pattern.compile("機能性|便利|IC対応|手帳型");
            
        
        /*Matcherメソッドを使用して上で作成したTargetからキーワード検索ワードの結果を変数 m として作成*/
            Matcher m = p.matcher(Target);
            System.out.println(m);
            ItemDataclass item = new ItemDataclass();
            if (m == null){
                throw new Exception("検索結果がありませんでした");
            }
            int start = m.start(); //文字列の最初を指定
            int end = m.end(); //文字列の最後を指定
      
            /*System上で該当アイテムを検索キーワードを[]で表示し確認できるようにする*/
            String str  = Target.substring(0, start) + "【" + m.group() + "】"
                            + Target.substring(end, Target.length());
            System.out.println("○ [アイテム名]: "+ Name); //検索キーワードを[]で表示
            System.out.println("該当箇所[アイテム名とレビュー本文]: "+str);
      
            int price =Integer.parseInt(price_s);
            double favorite = Double.parseDouble(Favorite);
      
            item.setName(Name);
            item.setImageurl(imgurl);
            item.setPrice(price);
            item.setItemurl(url);
            item.setFavorite(favorite);
            item.setItemcode(itemcode);
            array.add(item);
    }   return array;
        }else{
            throw new Exception("検索結果がありませんでした"); 
        }
}
/*【ケース】耐衝撃強度を重視 > 耐防水にこだわる*/
public ArrayList Parse_keywordsearch_water() throws Exception{
    
    ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();

    if( !Integer.valueOf((String) root.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
    for(int i = 0; i < Integer.valueOf(root.get("ResultSet").get("totalResultsAvailable").toString()); i++){    
        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));
        //アイテムの画像URLの取得
            String imgurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
        //アイテムのURLを取得
            String url =result.get("Url").toString();
        //名前を取得
            String Name = result.get("Name").toString();
        //価格を取得
            String price_s = ((Map<String, Object>)result.get("Price")).get("_value").toString();
        //アイテムのレビュー評価を取得
            String Favorite = ((Map<String,Object>)result.get("Review")).get("Rate").toString();
        //アイテム名を作成しこの文字列内からキーワード検索を行う。
            String Target = Name;
        //アイテムコードを取得
            String itemcode = result.get("Code").toString();
        //検索キーワードを設定
            Pattern p = Pattern.compile("防水 耐衝撃");
            
        
        /*Matcherメソッドを使用して上で作成したTargetからキーワード検索ワードの結果を変数 m として作成*/
            Matcher m = p.matcher(Target);
            System.out.println(m);
            ItemDataclass item = new ItemDataclass();
            if (m == null){
                throw new Exception("検索結果がありませんでした");
            }
            int start = m.start(); //文字列の最初を指定
            int end = m.end(); //文字列の最後を指定
      
            /*System上で該当アイテムを検索キーワードを[]で表示し確認できるようにする*/
            String str  = Target.substring(0, start) + "【" + m.group() + "】"
                            + Target.substring(end, Target.length());
            System.out.println("○ [アイテム名]: "+ Name); //検索キーワードを[]で表示
            System.out.println("該当箇所[アイテム名とレビュー本文]: "+str);
      
            int price =Integer.parseInt(price_s);
            double favorite = Double.parseDouble(Favorite);
      
            item.setName(Name);
            item.setImageurl(imgurl);
            item.setPrice(price);
            item.setItemurl(url);
            item.setFavorite(favorite);
            item.setItemcode(itemcode);
            array.add(item);
    }   return array;
        }else{
            throw new Exception("検索結果がありませんでした"); 
        }
}
/*【ケース】耐衝撃強度を重視 > こだわらない*/
public ArrayList Parse_keywordsearch_protect() throws Exception{
    
    ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();

    if( !Integer.valueOf((String) root.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
    for(int i = 0; i < Integer.valueOf(root.get("ResultSet").get("totalResultsAvailable").toString()); i++){    
        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));
        //アイテムの画像URLの取得
            String imgurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
        //アイテムのURLを取得
            String url =result.get("Url").toString();
        //名前を取得
            String Name = result.get("Name").toString();
        //価格を取得
            String price_s = ((Map<String, Object>)result.get("Price")).get("_value").toString();
        //アイテムのレビュー評価を取得
            String Favorite = ((Map<String,Object>)result.get("Review")).get("Rate").toString();
        //アイテム名を作成しこの文字列内からキーワード検索を行う。
            String Target = Name;
        //アイテムコードを取得
            String itemcode = result.get("Code").toString();
        //検索キーワードを設定
            Pattern p = Pattern.compile("耐衝撃");
            
        
        /*Matcherメソッドを使用して上で作成したTargetからキーワード検索ワードの結果を変数 m として作成*/
            Matcher m = p.matcher(Target);
            System.out.println(m);
            ItemDataclass item = new ItemDataclass();
            if (m == null){
                throw new Exception("検索結果がありませんでした");
            }
            int start = m.start(); //文字列の最初を指定
            int end = m.end(); //文字列の最後を指定
      
            /*System上で該当アイテムを検索キーワードを[]で表示し確認できるようにする*/
            String str  = Target.substring(0, start) + "【" + m.group() + "】"
                            + Target.substring(end, Target.length());
            System.out.println("○ [アイテム名]: "+ Name); //検索キーワードを[]で表示
            System.out.println("該当箇所[アイテム名とレビュー本文]: "+str);
      
            int price =Integer.parseInt(price_s);
            double favorite = Double.parseDouble(Favorite);
      
            item.setName(Name);
            item.setImageurl(imgurl);
            item.setPrice(price);
            item.setItemurl(url);
            item.setFavorite(favorite);
            item.setItemcode(itemcode);
            array.add(item);
    }   return array;
        }else{
            throw new Exception("検索結果がありませんでした"); 
        }
}
/*【ケース】ブランド×コラボ > アパレルブランド*/
public ArrayList Parse_keywordsearch_apparel() throws Exception{
    
    ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();

    if( !Integer.valueOf((String) root.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
    for(int i = 0; i < Integer.valueOf(root.get("ResultSet").get("totalResultsAvailable").toString()); i++){    
        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));
        //アイテムの画像URLの取得
            String imgurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
        //アイテムのURLを取得
            String url =result.get("Url").toString();
        //名前を取得
            String Name = result.get("Name").toString();
        //価格を取得
            String price_s = ((Map<String, Object>)result.get("Price")).get("_value").toString();
        //アイテムのレビュー評価を取得
            String Favorite = ((Map<String,Object>)result.get("Review")).get("Rate").toString();
        //アイテム名を作成しこの文字列内からキーワード検索を行う。
            String Target = Name;
        //アイテムコードを取得
            String itemcode = result.get("Code").toString();
        //検索キーワードを設定
            Pattern p = Pattern.compile("ADIDAS|PRADA|soccer junky|surf junky|NESTA BRAND|PUNK DRUNKERS|BLACKFLYS|Brown's Beach");
            
        
        /*Matcherメソッドを使用して上で作成したTargetからキーワード検索ワードの結果を変数 m として作成*/
            Matcher m = p.matcher(Target);
            System.out.println(m);
            ItemDataclass item = new ItemDataclass();
            if (m == null){
                throw new Exception("検索結果がありませんでした");
            }
            int start = m.start(); //文字列の最初を指定
            int end = m.end(); //文字列の最後を指定
      
            /*System上で該当アイテムを検索キーワードを[]で表示し確認できるようにする*/
            String str  = Target.substring(0, start) + "【" + m.group() + "】"
                            + Target.substring(end, Target.length());
            System.out.println("○ [アイテム名]: "+ Name); //検索キーワードを[]で表示
            System.out.println("該当箇所[アイテム名とレビュー本文]: "+str);
      
            int price =Integer.parseInt(price_s);
            double favorite = Double.parseDouble(Favorite);
      
            item.setName(Name);
            item.setImageurl(imgurl);
            item.setPrice(price);
            item.setItemurl(url);
            item.setFavorite(favorite);
            item.setItemcode(itemcode);
            array.add(item);
    }   return array;
        }else{
            throw new Exception("検索結果がありませんでした"); 
        }
}
/*【ケース】ブランド×コラボ > デザイナーズブランド*/
public ArrayList Parse_keywordsearch_designers() throws Exception{
    
    ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();

    if( !Integer.valueOf((String) root.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
    for(int i = 0; i < Integer.valueOf(root.get("ResultSet").get("totalResultsAvailable").toString()); i++){    
        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));
        //アイテムの画像URLの取得
            String imgurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
        //アイテムのURLを取得
            String url =result.get("Url").toString();
        //名前を取得
            String Name = result.get("Name").toString();
        //価格を取得
            String price_s = ((Map<String, Object>)result.get("Price")).get("_value").toString();
        //アイテムのレビュー評価を取得
            String Favorite = ((Map<String,Object>)result.get("Review")).get("Rate").toString();
        //アイテム名を作成しこの文字列内からキーワード検索を行う。
            String Target = Name;
        //アイテムコードを取得
            String itemcode = result.get("Code").toString();
        //検索キーワードを設定
            Pattern p = Pattern.compile("Oilshock Designs|PRADA|GUCCI");
            
        
        /*Matcherメソッドを使用して上で作成したTargetからキーワード検索ワードの結果を変数 m として作成*/
            Matcher m = p.matcher(Target);
            System.out.println(m);
            ItemDataclass item = new ItemDataclass();
            if (m == null){
                throw new Exception("検索結果がありませんでした");
            }
            int start = m.start(); //文字列の最初を指定
            int end = m.end(); //文字列の最後を指定
      
            /*System上で該当アイテムを検索キーワードを[]で表示し確認できるようにする*/
            String str  = Target.substring(0, start) + "【" + m.group() + "】"
                            + Target.substring(end, Target.length());
            System.out.println("○ [アイテム名]: "+ Name); //検索キーワードを[]で表示
            System.out.println("該当箇所[アイテム名とレビュー本文]: "+str);
      
            int price =Integer.parseInt(price_s);
            double favorite = Double.parseDouble(Favorite);
      
            item.setName(Name);
            item.setImageurl(imgurl);
            item.setPrice(price);
            item.setItemurl(url);
            item.setFavorite(favorite);
            item.setItemcode(itemcode);
            array.add(item);
    }   return array;
        }else{
            throw new Exception("検索結果がありませんでした"); 
        }
}
/*【ケース】ブランド×コラボ > キャラクター*/
public ArrayList Parse_keywordsearch_character() throws Exception{
    
    ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();
    
    if( !Integer.valueOf((String) root.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
    for(int i = 0; i < Integer.valueOf(root.get("ResultSet").get("totalResultsAvailable").toString()); i++){    
        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));
        //アイテムの画像URLの取得
            String imgurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
        //アイテムのURLを取得
            String url =result.get("Url").toString();
        //名前を取得
            String Name = result.get("Name").toString();
        //価格を取得
            String price_s = ((Map<String, Object>)result.get("Price")).get("_value").toString();
        //アイテムのレビュー評価を取得
            String Favorite = ((Map<String,Object>)result.get("Review")).get("Rate").toString();
        //アイテム名を作成しこの文字列内からキーワード検索を行う。
            String Target = Name;
        //アイテムコードを取得
            String itemcode = result.get("Code").toString();
        //検索キーワードを設定
            Pattern p = Pattern.compile("スヌーピー|キティ|ディズニー|おそ松|プーさん|ムーミン");
            
        
        /*Matcherメソッドを使用して上で作成したTargetからキーワード検索ワードの結果を変数 m として作成*/
            Matcher m = p.matcher(Target);
            System.out.println(m);
            ItemDataclass item = new ItemDataclass();
            if (m == null){
                throw new Exception("検索結果がありませんでした");
            }
            int start = m.start(); //文字列の最初を指定
            int end = m.end(); //文字列の最後を指定
      
            /*System上で該当アイテムを検索キーワードを[]で表示し確認できるようにする*/
            String str  = Target.substring(0, start) + "【" + m.group() + "】"
                            + Target.substring(end, Target.length());
            System.out.println("○ [アイテム名]: "+ Name); //検索キーワードを[]で表示
            System.out.println("該当箇所[アイテム名とレビュー本文]: "+str);
      
            int price =Integer.parseInt(price_s);
            double favorite = Double.parseDouble(Favorite);
      
            item.setName(Name);
            item.setImageurl(imgurl);
            item.setPrice(price);
            item.setItemurl(url);
            item.setFavorite(favorite);
            item.setItemcode(itemcode);
            array.add(item);
    }   return array;
        }else{
            throw new Exception("検索結果がありませんでした"); 
        }
}
/*【液晶シート】綺麗な見栄えを重視*/
public ArrayList Parse_keywordsearch_koukoutaku() throws Exception{
    
    ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();

    if( !Integer.valueOf((String) root.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
    for(int i = 0; i < Integer.valueOf(root.get("ResultSet").get("totalResultsAvailable").toString()); i++){    
        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));
        //アイテムの画像URLの取得
            String imgurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
        //アイテムのURLを取得
            String url =result.get("Url").toString();
        //名前を取得
            String Name = result.get("Name").toString();
        //価格を取得
            String price_s = ((Map<String, Object>)result.get("Price")).get("_value").toString();
        //アイテムのレビュー評価を取得
            String Favorite = ((Map<String,Object>)result.get("Review")).get("Rate").toString();
        //アイテム名を作成しこの文字列内からキーワード検索を行う。
            String Target = Name;
        //アイテムコードを取得
            String itemcode = result.get("Code").toString();
        //検索キーワードを設定
            Pattern p = Pattern.compile("高光沢");
            
        
        /*Matcherメソッドを使用して上で作成したTargetからキーワード検索ワードの結果を変数 m として作成*/
            Matcher m = p.matcher(Target);
            System.out.println(m);
            ItemDataclass item = new ItemDataclass();
            if (m == null){
                throw new Exception("検索結果がありませんでした");
            }
            int start = m.start(); //文字列の最初を指定
            int end = m.end(); //文字列の最後を指定
      
            /*System上で該当アイテムを検索キーワードを[]で表示し確認できるようにする*/
            String str  = Target.substring(0, start) + "【" + m.group() + "】"
                            + Target.substring(end, Target.length());
            System.out.println("○ [アイテム名]: "+ Name); //検索キーワードを[]で表示
            System.out.println("該当箇所[アイテム名とレビュー本文]: "+str);
      
            int price =Integer.parseInt(price_s);
            double favorite = Double.parseDouble(Favorite);
      
            item.setName(Name);
            item.setImageurl(imgurl);
            item.setPrice(price);
            item.setItemurl(url);
            item.setFavorite(favorite);
            item.setItemcode(itemcode);
            array.add(item);
    }   return array;
        }else{
            throw new Exception("検索結果がありませんでした"); 
        }
}
/*【液晶シート】操作性や機能性を重視*/
public ArrayList Parse_keywordsearch_antigurea() throws Exception{
    
    ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();

    if( !Integer.valueOf((String) root.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
    for(int i = 0; i < Integer.valueOf(root.get("ResultSet").get("totalResultsAvailable").toString()); i++){    
        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));
        //アイテムの画像URLの取得
            String imgurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
        //アイテムのURLを取得
            String url =result.get("Url").toString();
        //名前を取得
            String Name = result.get("Name").toString();
        //価格を取得
            String price_s = ((Map<String, Object>)result.get("Price")).get("_value").toString();
        //アイテムのレビュー評価を取得
            String Favorite = ((Map<String,Object>)result.get("Review")).get("Rate").toString();
        //アイテム名を作成しこの文字列内からキーワード検索を行う。
            String Target = Name;
        //アイテムコードを取得
            String itemcode = result.get("Code").toString();
        //検索キーワードを設定
            Pattern p = Pattern.compile("高光沢");
            
        
        /*Matcherメソッドを使用して上で作成したTargetからキーワード検索ワードの結果を変数 m として作成*/
            Matcher m = p.matcher(Target);
            System.out.println(m);
            ItemDataclass item = new ItemDataclass();
            if (m == null){
                throw new Exception("検索結果がありませんでした");
            }
            int start = m.start(); //文字列の最初を指定
            int end = m.end(); //文字列の最後を指定
      
            /*System上で該当アイテムを検索キーワードを[]で表示し確認できるようにする*/
            String str  = Target.substring(0, start) + "【" + m.group() + "】"
                            + Target.substring(end, Target.length());
            System.out.println("○ [アイテム名]: "+ Name); //検索キーワードを[]で表示
            System.out.println("該当箇所[アイテム名とレビュー本文]: "+str);
      
            int price =Integer.parseInt(price_s);
            double favorite = Double.parseDouble(Favorite);
      
            item.setName(Name);
            item.setImageurl(imgurl);
            item.setPrice(price);
            item.setItemurl(url);
            item.setFavorite(favorite);
            item.setItemcode(itemcode);
            array.add(item);
    }   return array;
        }else{
            throw new Exception("検索結果がありませんでした"); 
        }
}
/*【液晶シート】耐衝撃強度を重視*/
public ArrayList Parse_keywordsearch_glass() throws Exception{
    
    ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();

    if( !Integer.valueOf((String) root.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
    for(int i = 0; i < Integer.valueOf(root.get("ResultSet").get("totalResultsAvailable").toString()); i++){    
        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));
        //アイテムの画像URLの取得
            String imgurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
        //アイテムのURLを取得
            String url =result.get("Url").toString();
        //名前を取得
            String Name = result.get("Name").toString();
        //価格を取得
            String price_s = ((Map<String, Object>)result.get("Price")).get("_value").toString();
        //アイテムのレビュー評価を取得
            String Favorite = ((Map<String,Object>)result.get("Review")).get("Rate").toString();
        //アイテム名を作成しこの文字列内からキーワード検索を行う。
            String Target = Name;
        //アイテムコードを取得
            String itemcode = result.get("Code").toString();
        //検索キーワードを設定
            Pattern p = Pattern.compile("強化ガラス|9H");
            
        
        /*Matcherメソッドを使用して上で作成したTargetからキーワード検索ワードの結果を変数 m として作成*/
            Matcher m = p.matcher(Target);
            System.out.println(m);
            ItemDataclass item = new ItemDataclass();
            if (m == null){
                throw new Exception("検索結果がありませんでした");
            }
            int start = m.start(); //文字列の最初を指定
            int end = m.end(); //文字列の最後を指定
      
            /*System上で該当アイテムを検索キーワードを[]で表示し確認できるようにする*/
            String str  = Target.substring(0, start) + "【" + m.group() + "】"
                            + Target.substring(end, Target.length());
            System.out.println("○ [アイテム名]: "+ Name); //検索キーワードを[]で表示
            System.out.println("該当箇所[アイテム名とレビュー本文]: "+str);
      
            int price =Integer.parseInt(price_s);
            double favorite = Double.parseDouble(Favorite);
      
            item.setName(Name);
            item.setImageurl(imgurl);
            item.setPrice(price);
            item.setItemurl(url);
            item.setFavorite(favorite);
            item.setItemcode(itemcode);
            array.add(item);
    }   return array;
        }else{
            throw new Exception("検索結果がありませんでした"); 
        }
}


/*検索結果の合計数(カテゴリーでの検索時)*/
   public int getTotalResults_category(){
        return Integer.valueOf(root.get("ResultSet").get("totalResultsAvailable").toString());                    
    } 
 
 
   
   
/*ユーザーがキーワード検索欄から直接キーワードを入力して検索するメソッド*/
 public ArrayList getItemSearchResult_query()
        throws Exception{
        //返却用のItemData配列
        ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();
        
        //見つからなかった場合の例外
        if(Integer.valueOf(root.get("ResultSet").get("firstResultPosition").toString()) == 0){
            System.out.println("result..."+((BigDecimal) root.get("ResultSet").get("totalResultsReturned")).intValue());
            throw new Exception("検索結果がありませんでした");
        }
        
        //検索結果数が0件でなければ処理をする
        if(getTotalResults() != 0 ){
            //totalResultsReturned = Jsonファイルにある検索結果件数に到達するまでループ。
            for(int i = 0; i < ((BigDecimal) root.get("ResultSet").get("totalResultsReturned")).intValue(); i++){
                ItemDataclass item = new ItemDataclass();
                //コンパイラによる警告を無視
                @SuppressWarnings("unchecked")
                //i番目の商品データを入手
                 Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));
        //値を取得
            @SuppressWarnings("unchecked")
         //名前を取得
            String name = result.get("Name").toString();
        //アイテムの画像URLの取得
            String imageurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
         //価格を取得   
            int price = Integer.parseInt(((Map<String, Object>)result.get("Price")).get("_value").toString());       
        //アイテムのコードを取得
            String itemcode = result.get("Code").toString();
        //アイテムのレビュー評価を取得   
            double favorite = Double.parseDouble(((Map<String,Object>)result.get("Review")).get("Rate").toString());
        //アイテムのレビュー評価をした数を取得       
            int reviewer = Integer.parseInt(((Map<String,Object>)result.get("Review")).get("Count").toString());
       
                item.setName(name);
                item.setImageurl(imageurl);
                item.setPrice(price);
                item.setItemcode(itemcode);
                item.setFavorite(favorite);
                item.setReviewer(reviewer);
                array.add(item);      
        }
     }  return array;
  }
/*ここまででカテゴリー検索URLを用いた情報取得は終了*/
 
 
/*アイテム商品コード(詳細)のURLから得られる情報を取得*/
public ItemDataclass getItemDetail()
        throws Exception{
        //返却用のItemData
        ItemDataclass item = new ItemDataclass();
        
        //見つからなかった場合の処理
        if(Integer.valueOf(root.get("ResultSet").get("firstResultPosition").toString()) == 0){
            throw new Exception("検索結果がありませんでした");
        }

        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                        (Map<String, Map<String, Object>>)root.get("ResultSet").get("0")
                                            ).get("Result").get("0"));

        @SuppressWarnings("unchecked")
        //名前の取得
        String name = result.get("Name").toString();
        //ヘッドラインを取得
        String headline = result.get("Headline").toString();
        //アイテムの画像URLを取得(普通サイズ)
        String imageurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
        //アイテムの画像URLを取得(大サイズ)
        String bigimageurl = ((Map<String, Object>)result.get("ExImage")).get("Url").toString();        
        //アイテムの価格を取得
        int price = Integer.parseInt(((Map<String, Object>)result.get("Price")).get("_value").toString());                                
        //アイテムコードを取得
        String itemcode = result.get("Code").toString();
        //アイテムの販売店名を取得
        String storename = ((Map<String,Object>)result.get("Store")).get("Name").toString();
        //アイテムのレビュー情報を取得
        double favorite = Double.parseDouble(((Map<String,Object>)result.get("Review")).get("Rate").toString());
        //レビューの登録数を取得
        int reviewer = Integer.parseInt(((Map<String,Object>)result.get("Review")).get("Count").toString());
        //アイテムの詳細説明を取得
        String caption = result.get("Caption").toString();
        
        
        item.setName(name);
        item.setPrice(price);
        item.setImageurl(imageurl);
        item.setBigimageurl(bigimageurl);
        item.setItemcode(itemcode);
        item.setStorename(storename);
        item.setFavorite(favorite);
        item.setReviewer(reviewer);                      
        item.setCaption(caption);
                
        return item;
    }
 
 
/**
 * 商品データを保持するクラス【参考で実際には使用していない】
 */
class Product{
 public Long janCode;//アイテムJANコード
 public String name; //アイテム名
 public int review;  //評価
 public String imageurl; //画像URL
 public String bigimageurl; //画像URL
 public int price; //価格
 public String itemurl; //アイテムURL
 public String description; //商品詳細
 public String storename; //販売店名
 public double favorite;//レビューの星の個数
 public int reviewer; //評価

 /*【検索カテゴリー】スマホケース*/
 public int category_id_case = 38347;       /*全機種のケース*/
 public int category_id_iPhone6s_iPhone6 = 38369;  /*iPhone6s/iPhone6*/
 public int category_id_iPhone6sPlus_6Plus = 38368; /*iPhone6sPlus/6Plus*/
 public int category_id_iPhoneSE_iPhone5s = 38370;  /*iPhoneSE/iPhone5s*/
 public int category_id_Xperia = 38358;             /*Xperiaシリーズ*/
 public int category_id_AQUOS = 38362;              /*AQUOSシリーズ*/
 public int category_id_Galaxy = 38359;             /*Galaxyシリーズ*/
 
/*【検索カテゴリー】液晶シート*/
 public int category_id_sheet = 38333;      /*全機種のシート*/
 public int category_id_sheet_iPhone = 38374;   /*iPhoneシリーズ*/
 public int category_id_sheet_Xperia = 38375;   /*Xperiaシリーズ*/
 public int category_id_sheet_AQUOS = 38379;    /*AQUOSシリーズ*/
 public int category_id_sheet_Galaxy = 38376;   /*Galaxyシリーズ*/
 
/*【検索ワード】スマホケース*/ 
 public String regex_mens = "黒|カッコイイ|メンズ";              /*デザインを重視 > 男性目線*/
 public String regex_women = "カワイイ|オシャレ|レディース|かわいい";                            /*> 女性目線*/
 public String regex_functionality = "機能性|便利|IC対応|手帳型";     /*機能性を重視*/
 public String regex_anti_shock_water = "防水 耐衝撃";  /*耐衝撃強度を重視 > 耐防水にこだわる(iPhoneのみ)*/
 public String regex_anti_shock = "耐衝撃";                              /*> こだわらない*/
 public String regex_brand_aparel = "ADIDAS|PRADA|soccer junky|surf junky|NESTA BRAND|PUNK DRUNKERS|BLACKFLYS|Brown's Beach";      /*ブランド×コラボ > アパレルブランド*/
 public String regex_brand_designer = "Oilshock Designs|PRADA|GUCCI";                                                              /*> デザイナーズブランド*/
 public String regex_brand_character = "スヌーピー|キティ|ディズニー|おそ松|プーさん|ムーミン";                                    /*> キャラクター*/

/*【検索ワード】液晶シート*/
 public String regex_beautiful = "高光沢";         /*綺麗な見栄えを重視*/
 public String regex_responce = "アンチグレア";          /*操作性や機能性を重視*/
 public String regex_anti_shock_sheet = "強化ガラス|9H";  /*耐衝撃強度を重視*/
}
}
