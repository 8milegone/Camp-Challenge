package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DB_Manage.UserData;
import Origin_Site.JumsHelper;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');
      out.write('\n');

  HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserData ud = (UserData)hs.getAttribute("userdata");
    
    //検索キーワードがnullかを比較
    boolean keyword = false;
    if(request.getAttribute("empty") != null) {
        keyword = true;
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Proposal Your Phone Accessories</title>\n");
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
      out.write("         \n");
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
      out.write("        <p>あなたの機種名は<a href=\"MyData\">");
      out.print(ud.getTerminal());
      out.write("</a>です。</p>\n");
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
      out.write("        \n");
      out.write("        <form action=\"Search_user\" method=\"GET\">     ");
      out.write("\n");
      out.write("        商品キーワード検索<br>\n");
      out.write("        <font color=\"#ff0000\" >※何も記入せずに検索ボタンを押すとエラーが表示されます。</font><br>\n");
      out.write("        <input type=\"text\" name=\"query\" placeholder=\"キーワードを入力\" style=\"width:100px\">\n");
      out.write("        <input type=\"submit\" name=\"btnSubmit\" value=\"検索\" style=\"width:40px\">\n");
      out.write("        </form> \n");
      out.write("        スマホケース\n");
      out.write("        <br><br>\n");
      out.write("        デザインを重視 <a href=\"Search_category_mens\">男性目線</a> <br>\n");
      out.write("                       <a href=\"Search_category_ladys\">女性目線</a> <br>\n");
      out.write("        機能性を重視 <a href=\"Search_category_fanction\">機能性を重視</a> <br>\n");
      out.write("        耐衝撃強度を重視 <a href=\"Search_category_water\">耐防水にこだわる(iPhoneのみ)</a> <br>\n");
      out.write("                         <a href=\"Search_category_protect\">こだわらない</a> <br>\n");
      out.write("        ブランド×コラボ <a href=\"Search_category_apparel\">アパレルブランド</a> <br>\n");
      out.write("                         <a href=\"Search_category_designer\">デザイナーズブランド</a> <br>\n");
      out.write("                         <a href=\"Search_category_character\">キャラクター</a> <br><br>\n");
      out.write("        液晶シート\n");
      out.write("        <br><br>\n");
      out.write("        <a href=\"Search_category_koukoutaku\">綺麗な見栄えを重視</a> <br>\n");
      out.write("        <a href=\"Search_category_antigurea\">操作性や機能性を重視</a> <br>\n");
      out.write("        <a href=\"Search_category_glass\">耐衝撃強度を重視</a> <br><br>\n");
      out.write("        \n");
      out.write("<p>こんなことは経験したことはないでしょうか？<br>\n");
      out.write("スマホを購入したのはいいけど、どんなケース、シートを選べばいいだろう…?<br>\n");
      out.write("ショッピングサイトを見てもたくさん情報があって、よくわからなくなる…<br>\n");
      out.write("よくわからないから、物は試しに買ったら満足するものではなかった…<br>\n");
      out.write("持っている機種に対応していなかった…<br><br>\n");
      out.write("\n");
      out.write("そんな「 あなた 」にこのサイトから是非提案させて下さい！<br>\n");
      out.write("\n");
      out.write("会員登録の際にあなたのスマホの機種名を登録して検索時にあなたの端末に合うアイテムだけを見つけます。<br>\n");
      out.write("また、カテゴリ別に分類されている「こだわり」からあなたに気に入って頂けるアイテムを見つけられる様に一覧で表示します。<br>\n");
      out.write("ご購入の際には、会員登録が必要です。<br><br>\n");
      out.write("\n");
      out.write("★会員登録のメリット★<br>\n");
      out.write("あなたの持っているスマホの機種名と検索条件を保存することが可能です。<br>\n");
      out.write("簡単に条件にあったアイテムを探すことができます。<br>\n");
      out.write("</p>        \n");
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
