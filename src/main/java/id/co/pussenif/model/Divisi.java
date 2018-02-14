/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.pussenif.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    , @NamedQuery(name = "Divisi.findByLevel", query = "SELECT d FROM Divisi d WHERE d.level = :level")})
public class Divisi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIVISI_ID")
    private Integer divisiId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAMA")
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LEVEL")
    private int level;
    @OneToMany(mappedBy = "divisiId", fetch = FetchType.LAZY)
    private List<Anggota> anggotaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId", fetch = FetchType.LAZY)
    private List<Divisi> divisiList;
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "DIVISI_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Divisi parentId;

    public Divisi() {
    }

    public Divisi(Integer divisiId) {
        this.divisiId = divisiId;
    }

    public Divisi(Integer divisiId, String nama, int level) {
        this.divisiId = divisiId;
        this.nama = nama;
        this.level = level;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @XmlTransient
    public List<Anggota> getAnggotaList() {
        return anggotaList;
    }

    public void setAnggotaList(List<Anggota> anggotaList) {
        this.anggotaList = anggotaList;
    }

    @XmlTransient
    public List<Divisi> getDivisiList() {
        return divisiList;
    }

    public void setDivisiList(List<Divisi> divisiList) {
        this.divisiList = divisiList;
    }

    public Divisi getParentId() {
        return parentId;
    }

    public void setParentId(Divisi parentId) {
        this.parentId = parentId;
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
        return "id.co.pussenif.Divisi[ divisiId=" + divisiId + " ]";
    }
    
}
