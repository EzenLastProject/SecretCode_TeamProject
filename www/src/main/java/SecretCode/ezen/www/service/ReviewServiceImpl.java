package SecretCode.ezen.www.service;


import SecretCode.ezen.www.domain.PagingVO;

import SecretCode.ezen.www.domain.ReviewVO;
import SecretCode.ezen.www.repository.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewMapper reviewMapper;
    private PagingVO pgvo;


    public class ReviewNotFoundException extends RuntimeException {

        public ReviewNotFoundException(String message) {
            super(message);
        }
    }

    @Override
    public int register(ReviewVO rvo) {
        return reviewMapper.register(rvo);
    }

    @Override
    public int getTotalCount(PagingVO pgvo) {
        return reviewMapper.getTotalCount(pgvo);
    }

    @Override
    public List<ReviewVO> getList(PagingVO pgvo) {
        return reviewMapper.getList(pgvo);


    }

    @Override
    public void incrementLikeCount(int bno) {
        reviewMapper.incrementLikeCount(bno);
    }

    @Override
    public int getReadCount(int bno) {
        return reviewMapper.getReadCount(bno);
    }

    @Override
    public void decrementLikeCount(int bno) {
        reviewMapper.decrementLikeCount(bno);
    }

    @Override
    public List<ReviewVO> myreview(String email) {
        return reviewMapper.myreview(email);
    }

    @Override
    public void modify(ReviewVO rvo) {
        reviewMapper.modify(rvo);
    }


}
