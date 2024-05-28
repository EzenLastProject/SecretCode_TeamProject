package SecretCode.ezen.www.controller;


import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaDTO;
import SecretCode.ezen.www.domain.QnaVO;
import SecretCode.ezen.www.handler.PagingHandler;
import SecretCode.ezen.www.service.QnaCommentService;
import SecretCode.ezen.www.service.QnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/qna/*")
public class QNAController {
    private final QnaService qsv;
    private final QnaCommentService qcsv;
   /* private final QnaDTO qdto;*/


    @GetMapping("/list")
    public void list(Model m, PagingVO pgvo)  {
        log.info(">>>pgvo>>{}",pgvo);
        //totalCount db에서 가져오기
        int totalCount = qsv.getTotalCount(pgvo); //검색어 같이


        //pagingHandler 객체 생성
        PagingHandler ph = new PagingHandler(pgvo,totalCount);



        m.addAttribute("list", qsv.getList(pgvo));
        m.addAttribute("ph",ph);
    }



    @GetMapping("/register")
    public void register() {



    }


    @PostMapping("/register")
    public String register(QnaVO qvo) {
        // 비밀글 체크박스 처리
        log.info(">>>qvo>>{}",qvo);


        int isOk = qsv.register(qvo);
        return "redirect:/qna/list";
    }


    @GetMapping("/detail")
    public String detail(@RequestParam("bno") int bno, Model m) {
    log.info(">>bno>>{}",bno);
       QnaVO qvo= qsv.getDetail(bno);

       int isOk = qsv.readCount(bno);
        log.info(">>qvo>>{}",qvo);
        m.addAttribute("qvo", qvo);


        return "/qna/detail";

    }

    @PostMapping("/modify")
    public String modify(QnaVO qvo){
        qsv.modify(qvo);
        return "redirect:/qna/detail?bno="+qvo.getBno();
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno")long bno){
        qsv.remove(bno);
        return "redirect:/qna/list";
    }




}
