/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.geek.job.camp;

/**
 *
 * @author 8mile_000
 */
//取組2 課題の項目をすべてpublicで表現はしていませんが、javaクラスからサーブレットで表現するように取り組んでみました。
public class Task1 {        //publicのクラスを作成
    public int hensuu1;     //2つの変数を作成
    public int hensuu2;
    
    public void setHensuu1(int hensuu1){        //Hensuu1に作成したhensuu1を呼び出す。
        this.hensuu1=hensuu1;
    }
    public void setHensuu2(int hensuu2){        //Hensuu2に作成したhensuu2を呼び出す。
        this.hensuu2=hensuu2;
    }  
   
}
/*public class ObjectOriented {
    public int a = 100;
    public int b = 70;
    
    public void data(){
        this.a=3;
        this.b=5;
    }
    
    public void print(PrintWriter out){
        
        out.println(this.a);
        out.println(this.b);
        
    }
    
}*/
