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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "divisi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divisi.findAll", query = "SELECT d FROM Divisi d")
    , @NamedQuery(name = "Divisi.findByDivisiId", query = "SELECT d FROM Divisi d WHERE d.divisiId = :divisiId")
    , @NamedQuery(name = "Divisi.findByNama", query = "SELECT d FROM Divisi d WHERE d.nama = :nama")
    , @NamedQuery(name = "Divisi.findByLastUpdate", query = "SELECT d FROM Divisi d WHERE d.lastUpdate = :lastUpdate")
    , @NamedQuery(name = "Divisi.findByIsActive", query = "SELECT d FROM Divisi d WHERE d.isActive = :isActive")})
public class Divisi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "divisi_id")
    private Integer divisiId;
    @Basic(optional = false)
    //@NotNull
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisiId", fetch = FetchType.LAZY)
    private List<Anggota> anggotaList;
    @JoinColumn(name = "subdiv_id", referencedColumnName = "subdiv_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subdivisi subdivId;

    public Divisi() {
    }

    public Divisi(Integer divisiId) {
        this.divisiId = divisiId;
    }

    public Divisi(Integer divisiId, String nama, Date lastUpdate, int isActive) {
        this.divisiId = divisiId;
        this.nama = nama;
        this.lastUpdate = lastUpdate;
        this.isActive = isActive;
    }

    public Integer getDivisiId() {
        return divisiId;
    }

    public void setDivisiId(Integer divisiId) {
        this.divisiId = divisiId;
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
    public List<Anggota> getAnggotaList() {
        return anggotaList;
    }

    public void setAnggotaList(List<Anggota> anggotaList) {
        this.anggotaList = anggotaList;
    }

    public Subdivisi getSubdivId() {
        return subdivId;
    }

    public void setSubdivId(Subdivisi subdivId) {
        this.subdivId = subdivId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (divisiId != null ? divisiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisi)) {
            return false;
        }
        Divisi other = (Divisi) object;
        if ((this.divisiId == null && other.divisiId != null) || (this.divisiId != null && !this.divisiId.equals(other.divisiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.pussenif.model.Divisi[ divisiId=" + divisiId + " ]";
    }
    
}
