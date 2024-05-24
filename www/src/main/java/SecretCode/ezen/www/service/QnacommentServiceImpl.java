package SecretCode.ezen.www.service;

import SecretCode.ezen.www.repository.QnacommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class QnacommentServiceImpl implements QnacommentService{


    private final QnacommentMapper qnacommentMapper;



}
