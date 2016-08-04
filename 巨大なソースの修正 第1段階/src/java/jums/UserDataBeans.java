/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.sql.Timestamp;
import java.util.Date;

/**
 *課題3 フォームから受け取ったデータ自体を格納できるJavaBeans(UserDataBeans.java)
 *を作成し、これを利用して表示や分岐などをさせなさい
 * 
 * 入力されたデータ自体を格納することができる。
 * これにより今後、データ自体(値など)になんらかしらの情報を修正したり追加する際に
 * 各データからコードの修正をしなくても良いので、作業がしやすくなる。
 * 
 */
public class UserDataBeans {                                                   /*受け取るデータはInsertConfirm.javaから*/
    private String name;                                                        /*①name*/
    private String year;                                                        /*②year*/
    private String month;                                                       /*③month*/
    private String day;                                                         /*④day*/
    private int type;                                                           /*⑤type　課題4 String型からint型へ修正*/
    private String tell;                                                        /*⑥tell*/
    private String comment;                                                     /*⑦comment
                                                                                    の計7つなのでクラスを宣言*/
    
    public UserDataBeans(){
        this.name = "";
        this.year = "";
        this.month = "";
        this.day = "";
        this.type = 0;                                                          /*課題4 String型からint型へ修正の為に0を初期値にしています。*/
        this.tell = "";
        this.comment = "";
    } 
    
 //入力されたデータ自体を格納させる為に、①～⑦までの値を取得できるようにする 
 //フィールドに値を入れるset フィールドの値を取得するget を作成
    
    public void setName(String name){                                           
        this.name = name;
}
    public String getName(){
        return name;
    }

    public void setYear(String Year){
        this.year = Year;
}
    public String getYear(){
        return year;
    }
    
    public void setMonth(String month){
        this.month = month;
}
    public String getMonth(){
        return month;
    }
    
    public void setDay(String day){
        this.day = day;
    }
    public String getDay(){
        return day;
    }
    
    public void setType(int type){                                              //課題4 String型からint型へ修正
        this.type = type;                                                       //insertconfirm.jspにてnullの値をint=0で受け取りができるようにしています。
    }

    public int getType(){
        return type;
    }
    
    public void setTell(String tell){
        this.tell = tell;

    }
    public String getTell(){
        return tell;
    }
    
    public void setComment(String comment){
        this.comment = comment;
    }
    public String getComment(){
        return comment;
    }
}
