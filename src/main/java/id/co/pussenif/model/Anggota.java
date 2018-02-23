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
import javax.persistence.Lob;
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
@Table(name = "anggota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anggota.findAll", query = "SELECT a FROM Anggota a")
    , @NamedQuery(name = "Anggota.findByAnggotaId", query = "SELECT a FROM Anggota a WHERE a.anggotaId = :anggotaId")
    , @NamedQuery(name = "Anggota.findByNrp", query = "SELECT a FROM Anggota a WHERE a.nrp = :nrp")
    , @NamedQuery(name = "Anggota.findByNama", query = "SELECT a FROM Anggota a WHERE a.nama = :nama")
    , @NamedQuery(name = "Anggota.findByTanggalLahir", query = "SELECT a FROM Anggota a WHERE a.tanggalLahir = :tanggalLahir")
    , @NamedQuery(name = "Anggota.findByAlamat", query = "SELECT a FROM Anggota a WHERE a.alamat = :alamat")
    , @NamedQuery(name = "Anggota.findByAgama", query = "SELECT a FROM Anggota a WHERE a.agama = :agama")
    , @NamedQuery(name = "Anggota.findByJnsKelamin", query = "SELECT a FROM Anggota a WHERE a.jnsKelamin = :jnsKelamin")
    , @NamedQuery(name = "Anggota.findByNoTelp", query = "SELECT a FROM Anggota a WHERE a.noTelp = :noTelp")
    , @NamedQuery(name = "Anggota.findByStatus", query = "SELECT a FROM Anggota a WHERE a.status = :status")
    , @NamedQuery(name = "Anggota.findByTglAktif", query = "SELECT a FROM Anggota a WHERE a.tglAktif = :tglAktif")
    , @NamedQuery(name = "Anggota.findByLastUpdate", query = "SELECT a FROM Anggota a WHERE a.lastUpdate = :lastUpdate")
    , @NamedQuery(name = "Anggota.findByIsActive", query = "SELECT a FROM Anggota a WHERE a.isActive = :isActive")})
public class Anggota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "anggota_id")
    private Integer anggotaId;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "nrp")
    private int nrp;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "tanggal_lahir")
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 10)
    @Column(name = "agama")
    private String agama;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 10)
    @Column(name = "jns_kelamin")
    private String jnsKelamin;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 15)
    @Column(name = "no_telp")
    private String noTelp;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "tgl_aktif")
    @Temporal(TemporalType.DATE)
    private Date tglAktif;
    @Basic(optional = false)
    //@NotNull
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "is_active")
    private int isActive;
    @JoinColumn(name = "golongan_id", referencedColumnName = "golongan_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Golongan golonganId;
    @JoinColumn(name = "divisi_id", referencedColumnName = "divisi_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Divisi divisiId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anggotaId", fetch = FetchType.LAZY)
    private List<Presensi> presensiList;

    public Anggota() {
    }

    public Anggota(Integer anggotaId) {
        this.anggotaId = anggotaId;
    }

    public Anggota(Integer anggotaId, int nrp, String nama, Date tanggalLahir, String alamat, String agama, String jnsKelamin, String noTelp, String status, Date tglAktif, byte[] foto, Date lastUpdate, int isActive) {
        this.anggotaId = anggotaId;
        this.nrp = nrp;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
        this.agama = agama;
        this.jnsKelamin = jnsKelamin;
        this.noTelp = noTelp;
        this.status = status;
        this.tglAktif = tglAktif;
        this.foto = foto;
        this.lastUpdate = lastUpdate;
        this.isActive = isActive;
    }

    public Integer getAnggotaId() {
        return anggotaId;
    }

    public void setAnggotaId(Integer anggotaId) {
        this.anggotaId = anggotaId;
    }

    public int getNrp() {
        return nrp;
    }

    public void setNrp(int nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getJnsKelamin() {
        return jnsKelamin;
    }

    public void setJnsKelamin(String jnsKelamin) {
        this.jnsKelamin = jnsKelamin;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTglAktif() {
        return tglAktif;
    }

    public void setTglAktif(Date tglAktif) {
        this.tglAktif = tglAktif;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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

    public Golongan getGolonganId() {
        return golonganId;
    }

    public void setGolonganId(Golongan golonganId) {
        this.golonganId = golonganId;
    }

    public Divisi getDivisiId() {
        return divisiId;
    }

    public void setDivisiId(Divisi divisiId) {
        this.divisiId = divisiId;
    }

    @XmlTransient
    public List<Presensi> getPresensiList() {
        return presensiList;
    }

    public void setPresensiList(List<Presensi> presensiList) {
        this.presensiList = presensiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anggotaId != null ? anggotaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anggota)) {
            return false;
        }
        Anggota other = (Anggota) object;
        if ((this.anggotaId == null && other.anggotaId != null) || (this.anggotaId != null && !this.anggotaId.equals(other.anggotaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.pussenif.model.Anggota[ anggotaId=" + anggotaId + " ]";
    }
    
}
