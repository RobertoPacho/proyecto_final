/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.ups.controladores;

import Conexion.Conexion_db;
import ec.edu.ups.modelo.CitaMedicaDetallada;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rober
 */
public class ControladorCitaMedicaDetallada {
    private final Conexion_db conexion;
    //Declaracion de variables
    private Set<CitaMedicaDetallada> lista;
    private int codigo;
    /**
     * Constructor inicializa variables
     */
    public ControladorCitaMedicaDetallada(){
        conexion=new Conexion_db();
        lista = new HashSet<>();
        codigo = 0;
    }
    /**
     * Metodo que te obtiene el codigo
     * @return 
     */
    public int getCodigo() {
        conexion.EstableserConexion();
        codigo = conexion.codigo("citamedicadetallada");
        codigo=codigo + 1;
        return codigo;
    }
    /**
     * Metodo que crea un objeto 
     * @param citaMedicaDetallada
     */ 
    public void cread(CitaMedicaDetallada citaMedicaDetallada) {
        conexion.EstableserConexion();
        String insertPro = " INSERT INTO citaMedicaDetallada (codigo,diagnostico) "
                + " VALUES (" + citaMedicaDetallada.getCodigo() + ",'" + citaMedicaDetallada.getDiagnostico()+ "')";
        conexion.InsertDatos(insertPro);
        conexion.cerrarConexion();
    }
     /**
    * Metodo que lee un objeto por el codigo
    * @param codigo
    * @return 
    */
    /*public CitaMedicaDetallada read(int codigo) {
        conexion.EstableserConexion();
        CitaMedicaDetallada citaMedicaDetallada=conexion.buscarMediDetallada(codigo);
        conexion.cerrarConexion();
        return citaMedicaDetallada;
    }*/
    /**
     * Metodo Actualiza Objeto
     * @param citaMedicaDetallada 
     */
    public void update(CitaMedicaDetallada citaMedicaDetallada) {
        conexion.EstableserConexion();
        String insertPro = "UPDATE citamedicadetallada SET diagnostico='"+citaMedicaDetallada.getDiagnostico()+"' WHERE codigo="+citaMedicaDetallada.getCodigo();
        conexion.InsertDatos(insertPro);
    }
    /**
     * Metodo que elimina un objeto por el codigo
     * @param codigo 
     */
    public void delete(int codigo) {
       conexion.EstableserConexion();
       String delete="DELETE FROM citamedicadetallada WHERE codigo="+codigo;
       conexion.InsertDatos(delete); 
    }
    /**
     * Metodo que retorna la lista del objeto
     * @return 
     */
    public Set<CitaMedicaDetallada> getLista() {
        lista=new HashSet<>();
        conexion.EstableserConexion();
        conexion.listadoMediDetallada(lista);
        return lista;

    }

}
