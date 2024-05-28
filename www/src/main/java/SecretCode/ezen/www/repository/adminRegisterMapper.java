package SecretCode.ezen.www.repository;

import SecretCode.ezen.www.domain.adRegisterVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface adminRegisterMapper {

    int insert(adRegisterVO advo);
}
