/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Address;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
//    @ElementCollection(fetch = FetchType.LAZY)
//    @CollectionTable(
//            name = "CustomerHobbies",
//            joinColumns = @JoinColumn(name = "customerId", referencedColumnName = "id")
//    )
//    @Column(name = "hobbies")
//    private List<String> hobbies;
//    @ElementCollection(fetch = FetchType.LAZY)
//    @MapKeyColumn(name = "phone")
//    @Column(name = "description")
//    @CollectionTable(
//            name = "CustomerPhones",
//            joinColumns = @JoinColumn(name = "customerId", referencedColumnName = "id")
//    )
//    private Map<String, String> phones;

//    @OneToMany
//    @JoinColumn(name="customerId")
//    @OneToMany(mappedBy = "customer")
    @ManyToMany
    private List<Address> address;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = new ArrayList();
//        hobbies = new ArrayList();
//        phones = new HashMap();
    }

//    public void addPhone(String phoneNo, String description) {
//        phones.put(phoneNo, description);
//    }
//
//    public String getPhoneDescription(String phoneNo) {
//        return phones.get(phoneNo);
//    }
//    public String getHobbies() {
//
//        String str = "";
//        for (int i = 0; i <= hobbies.size() - 1; i++) {
//            if (i == hobbies.size() - 1) {
//                str += hobbies.get(i);
//
//            }
//            if (i != hobbies.size() - 1) {
//                str += hobbies.get(i) + ", ";
//            }
//        }
//        return str;
//    }
    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public void addHobby(String str) {
//        hobbies.add(str);
//    }
//
//    public void setHobbies(List<String> hobbies) {
//        this.hobbies = hobbies;
//    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Customer[ id=" + id + " ]";
    }

}
