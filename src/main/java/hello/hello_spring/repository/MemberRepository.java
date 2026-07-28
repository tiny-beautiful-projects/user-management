package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

// Member 객체(회원 데이터)를 데이터베이스나 메모리 등 저장소에 저장하고 조회(검색)하는 역할의 '표준 규격(약속)'을 정의한 것
// "회원 정보를 저장하고, ID나 이름으로 찾거나, 전체 목록을 조회할 때 '어떤 기능들이 제공되어야 하는지' 선언해 둔 저장소 설계도"
// 메서드 선언: 반환타입 메서드 이름(파라미터 타입, 파라미터 이름)
public interface MemberRepository {
    // 전달받은 회원(member)을 저장소에 저장, 반환값: 저장 처리가 완료된 Member 객체를 다시 반환
    Member save(Member member);
    // 고유 번호(id)를 기준으로 회원을 찾아옵니다. 반환값: Optional<Member>의 의미: 조회한 ID에 해당하는 회원이 존재하지 않을 수 있기 때문에 null을 직접 반환하는 대신 Optional로 감싸서 반환
    Optional<Member> findById(Long id);
    // 회원 이름(name)을 기준으로 회원, 회원이 없을 경우를 대비해 Optional로 감싸서 반환
    Optional<Member> findByName(String name);
    // 저장소에 등록된 모든 회원 목록
    List<Member> findAll();
}
