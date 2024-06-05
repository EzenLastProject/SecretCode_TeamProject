package SecretCode.ezen.www.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/theme/*")
@RequiredArgsConstructor
@Slf4j
public class ThemeController {

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
}
