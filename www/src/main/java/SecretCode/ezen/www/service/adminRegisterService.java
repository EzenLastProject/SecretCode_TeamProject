package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.MemberVO;
import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaVO;
import SecretCode.ezen.www.domain.adRegisterVO;
import SecretCode.ezen.www.domain.FileVO;

import java.util.List;

public interface adminRegisterService {
    int insert(adRegisterVO advo);

    List<MemberVO> getList();

    int deleteUser(String email);

    int deleteAuthUser(String email);

    int getTotalCount();

    List<MemberVO> getListWithPaging(PagingVO pagingVO);

    List<QnaVO> getBoardList(PagingVO pgvo);

    int getBoardTotalCount(PagingVO pgvo);

    int insertFile(FileVO fileVO);

    // 추가된 메서드
    int insertWithFiles(adRegisterVO advo, List<FileVO> fileVOList);

    List<adRegisterVO> getreservationList();
}
