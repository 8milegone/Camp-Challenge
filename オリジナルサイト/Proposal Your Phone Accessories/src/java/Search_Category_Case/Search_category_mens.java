/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * カテゴリー【男性目線】
 * @author 長島 奨
 */
public class Search_category_mens extends HttpServlet {

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
              //ユーザー情報から機種名(terminal)を取得
//                UserData ud = new UserData();
//            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
//                UserDataDTO udd = new UserDataDTO();
//                ud.UDB2DTOMapping(udd);
//            
//            //UserDAOからUserSearch()メソッドを利用
//                UserDataDTO user = UserDataDAO.getInstance().UserSearch(udd);
//            //View用のパラメータにマッピング(DTO→UserData)
//                UserData userdata = new UserData();
//                userdata.DTOUD2Mapping(user);
//            
//            //セッションに値をセット
//                hs.setAttribute("userdata", userdata);
//                System.out.println("Session update!!");
            //ログイン情報から機種名を取得    
                String query = ud.getTerminal();
                String category = "";
                System.out.println("検索対象の機種は"+query+"です。");
                
                /*URLにカテゴリー値を代入する*/
                if(query.equals("iPhone6s iPhone6")){
                   category = "38369";
                 }else if(query=="iPhone6s Plus iPhone6 Plus"){
                        category = "38368";  
                    }else if(query=="iPhoneSE Phone5s"){
                            category = "38370";    
                        }else if(query=="Xperia X Performance SO-04H"){
                               category = "38358";   
                            }else if(query=="AQUOS ZETA SH-04H"){
                                   category = "38379";
                                }else if(query=="Galaxy S7 edge SC-02H"){
                                       category = "38376";
                                    }else if(query==""){
                                         category = "38347";    //機種名がなければスマホアクセサリー全体のIDを代入する
                                        }
                /*URLに機種名を代入する(Andoroidの場合のみ)*/
                if(query=="Xperia X Performance SO-04H"){
                        query ="SO-04H ";
                    }else if(query=="AQUOS ZETA SH-04H"){
                            query="SH-04H";
                        }else if(query=="Galaxy S7 edge SC-02H"){
                                query="SC-02H";
                            }else{
                                  query="";
                              }
            //検索結果の取得(Jsonへ変換)
                String json_true = YahooAPI.getResult(YahooURL.querySearch_user(query,category,(page - 1) * 20));    
            //json文字列をパースしItemDataが入った配列を取得
                    JsonParse jp = new JsonParse(json_true);
                    int totalresults = jp.getTotalResults();
                    System.out.println(totalresults);
                    ArrayList<ItemDataclass> array = jp.Parse_keywordsearch_mens();
            
                    request.setAttribute("searchresults", array);
            
                    request.getSession().setAttribute("query", query);
                    request.getSession().setAttribute("page", page);                        
                    request.setAttribute("query",query);
                    request.setAttribute("page", page);
                    request.setAttribute("totalresults", totalresults);
                    
                    //ログを記録
                    Log.getInstance().logtext("search_categoryへ遷移しました。");
            
                    request.getRequestDispatcher("/serach_category.jsp").forward(request, response);
 
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
