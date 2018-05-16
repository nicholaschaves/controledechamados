/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author dma
 */
@Entity
@Table(name = "chamados", catalog = "", schema = "")
@NamedQueries({
    @NamedQuery(name = "Chamados.findAll", query = "SELECT c FROM Chamados c")
    , @NamedQuery(name = "Chamados.findById", query = "SELECT c FROM Chamados c WHERE c.id = :id")
    , @NamedQuery(name = "Chamados.findByRequerente", query = "SELECT c FROM Chamados c WHERE c.requerente = :requerente")
    , @NamedQuery(name = "Chamados.findBySetor", query = "SELECT c FROM Chamados c WHERE c.setor = :setor")
    , @NamedQuery(name = "Chamados.findByReclamacao", query = "SELECT c FROM Chamados c WHERE c.reclamacao = :reclamacao")
    , @NamedQuery(name = "Chamados.findByConclusao", query = "SELECT c FROM Chamados c WHERE c.conclusao = :conclusao")
    , @NamedQuery(name = "Chamados.findByStatus", query = "SELECT c FROM Chamados c WHERE c.status = :status")})
public class Chamados implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "requerente")
    private String requerente;
    @Column(name = "setor")
    private String setor;
    @Column(name = "reclamacao")
    private String reclamacao;
    @Column(name = "conclusao")
    private String conclusao;
    @Column(name = "status")
    private String status;

    public Chamados() {
    }

    public Chamados(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getRequerente() {
        return requerente;
    }

    public void setRequerente(String requerente) {
        String oldRequerente = this.requerente;
        this.requerente = requerente;
        changeSupport.firePropertyChange("requerente", oldRequerente, requerente);
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        String oldSetor = this.setor;
        this.setor = setor;
        changeSupport.firePropertyChange("setor", oldSetor, setor);
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        String oldReclamacao = this.reclamacao;
        this.reclamacao = reclamacao;
        changeSupport.firePropertyChange("reclamacao", oldReclamacao, reclamacao);
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        String oldConclusao = this.conclusao;
        this.conclusao = conclusao;
        changeSupport.firePropertyChange("conclusao", oldConclusao, conclusao);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chamados)) {
            return false;
        }
        Chamados other = (Chamados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Chamados[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
