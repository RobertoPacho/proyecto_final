/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import Conexion.Conexion_db;
import ec.edu.ups.modelo.Medicina;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rober
 */
public class ControladorMedicina {
    private final Conexion_db conexion;
    
    private Set<Medicina> lista;
    private int codigo;

    public ControladorMedicina (){
        conexion= new Conexion_db();
        lista = new HashSet<>();
        codigo = 0;
    }

    public int getCodigo() {
        conexion.EstableserConexion();
        codigo = conexion.codigo("Medicina");
        codigo=codigo + 1;
        return codigo;
    }

    public void create(Medicina medicina) {
        conexion.EstableserConexion();
        String insertPro = " INSERT INTO medicina (codigo,nombre, marca, descripcion,precio) "
                + " VALUES (" + medicina.getCodigo() + ",'" + medicina.getNombre() + " ',' "
                + medicina.getMarca() + "',' " + medicina.getDescripcion() + " ', "
                + medicina.getPrecio() + ")";
        conexion.InsertDatos(insertPro);
        conexion.cerrarConexion();
    }

    public Medicina read(int codigo) {
        conexion.EstableserConexion();
        Medicina medicina=conexion.buscarMedi(codigo);
        conexion.cerrarConexion();
        return medicina;
    }

    public void update(Medicina medicina) {
        conexion.EstableserConexion();
        String insertPro = "UPDATE medicina SET nombre='"+medicina.getNombre()+"',marca='"+medicina.getMarca()+"',descripcion='"+medicina.getDescripcion()+"',precio="+medicina.getPrecio()+" WHERE codigo="+medicina.getCodigo();
        conexion.InsertDatos(insertPro);
    }

    public void delete(int codigo) {
        conexion.EstableserConexion();
        String delete="DELETE FROM medicina WHERE codigo="+codigo;
        conexion.InsertDatos(delete); 
    }

    public Set<Medicina> getLista() {
        lista=new HashSet<>();
        conexion.EstableserConexion();
        conexion.listadoMedi(lista);
        return lista;

    }

   
          
}
