package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.ReviewVO;

import java.util.List;

public interface ReviewService {


    int register(ReviewVO rvo);

    int getTotalCount(PagingVO pgvo);

    List<ReviewVO> getList(PagingVO pgvo);
}
