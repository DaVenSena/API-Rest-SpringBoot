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
 * @author PapiMoise 31 Jul-2021
 */
public class Proveedores {
    
    private Integer idProveedores;
    private String nit;
    private String nombreProveedor;
    private Integer calidad;
    private Integer estado;
    private Date fechCreacion;

    public Proveedores() {
    }

    public Proveedores(Integer idProveedores, String nit, String nombreProveedor, Integer calidad, Integer estado, Date fechCreacion) {
        this.idProveedores = idProveedores;
        this.nit = nit;
        this.nombreProveedor = nombreProveedor;
        this.calidad = calidad;
        this.estado = estado;
        this.fechCreacion = fechCreacion;
    }

    public Integer getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(Integer idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Integer getCalidad() {
        return calidad;
    }

    public void setCalidad(Integer calidad) {
        this.calidad = calidad;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFechCreacion() {
        return fechCreacion;
    }

    public void setFechCreacion(Date fechCreacion) {
        this.fechCreacion = fechCreacion;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "idProveedores=" + idProveedores + ", nit=" + nit + ", nombreProveedor=" + nombreProveedor + ", calidad=" + calidad + ", estado=" + estado + ", fechCreacion=" + fechCreacion + '}';
    }
    
    
    
    public static Proveedores load(ResultSet rs)throws SQLException{
        Proveedores proveedor= new Proveedores();
        
        proveedor.setIdProveedores(rs.getInt(1));
        proveedor.setNit(rs.getString(2));
        proveedor.setNombreProveedor(rs .getString(3));
        proveedor.setCalidad(rs.getInt(4));
        proveedor.setEstado(rs.getInt(5)); 
        proveedor.setFechCreacion(rs.getDate(6));
       
                       
        return proveedor;
    }
    
    
    
}
