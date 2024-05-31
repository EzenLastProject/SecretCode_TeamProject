package SecretCode.ezen.www.repository;


import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QnaMapper {


    List<QnaVO> getList(PagingVO pgvo);

    int getTotalCount(PagingVO pgvo);


    int register(QnaVO qvo);

    void updateReadCount(int bno);

    QnaVO getDetail(int bno);

    void remove(long bno);

    void modify(QnaVO qvo);

    int readCount(int bno);



    String getSecretByBno(long bno);

    String getPassword(long bno);

    QnaVO getQnaByBno(long bno);




   /* QnaVO getDetail(int bno);

    void readCount(int bno);*/
}
