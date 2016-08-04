package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertconfirm.jspと対応するサーブレット
 * フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {

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
        try{
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");
//            session.setAttribute("bc", (int) (Math.random() * 1000));           /*課題2 直リンク防止の処理 inserresultへの直リンクを防ぐ為にsetAttributeで"bc"(int)を設置
//課題2 にて"bc"を新しく作成して引用していましたが、"ac"で持ち回りできるので省略  insert.jspからInsertResult.javaへアクセスした段階でランダム変数の"bc"を与えることにより
//                                                                                その後のinsertresultへの直リンク防止の処理につながる*/
            
            /*セッションに格納する文字コードをUTF-8に変更直リンクを防ぐ為
            "accesschk"を作成しnullまたは"ac"から情報を得られなければ"不正なアクセス"と表記する*/
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            //フォームからの入力を取得
            String name = request.getParameter("name");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            
            int type = 0;                                                       //課題4 typeをStringのままで取得すると、どうしてもnullで取得されてしまい
            if (request.getParameter("type") == null){                          //課題4のtypeに対する項目でエラーになるのでnullからtype=0へ変換されるように
                type = 0;                                                       //しています。
            }else {
                type = Integer.parseInt(request.getParameter("type"));
            }
            String tell = request.getParameter("tell");
            String comment = request.getParameter("comment");
            
            

            //セッションに格納                                                  //課題3 にて作成したUserDataBeans("udb")より不要になったので省略
//            session.setAttribute("name", name);
//            session.setAttribute("year", year);
//            session.setAttribute("month",month);
//            session.setAttribute("day", day);
//            session.setAttribute("type", type);
//            session.setAttribute("tell", tell);
//            session.setAttribute("comment", comment);
//            System.out.println("Session updated!!");
            
            //UserDataBeansのインスタンスを生成                                 //課題3 フォームから取得できた値をUserDataBeansへ
            UserDataBeans udb = new UserDataBeans();                            //格納していく
            udb.setName(name);
            udb.setYear(year);
            udb.setMonth(month);
            udb.setDay(day);
            udb.setType(type);
            udb.setTell(tell);
            udb.setComment(comment);
            
            System.out.println("name;"+udb.getName());
            System.out.println("udb;"+udb.getType());
            
           session.setAttribute("udb",udb);                                     //課題3 HttpSessionにudbオブジェクトを"udb"として参照していく 
            
            request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
        }catch(Exception e){
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
