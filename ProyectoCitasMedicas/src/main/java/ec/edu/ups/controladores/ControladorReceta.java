/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import Conexion.Conexion_db;
import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.Medicina;
import ec.edu.ups.modelo.Medico;
import ec.edu.ups.modelo.Paciente;
import ec.edu.ups.modelo.Receta;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rober
 */
public class ControladorReceta {

    //declaracion de variables
    private final Conexion_db conexion;
    private Set<Receta> lista;
    private Set<CitaMedica> listaCitaMedica;
    private Set<Paciente> listaPasc;
    private Set<Medicina> listaMedicina;
    private Set<Medico> listaMedico;
    private int codigo;

    //constructor inicia variables
    public ControladorReceta() {
        conexion = new Conexion_db();
        lista = new HashSet<>();
        listaCitaMedica = new HashSet<>();
        listaPasc = new HashSet<>();
        listaMedicina = new HashSet<>();
        listaMedico = new HashSet<>();
        codigo = 0;
    }

    //metodo que obtiene el codigo
    public int getCodigo() {
        conexion.EstableserConexion();
        codigo = conexion.codigo("receta");
        return codigo + 1;
    }

    public void cread(int codigopas,Receta receta) {
        conexion.EstableserConexion();
        String insertPro = " INSERT INTO receta (codigo,cod_paciente, cod_citamedica, cod_medicina,indicaciones) "
                + " VALUES (" + receta.getCodigo() + "," + codigopas + "," + receta.getCitaMedica().getNumeroCita() + ","
                + receta.getMedicina().getCodigo() + ",' " + receta.getIndicaciones() + " ')";
        conexion.InsertDatos(insertPro);
        conexion.cerrarConexion();
    }

    public Receta read(int codigo) {
        conexion.EstableserConexion();
        Receta receta=conexion.buscarreceta(codigo, listaCitaMedica, listaPasc, listaMedicina);
        conexion.cerrarConexion();
        return receta;
    }

    public void update(Receta objeto) {
        if (lista.contains(objeto)) {
            lista.remove(objeto);
            lista.add(objeto);
        }
    }

    public void delete(int codigo) {
        for (Receta receta : lista) {
            if (receta.getCodigo() == codigo) {
                lista.remove(receta);
                break;
            }
        }
    }

    public Set<Paciente> getListaPasc() {
        listaPasc = new HashSet<>();
        conexion.EstableserConexion();
        conexion.listado(listaPasc);
        return listaPasc;
    }

    public Set<Medicina> getListaMedicina() {
        listaMedicina = new HashSet<>();
        conexion.EstableserConexion();
        conexion.listadoMedi(listaMedicina);
        return listaMedicina;
    }

    public Set<Medico> getListaMedico() {
        listaMedico = new HashSet<>();
        conexion.EstableserConexion();
        conexion.listadoMed(listaMedico);
        return listaMedico;
    }

    public Set<CitaMedica> getListaCitaMedica() {
        listaCitaMedica = new HashSet<>();
        conexion.EstableserConexion();
        conexion.listadoCitaMedi(listaCitaMedica, listaPasc, listaMedico);
        return listaCitaMedica;
    }

    public Set<Receta> getLista() {
        lista = new HashSet<>();
        conexion.EstableserConexion();
        conexion.listadoReseta(lista,getListaCitaMedica(), getListaPasc(),getListaMedicina());
        return lista;

    }

}
