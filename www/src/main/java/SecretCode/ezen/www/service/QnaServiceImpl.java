package SecretCode.ezen.www.service;


import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaVO;
import SecretCode.ezen.www.repository.QnaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {

    private final QnaMapper qnaMapper;
    private PagingVO pgvo;



    @Override
    public List<QnaVO> getList(PagingVO pgvo) {
        // 공지글 가져오기
        List<QnaVO> noticeList = qnaMapper.getNoticeList();

        // 일반 게시글 가져오기
        List<QnaVO> regularList = qnaMapper.getList(pgvo);

        // 공지글을 상단에 고정하기 위해 두 리스트 결합
        List<QnaVO> combinedList = new ArrayList<>();
        combinedList.addAll(noticeList);
        combinedList.addAll(regularList);

        return combinedList;
    }


    @Override
    public int getTotalCount(PagingVO pgvo) {
        return qnaMapper.getTotalCount(pgvo);
    }

    @Override
    public int register(QnaVO qvo) {
        return qnaMapper.register(qvo);
    }



    @Override
    public String getSecretByBno(long bno) {
        return qnaMapper.getSecretByBno(bno);
    }

    @Override
    public boolean validatePassword(long bno, String password) {
        // 데이터베이스에서 bno에 해당하는 QnaVO를 가져옵니다.
        QnaVO qnaVO = qnaMapper.getQnaByBno(bno);

        // 입력된 비밀번호와 QnaVO 객체에 저장된 비밀번호를 비교합니다.
        return qnaVO != null && qnaVO.getScpwd() != null && qnaVO.getScpwd().equals(password);
    }

    @Override
    public void updateCmtQty(int bno) {
        qnaMapper.updateCmtQty(bno);
    }

    @Override
    public int getCommentCount(int bno) {
        return qnaMapper.getCommentCount(bno);
    }

    @Override
    public void updateCmtStatus(int bno) {
        qnaMapper.updateCmtStatus(bno);
    }

    @Override
    public List<QnaVO> myqna(String email) {
        return qnaMapper.myqna(email);
    }

    @Override
    public List<QnaVO> memberQna() {
        return qnaMapper.memberQna();
    }


    @Override
    public QnaVO getDetail(int bno) {

        /*qnaMapper.updateReadCount(bno);*/
        return   qnaMapper.getDetail(bno);


    }

    @Override
    public void remove(long bno) {
        qnaMapper.remove(bno);
    }

    @Override
    public int readCount( int bno) {
        return qnaMapper.readCount(bno);
    }

    @Override
    public void modify(QnaVO qvo) {
        qnaMapper.modify(qvo);
    }



}
