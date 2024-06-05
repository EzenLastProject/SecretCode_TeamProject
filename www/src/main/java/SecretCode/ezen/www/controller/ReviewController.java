package SecretCode.ezen.www.controller;


import SecretCode.ezen.www.domain.QnaVO;
import SecretCode.ezen.www.domain.ReviewVO;
import SecretCode.ezen.www.service.QnaCommentService;
import SecretCode.ezen.www.service.QnaService;
import SecretCode.ezen.www.service.ReviewCommentService;
import SecretCode.ezen.www.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/review/*")
public class ReviewController {

    private final ReviewService rsv;
    private final ReviewCommentService rcsv;


    @GetMapping("/list")
    public void list(){




    }


    @GetMapping("/register")
    public void register(){




    }

    @PostMapping("/register")
    public String register(ReviewVO rvo) {

        log.info(">>>qvo>>{}",rvo);

        int isOk = rsv.register(rvo);

        return "redirect:/review/register";
    }
}
