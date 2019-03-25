/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author George
 */
@Entity
@NamedQueries({
    @NamedQuery(name="TempFoodOrder.selectByID", query = "SELECT s FROM TempFoodOrder s where s.userid = :y")})
public class TempFoodOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userid;
    private String orderdatetime;
    private int price;
    private String address;
    private String status;
    private int quantity;
    private char deliverystatus;
    private String deliveryman;
    private String rating;
    ArrayList<String> foodid = new ArrayList<>();
//    @OneToMany
//    private  List<FoodDetails> foodid = new ArrayList<FoodDetails> ();
//    @OneToMany
//    private  List<UserAccount> userid = new ArrayList<UserAccount> ();

    public TempFoodOrder(String userid, ArrayList<String> foodid, String orderdatetime, int price, String address, String status, int quantity, char deliverystatus, String deliveryman) {
        this.userid = userid;
        this.foodid = foodid;
        this.orderdatetime = orderdatetime;
        this.price = price;
        this.address = address;
        this.status = status;
        this.quantity = quantity;
        this.deliverystatus = deliverystatus;
        this.deliveryman = deliveryman;
    }
    
      public TempFoodOrder(String foodid) {
          this.foodid.add(foodid);
    }

    public String getDeliveryman() {
        return deliveryman;
    }

    public char getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(char deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    public String getUserid() {
        return userid;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    
    

    public ArrayList<String> getFoodid() {
        return foodid;
    }

    public void setDeliveryman(String deliveryman) {
        this.deliveryman = deliveryman;
    }
    
    

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setFoodid(ArrayList<String> foodid) {
        this.foodid = foodid;
    }



    public TempFoodOrder() {
    }


    public int getQuantity() {
        return quantity;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    public String getOrderdatetime() {
        return orderdatetime;
    }


    public int getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

        public String getStatus() {
        return status;
    }

 

   

    public void setOrderdatetime(String orderdatetime) {
        this.orderdatetime = orderdatetime;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    public void setPrice(int price) {
        this.price = price;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof TempFoodOrder)) {
            return false;
        }
        TempFoodOrder other = (TempFoodOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TempFoodOrder[ id=" + id + " ]";
    }
    
}
