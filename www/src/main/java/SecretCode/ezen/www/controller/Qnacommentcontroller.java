package SecretCode.ezen.www.controller;


import SecretCode.ezen.www.service.QnacommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Qnacomment/*")
@RestController
@Slf4j
@RequiredArgsConstructor
public class Qnacommentcontroller {

    private final QnacommentService qcsv;

}
