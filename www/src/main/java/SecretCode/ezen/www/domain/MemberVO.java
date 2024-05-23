package SecretCode.ezen.www.domain;

import lombok.*;

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

}
