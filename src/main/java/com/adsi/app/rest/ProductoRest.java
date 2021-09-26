/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.app.rest;

import com.adsi.app.controlador.Controlador;
import com.adsi.app.modelo.Producto;
import com.adsi.app.modelo.Proveedores;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Administrator
 */
@Path("/rest")
public class ProductoRest {

    private final Controlador repo = new Controlador();

    public ProductoRest() throws SQLException, IOException {
        repo.conectar();
    }

    @GET
    @Produces((MediaType.APPLICATION_JSON))
    @Path("/get")
    public String get() {

        return "PapiMoiseGOD";
    }

    @GET
    @Produces((MediaType.APPLICATION_JSON))
    @Path("/productos/list")
    public List<Producto> productList() throws SQLException {

        return repo.findAllProductos();
    }

    @GET
    @Produces((MediaType.APPLICATION_JSON))
    @Path("/productos/escasos/{cantidad}")
    public List<Producto> findLikeName(@PathParam("cantidad") String cantidad) throws SQLException {

        return repo.findLikeName(cantidad);
    }

    @GET
    @Produces((MediaType.APPLICATION_JSON))
    @Path("/productos/like/inventario/{cadena}")
    public List<Producto> listarProductosEscasos(@PathParam("cadena") String cadena) throws SQLException {

        return repo.findLikeName(cadena);
    }

    @GET
    @Produces((MediaType.APPLICATION_JSON))
    @Path("/productos/like/{cadena}")
    public List<Producto> findLikeNameConExistecia(@PathParam("cadena") String cadena) throws SQLException {

        return repo.findLikeNameConExistecia(cadena);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/proveedores/list")
    public List<Proveedores> findAllProveedores() throws SQLException {
        return repo.findAllProveedores();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/proveedores/id")
    public Proveedores findProveedoresByIdProveedor(@QueryParam("id") Integer id) throws SQLException {
        return repo.findProveedoresByIdProveedor(id).get();
    }

}
