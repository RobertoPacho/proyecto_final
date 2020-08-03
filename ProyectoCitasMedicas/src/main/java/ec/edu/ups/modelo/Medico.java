package ec.edu.ups.modelo;

import java.util.Date;

public class Medico extends Persona {
private String especialidad;
private String laboratorio;


    public Medico() {
    }

    public Medico(String especialidad, String laboratoio) {
        this.especialidad = especialidad;
        this.laboratorio = laboratoio;
        
    }

    public Medico(String especialidad, String laboratoio, int codigo, String cedula, String nombre, String telefono, String direccion) {
        super(codigo, cedula, nombre, telefono, direccion);
        this.especialidad = especialidad;
        this.laboratorio = laboratoio;
        
    }
    

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratoio(String laboratoio) {
        this.laboratorio = laboratoio;
    }

    

    @Override
    public String toString() {
        return "Medico{" + "especialidad=" + especialidad + ", laboratoio=" + laboratorio + ")";
    }


}
