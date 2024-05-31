package SecretCode.ezen.www.repository;

import SecretCode.ezen.www.domain.MemberVO;
import SecretCode.ezen.www.domain.adRegisterVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface adminRegisterMapper {

    int insert(adRegisterVO advo);

    List<MemberVO> getList();

    int deleteUser(String email);

    int deleteAuthUser(String email);
}
