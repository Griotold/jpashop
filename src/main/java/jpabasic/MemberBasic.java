package jpabasic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class MemberBasic {
    @Id
    private Long id;
    private String name;
}
