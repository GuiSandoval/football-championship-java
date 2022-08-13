<%-- 
    Document   : TelaInicio
    Created on : 10/06/2019, 00:04:17
    Author     : guilherme.sandoval
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.TimeDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Final</title>
    </head>
    <body>
        <%
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
        %>
        <div>
            <table align="left" class="table" border="1">
                <table border="1" align="center">
                    <tr>
                        <th scope="col">Pontuação</th>
                        <th scope="col">NOME</th>
                        <th scope="col">Pontos</th>
                    </tr>
                    <tr>
                        <%
                            int i = 1;
                            while (rs.next()) {
                        %>
                        <td><%= i%></td>
                        <td><%= rs.getString("nome")%></td>
                        <td><%= rs.getInt("pontos")%></td>
                    </tr>
                    <%
                            i = i + 1;
                        }
                    %>
                </table>
        </div>

    </body>
</html>

