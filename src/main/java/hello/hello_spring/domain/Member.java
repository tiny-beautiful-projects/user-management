package hello.hello_spring.domain;

public class Member {
    private Long id;
    private String name;

    //  저장되어 있는 회원의 id 값을 읽어서 반환
    public Long getId(){
        return id;
    }

    // 새로운 id 값을 받아 내부 변수에 저장/수정(Setter)
    public void setId(Long id){
        this.id = id;
    }

    // 저장되어 있는 회원의 name 값을 읽어서 반환(
    public String getName(){
        return name;
    }

}

