package SecretCode.ezen.www.controller;

import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaVO;
import SecretCode.ezen.www.handler.PagingHandler;
import SecretCode.ezen.www.service.QnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/qna/*")
public class QNAController {
    private final QnaService qsv;

    /*@GetMapping("/list")
    public void list(Model m, PagingVO pgvo) {
        log.info(">>>pgvo>>{}", pgvo);
        int totalCount = qsv.getTotalCount(pgvo);
        PagingHandler ph = new PagingHandler(pgvo, totalCount);
        m.addAttribute("list", qsv.getList(pgvo));
        m.addAttribute("ph", ph);
    }

    @GetMapping("/register")
    public void register() {}

    @PostMapping("/register")
    public String register(QnaVO qvo, Model model) {
        int isOk = qsv.register(qvo);
        // 등록한 게시글의 bno를 받아옴
        int bno = qvo.getBno();
        // 등록한 게시글의 상세 페이지 URL로 이동
        return "redirect:/qna/detail?bno=" + bno;
    }*/


    @GetMapping("/detail")
    public void detail(){}

    @PostMapping("/detail")
    public String detail(@RequestParam("bno") int bno, Model m) {
        qsv.updateReadCount(bno);
        QnaVO qvo = qsv.getDetail(bno);
        m.addAttribute("qvo", qvo);
        return "/qna/detail";
    }
}
