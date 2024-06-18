package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.*;
import SecretCode.ezen.www.repository.MemberMapper;
import SecretCode.ezen.www.repository.adminRegisterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class adminRegisterServiceImpl implements adminRegisterService {
    private final adminRegisterMapper arMapper;
    private final MemberMapper memberMapper;

    @Override
    public int insert(adRegisterVO advo) {
        return arMapper.insert(advo);
    }

    @Override
    public List<MemberVO> getList() {
        log.info("2");
        List<MemberVO> list = memberMapper.getList();
        log.info("list {}", list);
        return list;
    }

    @Override
    public int deleteAuthUser(String email) {
        return arMapper.deleteAuthUser(email);
    }

    @Override
    public int deleteUser(String email) {
        return arMapper.deleteUser(email);
    }

    @Override
    public int getTotalCount() {
        return arMapper.getTotalCount();
    }

    @Override
    public List<MemberVO> getListWithPaging(PagingVO pagingVO) {
        return arMapper.getListWithPaging(pagingVO);
    }

    @Override
    public List<QnaVO> getBoardList(PagingVO pgvo) {
        List<QnaVO> noticeList = arMapper.getNoticeList();
        List<QnaVO> regularList = arMapper.getBoardList(pgvo);

        List<QnaVO> combinedList = new ArrayList<>();
        combinedList.addAll(noticeList);
        combinedList.addAll(regularList);

        return combinedList;
    }

    @Override
    public int getBoardTotalCount(PagingVO pgvo) {
        return arMapper.getBoardTotalCount(pgvo);
    }

    @Override
    public int insertFile(FileVO fileVO) {
        return arMapper.insertFile(fileVO);
    }

    @Override
    @Transactional
    public int insertWithFiles(adRegisterVO advo, List<FileVO> fileVOList) {
        // 파일 정보 삽입
        for (FileVO fileVO : fileVOList) {
            arMapper.insertFile(fileVO);
        }

        return arMapper.insert(advo);
    }

    @Override
    public List<adRegisterVO> getreservationList() {

        List<adRegisterVO> reservationList = arMapper.getreservationList();

        return reservationList;
    }

    @Override
    public List<ThemeVO> getThemeNum() {
        return arMapper.getThemeNum();
    }

    @Override
    public int deleteTheme(int themeNum) {
        return arMapper.deleteTheme(themeNum);
    }

    @Override
    public int getTotalCountWithAuth(String auth) {
        return arMapper.getTotalCountWithAuth(auth);
    }
}
