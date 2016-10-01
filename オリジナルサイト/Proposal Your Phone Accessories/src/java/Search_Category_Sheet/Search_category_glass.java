/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search_Category_Sheet;

import DB_Manage.UserData;
import Origin_Site.ItemDataclass;
import Origin_Site.JsonParse;
import Origin_Site.Log;
import Origin_Site.YahooAPI;
import Origin_Site.YahooURL;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 長島 奨
 */
public class Search_category_glass extends HttpServlet {

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
        //セッションスタート
        HttpSession hs = request.getSession();
        try {
            //検索ページの取得
            int page = 1;
            if(request.getParameter("page") != null){
                page = Integer.parseInt(request.getParameter("page"));
            
            }
              UserData ud = (UserData)hs.getAttribute("userdata");
            if(ud != null){    
                String query = ud.getTerminal();
                String category = "";
                String keyword = "耐衝撃強度を重視";
                System.out.println("検索対象の機種は"+query+"です。");
                
                /*URLにカテゴリー値を代入する*/
                if(query.equals("iPhone6s iPhone6")){
                   category = "38374";
                   query ="iPhone6s 強化ガラス";
                 }else if(query.equals("iPhone6s Plus iPhone6 Plus")){
                        category = "38374";
                        query ="iPhone6s Plus 強化ガラス";
                    }else if(query.equals("iPhoneSE iPhone5s")){
                            category = "38374"; 
                            query ="iPhoneSE 強化ガラス";
                        }else if(query.equals("Xperia X Performance SO-04H")){
                               category = "38375";
                               query ="SO-04H 強化ガラス";
                            }else if(query.equals("AQUOS ZETA SH-04H")){
                                   category = "38379";
                                   query="SH-04H 強化ガラス";
                                }else if(query.equals("Galaxy S7 edge SC-02H")){
                                       category = "38376";
                                       query="SC-02H 強化ガラス";
                                    }
            //検索結果の取得(Jsonへ変換)
                String json_true = YahooAPI.getResult(YahooURL.querySearch_user(query,category,(page - 1) * 20));    
            //json文字列をパースしItemDataが入った配列を取得
                    JsonParse jp = new JsonParse(json_true);
                    int totalresults = jp.getTotalResults();
                    System.out.println(totalresults);
                    ArrayList<ItemDataclass> array = jp.Parse_keywordsearch();
                    String search_method = "Search_category_glass";
                    
                    request.getSession().setAttribute("query", query);
                    request.getSession().setAttribute("page", page);
                    request.getSession().setAttribute("search_method", search_method);
                    
                    
                    request.setAttribute("searchresults", array);
                    request.setAttribute("keyword", keyword);
                    request.setAttribute("query",query);
                    request.setAttribute("page", page);
                    request.setAttribute("totalresults", totalresults);
                    request.setAttribute("search_method",search_method);
                    
                    //ログを記録
                    Log.getInstance().logtext("search_categoryへ遷移しました。");
            
                    request.getRequestDispatcher("/search_category.jsp").forward(request, response);
            }else{
                String query = "強化ガラス";
                String category = "38333";
                String keyword = "耐衝撃強度を重視";
                System.out.println("検索対象の機種は未設定です。");
                
            //検索結果の取得(Jsonへ変換)
                String json_true = YahooAPI.getResult(YahooURL.querySearch_user(query,category,(page - 1) * 20));    
            //json文字列をパースしItemDataが入った配列を取得
                    JsonParse jp = new JsonParse(json_true);
                    int totalresults = jp.getTotalResults();
                    System.out.println(totalresults);
                    ArrayList<ItemDataclass> array = jp.Parse_keywordsearch();
                    String search_method = "Search_category_glass";
                    
                    request.getSession().setAttribute("keyword", keyword);
                    request.getSession().setAttribute("query", query);
                    request.getSession().setAttribute("page", page);
                    request.getSession().setAttribute("search_method", search_method);
                    
                    request.setAttribute("searchresults", array);
                    request.setAttribute("keyword", keyword);
                    request.setAttribute("query",query);
                    request.setAttribute("page", page);
                    request.setAttribute("totalresults", totalresults);
                    request.setAttribute("search_method",search_method);
                    
                    //ログを記録
                    Log.getInstance().logtext("search_categoryへ遷移しました。");
            
                    request.getRequestDispatcher("/search_category.jsp").forward(request, response);
            }
            
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
