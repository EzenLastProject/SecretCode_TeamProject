package SecretCode.ezen.www.controller;

import SecretCode.ezen.www.domain.adRegisterVO;
import SecretCode.ezen.www.service.adminRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/adminRegister/*")
@Slf4j
@RequiredArgsConstructor
@Controller
public class adminRegisterController {
    private final adminRegisterService arsv;

    @GetMapping("/adminRegister")
    public void register(){}

    @PostMapping("/adminRegister")
    public String insert(adRegisterVO arvo){

        int isOk = arsv.insert(arvo);
        log.info("arvo {}", arvo);
        return "/member/list";
    }


}
