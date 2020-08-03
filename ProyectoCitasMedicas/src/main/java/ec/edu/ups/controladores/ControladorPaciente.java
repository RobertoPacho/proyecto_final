package ec.edu.ups.controladores;

import Conexion.Conexion_db;
import ec.edu.ups.modelo.Paciente;
import java.util.HashSet;
import java.util.Set;

public class ControladorPaciente {
    private final Conexion_db conexion;

    private Set<Paciente> lista;
    private int codigo;

    public ControladorPaciente() {
        conexion = new Conexion_db();
        lista = new HashSet<>();
        codigo = 0;
    }

    public int getCodigo() {
        conexion.EstableserConexion();
        codigo = conexion.codigo("paciente");
        return codigo + 1;

    }

    public void crear(Paciente paciente) {
        conexion.EstableserConexion();
        String insertPro = " INSERT INTO paciente (codigo,cedula, nombre, telefono,direccion, sintomas) "
                + " VALUES (" + paciente.getCodigo() + ",'" + paciente.getCedula() + " ',' " + paciente.getNombre() + " ',' "
                + paciente.getTelefono() + "',' " + paciente.getDireccion() + " ',' "
                + paciente.getSintomas() + "')";
        conexion.InsertDatos(insertPro);
        conexion.cerrarConexion();
    }

    

    public Paciente read(int codigo) {
        conexion.EstableserConexion();
        Paciente paciente=conexion.buscarPas(codigo);
        conexion.cerrarConexion();
        return paciente;
    }

    public Paciente readCedula(String cedula) {
        for (Paciente paciente : lista) {
            if (paciente.getCedula().equals(cedula)) {
                return paciente;
            }
        }
        return null;
    }

    public void update(Paciente paciente) {
        conexion.EstableserConexion();
        String insertPro = "UPDATE paciente SET cedula='"+paciente.getCedula()+"',nombre='"+paciente.getNombre()+"',telefono='"+paciente.getTelefono()+"',direccion='"+paciente.getDireccion()+"',sintomas='"+paciente.getSintomas()+"' WHERE codigo="+paciente.getCodigo();
        conexion.InsertDatos(insertPro);

    }

    public void delete(int codigo) {
        conexion.EstableserConexion();
        String delete="DELETE FROM paciente WHERE codigo="+codigo;
        conexion.InsertDatos(delete);
        
    }

    public Set<Paciente> getLista() {
        lista= new HashSet<>();
        conexion.EstableserConexion();
        conexion.listado(lista);
        return lista;

    }

}
