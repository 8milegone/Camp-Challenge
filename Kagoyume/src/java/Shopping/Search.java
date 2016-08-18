package Shopping;

/*  検索結果ページ
    topから検索により遷移できる。YahooショッピングAPIに直接検索キーワードを渡し、その結果を受け取り＆表示している
    検索キーワード、検索結果数を表示
    縦のリスト型に表示。サムネイルと、その横に商品名、金額が載っている。クリックでitemへ
    結果は上位20件まで
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Kagoyume.YahooAPI;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 8mile_000
 */
public class Search extends HttpServlet {

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
        //セッションスタート
        HttpSession hs = request.getSession();
        //フォームからの入力を取得
        String query = request.getParameter("query");
        try {
            //リクエストパラメータの文字コードを変更
            byte[] byteData = query.getBytes("ISO_8859_1");
            query = new String(byteData, "Shift_JIS");
            
            //検索ワードが空の場合はエラーを表示
            if(query.equals("")) {
                throw new Exception("検索ワードが未入力です");
            }
            
            //Http接続して結果を得る
            String result = YahooAPI.getResult(query);
            
            //文字列からJSONへの変換
            YahooAPI jnode = YahooAPI.getJsonNode(result);
            
            //商品情報をリスト化したShoppingDataに格納
            List<ShoppingData> sdList = new ArrayList<ShoppingData>();
            for(int i = 0; i < jnode.get("ResultSet").get("totalResultsReturned").intValue(); i++) {
                ShoppingData sd = Json.ItemDetail(jnode, i);
                sdList.add(sd);
            }
            
            //検索キーワード・検索結果総数をShoppingDataに格納
            ShoppingData sd = new ShoppingData();
            sd.setTotalResult(jnode.get("ResultSet").get("totalResultsAvailable").textValue());
            sd.setQuery(jnode.get("ResultSet").get("0").get("Result").get("Request").get("Query").textValue());
            
            request.setAttribute("searchResult", sdList);
            request.setAttribute("sd", sd);

            //ログを記録
            Log.getInstance().logtext("searchへ遷移");
            
        request.getRequestDispatcher("/search.jsp").forward(request, response);
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
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

