/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.app.modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author RICARDO
 */
public class Producto {
    
private  int id ;
private   String nombre;
private   Integer cantidad ;
private   Integer valor ;
private   Date fechaIngreso ;
private   String descripcion;
private   Integer fk_proveedor;
        

    public Producto() {
    }

    public Producto(int id, String nombre, Integer cantidad, Integer valor, Date fechaIngreso, String descripcion, Integer fk_proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valor = valor;
        this.fechaIngreso = fechaIngreso;
        this.descripcion = descripcion;
        this.fk_proveedor = fk_proveedor;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIng) {
        this.fechaIngreso = fechaIng;
    }

    public Integer getFk_proveedor() {
        return fk_proveedor;
    }

    public void setFk_proveedor(Integer fk_proveedor) {
        this.fk_proveedor = fk_proveedor;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
  
  
    
    public static Producto load(ResultSet rs)throws SQLException{
        Producto producto= new Producto();
        
        producto.setId(rs.getInt(1));
        producto.setNombre(rs.getString(2));
        producto.setCantidad(rs.getInt(3));
        producto.setValor(rs.getInt(4));
        producto.setFechaIngreso(rs.getDate(5));
        producto.setDescripcion(rs.getString(6));
        producto.setFk_proveedor(rs.getInt(7));
                       
        return producto;
    }
    
    
  
  
    
}
