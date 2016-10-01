package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Origin_Site.ItemDataclass;
import java.util.ArrayList;
import DB_Manage.UserData;
import Origin_Site.JumsHelper;

public final class item_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    JumsHelper jh = JumsHelper.getInstance();
    //ログインのチェック
    boolean loginChk = false;
    HttpSession hs = request.getSession();
    ItemDataclass item = (ItemDataclass)hs.getAttribute("itemdata"); 
    UserData ud = (UserData)hs.getAttribute("userdata");
    if(ud != null) {
        loginChk =true;
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>商品詳細ページ</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h4>スマホアイテム提案サイト Proposal Your Phone Accessories  </h4>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
if(hs.getAttribute("userdata") == null) {
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <p>全機種での該当アイテムを表示しています。</p>\n");
      out.write("        <p>会員登録から『あなたの機種』を登録すると『あなたの機種』に対応するアイテムのみを表示できます。</p>\n");
      out.write("        ");
      out.print(jh.login());
      out.write("<br>");
      out.write("\n");
      out.write("        ");
      out.print(jh.register());
      out.write("<br>");
      out.write("\n");
      out.write("        ");
      out.print(jh.cart());
      out.write("<br>");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
 }else { 
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <p>ようこそ <a href=\"MyData\">");
      out.print(ud.getName());
      out.write("</a> さん</p>\n");
      out.write("        <p>");
      out.print(ud.getName());
      out.write("さんの<a href=\"MyData\">");
      out.print(ud.getTerminal());
      out.write("</a>対応のアイテムのみをカテゴリー検索から表示しました。</p>\n");
      out.write("        \n");
      out.write("        ");
      out.print(jh.logout());
      out.write("<br>\n");
      out.write("        ");
      out.print(jh.cart());
      out.write("\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <HR>\n");
      out.write("        <form action=\"Search_user\" method=\"GET\">     ");
      out.write("\n");
      out.write("        商品キーワード検索<br>\n");
      out.write("        <font color=\"#ff0000\" >※何も記入せずに検索ボタンを押すとエラーが表示されます。</font><br>\n");
      out.write("        <input type=\"text\" name=\"query\" placeholder=\"キーワードを入力\" style=\"width:100px\">\n");
      out.write("        <input type=\"submit\" name=\"btnSubmit\" value=\"検索\" style=\"width:40px\">\n");
      out.write("        </form><br>\n");
      out.write("                       ");
if(hs.getAttribute("keyword")!=null){
      out.write("\n");
      out.write("                                    ");
 out.print("カテゴリー; "+hs.getAttribute("keyword"));}
      out.write("\n");
      out.write("                       ");
if(hs.getAttribute("fromprice")!=null){
      out.write("                 \n");
      out.write("                                    ");
out.print("コストパフォーマンス重視を重視; "+hs.getAttribute("fromprice"));}
      out.write("\n");
      out.write("                       ");
if(hs.getAttribute("toprice")!=null){
      out.write("    \n");
      out.write("                                    ");
out.print(hs.getAttribute("toprice"));}
      out.write("\n");
      out.write("            \n");
      out.write("            <p>");
if(item.getHeadline()!=null){item.getHeadline();}
      out.write("</p>\n");
      out.write("            <h3 style=\"margin:1px\">");
      out.print(item.getName());
      out.write("</h3><br>\n");
      out.write("            <div style=\"font-size:small;margin-top:-1.5% \">");
      out.print(item.getStorename());
      out.write("</div>\n");
      out.write("            <div>レビュー評価☆:");
      out.print(item.getFavorite() );
      out.write('/');
      out.print(item.getReviewer());
      out.write("件のカスタマーレビュー</div>\n");
      out.write("            <h3 style=\"margin:1px\">価格:  ¥ ");
      out.print(item.getPrice());
      out.write("</h3><br>\n");
      out.write("            <form action=\"Add\" method=\"post\">            \n");
      out.write("                個数:<input type=\"number\" name=\"qty\" value=\"1\" style=\"width: 3em\">個\n");
      out.write("                <input type=\"hidden\" name=\"ac\" value=\"");
      out.print(hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("                <button type=\"submit\" name=\"cartin\">カートに入れる</button>\n");
      out.write("            </form>\n");
      out.write("            <br>\n");
      out.write("            <img src=\"");
      out.print(item.getBigimageurl() );
      out.write("\"/><br>\n");
      out.write("             \n");
      out.write("            <div style=\"a{pointer-events: none}\">\n");
      out.write("                <p>");
      out.print(item.getCaption());
      out.write("</p>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <br><br>\n");
      out.write("            <a href=\"Search_user?query=");
      out.print(hs.getAttribute("query"));
      out.write("&page=");
      out.print(hs.getAttribute("page"));
      out.write("\">検索結果に戻る(キーワード検索)</a><br>\n");
      out.write("            <a href=\"");
hs.getAttribute("search_method");
      out.write("?query=");
      out.print(hs.getAttribute("query"));
      out.write("&page=");
      out.print(hs.getAttribute("page"));
      out.write("\">検索結果に戻る(カテゴリー検索)</a><br>\n");
      out.write("            <a href=\"top.jsp\">トップページへ戻る</a>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
