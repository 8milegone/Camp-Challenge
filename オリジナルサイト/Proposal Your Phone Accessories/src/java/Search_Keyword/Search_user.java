package Search_Keyword;

/*  ユーザーがキーワード検索する事により得られる情報結果
    検索キーワード、検索結果数を表示
    縦のリスト型に表示。サムネイルと、その横に商品名、金額が載っている。クリックでitemへ
    結果は上位20件まで
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
 * キーワード検索
 * @author 長島 奨
 */
public class Search_user extends HttpServlet {
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
        //フォームからの入力を取得
        try {
            //検索ワードが空の場合はエラーを表示
            String query = request.getParameter("query");
            if(query.equals("")) {
                throw new Exception("検索ワードが未入力です");
            }
            
            //検索ページの取得
            int page = 1;
            if(request.getParameter("page") != null){
                page = Integer.parseInt(request.getParameter("page"));
            }
            
            //検索結果の取得(Jsonへ変換)
            String json = YahooAPI.getResult(YahooURL.querySearch_main(query, (page - 1) * 20));
            
            //json文字列をパースしItemDataが入った配列を取得
            JsonParse jp = new JsonParse(json);
            int totalresults = jp.getTotalResults();
            System.out.println(totalresults);
            ArrayList<ItemDataclass> array = jp.getItemSearchResult_query();
            
            request.setAttribute("searchresults", array);
            
            request.getSession().setAttribute("query", query);
            request.getSession().setAttribute("page", page);                        
            request.setAttribute("query",query);
            request.setAttribute("page", page);
            request.setAttribute("totalresults", totalresults);
                        
           //ログを記録
            Log.getInstance().logtext("search_keywordへ遷移しました。");
            
            request.getRequestDispatcher("/search_keyword.jsp").forward(request, response);
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
