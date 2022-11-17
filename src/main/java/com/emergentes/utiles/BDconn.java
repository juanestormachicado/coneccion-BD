package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDconn {

    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_almacen";
    static String usuario = "root";
    static String password = "";
        Connection conn = null;
    public BDconn() {
        
        try {
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if( conn!= null){
            System.out.println("coneccion OK"+conn);
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDconn.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        catch(SQLException e)
        {System.out.println("Error al concetar "+ e.getMessage());}
        
    }
    public Connection conectar(){
    return conn;
    
    }
    public void deconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BDconn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
