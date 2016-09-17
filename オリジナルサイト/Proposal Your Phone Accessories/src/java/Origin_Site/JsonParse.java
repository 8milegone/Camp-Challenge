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
   Map<String, Map<String, Object>> json;
   
   public JsonParse(String json){
        json = JSON.decode(json);
}

/*検索結果の合計数*/
   public int getTotalResults(){
        return Integer.valueOf(json.get("ResultSet").get("totalResultsAvailable").toString());                    
    }
   
 /**
 * アイテム検索のアイテム名からカテゴリキーワードに一致している情報を抜粋する
 * JSONテキストをパースして、Productインスタンスの該当フィールドに追加
 *
 * @param product
 * @param jsonText
 */
private void Parse_keywordsearch(Product product, String jsonText) throws Exception{
 
    Map<String, Map<String, Object>> json = JSON.decode(jsonText);
    //下記のif文でStringからintへ型変換の条件付けを行うためにObjectを利用する。
//    Map<String,Map<String,ArrayList>> review = JSON.decode(jsonText);
//    //アイテム格納データが配列で格納されているので宣言もArrayListを利用する。

    if( !Integer.valueOf((String) json.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
    for(int i = 0; i < ((BigDecimal) json.get("ResultSet").get("totalResultsReturned")).intValue(); i++){    
        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)json.get("ResultSet").get("0")
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
            Pattern p = Pattern.compile(product.regex_mens);
            mutchsearh_keywordsearch(p,Target,imgurl,url,Name,price_s,Favorite,itemcode);
        
    }
    }else{
       throw new Exception("検索結果がありませんでした"); 
    }
   }
 
 
 public void mutchsearh_keywordsearch(Pattern p, String Target,String imgurl,String url,String Name,String price_s,String Favorite,String itemcode) throws Exception{
  /*①Matcherメソッドを使用して上で作成したTargetからカテゴリ検索ワードの結果を変数 m として作成*/
    Matcher m = p.matcher(Target);
    if (m.find()){
  /*スマホケース:iPhoneシリーズ以外の機種、シートはさらにユーザー登録機種の選定を行うためにさらに機種名を検索キーワードとして設定*/    
      Pattern t = Pattern.compile("SO-04H");
      getItemSearchResult_category(t,Target,imgurl,url,Name,price_s,Favorite,itemcode);
    }
 }

/*アイテム検索結果の取得(カテゴリ検索)*/ 
 public ArrayList getItemSearchResult_category(Pattern t, String Target,String imgurl,String url,String Name,String price_s,String Favorite,String itemcode) 
   throws Exception{
   /*返却用のItemData配列*/
   ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();
   
   /*②Matcherメソッドを使用して上で作成したTargetから機種名検索ワードの結果を変数 m として作成*/
    Matcher m = t.matcher(Target);
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
      return array;
}
 
 /**/
 public ArrayList getItemSearchResult_query()
        throws Exception{
        //返却用のItemData配列
        ArrayList<ItemDataclass> array = new ArrayList<ItemDataclass>();
        
        //見つからなかった場合の例外
        if(Integer.valueOf(json.get("ResultSet").get("firstResultPosition").toString()) == 0){
            System.out.println("result..."+((BigDecimal) json.get("ResultSet").get("totalResultsReturned")).intValue());
            throw new Exception("検索結果がありませんでした");
        }
        
        //検索結果数が0件でなければ処理をする
        if(getTotalResults() != 0 ){
            //totalResultsReturned = Jsonファイルにある検索結果件数に到達するまでループ。
            for(int i = 0; i < ((BigDecimal) json.get("ResultSet").get("totalResultsReturned")).intValue(); i++){
                ItemDataclass item = new ItemDataclass();
                //コンパイラによる警告を無視
                @SuppressWarnings("unchecked")
                //i番目の商品データを入手
                Map<String, Object> result = ((Map<String, Object>)(
                                                (Map<String, Map<String, Object>>)json.get("ResultSet").get("0")
                                                    ).get("Result").get(Integer.toString(i)));

                //値を取得
                @SuppressWarnings("unchecked")
                String name = result.get("Name").toString();
                String imageurl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
                int price = Integer.parseInt(((Map<String, Object>)result.get("Price")).get("_value").toString());                
                String itemcode = result.get("Code").toString();
                double favorite = Double.parseDouble(((Map<String,Object>)result.get("Review")).get("Rate").toString());
                int reviewer = Integer.parseInt(((Map<String,Object>)result.get("Review")).get("Count").toString());
                
                item.setName(name);
                item.setImageurl(imageurl);
                item.setPrice(price);
                item.setItemcode(itemcode);
                item.setFavorite(favorite);
                item.setReviewer(reviewer);
                array.add(item);      
            }
        }
        return array;
    }
 

/*ここまででカテゴリー検索URLを用いた情報取得は終了*/
/*アイテム商品コード(詳細)のURLから得られる情報を取得*/
public ItemDataclass getItemDetail()
        throws Exception{
        //返却用のItemData
        ItemDataclass item = new ItemDataclass();
        
        //見つからなかった場合の処理
        if(Integer.valueOf(json.get("ResultSet").get("firstResultPosition").toString()) == 0){
            throw new Exception("検索結果がありませんでした");
        }

        @SuppressWarnings("unchecked")
        Map<String, Object> result = ((Map<String, Object>)(
                                        (Map<String, Map<String, Object>>)json.get("ResultSet").get("0")
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
 * 商品データを保持するクラス
 */
class Product {
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
