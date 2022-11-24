package jpabook.jpashop.web;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {
    // 아이템 공통속성
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
    
    // 책 고유 속성
    private String author;
    private String isbn;

}
