/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author alex-escb
 */
public class RegistroDao {
    public static void setup() {
        String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS PROYECTO"
                + " (CODIGO INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " NOMBRE TEXT,"
                + " ESTADO TEXT,"
                + " CORREO TEXT,"
                + " MESES TEXT,"
                + " AREA TEXT,"
                + " PAIS TEXT);";
        try {
            Statement comando = Conexion.getConexion().createStatement();
            int resultado = comando.executeUpdate(sqlCrearTabla);
            comando.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
    public static ArrayList<Registro> obtenerTodos(){
        String sqlObtenerTodo = "SELECT * FROM PROYECTO;";
        ArrayList<Registro> registros = new ArrayList<>();
        try{
            Statement comando = Conexion.getConexion().createStatement();
            ResultSet registroRows = comando.executeQuery(sqlObtenerTodo);
            while (registroRows.next()){
                Registro registro = new Registro();
                registro.setCodigo(registroRows.getInt("CODIGO"));
                registro.setNombre(registroRows.getString("NOMBRE"));
                registro.setEstado(registroRows.getString("ESTADO"));
                registro.setCorreo(registroRows.getString("CORREO"));
                registro.setMeses(registroRows.getString("MESES"));
                registro.setArea(registroRows.getString("AREA"));
                registro.setPais(registroRows.getString("PAIS"));
                registros.add(registro);
            }
            comando.close();
            return registros;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }
    public static Registro agregar (Registro newRegistro) {
        String sqlInsertRegistro = "INSERT INTO PROYECTO (NOMBRE, ESTADO, CORREO, MESES, AREA, PAIS) VALUES (?, ?, ?, ?, ?, ?); ";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlInsertRegistro);
            comando.setString(1, newRegistro.getNombre());
            comando.setString(2, newRegistro.getEstado());
            comando.setString(3, newRegistro.getCorreo());
            comando.setString(4, newRegistro.getMeses());
            comando.setString(5, newRegistro.getArea());
            comando.setString(6, newRegistro.getPais());
            int registroAgregado = comando.executeUpdate();
            comando.close();
            return newRegistro;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }
    
    public static Registro actualizar(Registro updRegistro) {
        String sqlUpdateCategoria = "UPDATE PROYECTO set NOMBRE=? , ESTADO=? , CORREO=? , MESES=? , AREA=? , PAIS=? where CODIGO=?;";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlUpdateCategoria);
            comando.setString(1, updRegistro.getNombre());
            comando.setString(2, updRegistro.getEstado());
            comando.setString(3, updRegistro.getCorreo());
            comando.setString(4, updRegistro.getMeses());
            comando.setString(5, updRegistro.getArea());
            comando.setString(6, updRegistro.getPais());
            comando.setInt(7, updRegistro.getCodigo());
            int registroActualizado = comando.executeUpdate();
            comando.close();
            return updRegistro;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
        
    }
    
    public static int eliminar (int codEliminar) {
        String sqlEliminarRegistro= "DELETE FROM PROYECTO WHERE CODIGO=?;";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlEliminarRegistro);
            comando.setInt(1, codEliminar);
            int registrosEliminados = comando.executeUpdate();
            comando.close();
            return registrosEliminados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return 0;
        }
    
    }
    
}
