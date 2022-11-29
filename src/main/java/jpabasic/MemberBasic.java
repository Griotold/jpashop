package jpabasic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor // JPA는 기본 생성자를 요구한다.
public class MemberBasic {

    @Id
    private Long id;
    private String name;
    public MemberBasic(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
