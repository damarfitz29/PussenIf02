/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.pussenif.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WINDOWS 10
 */
@Entity
@Table(name = "subdivisi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subdivisi.findAll", query = "SELECT s FROM Subdivisi s")
    , @NamedQuery(name = "Subdivisi.findBySubdivId", query = "SELECT s FROM Subdivisi s WHERE s.subdivId = :subdivId")
    , @NamedQuery(name = "Subdivisi.findByNama", query = "SELECT s FROM Subdivisi s WHERE s.nama = :nama")
    , @NamedQuery(name = "Subdivisi.findByLastUpdate", query = "SELECT s FROM Subdivisi s WHERE s.lastUpdate = :lastUpdate")
    , @NamedQuery(name = "Subdivisi.findByIsActive", query = "SELECT s FROM Subdivisi s WHERE s.isActive = :isActive")})
public class Subdivisi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subdiv_id")
    private Integer subdivId;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "is_active")
    private int isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subdivId", fetch = FetchType.LAZY)
    private List<Divisi> divisiList;

    public Subdivisi() {
    }

    public Subdivisi(Integer subdivId) {
        this.subdivId = subdivId;
    }

    public Subdivisi(Integer subdivId, String nama, Date lastUpdate, int isActive) {
        this.subdivId = subdivId;
        this.nama = nama;
        this.lastUpdate = lastUpdate;
        this.isActive = isActive;
    }

    public Integer getSubdivId() {
        return subdivId;
    }

    public void setSubdivId(Integer subdivId) {
        this.subdivId = subdivId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Divisi> getDivisiList() {
        return divisiList;
    }

    public void setDivisiList(List<Divisi> divisiList) {
        this.divisiList = divisiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subdivId != null ? subdivId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subdivisi)) {
            return false;
        }
        Subdivisi other = (Subdivisi) object;
        if ((this.subdivId == null && other.subdivId != null) || (this.subdivId != null && !this.subdivId.equals(other.subdivId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.pussenif.model.Subdivisi[ subdivId=" + subdivId + " ]";
    }
    
}
