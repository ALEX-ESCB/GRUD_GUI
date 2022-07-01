/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

/**
 *
 * @author alex-escb
 */
public class Registro {

    /**
     * @return the codigo
     */
    
    public Registro(){
        
        
    }
    
    public Registro(int codigo, String nombre, String estado, String correo, String meses, String area, String pais){
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.correo = correo;
        this.meses = meses;
        this.area = area;
        this.pais = pais;
    }
    
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the meses
     */
    public String getMeses() {
        return meses;
    }

    /**
     * @param meses the meses to set
     */
    public void setMeses(String meses) {
        this.meses = meses;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public String printString(){
        return String.valueOf(codigo) + '\t' + nombre + '\t'  + estado + '\t' + correo + '\t' + meses + '\t' + area + '\t' + pais;
    }
    
    private int codigo;
    private String nombre;
    private String estado;
    private String correo;
    private String meses;
    private String area;
    private String pais;
    
}
