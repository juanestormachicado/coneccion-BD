
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.productos"%>
<%
List<productos> lista =(List<productos>)request.getAttribute("list");



%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS v5.2.0-beta1 -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
      integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
      crossorigin="anonymous"
    />
        
        <title>JNMCH</title>
    </head>
    <body>
        <div class="container">
            <h1>CONECCION A BASE DE DATOS  TEM-742 </h1>
            <h2>Nombre.- Juan Nestor Machicado Chaiña </h2>
            <h2 >Carnet.- 5980983</h2>
            
            <h1>PRODUCTOS</h1>
            <a href="MainServlet?op=nuevo" class="btn btn-primary"> NUEVO</a>
            <table class="table" >
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Descripcion</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                       
                        <th>Modificar</th>
                        <th>Eliminar</th>
    
                    </tr>
                </thead>
                <tbody>
                   
                    <tr>
                        <c:forEach var="item" items="${lista}">
                        <td>${item.id}</td>
                        <td>${item.producto}</td>
                        <td>${item.precio}</td>
                        <td>${item.cantidad}</td>
                        

                        <td><a href="MainServlet?op=eliminiar&id=${item.id}">Editar</a></td>
                        <td><a href="MainServlet?op=eliminiar&id=${item.id}" onclick="return confirm('seguro de eliminar')"  > Eliminar</a></td>
                        
                        
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
