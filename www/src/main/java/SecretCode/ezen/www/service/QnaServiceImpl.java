package SecretCode.ezen.www.service;


import SecretCode.ezen.www.repository.NoticeMapper;
import SecretCode.ezen.www.repository.QnaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {

    private final QnaMapper qnaMapper;
}
