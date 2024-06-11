package SecretCode.ezen.www.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/portOnePay/*")
@Slf4j
@RequiredArgsConstructor
@Controller
public class PaymentController {


    @GetMapping("/portOnePay")
    public void pay() {
    }

  /*  //결제 후 예약 DB 작업
    @ResponseBody
    @GetMapping(value = "/phoneCheck/{date}/{time}/{theme}/{name}/{phone}/{email}/{participants}/{price}")
    public String reservation(@PathVariable("date")String date, @PathVariable("time")String time, @PathVariable("theme")String theme
            , @PathVariable("name")String name, @PathVariable("phone")String phone, @PathVariable("email")String email
            , @PathVariable("participants")int participants, @PathVariable("price")int price) {

        log.info(">>> date >> {}",date);
        log.info(">>> time >> {}",time);
        log.info(">>> theme >> {}",theme);
        log.info(">>> name >> {}",name);
        log.info(">>> phone >> {}",phone);
        log.info(">>> email >> {}",email);
        log.info(">>> participants >> {}",participants);
        log.info(">>> price >> {}",price);



  *//*

        String phoneCheck = msv.phoneCheck(phone, nickName);

        log.info(">>> phoneCheck >> {}",phoneCheck);*//*



        return phoneCheck;

    }*/


}
