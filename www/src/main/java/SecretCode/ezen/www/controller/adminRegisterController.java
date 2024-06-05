package SecretCode.ezen.www.controller;

import SecretCode.ezen.www.domain.MemberVO;
import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaVO;
import SecretCode.ezen.www.domain.adRegisterVO;
import SecretCode.ezen.www.handler.PagingHandler;
import SecretCode.ezen.www.service.adminRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/adminRegister/*")
@Slf4j
@RequiredArgsConstructor
@Controller
public class adminRegisterController {
    private final adminRegisterService arsv;

    @GetMapping("/adminBoard")
    public String adminBoard(Model m, PagingVO pgvo) {
        List<QnaVO> qnaList = arsv.getBoardList(pgvo);
        int totalCount = arsv.getBoardTotalCount(pgvo);
        PagingHandler ph = new PagingHandler(pgvo, totalCount);

        m.addAttribute("list", qnaList);
        m.addAttribute("ph", ph);

        return "/adminRegister/adminBoard";
    }

    @GetMapping("/adminRegister")
    public void register() {}

    @PostMapping("/adminRegister")
    public String insert(adRegisterVO arvo) {
        int isOk = arsv.insert(arvo);
        log.info("arvo {}", arvo);
        return "/member/list";
    }

    @GetMapping("/adminUser")
    public String list(Model m, PagingVO pgvo) {
        log.info(">>>pgvo>>{}", pgvo);

        List<MemberVO> memberList = arsv.getListWithPaging(pgvo);

        int totalCount = arsv.getTotalCount();
        log.info(" {}", totalCount);

        PagingHandler ph = new PagingHandler(pgvo, totalCount);

        m.addAttribute("list", memberList);
        m.addAttribute("ph", ph);

        return "/member/adminUser";
    }

    @DeleteMapping(value = "/delete/{email}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(@PathVariable("email") String email){
        log.info("email {}", email);
        int isOk = arsv.deleteAuthUser(email);
        arsv.deleteUser(email);

        return isOk > 0 ? new ResponseEntity<>("1", HttpStatus.OK) :
                new ResponseEntity<>("0", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

