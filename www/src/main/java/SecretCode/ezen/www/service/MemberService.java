package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.MemberVO;

import java.util.List;

public interface MemberService {

    int insert(MemberVO mvo);

    List<MemberVO> getList();

    void memberModify(MemberVO mvo);

    void memberPwdModify(MemberVO mvo);

    void memberAuthDelete(String email);

    void memberDelete(String email);

    MemberVO isUser(MemberVO mvo);

    int checkEmail(String email);


}
