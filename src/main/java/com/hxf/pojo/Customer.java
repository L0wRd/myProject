package com.hxf.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;


/**
 * @author: hxf
 * @date: 2019/9/12 10:03
 * @Description:
 */
//@Entity
@Data
public class Customer {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    @Id
    private String id;

    private String firstName;

    private String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
