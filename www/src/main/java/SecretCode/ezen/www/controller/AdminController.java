package SecretCode.ezen.www.controller;

import SecretCode.ezen.www.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private final AdminService asv;

    @GetMapping("/adminBoard")
    public void adminBoard(){}


    @GetMapping("/adminUser")
    public void adminUser(){}

    @GetMapping("/adminRegister")
    public void adminRegister(){}

    @GetMapping("/adminReservation")
    public void adminReservation(){}
}
