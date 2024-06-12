package SecretCode.ezen.www.controller;

import SecretCode.ezen.www.domain.ReservationVO;
import SecretCode.ezen.www.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/portOnePay/*")
@Slf4j
@RequiredArgsConstructor
@Controller
public class PaymentController {

    private final PaymentService psv;


    @GetMapping("/portOnePay")
    public void pay() {
    }

    //결제 후 예약 DB 작업
    @ResponseBody
    @GetMapping(value = "/reservation/{date}/{time}/{theme}/{name}/{phone}/{email}/{participants}/{price}")
    public String reservation(ReservationVO rvo, @PathVariable("date")String date, @PathVariable("time")String time, @PathVariable("theme")String theme
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

        rvo.setReservationDate(date);
        rvo.setReservationTime(time);
        rvo.setThemeName(theme);
        rvo.setName(name);
        rvo.setPhone(phone);
        rvo.setEmail(email);
        rvo.setReservationPeople(participants);
        rvo.setReservationPrice(price);
        log.info(">>> rvo >> {}",rvo);

        int isOk = psv.reservationInsert(rvo);

        log.info(">>> reservationVO ================ >> {}",isOk);

        return isOk>0? "1":"0";

    }


/*
    //결제 후 예약 DB 작업
    @ResponseBody
    @GetMapping(value = "/validate/{rsp.imp_uid}")
    public String reservation(@PathVariable("date")String date) {




        return ;

    }
*/




}
