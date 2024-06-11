package SecretCode.ezen.www.repository;

import SecretCode.ezen.www.domain.MemberVO;
import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaVO;
import SecretCode.ezen.www.domain.adRegisterVO;
import SecretCode.ezen.www.domain.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface adminRegisterMapper {

    int insert(adRegisterVO advo);

    List<MemberVO> getList();

    int deleteUser(String email);

    int deleteAuthUser(String email);

    int getTotalCount();

    List<MemberVO> getListWithPaging(PagingVO pagingVO);

    List<QnaVO> getNoticeList();

    List<QnaVO> getBoardList(PagingVO pgvo);

    int getBoardTotalCount(PagingVO pgvo);

    int insertFile(FileVO fileVO);
}
