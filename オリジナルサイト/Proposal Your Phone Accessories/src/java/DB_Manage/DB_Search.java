/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 8mile_000
 */
public class DB_Search extends HttpServlet {

    
    /*検索する際に必要なradioボタン参照データ*/
    public static DB_Search getInstance(){
        return new DB_Search();
    }
    
    public String exType(int i){
        switch(i){
            case 1:
                return "ケース";
            case 2:
                return "液晶シート";
        }
        return "";
    }
    
    public String exTypeCase1(int i){
        switch(i){
            case 1:
                return "デザインを重視";
            case 2:
                return "機能性を重視";
            case 3:
                return "耐衝撃強度を重視";
            case 4:
                return "ブランド×コラボ";
        }
        return "";
    }    
    
    public String exTypeCase2(int i){
        switch(i){
            case 1:
                return "男性目線";
            case 2:
                return "女性目線";
            case 3:
                return "耐防水にこだわる(iPhoneのみ)";
            case 4:
                return "こだわらない";
            case 5:
                return "アパレルブランド";
            case 6:
                return "デザイナーズブランド";
            case 7:
                return "キャラクター";
        }
        return "";
    }    
    
    public String exTypeSheet(int i){
        switch(i){
            case 1:
                return "綺麗な見栄えを重視";
            case 2:
                return "操作性や機能性を重視";
            case 3:
                return "耐衝撃強度を重視";
        }
        return "";
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/db_search.jsp").forward(request, response);
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
