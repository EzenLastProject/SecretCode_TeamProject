package SecretCode.ezen.www.controller;


import SecretCode.ezen.www.domain.ThemeVO;
import SecretCode.ezen.www.service.ThemeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/theme/*")
@RequiredArgsConstructor
@Slf4j
public class ThemeController {

    @Autowired
   private final  ThemeService tsv;

    @GetMapping("/theme")
    public void theme(){

//        return "/theme";


    }
    @GetMapping("/themeReserv")
    public void themeReserv(){



    }

    @GetMapping("/mainHome")
    public void mainHome(){

    }


    @GetMapping("/list")
    public String list(Model model) {
        List<ThemeVO> themeList = tsv.getAllThemes();
        model.addAttribute("themeList", themeList);
        return "theme/list"; // 테마 목록을 보여주는 뷰
    }

 /*   @GetMapping("/mainHome")
    public void mainHome(@RequestParam(value = "success", required = false) String success, Model model){
        log.info(">>>{}",success);
        model.addAttribute("loginMsg", "success");
    }*/
}
