/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camp.basic.Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 8mile_000
 */
public class Task5 extends HttpServlet {
    public static void main(String[]args) {
        String name = "長島 奨";
        System.out.println("文字列の長さは" + name.length()+"です。");
        System.out.println("文字列のバイト数は"+getByteLength("長島 奨", Charset.forName("UTF-8"))+"です。");
        
    }
    

    public static int getByteLength(String string, Charset charset) {
        return string.getBytes(charset).length;
    }
   

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
            /*課題5 自分の氏名について、バイト数と文字数を取得して、表示してください。*/
             String myname=("長島 奨"); 
        out.println("名前"+" "+myname+"<br>");
        out.print("名前の文字数は"+myname.length()+"です。"+"<br>");
        out.print("名前のバイト数は"+myname.getBytes("UTF-8").length+"です。"+"<br>");
        out.println("UTF-8は日本語1文字3バイトです。半角スペースは1バイトで表現されます。");

        /*直接 out.println("長島 奨".getBytes("UTF-8").length); と入力してもバイト数は同じ*/
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
