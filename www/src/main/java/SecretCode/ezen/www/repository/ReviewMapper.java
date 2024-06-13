package SecretCode.ezen.www.repository;


import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    int register(ReviewVO rvo);

    int getTotalCount(PagingVO pgvo);

    List<ReviewVO> getList(PagingVO pgvo);


    void incrementLikeCount(int bno);

    int getReadCount(int bno);

    void decrementLikeCount(int bno);


    void modify(ReviewVO rvo);
}
