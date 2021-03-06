/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author patels
 */
@Entity
@Table(name = "registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registration.findAll", query = "SELECT r FROM Registration r"),
    @NamedQuery(name = "Registration.findByRid", query = "SELECT r FROM Registration r WHERE r.rid = :rid"),
    @NamedQuery(name = "Registration.findByName", query = "SELECT r FROM Registration r WHERE r.name = :name"),
    @NamedQuery(name = "Registration.findByEmailid", query = "SELECT r FROM Registration r WHERE r.emailid = :emailid"),
    @NamedQuery(name = "Registration.findByContact", query = "SELECT r FROM Registration r WHERE r.contact = :contact"),
    @NamedQuery(name = "Registration.findByAddress", query = "SELECT r FROM Registration r WHERE r.address = :address")})
public class Registration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    @Basic(optional = false)
    @Column(name = "rid")
    private Integer rid;
    @Column(name = "name")
    private String name;
    @Column(name = "emailid")
    private String emailid;
    @Column(name = "contact")
    private String contact;
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "lid", referencedColumnName = "lid")
    @ManyToOne(optional = false)
    private Login lid;

    public Registration() {
    }

    public Registration(Integer rid) {
        this.rid = rid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Login getLid() {
        return lid;
    }

    public void setLid(Login lid) {
        this.lid = lid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registration)) {
            return false;
        }
        Registration other = (Registration) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Registration[ rid=" + rid + " ]";
    }
    
}
