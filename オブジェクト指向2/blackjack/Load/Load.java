/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.Load;

/**
 *
 * @author 8mile_000
 */
public class Load {
        public void loading() throws InterruptedException{      //例外処理としてthrowsで投げかける
        System.out.print("Now Loading");
        for(int i = 0; i < 3; i++){
            System.out.print("♪");      //♪を3つ生成
            Thread.sleep(500);      //指定した時間の長さにわたってスレッドを中断(500ミリ秒間)
            }
        System.out.println("");
        System.out.println("");
        }
}