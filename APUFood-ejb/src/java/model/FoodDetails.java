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
import javax.persistence.Query;

/**
 *
 * @author George
 */
@Entity
@NamedQueries({
    @NamedQuery(name="FoodDetails.selectByID", query = "SELECT s FROM FoodDetails s where s.id = :y")})
public class FoodDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String foodname;
    private int price;
    private int quantity;
    private String description;
    private char foodtype; //drinks or solid food
    

    public FoodDetails() {
    }

    public FoodDetails(String id, String foodname, int price, int quantity, String description, char foodtype) {
        this.id = id;
        this.foodname = foodname;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.foodtype = foodtype;
    }

    public FoodDetails(String id, String foodname, String description) {
        this.id = id;
        this.foodname = foodname;
        this.description = description;
    }

    public String getFoodname() {
        return foodname;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public char getFoodtype() {
        return foodtype;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public void setFoodtype(char foodtype) {
        this.foodtype = foodtype;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
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
        if (!(object instanceof FoodDetails)) {
            return false;
        }
        FoodDetails other = (FoodDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FoodDetails[ id=" + id + " ]";
    }
    
//    public FoodDetails SearchID(String id){
//        FoodDetails fd = null;
//        Query query = 
//    }
    
}
