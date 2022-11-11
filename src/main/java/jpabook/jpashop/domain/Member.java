package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Member {
    @GeneratedValue
    @Id
    @Column(name = "member_id") // 데이터베이스 테이블에서 컬럼명 지정
    private Long id;

    private String name;

    @Embedded // 선언해둔 내장타입을 연결
    private Address address;

    @OneToMany(mappedBy = "member") // 나는 orders 테이블의 거울일 뿐이에요
    private List<Order> orders = new ArrayList<>();

}
