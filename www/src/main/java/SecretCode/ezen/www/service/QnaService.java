package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaDTO;
import SecretCode.ezen.www.domain.QnaVO;

import java.util.List;

public interface QnaService {

    List<QnaVO> getList(PagingVO pgvo);

    int getTotalCount(PagingVO pgvo);






    QnaVO getDetail(int bno);


    void modify(QnaVO qvo);

    void remove(long bno);

    int readCount(int bno);


    int register(QnaVO qvo);
}
