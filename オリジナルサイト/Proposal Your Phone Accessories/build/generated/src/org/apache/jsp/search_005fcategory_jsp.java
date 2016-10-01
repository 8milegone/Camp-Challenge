package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DB_Manage.UserData;
import Origin_Site.ItemDataclass;
import java.util.ArrayList;
import Origin_Site.JumsHelper;

public final class search_005fcategory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
 HttpSession hs = request.getSession(); 
   JumsHelper jh = JumsHelper.getInstance();
   ArrayList<ItemDataclass> array = (ArrayList<ItemDataclass>)request.getAttribute("searchresults");
   
    //ログインのチェック
    boolean loginChk = false;   
    UserData ud = (UserData)hs.getAttribute("userdata");
    if(ud != null) {
        loginChk =true;
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>検索結果ページ</title>\n");
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
      out.write("</a>対応のアイテムのみをカテゴリー検索から表示しています。</p>\n");
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
      out.write("        <h4>商品検索結果</h4>\n");
      out.write("        ");
      out.write("\n");
      out.write("        検索件数; ");
      out.print(request.getAttribute("totalresults"));
      out.write("件<br>\n");
      out.write("                       ");
if(request.getAttribute("keyword")!=null){
      out.write("\n");
      out.write("                                    ");
 out.print("カテゴリー; "+request.getAttribute("keyword"));}
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
      out.write("        <br><br>\n");
      out.write("        <table border=\"1\">    ");
      out.write("\n");
      out.write("        <tr>\n");
      out.write("        <th>サムネイル</th>\n");
      out.write("        <th>商品名</th>\n");
      out.write("        <th>価格</th>\n");
      out.write("        </tr>\n");
      out.write("        ");
 for (int i = 0; i < 20; i++) { 
      out.write(' ');
      out.write(' ');
      out.write("\n");
      out.write("        ");
ItemDataclass item = (ItemDataclass)array.get(i);
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <td><a href=\"Item?itemcode=");
      out.print(item.getItemcode() );
      out.write("\"><img src=\"");
      out.print(item.getImageurl() );
      out.write("\"></a></td>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <td><a href=\"Item?itemcode=");
      out.print(item.getItemcode() );
      out.write('"');
      out.write('>');
      out.print(item.getName() );
      out.write("</a></td>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <td>    ");
      out.print(item.getPrice() );
      out.write("円     </td>\n");
      out.write("            </tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </table>\n");
      out.write("        ");
      out.print(jh.home());
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
