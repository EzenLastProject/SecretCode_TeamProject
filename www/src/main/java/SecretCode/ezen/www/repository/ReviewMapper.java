package SecretCode.ezen.www.repository;


import SecretCode.ezen.www.domain.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {

    int register(ReviewVO rvo);
}
