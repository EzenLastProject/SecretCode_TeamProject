package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.MemberVO;
import SecretCode.ezen.www.domain.adRegisterVO;

import java.util.List;

public interface adminRegisterService {
    int insert(adRegisterVO advo);

    List<MemberVO> getList();


    MemberVO deleteUser(String email);
}
