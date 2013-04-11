package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class IndividualResult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Individual Result</title>\n");
      out.write("    <script src=\"http://code.jquery.com/jquery-1.9.1.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        google.load(\"visualization\", \"1\", {packages: [\"corechart\"]});\n");
      out.write("        google.setOnLoadCallback(drawChart);\n");
      out.write("        function drawChart() {\n");
      out.write("            var data = google.visualization.arrayToDataTable([\n");
      out.write("                ['Month', 'Bugs'],\n");
      out.write("                ['Jan', ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${first}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("],\n");
      out.write("                ['Feb', ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${second}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("],\n");
      out.write("                ['Mar', ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${third}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("],\n");
      out.write("                ['Apr', ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fourth}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("]\n");
      out.write("            ]);\n");
      out.write("            var options = {\n");
      out.write("                title: 'Company Performance',\n");
      out.write("                hAxis: {title: 'Year', titleTextStyle: {color: 'red'}}\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));\n");
      out.write("            chart.draw(data, options);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function searchPeople(input) {\n");
      out.write("            $.ajax({\n");
      out.write("                        url: 'searchPeople',\n");
      out.write("                        data: ({\n");
      out.write("                            keyword: input\n");
      out.write("                        }),\n");
      out.write("                        success: function (data) {\n");
      out.write("                            alert(data);\n");
      out.write("                            var arrs = data.split(',');\n");
      out.write("                            for (var i = 0; i < arrs.length; i++) {\n");
      out.write("                                var link = $('<a href=\"handleIndividual?name=' + arrs[i] + '\" id=\"' +\n");
      out.write("                                        arrs[i] + '_link\"><div class=\"btnText\">' + arrs[i] + '</div></a>');\n");
      out.write("                                $('body').append(link);\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("            )\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("name : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" <br>\n");
      out.write("score : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${score}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" <br>\n");
      out.write("<a href=\"home\">Back to homepage</a>\n");
      out.write("\n");
      out.write("<div id=\"chart_div\" style=\"width: 900px; height: 500px;\"></div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
