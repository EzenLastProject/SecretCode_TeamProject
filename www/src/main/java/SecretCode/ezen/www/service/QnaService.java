package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaVO;

import java.util.List;

public interface QnaService {

    QnaVO getDetail(int bno);
    void updateReadCount(int bno);
}
