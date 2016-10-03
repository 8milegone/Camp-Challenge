package Search_Category_Case;

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
 * カテゴリー【価格指定】
 * @author 長島 奨
 */
public class Search_category_case_price extends HttpServlet {

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
                String fromprice = request.getParameter("fromprice");
                String toprice = request.getParameter("toprice");
                System.out.println("検索対象の機種は"+query+"です。");
                
                /*URLにカテゴリー値を代入する*/
                if(query.equals("iPhone6s iPhone6")){
                   category = "38369";
                 }else if(query.equals("iPhone6s Plus iPhone6 Plus")){
                        category = "38368";
                    }else if(query.equals("iPhoneSE Phone5s")){
                            category = "38370";
                        }else if(query.equals("Xperia X Performance SO-04H")){
                               category = "38358";
                               query ="SO-04H";
                            }else if(query.equals("AQUOS ZETA SH-04H")){
                                   category = "38379";
                                   query="SH-04H";
                                }else if(query.equals("Galaxy S7 edge SC-02H")){
                                       category = "38376";
                                       query="SC-02H";
                                    }
            //検索結果の取得(Jsonへ変換)
                String json_true = YahooAPI.getResult(YahooURL.priceSearch_user(query,category,fromprice,toprice,(page - 1) * 20));    
            //json文字列をパースしItemDataが入った配列を取得
                    JsonParse jp = new JsonParse(json_true);
                    int totalresults = jp.getTotalResults();
                    System.out.println(totalresults);
                    ArrayList<ItemDataclass> array = jp.Parse_keywordsearch();
                    String search_method = "Search_category_case_price";
                    
                    request.getSession().setAttribute("query", query);
                    request.getSession().setAttribute("page", page); 
                    request.getSession().setAttribute("fromprice", fromprice);
                    request.getSession().setAttribute("toprice", toprice);
                    request.getSession().setAttribute("search_method", search_method);
                    
                    request.setAttribute("searchresults", array);
                    request.setAttribute("query",query);
                    request.setAttribute("page", page);
                    request.setAttribute("totalresults", totalresults);
                    request.setAttribute("fromprice",fromprice+"円 ～");
                    request.setAttribute("toprice", toprice+"円");
                    request.setAttribute("search_method",search_method);
                    
                    //ログを記録
                    Log.getInstance().logtext("search_priceへ遷移しました。");
            
                    request.getRequestDispatcher("/search_price.jsp").forward(request, response);
            }else{
                String query = "";
                String category = "38347";
                String fromprice = request.getParameter("fromprice");
                String toprice = request.getParameter("toprice");
                System.out.println("検索対象の機種は未設定です。");
                
            //検索結果の取得(Jsonへ変換)
                String json_true = YahooAPI.getResult(YahooURL.priceSearch_user(query,category,fromprice,toprice,(page - 1) * 20));    
            //json文字列をパースしItemDataが入った配列を取得
                    JsonParse jp = new JsonParse(json_true);
                    int totalresults = jp.getTotalResults();
                    System.out.println(totalresults);
                    ArrayList<ItemDataclass> array = jp.Parse_keywordsearch();
                    String search_method = "Search_category_case_price";
                    
                    
                    request.getSession().setAttribute("query", query);
                    request.getSession().setAttribute("page", page);
                    request.getSession().setAttribute("fromprice", fromprice);
                    request.getSession().setAttribute("toprice", toprice);
                    request.getSession().setAttribute("search_method", search_method);
                    
                    
                    request.setAttribute("searchresults", array);
                    request.setAttribute("query",query);
                    request.setAttribute("page", page);
                    request.setAttribute("totalresults", totalresults);
                    request.setAttribute("fromprice",fromprice+"円 ～");
                    request.setAttribute("toprice", toprice+"円");
                    request.setAttribute("search_method",search_method);
                    
                    //ログを記録
                    Log.getInstance().logtext("search_priceへ遷移しました。");
            
                    request.getRequestDispatcher("/search_price.jsp").forward(request, response);
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
