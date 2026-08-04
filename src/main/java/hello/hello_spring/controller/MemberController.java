package hello.hello_spring.controller;


import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    // 사용자가 브라우저 주소창에 http://localhost:8080/members/new로 접근(GET 요청)했을 때 이 메서드를 실행
    @GetMapping("/members/new")
    public String createForm(){
        // resources/templates/members/createMemberForm.html 경로에 있는 HTML 파일을 찾아서 브라우저에 나타낸다.
        return "members/createMemberForm";
    }

    // 브라우저에서 HTML <form method="post" action="/members/new"> 형태로 데이터를 제출(POST 요청)했을때 이 메서드가 실행되도록 연결
    // 실제 입력 데이터를 전달받아 처리하는 역할
    // 사용자가 HTML 입력 폼에서 입력한 값(예: <input name="name">)이 MemberFormController(또는 MemberForm) 객체의 필드로 자동 매핑되어 전달
    @PostMapping("/members/new")
    public String create(MemberFormController form){
        // new Member(): 실제 데이터베이스나 메모리에 저장할 엔티티/도메인 객체인 Member를 생성
        Member member = new Member();
        // form.getName(): 사용자가 화면에 입력한 이름을 폼 객체에서 가져옵니다.
        // member.setName(): 가져온 이름을 Member 객체에 세팅
        member.setName(form.getName());

        // 이전 단계에서 @Autowired로 전달받은 MemberService의 가입 메서드를 호출하여 회원 정보를 저장
        memberService.join(member);
        return "redirect:/";

    }




}
