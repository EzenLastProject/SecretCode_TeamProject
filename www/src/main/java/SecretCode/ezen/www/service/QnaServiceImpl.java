package SecretCode.ezen.www.service;


import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaCommentVO;
import SecretCode.ezen.www.domain.QnaDTO;
import SecretCode.ezen.www.domain.QnaVO;
import SecretCode.ezen.www.repository.NoticeMapper;
import SecretCode.ezen.www.repository.QnaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {

    private final QnaMapper qnaMapper;
    private PagingVO pgvo;

    @Override
    public List<QnaVO> getList(PagingVO pgvo) {
        this.pgvo = pgvo;
        return qnaMapper.getList(pgvo);
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
