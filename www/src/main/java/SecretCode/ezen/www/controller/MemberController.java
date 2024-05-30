package SecretCode.ezen.www.controller;

import SecretCode.ezen.www.domain.MemberVO;
import SecretCode.ezen.www.service.EmailService;
import SecretCode.ezen.www.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/member/*")
@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService msv;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @GetMapping("/login_register")
    public void join() {
    }

    //중복아이디 체크
    @ResponseBody
    @GetMapping(value = "/emailCheck/{email}")
    public String emailCheck(@PathVariable("email")String email) {

        log.info(">>> email >> {}",email);
        int emailCheck = msv.checkEmail(email);
        log.info(">>> emailCheck >> {}",emailCheck);
        String mailCheck = String.valueOf(emailCheck);

        return mailCheck;

    }

    @PostMapping("/register")
    public String register(MemberVO mvo, Model m){
        mvo.setPwd(passwordEncoder.encode(mvo.getPwd()));
        int isOk = msv.insert(mvo);
        if(isOk > 0){
            m.addAttribute("msg_register", 1);
            return "/index";
        }
        m.addAttribute("msg_register", 2);

        return "/index";

    }

    @GetMapping("/login")
    public String login(){
        return "/member/login_register";
    }

    @GetMapping("/list")
    public void list(Model m){
        m.addAttribute("list", msv.getList());
    }

    @GetMapping("/modify")
    public void modify(){}

    private void logout(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        new SecurityContextLogoutHandler()
                .logout(request, response, authentication);
    }


    @PostMapping("/modify")
    public String modify(MemberVO mvo, Principal principal,HttpServletRequest request, HttpServletResponse response ){
        String email = principal.getName();
        mvo.setEmail(email);

        if(mvo.getPwd().isEmpty() || mvo.getPwd().length() == 0){
            msv.memberModify(mvo);
        }else {

            String pwdModify = passwordEncoder.encode(mvo.getPwd());
            mvo.setPwd(pwdModify);
            msv.memberPwdModify(mvo);

        }
        logout(request, response);
        return "redirect:/";
    }

    @GetMapping("/deleteMember")
    public String deleteMember(Principal principal, HttpServletRequest request, HttpServletResponse response) {
        String email = principal.getName(); //id

        msv.memberAuthDelete(email);
        msv.memberDelete(email);
        logout(request, response);
        return "redirect:/";
    }

    //구글 이메일 인증
    @PostMapping("/emailConfirm")
    @ResponseBody
    public String emailConfirm(@RequestBody String email) throws Exception {
        log.info(email);

        String confirm = emailService.sendSimpleMessage(email);

        return confirm;
    }



}
