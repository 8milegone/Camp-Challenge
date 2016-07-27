package blackjack.Delaer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import blackjack.Human.Human;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 8mile_000
 */
public class Dealer extends Human{
    Integer numbers = 1;                                                        //カード用の変数
    int r;                                                                      //乱数用
    private ArrayList<Integer> cards;                                           //デッキ用の配列
    private ArrayList<Integer> dlr;                                             //ディーラー用配列
    private ArrayList<Integer> ply;                                             //プレイヤー用配列
    
    //以下, Dealerの情報
    boolean type;
    private int sum;                                                            //手札の合計値
    private String mark;                                                        //"dealer"と名付ける
    
    public String getMark(){                                                    //getter群の作成
        return this.mark;
    }
    public int getSum(){
        return this.sum;
    }
    //Dealerコンストラクタ   
        //カードをセットする、カードをシャッフルする、カードをPlayerに配る、手札を取得して保存する、合計値を取得する
        //ヒットする、スタンドする
    
    public Dealer(){                                                            //カードのセット
        this.cards = new ArrayList<>();
        this.dlr = new ArrayList<>();
        this.mycards = new ArrayList<>();
        this.ply = new ArrayList<>();
        this.mark = "dealer";
         
        while(this.numbers < 11){                                               //山に1〜10までのカードをセット
            this.cards.add(this.numbers);                                       //カードの配列が10になるまでに追加する
            this.numbers++;
        }
    }
    
    public ArrayList<Integer> deal(String mark){                                //カードのシャッフル、手札を取得する、カードをPlayerに配る
        ArrayList<Integer> reply = new ArrayList<>();                           //配列をmainメソッド返信用にする
        if ("dealer".equals(mark)){                                             //もしdealerなら
            System.out.println("ディーラーが自身に手札を渡しました。");
            for(int i = 0; i < 2; i++){                                         //最初に2枚手札を取得する
            this.r = new Random().nextInt(10);                                  //配列の添字(0〜9)を生成
            this.dlr.add(this.cards.get(this.r));                               //山札よりカードをディーラーの配列に追加
            reply = this.dlr;                                                   //mainメソッドに返信
            } 
        } else if ("player".equals(mark)){
            System.out.println("ディーラーがプレーヤーに手札を渡しました。");
            for(int i = 0; i < 2; i++){
            this.r = new Random().nextInt(10);                                  //配列の添字(0〜9)を生成
            this.ply.add(this.cards.get(this.r));                               //山札よりカードをプレーヤーの配列に追加
            reply = this.ply;                                                   //mainメソッドに返信
            }                                   
        }
        return reply;                                                           //reply配列はローカル配列のため, 初期化する必要はありません。
    }
    
    public ArrayList<Integer> hit(String mark){                                 //ヒットする
        ArrayList<Integer> reply = new ArrayList<Integer>();                    //配列をmainメソッド返信用にする
        switch(mark){
            case "dealer":                                                      //もしdealerなら
            if (this.sum <= 16){                                                //sumが16以下なら
                for (int i = 2; this.sum <= 17; i++){                           //sumが17以上になるまでヒットする→先に2枚引いているのでiは2から
                System.out.println("カードを1枚引きます。");
                this.r = new Random().nextInt(10);                              //配列の添字(0〜9)を生成
                //System.out.println(this.cards.get(r));
                    if (this.r == 0){                                           //もし'A'のカードを引いたら配列に11というカードを追加する
                        this.dlr.add(11);
                        this.sum = this.sum + 11;                               //合計値に11を追加する
                        
                    } else {
                        this.dlr.add(this.cards.get(this.r));                   //それ以外なら出た値のカードを配列に追加する
                        this.sum = this.sum + this.dlr.get(i);                  //合計値に出た値を追加する
                        
                    }
                }
                reply = this.dlr;                                               //結果をmainで引用するためにdealへ返却する
            } else {                                                            //合計値が17以上でstandする
                System.out.println("ディーラーはstandしました");
                reply = this.mycards;                                           //結果をmainで引用するためにdealへ返却する
            }
            break;
            
            case "player":                                                      //もしplayerなら
                this.r = new Random().nextInt(10);                              //配列の添字(0〜9)を生成
                this.ply.add(this.cards.get(this.r));                           //出た値のカードを配列に追加する
                System.out.println("もらったカードは" + this.cards.get(this.r) + "です。");
                reply = this.ply;                                               //結果をmainで引用するためにdealへ返却する
            break;
        }
        return reply;                                                           //結果をmainで引用するためにdealへ返却する
    }
 
    @Override
    public void setCards(ArrayList<Integer> cards) {                            //Human.javaから上書きで保存する為にOverride
        this.mycards = cards;                                                   //作成したmycardの変数に配列cardsの情報を連携させる
        this.sum = 0;                                                           //合計値をリセットする
        System.out.println("ディーラーの手持ちの1枚を開示します。");            
        System.out.println("「" + this.mycards.get(0) + "」");                  //1枚目の値を出力する
            for (int i = 0; i < this.mycards.size(); i++){                      //maycardsの配列のサイズまでmycardsの値は表示させない
            this.sum = this.sum + this.mycards.get(i);                          //maycardsの配列のサイズまでmycardsの値を合計する
            } 
        this.open();
    }
    
    @Override
    public void open() {                                                        //Human.javaから上書きで保存する為にOverride
        for (int i = 0; i < this.mycards.size(); i++){                          //maycardsの配列のサイズまでで
            if(this.mycards.get(i) == 1/* || this.sum == 2*/){                      //mycardsの配列のサイズの中に値が1が含まれるか合計値が2なら
            this.mycards.set(i, 11);                                            //そのiを11に置き換える
            /*this.sum = this.sum + 10;*/
            this.sum = this.sum + this.mycards.get(i);   
            }
        } 
        //System.out.println("ディーラーの合計" + this.sum);
    }                                                                           //合計値21以下で1のカードを引いた時の処理終了

  @Override
    public boolean checkSum() {                                                //Human.javaから上書きで保存する為にOverride
        boolean type = false;                                                   //falseの変数typeを生成
        int i = this.sum;                                                       //checkSum()内で判断するための変数iをsumから取得
        if (i <= 21){                                                           //合計値が21以下または21なら
            type = true;
        } else {                                                                //合計値が21以上ならfalse
            type = false;
        }
        return type;
    }


}