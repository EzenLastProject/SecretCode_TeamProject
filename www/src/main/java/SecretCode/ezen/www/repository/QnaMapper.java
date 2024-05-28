package SecretCode.ezen.www.repository;

import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QnaMapper {
    int getTotalCount(PagingVO pgvo);
    List<QnaVO> getList(PagingVO pgvo);
    int register(QnaVO qvo);
    void updateReadCount(@Param("bno") int bno);
    QnaVO getDetail(int bno);
}
