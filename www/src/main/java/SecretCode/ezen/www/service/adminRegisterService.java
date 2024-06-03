package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.MemberVO;
import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.adRegisterVO;

import java.util.List;

public interface adminRegisterService {
    int insert(adRegisterVO advo);

    List<MemberVO> getList();


    int deleteUser(String email);

    int deleteAuthUser(String email);

    int getTotalCount();

    List<MemberVO> getListWithPaging(PagingVO pagingVO);
}
