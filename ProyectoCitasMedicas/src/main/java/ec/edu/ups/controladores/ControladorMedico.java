package ec.edu.ups.controladores;
import Conexion.Conexion_db;
import ec.edu.ups.modelo.Medico;
import java.util.HashSet;
import java.util.Set;

public class ControladorMedico {
    private final Conexion_db conexion;
    
    private Set<Medico> lista;
    private int codigo;

    public ControladorMedico() {
        conexion = new Conexion_db();
        lista = new HashSet<>();
        codigo = 0;
    }

    public int getCodigo() {
        conexion.EstableserConexion();
        codigo = conexion.codigo("medico");
        return codigo + 1;
    }

    public void crear(Medico medico) {
        conexion.EstableserConexion();
        String insertPro = " INSERT INTO medico (codigo,cedula, nombre, telefono,direccion, especialidad,laboratorio) "
                + " VALUES (" + medico.getCodigo() + ",'" + medico.getCedula() + " ',' " + medico.getNombre() + " ',' "
                + medico.getTelefono() + "',' " + medico.getDireccion() + " ',' "
                + medico.getEspecialidad() + "',' " + medico.getLaboratorio() + " ')";
        conexion.InsertDatos(insertPro);
        conexion.cerrarConexion();
    }

    public Medico read(int codigo) {
        conexion.EstableserConexion();
        Medico medico=conexion.buscarMed(codigo);
        conexion.cerrarConexion();
        return medico;
    }

    public Medico readCedula(String cedula) {
        for (Medico medico : lista) {
            if (medico.getCedula().equals(cedula)) {
                return medico;
            }
        }
        return null;
    }

    public void update(Medico medico) {
        conexion.EstableserConexion();
        String insertPro = "UPDATE medico SET cedula='"+medico.getCedula()+"',nombre='"+medico.getNombre()+"',telefono='"+medico.getTelefono()+"',direccion='"+medico.getDireccion()+"',especialidad='"+medico.getEspecialidad()+"',laboratorio='"+medico.getLaboratorio()+"' WHERE codigo="+medico.getCodigo();
        conexion.InsertDatos(insertPro);
    }

    public void delete(int codigo) {
        conexion.EstableserConexion();
        String delete="DELETE FROM medico WHERE codigo="+codigo;
        conexion.InsertDatos(delete);
    }

    public Set<Medico> getLista() {
        conexion.EstableserConexion();
        conexion.listadoMed(lista);
        return lista;

    }

}

    

