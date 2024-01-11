/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nikit
 */
@Entity
public class Product implements Serializable {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;   
   private String type;
   private int price;
   private int quantity;//количество товара 
   private String brand;
   private String Model;

    public Product() {
    }

    public Product(Long id, String type, int price, int quantity, String brand, String Model) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.Model = Model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.type);
        hash = 23 * hash + this.price;
        hash = 23 * hash + this.quantity;
        hash = 23 * hash + Objects.hashCode(this.brand);
        hash = 23 * hash + Objects.hashCode(this.Model);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.price != other.price) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.brand, other.brand)) {
            return false;
        }
        if (!Objects.equals(this.Model, other.Model)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id 
                + ", type=" + type 
                + ", price=" + price 
                + ", quantity=" + quantity 
                + ", brand=" + brand 
                + ", Model=" + Model 
                + '}';
    }

   

}

