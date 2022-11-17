
<%@page import="com.emergentes.modelo.productos"%>
<%

productos lib =(productos) request.getAttribute("lis");


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
    crossorigin="anonymous"/>
    <title>JNMCH</title>
    
  </head>
    <body>
        <div class="container">
      <h1>SEGUNDO PARCIAL TEM-742</h1>
      <h2>Nombre.- Juan Nestor Machicado Chaiña</h2>
      <h2 aling="center">Carnet.- 5980983</h2>

      <h1>"NUEVO RESGISTRO":"EDITAR REGISTRO"%></h1>

      <form action="MainServlet" class="p-4" method="post">
        <input  type="hidden" name="id" value="${lib.id}" />
        <table>
          <tr>
            <td>DESCRIPCION</td>
            <td>
              <input
                type="text"
                name="desc" class="form-control"
                value="${lib.producto}"
              />
            </td>
          </tr>
          <tr>
            <td>CANTIDAD</td>
            <td>
              <input type="text" class="form-control" name="cant" value="${lib.cantidad}" />
            </td>
          </tr>
          <tr>
            <td>PRECIO</td>
            <td>
              <input type="text"  class="form-control" name="prec" value="${lib.precio}" />
            </td>
          </tr>
          
          <tr>
            <td></td>
            <td><input  class="form-control" type="submit" value="enviar" /></td>
          </tr>
        </table>
      </form>
    </div>
    </body>
</html>
