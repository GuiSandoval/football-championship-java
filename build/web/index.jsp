<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
    <head>

        <title>SIMULADOR DE BRASILEIRAO</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body{

                background-image: url('estadio.jpg');
                background-repeat: no-repeat;
                background-size:125%;
                bottom: 0;
                color: black;
                left: 0;
                overflow: auto;
                padding: 0em;
                position: absolute;
                right: 0;
                text-align: center;
                top: 0;

            }
            #imagem{
                position : relative;
                left: 0%;
                background-repeat: no-repeat;
                background-size:100%;
                height: 100%;
                width: 100%;
                top:0;
                opacity: 1;
            }
            h1{
                background-color: white;
                color:darkblue;
                font-family: verdana;
                font-size: 300%;
                border: 1px solid black;
                margin: 10px;
                margin-right: 500px;
                margin-left: 500px;
                margin-bottom: 15px;
                left: 3%;
                position: absolute;
            }

            table{
                background-color: white;
                position: absolute;
                left: -500%;
                top:-80%;   
                font-family: Arial;
                font-size: 1em;
                text-align: center;
                border-collapse: collapse;
                width: 30em;
                box-shadow: 1px 1px 10px 10px black;

            }
            #c{
                background-color: pink;
            }
            #L{
                background-color: #90ee90;
                border: 1pxss;
            }
            #pl{
                background-color: #add8e6;
            }
            #s{
                background-color: #FFD700; 
            }
            #r{
                background-color: #FF6347;
            }
            td{

                border:1px solid ;
                text-align:center; 
            }

            #normal{
                background-color: white;

                margin: 100px;
                font-family: impact;
                padding: 0.3em 1em;
                width: 70px;
            }
            #L,#pl,#normal,#r,#c,#s{
                font-family: inherit;
                padding: 0.3em 1em;
            }
            tr:nth-child(even) {
                background-color: #dddddd;
            }
            th {
                background-color: brown;
                color: white;
                font-family: Arial;
            }
            #in{
                height:200px;
                width:350px;
                position: absolute;
                    background-color: #2A4F27;
                left:70%;
                bottom: 60%;
                padding: 100px;
                box-shadow: 10px 10px 100px 10px black; 
                border: 1px solid black;
            }
            #tab{
                position: absolute;
                background-color: #2A4F27;
                left: 70%;
                bottom: 50%;
                padding: 100px;
                box-shadow: 10px 10px 100px 10px black; 
                border: 1px solid black;
            }
            h3{
                background-color: yellow ;  
            }
            #class{
                width:500px;
                height:600px ;
                position: absolute;
                background-color: white;
                left: 70%;
                bottom: 0%;
                padding: 20px;
                box-shadow: 10px 10px 100px 10px black; 
                border: 1px solid black;
            }
            #campeao{
                position: absolute;
                background-image: linear-gradient(to right, gold,white, blue);
                left:50%;
                bottom:50%;
                padding: 80px;
                width: 170px;;
                box-shadow: 10px 10px 100px#2A4F27;
                border: 1px solid black;
            }
            #camp{

            }
            .pontos{
                padding: 5px;
            }
            .nome{
                font-weight: bold;
            }
            .verde{
                background-color: green;
            }
            .vermelho{
                background-color: red;
            }
        </style>
    </head>
    <body>
        <h1>SIMULADOR BRASILEIRÃO</h1>
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
            ps = con.prepareStatement("select*from tb_time order by pontos desc,vitorias desc,golFeito desc,derrotas asc");
            rs = ps.executeQuery();
        %>
        <div id="tab">
            <table class="table" border="0">
                <thead>
                    <tr>
                        <th scope="col">Pontuação</th>
                        <!--  <th scope="col">NOME</th>
                          <th scope="col">Pontos</th>-->
                    </tr>
                </thead>

            </table>
            <table border="1" align="center">
                <tr>
                    <!-- <th scope="col">ID</th>-->

                    <th scope="col">Classificação</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Pontos</th>
                    <th scope="col">Vitorias</th>
                    <th scope="col">Empates</th>
                    <th scope="col">Derrotas</th>
                    <th scope="col">GolFeito</th>
                </tr>
                <tr>

                    <%
                        int i = 1;

                        while (rs.next()) {
                    %>
                    <td id="normal" > <%= i%>°</td>
                    <td class="nome"><%= rs.getString("nome")%></td>
                    <td class="pontos"><%= rs.getInt("pontos")%></td>
                    <td class="vitorias"><%= rs.getInt("Vitorias")%></td>
                    <td class="empates"><%= rs.getInt("Empates")%></td>
                    <td class="derrotas"><%= rs.getInt("Derrotas")%></td>
                    <td class="golFeito"><%= rs.getInt("golFeito")%></td>
                </tr>
                <%
                        i = i + 1;
                    }
                %>
            </table>
        </div>
        <div id="in">
            <h3>Para simular as partidas pressione o botão</h3>
            <!-- <input type="submit" value="SIMULAR" name="processar" /> -->
            <form action="Processo" method="POST ">
                <input type="submit" value="Iniciar"/>
            </form>    
            <br>
            <h3>Para Zerar as partidas pressione o botão</h3>
            <form action="Zerar" method="POST">
                <input type='submit' value='reiniciar'/>

            </form>
            <br>
            <!--<form action="processo">
                Nome.:<input type="text" name="nome" />
                <br/>
                <input type="submit" value="Enviar" />
            </form>-->
        </div>
        <div id="class">
            <h3 id="L">Classificados para Libertadores da América</h3>
            <p>1° ao 4°</p>
            <%
                ps = con.prepareStatement("SELECT * FROM (SELECT t.*, @rownum := @rownum + 1 AS colocacao FROM tb_time t, (SELECT @rownum := 0) r ORDER BY t.pontos desc,t.vitorias desc,t.golFeito desc) aux_table WHERE aux_table.colocacao between 1 and 4");
                rs = ps.executeQuery();%></p    
        <table>
            <% while (rs.next()) {
            %>
            <tr>
                <td><%
                    if (rs.getInt("pontos") == 0) {
                        out.print("Não foi simulado ainda");
                    } else {
                        out.print(rs.getString("nome"));
                    }
                    %>|||</td>

            </tr>

            <%
                }
            %>
        </table>
        <h4 id="r">Rebaixados para Série B</h4>
        <p>17° ao 20°</p>
        <%
            ps = con.prepareStatement("SELECT * FROM (SELECT t.*, @rownum := @rownum + 1 AS colocacao FROM tb_time t, (SELECT @rownum := 0) r ORDER BY t.pontos desc,t.vitorias desc,t.golFeito desc) aux_table WHERE aux_table.colocacao between 17 and 20");
            rs = ps.executeQuery();%></p
    <table>
        <% while (rs.next()) {
        %>
        <tr>
            <td><% if (rs.getInt("pontos") == 0) {
                    out.print("Não foi simulado ainda");
                } else {
                    out.print(rs.getString("nome"));
                }%>|||</td>

        </tr>

        <%
            }
        %>
    </table>

    <h4 id="s">Classificados Sul-Americana</h4>  
    <p>7° ao 12°</p>
        <%
        ps = con.prepareStatement("SELECT * FROM (SELECT t.*, @rownum := @rownum + 1 AS colocacao FROM tb_time t, (SELECT @rownum := 0) r ORDER BY t.pontos desc,t.vitorias desc,t.golFeito desc) aux_table WHERE aux_table.colocacao between 7 and 12");
        rs = ps.executeQuery();%></p
