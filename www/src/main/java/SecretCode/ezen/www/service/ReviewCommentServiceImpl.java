package SecretCode.ezen.www.service;


import SecretCode.ezen.www.repository.QnaCommentMapper;
import SecretCode.ezen.www.repository.ReviewCommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewCommentServiceImpl implements ReviewCommentService {

    private final ReviewCommentMapper reviewcommentMapper;

}
