package ProcessoServlet;

import Entidades.Time;
import dao.TimeDao;
import factory.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.stream.IntStream;

//@WebServlet(urlPatterns = {"/processo"})
@WebServlet(name = "Processo", urlPatterns = {"/Processo"})

public class Processo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        Connection con;
        String url = "jdbc:mysql://localhost:3306/brazuca";
        String Driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String clave = "uniceub";
        Class.forName(Driver);
        con = DriverManager.getConnection(url, user, clave);

        //TimeDao dao = new TimeDao();
        Random r = new Random();
        //Time time = new Time();
        for (int i = 1; i <= 19; i++) {
            if (i % 2 == 1) {
                int time1 = i;
                int time2 = i + 1;
                int golTime1 = r.nextInt(5);
                int golTime2 = r.nextInt(5);
                int saldoGolT1 = golTime1 - golTime2;
                int saldoGolT2 = golTime2 - golTime1;
                
                if (golTime1 > golTime2) {

                    String sql = "update tb_time set pontos = pontos + ?, vitorias = vitorias + ?,golFeito = golFeito +?,golSofre = golSofre + ?,saldoGol = saldoGol where cd_time =?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, 3);
                    st.setInt(2, 1);
                    st.setInt(3, golTime1);
                    st.setInt(4, golTime2);
                    st.setInt(5, time1);
                    st.execute();
                    
                    String sql2 = "update tb_time set pontos = pontos + 0, derrotas = derrotas +1, golFeito = golFeito + ?,golSofre = golSofre + ? where cd_time =?";

                    PreparedStatement st2 = con.prepareStatement(sql2);
                    st2.setInt(1, golTime2);
                    st2.setInt(2, golTime1);
                    st2.setInt(3, time2);
                    st2.execute();
                } else if (golTime1 < golTime2) {
                    
                    String sql = "update tb_time set pontos = pontos + ?, vitorias = vitorias + ?,golFeito = golFeito + ?,golSofre = golSofre + ? where cd_time =?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, 3);
                    st.setInt(2, 1);
                    st.setInt(3, golTime2);
                    st.setInt(4, golTime1);
                    st.setInt(5, time2);
                    st.execute();
                    
                    String sql2 = "update tb_time set pontos = pontos + 0, derrotas = derrotas +1, golFeito = golFeito + ?,golSofre = golSofre + ? where cd_time =?";

                    PreparedStatement st2 = con.prepareStatement(sql2);
                    st2.setInt(1, golTime1);
                    st2.setInt(2, golTime2);
                    st2.setInt(3, time1);
                    st2.execute();
                } else {                  
                    String sql = "update tb_time set pontos = pontos + 1, empates = empates+ 1,golFeito = golFeito +? , golSofre = golSofre + ?  where cd_time =?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, golTime1);
                    st.setInt(2, golTime2);
                    st.setInt(3, time1);
                    st.execute();
                    
                     String sql2 = "update tb_time set pontos = pontos + 1, empates = empates+ 1,golFeito = golFeito +? , golSofre = golSofre + ?  where cd_time =?";

                    PreparedStatement st2 = con.prepareStatement(sql2);
                    st2.setInt(1, golTime2);
                    st2.setInt(2, golTime1);
                    st2.setInt(3, time2);
                    st2.execute();
                }
            }
        }

        /* String sql = "update tb_time set pontos = ?  where cd_time =?";
        for (int i = 1; i <= 20; i++) {
            int pontos = r.nextInt(30);
            if (pontos == 0) {
                    pontos = 1;
            } else {

                //Connection con = new ConnectionFactory().getConnection();
                Connection con;
                String url = "jdbc:mysql://localhost:3306/brazuca";
                String Driver = "com.mysql.jdbc.Driver";
                String user = "root";
                String clave = "uniceub";
                Class.forName(Driver);
                con = DriverManager.getConnection(url, user, clave);

                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, pontos);
                st.setInt(2, i);
                st.execute();
            }
        }*/
        //  String parametro = "ola";
        //request.setAttribute("parametroEnviadoParaJSP", parametro);
        request.getRequestDispatcher("index.jsp").forward(request, response);

        //request.setAttribute("listaTimes", times);
        // TimeDao dao = new TimeDao();
        //List<Time> times;
        //times = dao.consultarTodos();
        //request.setAttribute("listaContatos",times);
        //request.getRequestDispatcher("tabela.jsp").forward(request, response);
        // request.setAttribute("Listatimes", times);
        //response.sendRedirect("Tabela.jsp");
        //request.setAttribute("listaTimes", times);
        //request.getRequestDispatcher("Tabela.jsp").forward(request, response);
    }

    /* <!-- <c:forEach var="time" items="${listaTimes}">
                <tr>
                    <td>${time.nome}</td>
                    <td>${time.pontos}</td>
                </tr>
            </c:forEach> -->*/
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