<table>
    <% while (rs.next()) {
    %>
    <tr>
        <td><%
            if (rs.getInt("pontos") == 0) {
                out.print("Não foi simulado ainda");
            } else {
                out.print(rs.getString("nome"));
            }
            %>|||</td>

    </tr>

    <%
        }
    %>
</table>



    
    <h4 id="pl">Pré-Libertadores</h4>
    <p>5° e 6°</p>
    <%
        ps = con.prepareStatement("SELECT * FROM (SELECT t.*, @rownum := @rownum + 1 AS colocacao FROM tb_time t, (SELECT @rownum := 0) r ORDER BY t.pontos desc,t.vitorias desc,t.golFeito desc) aux_table WHERE aux_table.colocacao between 5 and 6");
        rs = ps.executeQuery();%></p
<table>
    <% while (rs.next()) {
    %>
    <tr>
        <td><%
            if (rs.getInt("pontos") == 0) {
                out.print("Não foi simulado ainda");
            } else {
                out.print(rs.getString("nome"));
            }
            %>|||</td>

    </tr>

    <%
        }
    %>
</table>



</div>
<div id="campeao">            

    <h3 id="camp">Campeão</h3>

    <%
        ps = con.prepareStatement("SELECT * FROM (SELECT t.*, @rownum := @rownum + 1 AS colocacao FROM tb_time t, (SELECT @rownum := 0) r ORDER BY t.pontos desc,t.vitorias desc,t.golFeito desc) aux_table WHERE aux_table.colocacao between 1 and 1");
        rs = ps.executeQuery();%></p
<table>
    <% while (rs.next()) {
    %>
    <tr>
        <td><%
            if (rs.getInt("pontos") == 0) {
                out.print("Não foi simulado ainda");
            } else {
                out.print(rs.getString("nome"));
            }
            %></td>

    </tr>

    <%
        }
    %>
</table>





</div>
</body>
</html>
