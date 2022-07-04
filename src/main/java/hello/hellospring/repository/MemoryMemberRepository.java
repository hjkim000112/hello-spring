package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{
    //option + enter
    //control + space
    private static Map<Long, Member> store = new HashMap<>();
    private static  long sequence = 0L;
    @Override
    public Member save(Member member) {
         member.setId(++sequence); //스토어에 넣기전에 멤버에 아이디 값을 세팅 해주고
        store.put(member.getId(),member); // store Map에 저장
         return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 결과가 없다면?
        //최근에는 null이 반환될 가능성이 있다면 Optional 이라는 것으로 감싸서 리턴한다?
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream()
                .filter(member -> member.getName().equals(name))//람다?
                .findAny(); // 하나로도 찾는

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}

//테스트 양이 너무 많을때는  hello.hellospring 에서 ctrl+ 클릭(window 오른쪾클릭) 해서
//Build Module '폴더명' 클릭하거나
//Run 'Tests is '폴더명'을 클릭해서 테스트 할수있다.
//
