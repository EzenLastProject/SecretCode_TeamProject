package SecretCode.ezen.www.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO {
    private String email;
    private String pwd;
    private String nickName;
    private String regAt;
    private String lastLogin;
    private String phone;
    private String type;
    private List<AuthVO> authList;

    public MemberVO (String id, String type){
        this.email = id;
        this.pwd = "Password";
        this.type = type;
    }

}
