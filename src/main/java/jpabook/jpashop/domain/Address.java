package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
@Getter
@Embeddable // JPA의 내장타입. 어딘가에 내장될 수 있다.
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() { // JPA는 기본생성자를 요구하는데 public과 protected, 안전하게 protected
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
