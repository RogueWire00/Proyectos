/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcial3.aplicacion;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Gustavo
 */
@Entity
@Table(name = "palabras", catalog = "traductor", schema = "")
@NamedQueries({
    @NamedQuery(name = "Palabras.findAll", query = "SELECT p FROM Palabras p"),
    @NamedQuery(name = "Palabras.findByPalabraOrigen", query = "SELECT p FROM Palabras p WHERE p.palabraOrigen = :palabraOrigen"),
    @NamedQuery(name = "Palabras.findByPalabraResultado", query = "SELECT p FROM Palabras p WHERE p.palabraResultado = :palabraResultado"),
    @NamedQuery(name = "Palabras.findByIdioma", query = "SELECT p FROM Palabras p WHERE p.idioma = :idioma"),
    @NamedQuery(name = "Palabras.findByCodigo", query = "SELECT p FROM Palabras p WHERE p.codigo = :codigo")})
public class Palabras implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PalabraOrigen")
    private String palabraOrigen;
    @Basic(optional = false)
    @Column(name = "PalabraResultado")
    private String palabraResultado;
    @Basic(optional = false)
    @Column(name = "Idioma")
    private String idioma;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;

    public Palabras() {
    }

    public Palabras(String codigo) {
        this.codigo = codigo;
    }

    public Palabras(String codigo, String palabraOrigen, String palabraResultado, String idioma) {
        this.codigo = codigo;
        this.palabraOrigen = palabraOrigen;
        this.palabraResultado = palabraResultado;
        this.idioma = idioma;
    }

    public String getPalabraOrigen() {
        return palabraOrigen;
    }

    public void setPalabraOrigen(String palabraOrigen) {
        String oldPalabraOrigen = this.palabraOrigen;
        this.palabraOrigen = palabraOrigen;
        changeSupport.firePropertyChange("palabraOrigen", oldPalabraOrigen, palabraOrigen);
    }

    public String getPalabraResultado() {
        return palabraResultado;
    }

    public void setPalabraResultado(String palabraResultado) {
        String oldPalabraResultado = this.palabraResultado;
        this.palabraResultado = palabraResultado;
        changeSupport.firePropertyChange("palabraResultado", oldPalabraResultado, palabraResultado);
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        String oldIdioma = this.idioma;
        this.idioma = idioma;
        changeSupport.firePropertyChange("idioma", oldIdioma, idioma);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palabras)) {
            return false;
        }
        Palabras other = (Palabras) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hn.uth.pa1.parcial3.aplicacion.Palabras[ codigo=" + codigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
