package SecretCode.ezen.www.repository;


import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QnaMapper {




    int getTotalCount(PagingVO pgvo);

    // 공지글 가져오기
    List<QnaVO> getNoticeList();

    // 일반 게시글 가져오기
    List<QnaVO> getList(PagingVO pgvo);

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
