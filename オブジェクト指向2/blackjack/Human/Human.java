/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.Human;

import java.util.ArrayList;

/**
 *
 * @author 8mile_000
 */
/*Player,Dealerのメソッドに引用するHumanを作成*/
public abstract class Human {                                                   //未完成の為newしてはいけないクラスの宣言。
    public abstract void open();                                                //合計値21以下で1のカードを引いた時の処理
    public abstract void setCards(ArrayList<Integer> cards);                   //手札の配列のサイズまで合計の値を画面に出力させる
    public abstract boolean checkSum();                                        //手札の配列のサイズまで合計の値が21以下または21ならtrue/それ以外ならfalseで返す
                                                                                
    public ArrayList<Integer> mycards;                                          //カードの配列を作成
}