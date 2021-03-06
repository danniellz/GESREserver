package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Clase que declara el estado SignIn del usuario
 *
 * @author  Aritz Arrieta, Jonathan Viñan
 */
@Entity
@Table(name = "signIn", schema = "gesredb")
@XmlRootElement
public class SignIn implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Id del signIn. Es la clave primaria de la tabla "signIn".
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * Fecha del último acceso del usuario.
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSignIn;
    
    
    @ManyToOne
    private Usuario usuario;

    @XmlTransient
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que obtiene el id del signIn.
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Método que establece el id del signIn.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que obtiene el último acceso del usuario.
     *
     * @return el último acceso que se va a mostrar.
     */
    public Date getLastSignIn() {
        return lastSignIn;
    }

    /**
     * Método que establece el último acceso del usuario.
     *
     * @param LastSignIn el último acceso que se va a guardar.
     */
    public void setLastSignIn(Date lastSignIn) {
        this.lastSignIn = lastSignIn;
    }

   

  
    

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.lastSignIn);
        hash = 59 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

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
        final SignIn other = (SignIn) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.lastSignIn, other.lastSignIn)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

   

}
