package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaVO;
import SecretCode.ezen.www.repository.QnaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {

    private final QnaMapper qnaMapper;



    @Override
    public void updateReadCount(int bno) {
        qnaMapper.updateReadCount(bno);
    }

    @Override
    public QnaVO getDetail(int bno) {
        return qnaMapper.getDetail(bno);
    }
}
