/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camp.basic.Task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 8mile_000
 */
public class Task8 extends HttpServlet {

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
            /*課題8 ファイルに自己紹介を書き出し、保存してください。*/
            String name ="/Users/8mile_000/C/soeda_origin/開発/開発- JAVA/Java standard class/filename.txt";
            FileWriter filename = new FileWriter(name);     //ファイル出力用としてインスタンス化
            BufferedWriter bw = new BufferedWriter(filename);       //PrintWriterを作成する為BufferedWriterのオブジェクトを利用する
            PrintWriter write = new PrintWriter(bw);        //PrintWriterをインスタンス化
                                                            //これにより文字列だけではなく、int型やboolean型の値もそのまま出力するように記述することが可能
            write.println("私の名前は長島 奨です。");       //printlnで記入することにより
            write.println("生年月日は1987年9月20日です。");
            write.println("プログラミングの経験はありませんが、頑張って覚えていってます。");
            write.close();
            out.println("1:書き込みが完了しました");
            
            FileWriter tuiki = new FileWriter(name,true);       //追記をする為、FileWriterを新しくインスタンス化
            tuiki.write("よろしくお願いします。");              //PrintWriterではない為、改行なし
            tuiki.close();
            out.println("2:追記を完了しました。");
            
            
        } finally {
            out.close();
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
