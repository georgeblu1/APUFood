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
import javax.persistence.OneToOne;

/**
 *
 * @author George
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "UserAccount.selectByID", query = "SELECT s FROM UserAccount s where s.id = :y")
    ,
         @NamedQuery(name = "UserAccount.findByGender", query = "SELECT a FROM UserAccount a WHERE a.gender = :x")})
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String password;
    private String name;
    private int ic;
    private char gender;
    private int phoneno;
    private String email;
    private String address;
    private char status;

    @OneToMany
    private List<UserMoney> money = new ArrayList<UserMoney>();

//    @OneToMany
//    private List<CustFoodOrder> order = new ArrayList<CustFoodOrder> ();
//    
//     @OneToOne
//    private List<TempFoodOrder> temporder = new ArrayList<TempFoodOrder> ();
    public UserAccount() {
    }

    public UserAccount(String id, String password, String name, int ic, char gender, int phoneno, String email, String address, char status, UserMoney a) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.ic = ic;
        this.gender = gender;
        this.phoneno = phoneno;
        this.email = email;
        this.address = address;
        this.status = status;
        money.add(a);
    }
//    public UserAccount(String id, String address, TempFoodOrder a) {
//        this.id = id;
//        this.address = address;
//        temporder.add(a);
//    }

    public String getId() {
        return id;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getIc() {
        return ic;
    }

    public char getGender() {
        return gender;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIc(int ic) {
        this.ic = ic;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<UserMoney> getMoney() {
        return money;
    }

//    public List<CustFoodOrder> getOrder() {
//        return order;
//    }
//    
//    
//
//    public void setOrder(List<CustFoodOrder> order) {
//        this.order = order;
//    }
//    
    public void setMoney(List<UserMoney> money) {
        this.money = money;
    }

//    public List<TempFoodOrder> getTemporder() {
//        return temporder;
//    }
//
//    public void setTemporder(List<TempFoodOrder> temporder) {
//        this.temporder = temporder;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserAccount[ id=" + id + " ]";
    }

}
