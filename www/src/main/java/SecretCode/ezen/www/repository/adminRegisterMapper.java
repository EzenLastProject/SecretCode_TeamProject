package SecretCode.ezen.www.repository;

import SecretCode.ezen.www.domain.*;
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

    List<adRegisterVO> getreservationList();

    List<ThemeVO> getThemeNum();

    int deleteTheme(int themeNum);

    int getTotalCountWithAuth(String auth);
}
