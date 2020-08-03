/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.CitaMedicaDetallada;
import ec.edu.ups.modelo.Medicina;
import ec.edu.ups.modelo.Medico;
import ec.edu.ups.modelo.Paciente;
import ec.edu.ups.modelo.Receta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */
public class Conexion_db {

    Connection con;
    Statement sentencia;
    ResultSet resultado;

    String driver = "org.mysql.Driver"; // el nombre de nuestro driver Postgres.
    String connectString = "jdbc:mysql://localhost/citasmedicas" + "?userTimezone=true&serverTimezone=UTC"; // llamamos nuestra bd
    String user = "root"; // usuario postgres
    String password = "patito.123"; // no tiene password nuestra bd.

    public boolean EstableserConexion() {
        try {
            con = DriverManager.getConnection(connectString, user, password);
            System.out.println("conectado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        try {
            this.sentencia = (Statement) this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
            //JOptionPane.showMessageDialog(null, "Error al crear objeto de declaracion " + ex);
            return false;
        }
        return true;
    }

    public void InsertDatos(String sql) {
        try {
            sentencia.execute(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(Conexion_db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int codigo(String tabla) {
        int codigo = 0;
        try {
            String sqlCont = "SELECT * FROM " + tabla + " ORDER BY 1";
            resultado = sentencia.executeQuery(sqlCont);
            while (resultado.next()) {
                codigo = resultado.getInt("codigo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        return codigo;
    }

    public void cerrarConexion() {
        try {
            con.close();
            sentencia.close();
            resultado.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion_db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listado(Set<Paciente> lista) {
        try {
            String sqlCont = "SELECT * FROM paciente ORDER BY codigo";
            resultado = sentencia.executeQuery(sqlCont);
            while (resultado.next()) {
                Paciente paciente = new Paciente(
                        resultado.getString("sintomas"),
                        resultado.getInt("codigo"),
                        resultado.getString("cedula"),
                        resultado.getString("nombre"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"));
                lista.add(paciente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public Paciente buscarPas(int codigo) {
        try {
            String sqlCont = "SELECT * FROM paciente where codigo=" + codigo;
            resultado = sentencia.executeQuery(sqlCont);
            while (resultado.next()) {
                Paciente paciente = new Paciente(
                        resultado.getString("sintomas"),
                        resultado.getInt("codigo"),
                        resultado.getString("cedula"),
                        resultado.getString("nombre"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"));
                return paciente;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    ////////////////////////////////////////Medico 

    public Medico buscarMed(int codigo) {
        try {
            String sqlCont = "SELECT * FROM medico where codigo=" + codigo;
            resultado = sentencia.executeQuery(sqlCont);
            while (resultado.next()) {
                Medico medico = new Medico(
                        resultado.getString("especialidad"),
                        resultado.getString("laboratorio"),
                        resultado.getInt("codigo"),
                        resultado.getString("cedula"),
                        resultado.getString("nombre"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"));
                return medico;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public void listadoMed(Set<Medico> lista) {
        try {
            String sqlCont = "SELECT * FROM medico ORDER BY codigo";
            resultado = sentencia.executeQuery(sqlCont);
            while (resultado.next()) {
                Medico medico = new Medico(
                        resultado.getString("especialidad"),
                        resultado.getString("laboratorio"),
                        resultado.getInt("codigo"),
                        resultado.getString("cedula"),
                        resultado.getString("nombre"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"));
                lista.add(medico);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    //////////////////////////Medicina

    public Medicina buscarMedi(int codigo) {
        try {
            String sqlCont = "SELECT * FROM medicina where codigo=" + codigo;
            resultado = sentencia.executeQuery(sqlCont);
            while (resultado.next()) {
                Medicina medicina = new Medicina(
                        resultado.getInt("codigo"),
                        resultado.getString("nombre"),
                        resultado.getString("marca"),
                        resultado.getString("descripcion"),
                        resultado.getDouble("precio"));
                return medicina;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        return null;

    }

    public void listadoMedi(Set<Medicina> lista) {
        try {
            String sqlCont = "SELECT * FROM medicina ORDER BY codigo";
            resultado = sentencia.executeQuery(sqlCont);
            while (resultado.next()) {
                Medicina medicina = new Medicina(
                        resultado.getInt("codigo"),
                        resultado.getString("nombre"),
                        resultado.getString("marca"),
                        resultado.getString("descripcion"),
                        resultado.getDouble("precio"));
                lista.add(medicina);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    /////////////////////////////////////////////////
    public CitaMedica buscarCitaMed(int codigo, Set<Paciente> listaPasc, Set<Medico> listaMidico) {
        //Paciente paciente = new Paciente();
        try {
            String sqlCont = "SELECT * FROM citamedica where codigo=" + codigo;
            resultado = sentencia.executeQuery(sqlCont);
            while (resultado.next()) {
                for (Paciente paciente : listaPasc) {
                    for (Medico medico : listaMidico) {
                        if (paciente.getCodigo() == resultado.getInt("cod_paciente")) {
                            if (medico.getCodigo() == resultado.getInt("cod_medico")) {
                                CitaMedica citaMedica = new CitaMedica(
                                        resultado.getInt("codigo"),
                                        resultado.getDate("fechacita"),
                                        resultado.getDouble("precio"),
                                        paciente,
                                        medico,
                                        resultado.getString("diagnostico"));
                                return citaMedica;
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public void listadoCitaMedi(Set<CitaMedica> lista, Set<Paciente> listaPasc, Set<Medico> listaMedico) {
        try {
            String sqlCont = "SELECT * FROM citamedica ORDER BY codigo";
            resultado = sentencia.executeQuery(sqlCont);
            while (resultado.next()) {
                for (Paciente paciente : listaPasc) {
                    for (Medico medico : listaMedico) {
                        if (paciente.getCodigo() == resultado.getInt("cod_paciente")) {
                            if (medico.getCodigo() == resultado.getInt("cod_medico")) {
                                CitaMedica citaMedica = new CitaMedica(
                                        resultado.getInt("codigo"),
                                        resultado.getDate("fechacita"),
                                        resultado.getDouble("precio"),
                                        paciente,
                                        medico,
                                        resultado.getString("diagnostico"));
                                lista.add(citaMedica);
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    //////////////////////////////////////////////////
    public void listadoMediDetallada(Set<CitaMedicaDetallada> lista) {
        try {
            String sqlCont = "SELECT * FROM citamedicadetallada ORDER BY codigo";
            resultado = sentencia.executeQuery(sqlCont);
            while (resultado.next()) {
                CitaMedicaDetallada citaMedicaDetallada = new CitaMedicaDetallada(
                        resultado.getInt("codigo"),
                        resultado.getString("diagnostico"));
                lista.add(citaMedicaDetallada);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

   public Receta buscarreceta(int codigo, Set<CitaMedica> listaCitaMedica, Set<Paciente> listaPasc, Set<Medicina> listaMedicina) {
        try {
            String sqlCont = "SELECT * FROM receta where codigo=" + codigo;
            resultado = sentencia.executeQuery(sqlCont);
            while (resultado.next()) {
                for (Paciente paciente : listaPasc) {
                    for (CitaMedica citaMedica : listaCitaMedica) {
                        for (Medicina medicina : listaMedicina) {
                            if (paciente.getCodigo() == resultado.getInt("cod_paciente")) {
                                if (citaMedica.getNumeroCita() == resultado.getInt("cod_citamedica")) {
                                    if (medicina.getCodigo() == resultado.getInt("cod_medicina")) {
                                            Receta receta = new Receta(
                                            resultado.getInt("codigo"),
                                            paciente,
                                            citaMedica,
                                            medicina,
                                            resultado.getString("indicaciones"));
                                    return receta;
                                }
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public void listadoReseta(Set<Receta> lista, Set<CitaMedica> listaCitaMedica, Set<Paciente> listaPasc, Set<Medicina> listaMedicina) {
        try {
            String sqlCont = "SELECT * FROM receta ORDER BY codigo";
            resultado = sentencia.executeQuery(sqlCont);
            while (resultado.next()) {
                for (Paciente paciente : listaPasc) { 
                    for (CitaMedica citaMedica : listaCitaMedica) {
                        for (Medicina medicina : listaMedicina) {
                            if (paciente.getCodigo() == resultado.getInt("cod_paciente")) {
                                if (citaMedica.getNumeroCita() == resultado.getInt("cod_citamedica")) {
                                    if (medicina.getCodigo() == resultado.getInt("cod_medicina")) {
                                            Receta receta = new Receta(
                                            resultado.getInt("codigo"),
                                            paciente,
                                            citaMedica,
                                            medicina,
                                            resultado.getString("indicaciones"));
                                    lista.add(receta);
                                }
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
