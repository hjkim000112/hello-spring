package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //스프링이 관
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm"; //templates폴더로감.
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){ // TODO: memberForm 매개변수 부분이 requestBody를 뜻하는 듯함?
        System.out.println(form.getName()); //TODO: ??왜 MemberForm 에 대한 객체 정보가 들어오는지


        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; //홈 화면으로 보내기
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members); //멤버 리스트 자체를 모델에 담는다.
        // model 에 members 라는 키로 members 변수 안에 있는 값을 넣는다
        //TODO :  model 을? 어떻게 건네 주는건지?..
        return "members/memberList";
    }

}
