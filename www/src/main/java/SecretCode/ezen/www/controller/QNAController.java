package SecretCode.ezen.www.controller;


import SecretCode.ezen.www.service.QnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/qna/*")
public class QNAController {
    private final QnaService qsv;

    @GetMapping("/list")
    public String notice(){



        return "/qna/list";



    }

}
