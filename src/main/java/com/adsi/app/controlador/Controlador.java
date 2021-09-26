/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.app.controlador;

import com.adsi.app.modelo.Conexion;
import com.adsi.app.modelo.Producto;
import com.adsi.app.modelo.Proveedores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author RICARDO
 */
public class Controlador extends Conexion {
    
    
    public List<Producto> findLikeNameConExistecia(String cadena) throws SQLException {
        //SELECT * FROM productos 
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }

        LinkedList lista = new LinkedList();
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            String query;
            query = "SELECT * FROM productos WHERE nombre_completo like ? AND cantidad > '0' ";                    //Definir la consulta
            pst = con.prepareStatement(query); 
            pst.setString(1, "%"+cadena+"%");

            rst = pst.executeQuery();                               //Ejecutarla 

            while (rst.next()) {
                lista.add(Producto.load(rst));          //Recorrer el rst y llena la lista
            }

        } finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena

    }
    public List<Producto> findLikeName(String cadena) throws SQLException {
        //SELECT * FROM productos 
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }

        LinkedList lista = new LinkedList();
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            String query;
            query = "SELECT * FROM productos WHERE nombre_completo like ? AND cantidad > '0' ";                    //Definir la consulta
            pst = con.prepareStatement(query); 
            pst.setString(1, "%"+cadena+"%");

            rst = pst.executeQuery();                               //Ejecutarla 

            while (rst.next()) {
                lista.add(Producto.load(rst));          //Recorrer el rst y llena la lista
            }

        } finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena

    }

    public List<Producto> findAllProductos() throws SQLException {
        //SELECT * FROM productos 
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }

        LinkedList lista = new LinkedList();
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            String query;
            query = "SELECT * FROM productos ORDER BY id DESC;  ";                    //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla

            rst = pst.executeQuery();                               //Ejecutarla 

            while (rst.next()) {
                lista.add(Producto.load(rst));          //Recorrer el rst y llena la lista
            }

        } finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena

    }

    public Long totalProductos() throws SQLException {
        //SELECT * FROM productos 
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }

        LinkedList lista = new LinkedList();
        PreparedStatement pst = null;
        ResultSet rst = null;
        Long total = null;
        try {
            String query;
            query = "SELECT count(*) FROM productos";             //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla

            rst = pst.executeQuery();                               //Ejecutarla 

            while (rst.next()) {
                total = rst.getLong(1);                      //Recorrer el rst y llena la lista
            }

        } finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return total;                            //Retorna la lista llena

    }

    public List<Producto> listarProductosEscasos(Integer valor) throws SQLException {
        //SELECT * FROM productos 
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }

        LinkedList lista = new LinkedList();
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            String query;
            query = "SELECT * FROM productos where cantidad <= ? ";                    //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla
            pst.setInt(1, valor);

            rst = pst.executeQuery();                               //Ejecutarla 

            while (rst.next()) {
                lista.add(Producto.load(rst));          //Recorrer el rst y llena la lista
            }

        } finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena

    }

    ;
    
    
     public void addProductos(Producto producto) throws SQLException {
        //SELECT * FROM productos 
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }

        LinkedList lista = new LinkedList();
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            String query;
            query = " INSERT INTO `productos`\n"
                    + " ( `nombre_completo`, `cantidad`, `valor`, `fecha_ing`,  `descripcion`, `fk_proveedor` )\n"
                    + " VALUES\n"
                    + " (?, ?, ?, ?, ?, ?) ";                    //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla

            pst.setString(1, producto.getNombre());
            pst.setInt(2, producto.getCantidad());
            pst.setInt(3, producto.getValor());
            pst.setDate(4, producto.getFechaIngreso());
            pst.setString(5, producto.getDescripcion());
            pst.setInt(6, producto.getFk_proveedor());

            pst.execute();                               //Ejecutarla 

        } finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }

    }

    public List<Proveedores> findAllProveedores() throws SQLException {
        //SELECT * FROM productos 
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }

        LinkedList lista = new LinkedList();
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            String query;
            query = "SELECT * FROM proveedores ORDER BY nombre ASC;  ";                    //Definir la consulta
            pst = con.prepareStatement(query);                      //Prepararla

            rst = pst.executeQuery();                               //Ejecutarla 

            while (rst.next()) {
                lista.add(Proveedores.load(rst));          //Recorrer el rst y llena la lista
            }

        } finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena

    }

    public Optional<Proveedores> findProveedoresByIdProveedor(Integer idParametro) throws SQLException {
        //SELECT * FROM productos 
        if (!hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }

        LinkedList lista = new LinkedList();
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            String query;
            query = "SELECT * FROM proveedores WHERE id_proveedores = ?;  ";                    //Definir la consulta

            pst = con.prepareStatement(query);                      //Prepararla
            pst.setInt(1, idParametro);
            rst = pst.executeQuery();                               //Ejecutarla 

            while (rst.next()) {
                lista.add(Proveedores.load(rst));          //Recorrer el rst y llena la lista
            }

        } finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista.stream().findFirst();                            //Retorna la lista llena

    }
}
