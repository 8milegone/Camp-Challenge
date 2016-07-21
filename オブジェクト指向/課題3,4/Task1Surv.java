/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.geek.jpb.java;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.geek.job.camp.Task1;

/**
 *
 * @author 8mile_000
 */





public class Task1Surv extends HttpServlet {
    public int num1;      //①2つの変数を作成するメソッドの作成
    public int num2;
    
    public void data(){
        this.num1=8;        //②作成したnum1,num2の値を設定するメソッドの作成
        this.num2=10;
    }
    
    public void print(PrintWriter out){
         out.println(this.num1);     //③作成したnum1,num2を書き出すメソッドの作成
         out.println(this.num2);
    }

/*public class Remake extends Task1Surv{      //④作成したTaskSurvのクラスをRemakeというクラスへ継承
    public void clear(){        //④作成したRemakeでTaskSurvから取得したnum1,num2の値をリセット
        this.num1=0;
        this.num2=0;
    }    
}
*/
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                this.data();
                this.print(out);

            //取組2 課題の項目をすべてpublicで表現はしていませんが、javaクラスからサーブレットで表現するように取り組んでみました。   
            /*int num3=0;     //javaクラスで作成したhensuu1に代入する値を指定
            int num4=5;     //javaクラスで作成したhensuu2に代入する値を指定
            Task1 task1 = new Task1();      //javaクラスTask1を元に変数をtask1として作成
            Task1 task2 = new Task1();      //javaクラスTask1を元に変数をtask2として作成
            task1.setHensuu1(num3);     //javaクラスで作成したHensuu1(hensuu1)にnum1を代入する
            task2.setHensuu2(num4);     //javaクラスで作成したHensuu2(hensuu2)にnum1を代入する
                    //setを使用して代入*/
            
            
        
        //取組2 課題の項目をすべてpublicで表現はしていませんが、javaクラスからサーブレットで表現するように取り組んでみました。            
//            out.println(task1.hensuu1);     //作成したhensuu1の出力を指示
//            out.println(task2.hensuu2);     //作成したhensuu2の出力を指示
        }  catch(Exception e) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
