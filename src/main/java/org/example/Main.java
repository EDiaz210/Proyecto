package org.example;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
        String user = "root";
        String password = "123456";
        Connection con = null;
        PreparedStatement pls = null;


        try{
            //establecer conexion
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión Exitosa");

            String sql = "update estudiantes set b1 = ? where cedula = ?";
            pls = con.prepareStatement(sql);
            //Seteamos los valores de la sentencia previa.
            pls.setInt(1, 15);
            pls.setString(2, "1765090278");
            System.out.println(sql);
            int n = pls.executeUpdate();
            System.out.println("Se modifico:"+n+"lineas");




        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            //Cerramos la conexión
            try{
                if(pls != null){
                    pls.close();
                }if (con != null){
                    con.close();
                }
            }catch(SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

