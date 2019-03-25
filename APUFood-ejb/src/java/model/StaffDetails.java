/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author George
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "StaffDetails.selectByID", query = "SELECT s FROM StaffDetails s where s.id = :y")
    ,
    @NamedQuery(name = "StaffDetails.selectByStatus", query = "SELECT s FROM StaffDetails s where s.staffstatus like '%Occupied%'")
    ,
@NamedQuery(name = "StaffDetails.findByGender", query = "SELECT a FROM StaffDetails a WHERE a.gender = :x")}
)
public class StaffDetails implements Serializable {
//-	Name, ID, gender, phone, IC, email, address

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String password;
    private String staffname;
    private char gender;
    private int phone;
    private String ic;
    private String email;
    private String address;
    private char staffrole;
    private String staffstatus;

    public StaffDetails(String id, String password, String staffname, char gender, int phone, String ic, String email, String address, char staffrole, String staffstatus) {
        this.id = id;
        this.password = password;
        this.staffname = staffname;
        this.gender = gender;
        this.phone = phone;
        this.ic = ic;
        this.email = email;
        this.address = address;
        this.staffrole = staffrole;
        this.staffstatus = staffstatus;
    }

    public StaffDetails() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPassword() {
        return password;
    }

    public String getStaffname() {
        return staffname;
    }

    public char getGender() {
        return gender;
    }

    public char getStaffrole() {
        return staffrole;
    }

    public String getStaffstatus() {
        return staffstatus;
    }

    public int getPhone() {
        return phone;
    }

    public String getIc() {
        return ic;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public char getRole() {
        return staffrole;
    }

    public void setRole(char role) {
        this.staffrole = role;
    }

    public void setStaffrole(char staffrole) {
        this.staffrole = staffrole;
    }

    public void setStaffstatus(String staffstatus) {
        this.staffstatus = staffstatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
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
        if (!(object instanceof StaffDetails)) {
            return false;
        }
        StaffDetails other = (StaffDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.StaffDetails[ id=" + id + " ]";
    }

}
