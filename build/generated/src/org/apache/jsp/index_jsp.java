package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("        <title>SIMULADOR DE BRASILEIRAO</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("\n");
      out.write("                background-image: url('estadio.jpg');\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size:125%;\n");
      out.write("                bottom: 0;\n");
      out.write("                color: black;\n");
      out.write("                left: 0;\n");
      out.write("                overflow: auto;\n");
      out.write("                padding: 0em;\n");
      out.write("                position: absolute;\n");
      out.write("                right: 0;\n");
      out.write("                text-align: center;\n");
      out.write("                top: 0;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #imagem{\n");
      out.write("                position : relative;\n");
      out.write("                left: 0%;\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size:100%;\n");
      out.write("                height: 100%;\n");
      out.write("                width: 100%;\n");
      out.write("                top:0;\n");
      out.write("                opacity: 1;\n");
      out.write("            }\n");
      out.write("            h1{\n");
      out.write("                background-color: white;\n");
      out.write("                color:darkblue;\n");
      out.write("                font-family: verdana;\n");
      out.write("                font-size: 300%;\n");
      out.write("                border: 1px solid black;\n");
      out.write("                margin: 10px;\n");
      out.write("                margin-right: 500px;\n");
      out.write("                margin-left: 500px;\n");
      out.write("                margin-bottom: 15px;\n");
      out.write("                left: 3%;\n");
      out.write("                position: absolute;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table{\n");
      out.write("                background-color: white;\n");
      out.write("                position: absolute;\n");
      out.write("                left: -500%;\n");
      out.write("                top:-80%;   \n");
      out.write("                font-family: Arial;\n");
      out.write("                font-size: 1em;\n");
      out.write("                text-align: center;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                width: 30em;\n");
      out.write("                box-shadow: 1px 1px 10px 10px black;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #c{\n");
      out.write("                background-color: pink;\n");
      out.write("            }\n");
      out.write("            #L{\n");
      out.write("                background-color: #90ee90;\n");
      out.write("                border: 1pxss;\n");
      out.write("            }\n");
      out.write("            #pl{\n");
      out.write("                background-color: #add8e6;\n");
      out.write("            }\n");
      out.write("            #s{\n");
      out.write("                background-color: #FFD700; \n");
      out.write("            }\n");
      out.write("            #r{\n");
      out.write("                background-color: #FF6347;\n");
      out.write("            }\n");
      out.write("            td{\n");
      out.write("                 \n");
      out.write("                border:1px solid ;\n");
      out.write("                text-align:center; \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #normal{\n");
      out.write("                background-color: white;\n");
      out.write("\n");
      out.write("                margin: 100px;\n");
      out.write("                font-family: impact;\n");
      out.write("                padding: 0.3em 1em;\n");
      out.write("                width: 70px;\n");
      out.write("            }\n");
      out.write("            #L,#pl,#normal,#r,#c,#s{\n");
      out.write("                font-family: inherit;\n");
      out.write("                padding: 0.3em 1em;\n");
      out.write("            }\n");
      out.write("            tr:nth-child(even) {\n");
      out.write("                background-color: #dddddd;\n");
      out.write("            }\n");
      out.write("            th {\n");
      out.write("                background-color: brown;\n");
      out.write("                color: white;\n");
      out.write("                font-family: Arial;\n");
      out.write("            }\n");
      out.write("            #in{\n");
      out.write("                position: absolute;\n");
      out.write("                background-color: #2A4F27;\n");
      out.write("                left: 70%;\n");
      out.write("                bottom: 50%;\n");
      out.write("                padding: 100px;\n");
      out.write("                box-shadow: 10px 10px 100px 10px black; \n");
      out.write("                border: 1px solid black;\n");
      out.write("            }\n");
      out.write("            #tab{\n");
      out.write("                position: absolute;\n");
      out.write("                background-color: #2A4F27;\n");
      out.write("                left: 70%;\n");
      out.write("                bottom: 50%;\n");
      out.write("                padding: 100px;\n");
      out.write("                box-shadow: 10px 10px 100px 10px black; \n");
      out.write("                border: 1px solid black;\n");
      out.write("            }\n");
      out.write("            h3{\n");
      out.write("                background-color: yellow ;  \n");
      out.write("            }\n");
      out.write("            #class{\n");
      out.write("                position: absolute;\n");
      out.write("                background-color: white;\n");
      out.write("                left: 70%;\n");
      out.write("                bottom: 0%;\n");
      out.write("                padding: 80px;\n");
      out.write("                box-shadow: 10px 10px 100px 10px black; \n");
      out.write("                border: 1px solid black;\n");
      out.write("            }\n");
      out.write("            #campeao{\n");
      out.write("                position: absolute;\n");
      out.write("                background-image: linear-gradient(to right, gold,white, blue);\n");
      out.write("                left:50%;\n");
      out.write("                bottom:50%;\n");
      out.write("                padding: 80px;\n");
      out.write("                width: 170px;;\n");
      out.write("                box-shadow: 10px 10px 100px#2A4F27;\n");
      out.write("                border: 1px solid black;\n");
      out.write("            }\n");
      out.write("            #camp{\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            .pontos{\n");
      out.write("                padding: 5px;\n");
      out.write("            }\n");
      out.write("            .nome{\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .verde{\n");
      out.write("                background-color: green;\n");
      out.write("            }\n");
      out.write("            .vermelho{\n");
      out.write("                background-color: red;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>SIMULADOR BRASILEIRÃO</h1>\n");
      out.write("        ");

            Connection con;
            String url = "jdbc:mysql://localhost:3306/brazuca";
            String Driver = "com.mysql.jdbc.Driver";
            String user = "root";
            String clave = "uniceub";
            Class.forName(Driver);
            con = DriverManager.getConnection(url, user, clave);
            PreparedStatement ps;

            ResultSet rs;
            ps = con.prepareStatement("select*from tb_time order by pontos desc");
            rs = ps.executeQuery();
        
      out.write("\n");
      out.write("        <div id=\"tab\">\n");
      out.write("            <table class=\"table\" border=\"0\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\">Pontuação</th>\n");
      out.write("                        <!--  <th scope=\"col\">NOME</th>\n");
      out.write("                          <th scope=\"col\">Pontos</th>-->\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("            <table border=\"1\" align=\"center\">\n");
      out.write("                <tr>\n");
      out.write("                    <!-- <th scope=\"col\">ID</th>-->\n");
      out.write("                 \n");
      out.write("                    <th scope=\"col\">Classificação</th>\n");
      out.write("                    <th scope=\"col\">Nome</th>\n");
      out.write("                    <th scope=\"col\">Pontos</th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                   \n");
      out.write("                    ");

                        int i = 1;

                        while (rs.next()) {
                    
      out.write("\n");
      out.write("                    <td id=\"normal\" > ");
      out.print( i);
      out.write("°</td>\n");
      out.write("                    <td class=\"nome\">");
      out.print( rs.getString("nome"));
      out.write("</td>\n");
      out.write("                    <td class=\"pontos\">");
      out.print( rs.getInt("pontos"));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                        i = i + 1;
                    }
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"in\">\n");
      out.write("            <h3>Para simular as partidas pressione o botão</h3>\n");
      out.write("            <!-- <input type=\"submit\" value=\"SIMULAR\" name=\"processar\" /> -->\n");
      out.write("            <form action=\"Processo\" method=\"POST \">\n");
      out.write("                <input type=\"submit\" value=\"Iniciar\"/>\n");
      out.write("            </form>    \n");
      out.write("            <br>\n");
      out.write("            <h3>Para Zerar as partidas pressione o botão</h3>\n");
      out.write("            <form action=\"Zerar\" method=\"POST\">\n");
      out.write("                <input type='submit' value='reiniciar'/>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            <br>\n");
      out.write("            <!--<form action=\"processo\">\n");
      out.write("                Nome.:<input type=\"text\" name=\"nome\" />\n");
      out.write("                <br/>\n");
      out.write("                <input type=\"submit\" value=\"Enviar\" />\n");
      out.write("            </form>-->\n");
      out.write("        </div>\n");
      out.write("        <div id=\"class\">\n");
      out.write("            <h3 id=\"L\">Classificados para Libertadores da América</h3>\n");
      out.write("            ");

                ps = con.prepareStatement("SELECT * FROM tb_time order by pontos desc LIMIT 4");
                rs = ps.executeQuery();
      out.write("</p\n");
      out.write("        <table>\n");
      out.write("            ");
 while (rs.next()) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");

                    if (rs.getInt("pontos") == 0) {
                        out.print("Não foi simulado ainda");
                    } else {
                        out.print(rs.getString("nome"));
                    }
                    
      out.write("|||</td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <h4 id=\"r\">Rebaixados para Série B</h4>\n");
      out.write("        ");

            ps = con.prepareStatement("SELECT * FROM tb_time ORDER BY PONTOS LIMIT 4");
            rs = ps.executeQuery();
      out.write("</p\n");
      out.write("    <table>\n");
      out.write("        ");
 while (rs.next()) {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
 if (rs.getInt("pontos") == 0) {
                    out.print("Não foi simulado ainda");
                } else {
                    out.print(rs.getString("nome"));
                }
      out.write("|||</td>\n");
      out.write("\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("    <h4 id=\"s\">Classificados Sul-Americana</h4>\n");
      out.write("    <p>7° ao 12°</p>\n");
      out.write("    <h4 id=\"pl\">Rebaixados</h4>\n");
      out.write("    <p >5° e 6°</p>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<div id=\"campeao\">            \n");
      out.write("        \n");
      out.write("        <h3 id=\"camp\">Campeão</h3>\n");
      out.write("\n");
      out.write("    ");

        ps = con.prepareStatement("SELECT * FROM tb_time order by pontos desc LIMIT 1");
        rs = ps.executeQuery();
      out.write("</p\n");
      out.write("<table>\n");
      out.write("    ");
 while (rs.next()) {
    
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");

            if (rs.getInt("pontos") == 0) {
                out.print("Não foi simulado ainda");
            } else {
                out.print(rs.getString("nome"));
            }
            
      out.write("</td>\n");
      out.write("\n");
      out.write("    </tr>\n");
      out.write("\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</body>\n");
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
