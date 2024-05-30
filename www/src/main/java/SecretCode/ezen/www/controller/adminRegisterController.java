package SecretCode.ezen.www.controller;

import SecretCode.ezen.www.domain.adRegisterVO;
import SecretCode.ezen.www.service.adminRegisterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RequestMapping("/adminRegister/*")
@Slf4j
@RequiredArgsConstructor
@Controller
public class adminRegisterController {
    private final adminRegisterService arsv;

    @GetMapping("/adminRegister")
    public void register() {}

    @PostMapping("/adminRegister")
    public String insert(adRegisterVO arvo) {
        int isOk = arsv.insert(arvo);
        log.info("arvo {}", arvo);
        return "/member/list";
    }

    @GetMapping("/adminUser")
    public String list(Model m) {
        log.info("1");
        m.addAttribute("list", arsv.getList());
        return "/member/adminUser";
    }

    @DeleteMapping(value = "/delete", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        int isOk = arsv.deleteUser(email);

        return isOk > 0 ? new ResponseEntity<>("1", HttpStatus.OK) :
                new ResponseEntity<>("0", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
