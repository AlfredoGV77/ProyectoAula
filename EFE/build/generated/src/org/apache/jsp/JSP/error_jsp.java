package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class error_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ERROR FATAL</title>\n");
      out.write("        <link href=\"../CSS/error.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"../img/efeicon.ico\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("        <body>\n");
      out.write("\n");
      out.write("        <div class=\"text\"><p>404</p></div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("          <!-- caveman left -->\n");
      out.write("          <div class=\"caveman\">\n");
      out.write("            <div class=\"leg\">\n");
      out.write("              <div class=\"foot\"><div class=\"fingers\"></div></div>      \n");
      out.write("            </div>\n");
      out.write("            <div class=\"leg\">\n");
      out.write("              <div class=\"foot\"><div class=\"fingers\"></div></div>      \n");
      out.write("            </div>\n");
      out.write("            <div class=\"shape\">\n");
      out.write("              <div class=\"circle\"></div>\n");
      out.write("              <div class=\"circle\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"head\">\n");
      out.write("              <div class=\"eye\"><div class=\"nose\"></div></div>\n");
      out.write("              <div class=\"mouth\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"arm-right\"><div class=\"club\"></div></div>    \n");
      out.write("          </div>\n");
      out.write("          <!-- caveman right -->\n");
      out.write("          <div class=\"caveman\">\n");
      out.write("            <div class=\"leg\">\n");
      out.write("              <div class=\"foot\"><div class=\"fingers\"></div></div>      \n");
      out.write("            </div>\n");
      out.write("            <div class=\"leg\">\n");
      out.write("              <div class=\"foot\"><div class=\"fingers\"></div></div>      \n");
      out.write("            </div>\n");
      out.write("            <div class=\"shape\">\n");
      out.write("              <div class=\"circle\"></div>\n");
      out.write("              <div class=\"circle\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"head\">\n");
      out.write("              <div class=\"eye\"><div class=\"nose\"></div></div>\n");
      out.write("              <div class=\"mouth\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"arm-right\"><div class=\"club\"></div></div>    \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- //////////////// CREDIT //////////////// -->\n");
      out.write("        <a href=\"https://codepen.io/SofiaSergio/\" target=\"_blank\">\n");
      out.write("          <div id=\"link\">\n");
      out.write("            <i class=\"fab fa-codepen\"></i>\n");
      out.write("            <p>watch other pens</p>\n");
      out.write("          </div>\n");
      out.write("        </a>\n");
      out.write("\n");
      out.write("        </body>    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
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
