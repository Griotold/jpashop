package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    // 인젝션 방식 : 필드, 세터, 생성자
    // 권장 방식은 생성자
    // final : 바꿀 일이 없기 때문에
    private final MemberRepository memberRepository;

    // @Autowired 생성자가 하나만 있는 경우 스프링이 자동으로 인젝션
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /**
     * 회원가입
     * */
    @Transactional // readOnly = false(default)
    public Long join(Member member){
        // 중복 회원 검증
        validateDuplicateMember(member);

        // 실제 등록 로직
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    /**
     * 회원 전체 조회
     * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    /**
     * 단건 조회
     * */
    public Member findOne(Long MemberId) {
        return memberRepository.findOne(MemberId);
    }
}
