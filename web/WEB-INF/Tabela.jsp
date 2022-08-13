<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Resultado</title>
    </head>
    <body>
        <h1>Tabela preenchida Simulador Camp. Brasileiro</h1>

        <%
            String parametrof = (String) request.getAttribute("parametroFlaJSP");
            String parametroc = (String) request.getAttribute("parametroCorJSP");
        %>

        <h1><%=parametrof%></h1>
        <h1><%=parametroc%></h1>
    </body>
</html>
