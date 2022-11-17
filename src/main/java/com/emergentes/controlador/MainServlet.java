
package com.emergentes.controlador;

import com.emergentes.modelo.productos;
import com.emergentes.utiles.BDconn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        String op;
         op = (request.getParameter("op")!= null) ? request.getParameter("op"):"lista";
         
           ArrayList<productos> lista= new ArrayList<productos>();
           BDconn canal = new BDconn();
           Connection conn = canal.conectar() ;
           
           
           PreparedStatement ps;
           ResultSet rd;
           
           if(op.equals("lista")){
            
                String sql = "select * from productos";
                
                ps = conn.prepareStatement(sql);
                rd = ps.executeQuery();
                
                while (rd.next()){
                    productos p = new productos();

                p.setId(rd.getInt("id"));
                p.setProducto(rd.getString("producto"));
                p.setPrecio(rd.getFloat("precio"));
                p.setCantidad(rd.getInt("cantidad"));

                lista.add(p);
                    
                    
                }
                
                request.setAttribute("lista", lista);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
           }
         if(op.equals("eliminar")){
           int id = Integer.parseInt(request.getParameter("id"));
           
           String sql = "delete from productos where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            response.sendRedirect("MainServlet");
           
           }
          if(op.equals("nuevo")){
           
                productos p = new productos();
               request.setAttribute("lis", p);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
              
              
              
           }
        
        
        } catch (SQLException ex) {
                Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
        int id = Integer.parseInt(request.getParameter("id"));
        
        String producto = request.getParameter("producto");
        float precio =Float.parseFloat(request.getParameter("precio"));
        int cantidad =Integer.parseInt(request.getParameter("cantidad"));
        
        productos p = new productos();

                p.setId(id);
                p.setProducto(producto);
                p.setPrecio(precio);
                p.setCantidad(cantidad);
        
          BDconn canal = new BDconn();
           Connection conn = canal.conectar() ;
           
           PreparedStatement ps;
           
           if (id==0){
           
                String sql = "insert into productos (producto,precio,cantidad) values (?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, p.getProducto());
                ps.setFloat(2, p.getPrecio());
                ps.setInt(3, p.getCantidad());
                
            ps.executeUpdate();
                
           }
           
           
           ResultSet rd;
         } catch (SQLException ex) {
                Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
