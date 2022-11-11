package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne // 일대다 관계에서 다쪽이 연관관계의 주인. 외래키를 갖고 있는 놈
    @JoinColumn(name = "member_id") // 테이블상에서 member.member_id와 연결
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; // 주문 시간

    @Enumerated(EnumType.STRING) // ORDINAL로 절대하지말고 꼭 STRING
    private OrderStatus status; // 주문상태 [ORDER, CANCEL]

}
