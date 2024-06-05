package SecretCode.ezen.www.service;


import SecretCode.ezen.www.domain.PagingVO;

import SecretCode.ezen.www.domain.ReviewVO;
import SecretCode.ezen.www.repository.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewMapper reviewMapper;
    private PagingVO pgvo;


    @Override
    public int register(ReviewVO rvo) {
        return reviewMapper.register(rvo);
    }
}
