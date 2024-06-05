package SecretCode.ezen.www.controller;


import SecretCode.ezen.www.service.QnaCommentService;
import SecretCode.ezen.www.service.ReviewCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/comment/*")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ReviewCommentController {

    private final ReviewCommentService rcsv;
}
