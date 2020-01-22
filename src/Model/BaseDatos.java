package Model;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class BaseDatos {
    
    String url;
    Connection conexion = null;
    public HashMap<String,String> componentes = new HashMap<String,String>();
    
    public BaseDatos (String url) {
        this.url = url;
    }
    
    public void open () {
        try {
            conexion = DriverManager.getConnection(this.url);
            System.out.println("BASE DE DATOS INICIADA");
        } catch (SQLException ex) {
            System.out.println("FALLO AL ABRIR LA BASE DE DATOS " + ex.getMessage());
        }
    }

    public void close() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("BASE DE DATOS INICIADA");
            } catch (SQLException ex) {
                System.out.println("ERROR AL CERRAR BASE DE DATOS " + ex.getMessage());
            }
        }
    }

    public void insert(String jugador, String equipo) {
        String SQL = "INSERT INTO CLUB (JUGADOR, EQUIPO) VALUES (?,?)";
        try {
            PreparedStatement preparestatement = conexion.prepareStatement(SQL);
            preparestatement.setString(1, jugador);
            preparestatement.setString(2, equipo);
            preparestatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR AL INSERTAR EN BASE DE DATOS " + ex.getMessage());
        }
    }

    public void select() {
        String SQL  = "SELECT * FROM CLUB";
        
        if(conexion != null){
            try {
                Statement statement = conexion.createStatement();
                ResultSet resultset = statement.executeQuery(SQL);

                while (resultset.next()) {
                    componentes.put(resultset.getString("JUGADOR"), resultset.getString("EQUIPO"));
                    System.out.println(resultset.getString("JUGADOR") + " " + resultset.getString("EQUIPO"));
                }
            } catch (SQLException ex) {
                System.out.println("ERROR AL SELECCIONAR EN BASE DE DATOS " + ex.getMessage());
            }
        } 
    }
}