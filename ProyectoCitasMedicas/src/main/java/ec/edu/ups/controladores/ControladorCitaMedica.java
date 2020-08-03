/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.ups.controladores;

import Conexion.Conexion_db;
import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.Medico;
import ec.edu.ups.modelo.Paciente;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rober
 */
public class ControladorCitaMedica {
    private final Conexion_db conexion;
   //Declaracion de variables
    private Set<CitaMedica> lista;
    private Set<Paciente> listaPasc;
    private Set<Medico> listaMedico;
    private int codigo;
    /**
     * Constructor inicializa variables
     */
    public ControladorCitaMedica(){
        conexion= new Conexion_db();
        lista = new HashSet<>();
        listaPasc=new HashSet<>();
        listaMedico=new HashSet<>();
        codigo = 0;
    }
    /**
     * Metodo que te obtiene el codigo
     * @return 
     */
    public int getCodigo() {
        conexion.EstableserConexion();
        codigo = conexion.codigo("citamedica");
        codigo=codigo + 1;
        return codigo;
    }
    /**
     * Metodo que crea un objeto
     * @param citaMedica
     */ 
    public void cread(CitaMedica citaMedica) {
        conexion.EstableserConexion();
        String insertPro = " INSERT INTO citamedica (codigo,fechacita, precio, cod_paciente,cod_medico,diagnostico) "
                + " VALUES (" + citaMedica.getNumeroCita() + ",'" + citaMedica.getFechaCita() + " ', "
                + citaMedica.getPrecio() + "," + citaMedica.getPaciente().getCodigo() + ","
                + citaMedica.getMedico().getCodigo() + ",'" + citaMedica.getDiagnostico() + "')";
        conexion.InsertDatos(insertPro);
        conexion.cerrarConexion();
    }
     /**
    * Metodo que lee un objeto por el codigo
    * @param codigo
    * @return 
    */
    
    public CitaMedica read(int codigo) {
        conexion.EstableserConexion();
        CitaMedica citaMedica=conexion.buscarCitaMed(codigo,getListaPasc(),getListaMedico());
        conexion.cerrarConexion();
        return citaMedica;
    }
    /**
     * Metodo Actualiza Objeto
     * @param citaMedica
     */
    public void update(CitaMedica citaMedica) {
        conexion.EstableserConexion();
        String insertPro = "UPDATE citamedica SET fechacita='"+citaMedica.getFechaCita()+"',precio='"+citaMedica.getPrecio()+"',paciente='"+citaMedica.getPaciente().getCodigo()+"',medico='"+citaMedica.getMedico().getCodigo()+"',diagnostico='"+citaMedica.getDiagnostico()+"' WHERE codigo="+citaMedica.getNumeroCita();
        conexion.InsertDatos(insertPro);

    }
    /**
     * Metodo que elimina un objeto por el codigo
     * @param codigo 
     */
    public void delete(int codigo) {
        conexion.EstableserConexion();
        String delete="DELETE FROM citamedica WHERE codigo="+codigo;
        conexion.InsertDatos(delete); 
    }
    /**
     * Metodo que retorna la lista del objeto
     * @return 
     */
    public Set<Paciente> getListaPasc() {
        listaPasc=new HashSet<>();
        conexion.EstableserConexion();
        conexion.listado(listaPasc);
        return listaPasc;
    }
    
    public Set<Medico> getListaMedico() {
        listaMedico=new HashSet<>();
        conexion.EstableserConexion();
        conexion.listadoMed(listaMedico);
        return listaMedico;
    }
    
    public Set<CitaMedica> getLista() {
        lista=new HashSet<>();
        conexion.EstableserConexion();
        conexion.listadoCitaMedi(lista,getListaPasc(),getListaMedico());
        return lista;
    }

}
