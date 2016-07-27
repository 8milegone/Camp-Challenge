/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.Main;



import blackjack.Delaer.Dealer;
import blackjack.Gameover.Gameover;
import blackjack.Load.Load;
import blackjack.Player.Player;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 8mile_000
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{         //割り込みが発生した場合に投げられる例外 InterruptedException を入力
    System.out.println("あなたの名前を入力して下さい");
    String name = new Scanner(System.in).nextLine();                            //指定した型の値を読み込む"Scannerメソッド"で
                                                                                //コマンドプロンプトからキーボード(標準)入力を取得するプログラムとして"System in"
                                                                                //nextLine：入力された値を”空白”までの範囲で認識します。(姓、名の間に空白が生まれる可能性がある為)
                                                            
    Player p = new Player();                                                    //プレーヤーインスタンスを生成→Player.javaから
    Dealer d = new Dealer();                                                    //ディーラーインスタンスを生成→Dealer.javaから
    Gameover g = new Gameover();                                                //ゲームオーバーインスタンスを生成→Gameover.javaから
    Load s = new Load();                                                        //ロードインスタンスを生成→Load.javaから
    boolean plyjudge;                                                           //プレーヤー用手持ち判断変数
    boolean dlrjudge;                                                           //ディーラー用手持ち判断用変数
    
    if (name.length() == 0){                                                    //名前が入力されなかった場合, 「You」となる
        p.setName();
    } else {
        p.setName(name);
    }
    
    System.out.println("ゲームを始めましょう" + p.getName() + "さん。");        //Player pの変数をpとして設定したNameを取得して表示
    System.out.println("ゲームの準備をしています。");
    s.loading();        //Load sの変数sを実行
    
    //手札の配布と保存
    ArrayList<Integer> deal;                                                    //ディーラー用配列
    ArrayList<Integer> play;                                                    //プレーヤー用配列
    
    deal = d.deal(d.getMark());                                                 //ディーラーメソッドで生成されたディーラーの手札を保存
    s.loading();
    play = d.deal(p.getMark());                                                 //ディーラーメソッドで生成されたプレーヤーの手札を保存
    //s.loading();は省略
    System.out.println("");
    
    d.setCards(deal);                                                           //ディーラーの手札をsetCardsメソッドを使ってd.mycardsに保存
    //s.loading();
    p.setCards(play);                                                           //プレーヤーの手札をsetCardsメソッドを使ってp.mycardsに保存
    
    //以下, ゲーム開始
    System.out.println("ゲームが始まりました!");
    System.out.println("プレーヤーのターン");
    System.out.println("");
    
    if (p.getSum() < 21){                                                       //プレーヤーの手持ちが21未満 getSumでpの最大値を取得
        while(p.getSum() <= 21 && p.under21()){                                 //プレーヤーがhitし, かつ手持ちが21以下
        play = d.hit(p.getMark());
        p.setCards(play);
        s.loading();
        }
    } 
    //plyjudge = g.sumJudge(p.getSum(), p.getMark());                           
    plyjudge = p.checkSum();                                                    //プレーヤーの合計値確認
    if(plyjudge && p.getSum() == 21){                                           //プレーヤーの合計値がブラックジャックの場合
        System.out.println("ブラックジャック成功!!!");
        System.out.println(p.getName() + "さんの勝ちです＄");
        
    } else if (plyjudge == false){                                              //プレーヤーの合計値が22以上
        System.out.println(p.getName() + "さんはバーストしました( ﾉД`)");
        System.out.println("ディーラーの勝ち☠");
        
    } else {                                                                    //プレーヤーの合計値が21未満の時
        
        s.loading();                                        
        System.out.println("ディーラーのターン");
        s.loading();
        deal = d.hit(d.getMark());                                              //ディーラーは16以下ならhitし, 17以上ならstand
        d.setCards(deal);                                                       //ディーラーの手札をsetCardsメソッドを使ってd.mycardsに保存
        System.out.println("ディーラーのターン終了");
        dlrjudge = d.checkSum();                                                //ディーラーの合計値確認
        s.loading();
        
        if(dlrjudge && d.getSum() == 21){                                       //ディーラーの合計値がブラックジャックの場合
            System.out.println("ディーラーがブラックジャック成功(゜-゜)");
            System.out.println("ディーラーの勝利☠");
            
        } else if (dlrjudge == false){                                          //ディーラーの合計値が22以上
            System.out.println("ディーラーはバーストしました(*｀艸´)");
            System.out.println(p.getName() + "さんの勝ちです＄");
            
        } else {                                                                //プレーヤー, ディーラー共に21未満
            
            s.loading();
            System.out.println("勝負に入ります");
            s.loading();
            if (plyjudge && dlrjudge){                                          //両者とも21未満である
                if (p.getSum() > d.getSum()){                                   //プレーヤーの値がディーラーの値以上なら勝ち
                    System.out.println(p.getName() + "さんの勝ちです＄");
                    
                } else if (p.getSum() < d.getSum()){
                    System.out.println("ディーラーの勝利☠");                   //ディーラーの値がプレイヤーの値以上なら負け
                    
                } else if (p.getSum() == d.getSum()){                           //値が同じなら引き分け
                    System.out.println("引き分け|дﾟ)!");
                    
                }
            }
        }   
    }
            s.loading();
            System.out.println("「結果」");
            System.out.println("プレーヤーの合計：" + p.getSum());
            System.out.println("ディーラーの合計：" + d.getSum()); 
            
            System.out.println("ディーラーの手札を開示します");
            for (int i = 0; i < d.mycards.size(); i++){
            System.out.print("「" + d.mycards.get(i) + "」");                   //ディーラーの持っている手札の枚数分、値を表示
            }
    }
}