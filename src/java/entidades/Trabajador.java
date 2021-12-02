/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Clase que define los atributos y los métodos de la entidad "Trabajador".
 *
 * @author Jonathan Viñan
 */
//Queries para realizar opreciones en la base de datos
@NamedQueries({
    //Busca todos los TRabajadores y sus atributos 
    @NamedQuery(
            name = "listarTrabajadores", query = "SELECT t FROM Trabajador t"
    )
})
@Entity
@Table(name = "trabajador", schema = "gesredb")
public class Trabajador implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Precio a las horas incurridas en el Trabajador
     */
    @NotNull
    private Double precioHora;

    /**
     * Fecha del contrato del Trabajador
     */
    @NotNull
    private Timestamp fechaContrato;

    /**
     * Metodo que obtine el pricio hora del trbajador
     *
     * @return
     */
    public Double getPrecioHora() {
        return precioHora;
    }

    /**
     * Metodo que establece el precio hora del trabajador
     *
     * @param precioHora
     */
    public void setPrecioHora(Double precioHora) {
        this.precioHora = precioHora;
    }

    /**
     * Metodo que obtine el fecha contrato del trbajador
     *
     * @return
     */
    public Timestamp getFechaContrato() {
        return fechaContrato;
    }

    /**
     * Metodo que establece la fecha contrato del trabajador
     *
     * @param fechaContrato
     */
    public void setFechaContrato(Timestamp fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    /**
     * Método que compara el código hash de dos objetos.
     *
     * @return el código hash del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.precioHora);
        hash = 71 * hash + Objects.hashCode(this.fechaContrato);
        return hash;
    }

    /**
     * Método que compara si un objeto es igual al objeto "Trabajador".
     *
     * @param obj cualquier tipo de objeto.
     * @return un "false" si los objetos no son iguales y un "true" si lo son.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trabajador other = (Trabajador) obj;
        if (!Objects.equals(this.precioHora, other.precioHora)) {
            return false;
        }
        if (!Objects.equals(this.fechaContrato, other.fechaContrato)) {
            return false;
        }
        return true;
    }

    /**
     * Método que devuelve un String con los atributos del Trabajdor.
     *
     * @return un String con los atributos de la entidad.
     */
    @Override
    public String toString() {
        return "Trabajador{" + "precioHora=" + precioHora + ", fechaContrato=" + fechaContrato + '}';
    }

}
