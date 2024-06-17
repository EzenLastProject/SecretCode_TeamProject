package SecretCode.ezen.www.controller;

import SecretCode.ezen.www.domain.*;
import SecretCode.ezen.www.handler.FileHandler;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/adminRegister/*")
@Slf4j
@RequiredArgsConstructor
@Controller
public class adminRegisterController {
    private final adminRegisterService arsv;
    private final FileHandler fhd;

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
    public void register(Model m) {
        List<ThemeVO> getThemeNum = arsv.getThemeNum();

        m.addAttribute("getThemeNum",getThemeNum);
    }

    @GetMapping("/adminThemeList")
    public void adminThemeList(Model m) {
        m.addAttribute("reservationList", arsv.getreservationList());

    }

    @PostMapping("/adminRegister")
    public String insert(adRegisterVO arvo, @RequestParam("files") MultipartFile[] files) {
        log.info("arvo {}", arvo);

        List<FileVO> fileVOList = fhd.uploadFiles(files);


        // 첫 번째 파일의 UUID를 arvo 객체에 설정
        FileVO firstFile = fileVOList.get(0);
        arvo.setUuid(firstFile.getUuid());

        int isOk = arsv.insertWithFiles(arvo, fileVOList);

        if (isOk > 0) {
            return "redirect:/adminRegister/adminThemeList";
        } else {
            return "redirect:/adminRegister/adminRegister";
        }
    }


    //삭제할 테마
    @GetMapping("/admainReservationList")
    public void list(Model m){
        m.addAttribute("reservationList", arsv.getreservationList());
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


    @DeleteMapping(value = "/deleteTheme/{themeNum}")
    @ResponseBody
    public String deleteTheme(@PathVariable("themeNum") int themeNum){
        log.info("themeNum >>>> {}", themeNum);

        int isOk = arsv.deleteTheme(themeNum);

        log.info("isOk >>>> {}", isOk);


        return isOk>0? "1":"0";
    }
}
