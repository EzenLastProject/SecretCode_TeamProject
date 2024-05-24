package SecretCode.ezen.www.controller;

import SecretCode.ezen.www.domain.MemberVO;
import SecretCode.ezen.www.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@RequestMapping("/member/*")
@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService msv;
    private final PasswordEncoder passwordEncoder;

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


    @PostMapping("/login_register")
    public String login(MemberVO mvo, HttpServletRequest request, Model m, RedirectAttributes re) {
        log.info(">>>> mvo >>{}",mvo);

        //mvo 객체가 DB의 값과 일치하는 객체 가져오기
        MemberVO loginMvo = msv.isUser(mvo);
        log.info(">>>> loginMvo >>{}",loginMvo);

        if(loginMvo != null) {
            //로그인 성공 시.
            HttpSession ses = request.getSession();
            ses.setAttribute("ses", loginMvo); //세션에 로그인 객체 저장
            ses.setMaxInactiveInterval(10*60); //로그인 유지 시간
            return "/index";
        }else {
            //로그인 실패 시.
            m.addAttribute("msg_login", 1);

        }
        return "/member/login_register";
    }


//    @GetMapping("/register")
//    public void join(){}


//    @PostMapping("/register")
//    public String register(MemberVO mvo){
//        mvo.setPwd(passwordEncoder.encode(mvo.getPwd()));
//        int isOk = msv.insert(mvo);
//
//        return "/index";
//    }

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












}
