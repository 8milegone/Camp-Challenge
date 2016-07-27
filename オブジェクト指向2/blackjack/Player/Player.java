/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.Player;

import blackjack.Human.Human;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 8mile_000
 */
public class Player extends Human{
    
        //以下, Playerの情報
        private String name;                                                    //プレイヤーの名前の変数
        private String mark;                                                    //"player"と名付ける
        private int sum;                                                        //手札の合計値
        private int t;                                                          //1か11かを選択する値
        private String d;                                                       //hitかstandするかを選択する文字
        private boolean type;                                                   //各メソッド内で作成するのであくまで情報として記述
        private final String h = "hit";                                         //メソッド内で作成するのであくまで情報として記述
                                                 //
    
        
        
        public void setName(String name){                                       //getter群とsetter群の作成
            this.name = name;
        }
        public void setName(){
            this.name = "You";
        }
        public String getName(){
            return this.name;
        }
        public String getMark(){
            return this.mark;
        }
        public int getSum(){
            return this.sum;
        }

    //Playreコンストラクタ   
        //名前を決める、手札を取得して保存する、合計値を取得する、ヒットする、スタンドする、1か11かを選択する
    public Player(){                                                            //Playerのメソッドを作成
        this.mycards = new ArrayList<>();
        this.mark = "player";
    }

    @Override
    public void setCards(ArrayList<Integer> cards) {                            //Human.javaから上書きで保存する為にOverride
        this.mycards = cards;                                                   //作成したmycardの変数に配列cardsの情報を連携させる
        System.out.println(this.name + "さんの手持ちを開示します");
        for  (int i = 0; i < this.mycards.size(); i++){                         //maycardsの配列のサイズまでmycardsの値を表示させる
            System.out.print("「" + this.mycards.get(i) + "」");
            
        }
        this.open();
    }
    
    @Override
    public void open() {                                                        //Human.javaから上書きで保存する為にOverride
        if (this.sum < 21){                                                     //値が21未満ならsumの値を0にリセット    
        this.sum = 0;
        for (int i = 0; i < this.mycards.size(); i++){                          //mycardsの配列のサイズの中に値が1が含まれるなら
            if(this.mycards.get(i) == 1){                                       //値1を'1'としてか'11'として扱うかを問う
                System.out.println("エースを入手しました。このカードは11として扱うことも出来ます。");
                System.out.println("1又は11を入力して下さい。");
                t = new Scanner(System.in).nextInt();                           //テキスト入力を扱うためのScannerクラスを用いる。
                this.mycards.set(i, t);                                         //入力された値(1or11)をiと置き換える
            }
            this.sum = this.sum + this.mycards.get(i);                          //置き換えた値をsumに追加する
        } 
        }                                                                       //合計値21以下で1のカードを引いた時の処理終了
        System.out.println("カードの合計値は「" + sum + "」です。");
        
    }
    
    public boolean under21(){                                                   //合計値が21の時hitかstandかを選択するメソッドなのでbooleanを起用
        if (this.sum < 21){                                                     
        System.out.println("手持ちのカードの合計は21未満です。");               
        System.out.println("カードを1枚引く場合は「hit」を入力して下さい。");
        System.out.println("引かない場合は「stand」を記入して下さい。");        //未記入の場合は自動的にstandになるようにboolean callで設定
        d = new Scanner(System.in).nextLine();                                  //テキスト入力を扱うためのScannerクラスを用いる。
        }
        return this.call(d);                                                    //①結果をboolean callへ継承させる。
    }
    
    
    @Override                                                                   //Human.javaから上書きで保存する為にOverride
    public boolean checkSum() {                                                                                              
        boolean type;                                                           //falseの変数typeを生成
        int i = this.sum;                                                       //checkSum()内で判断するための変数iをsumから取得
        if (i <= 21){                                                           //合計値が21以下または21なら
            type = true;
        } else {
            type = false;                                                       //合計値が21以上ならfalse
        }
        return type;                                                            
    }
    
    public boolean call(String t){                                              //①と②の結果を引用してcallの宣言のメソッドを作成
        boolean type;                                                           //①の結果
        if ("hit".equals(t)){                                                   //"hit"と入力された場合
         System.out.println("hitします。ディーラーからカードをもらいます。");
         type = true;                                                           //メソッドcallのbooleanに返却
        } else {
         System.out.println("standします。ディーラーのターンになります。");     //"hit"以外で入力された場合
         type = false;                                                          //メソッドcallのbooleanに返却
        }
        return type;                                                            //メソッドcallのbooleanに返却
    }


 
    
}