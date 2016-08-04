package jums;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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
        
        //セッションスタート
        HttpSession session = request.getSession();
        UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
        /*課題3 セッションにudbのデータも参照する*/
        
        try{
            /*課題2 直リンク防止の処理 セッションに格納する文字コードをUTF-8に変更直リンクを防ぐ為
            "accesschk"を作成しnullまたは"ac"から情報を得られなければ"不正なアクセス"と表記する*/
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }

            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく(課題3 で作成したUserDataBeans udbの各値をDTOへ格納)
            UserDataDTO userdata = new UserDataDTO();                           //課題6 現在時間でDBに格納されているので修正
            userdata.setName(udb.getName());
            
            
            Calendar birthday = Calendar.getInstance();                         //Calendar型のインスタンス取得
            int year = Integer.parseInt(udb.getYear());
            int  month= Integer.parseInt(udb.getMonth());
            int day = Integer.parseInt(udb.getDay());
            month= month-1;                                                     //正しい生まれ月を記録するため、フォームに入力された値から１を引いてからJavaBeansオブジェクトに格納
            birthday.set(year, month, day);                                 
            
            userdata.setBirthday(birthday.getTime());                           //int型からDate型へ値変換したのを格納
            userdata.setType(udb.getType());
            userdata.setTell(udb.getTell());
            userdata.setComment(udb.getComment());
            
            //DBへデータの挿入
            UserDataDAO .getInstance().insert(userdata);
            
            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);   //ここまではセッションの情報は必要
            //課題7 セッションのクリア 
            //MVCからこの段階でクリアにして後はinsertresult.jspへ出力も行ったのでこの箇所を指定。
            //今回破棄するセッションは①直リンク防止用の"ac"と②データ自体を格納していた"udb"の2つ
            session.invalidate();
        }catch(Exception e){
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
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
