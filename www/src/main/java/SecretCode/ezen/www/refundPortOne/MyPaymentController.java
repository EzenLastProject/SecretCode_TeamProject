package SecretCode.ezen.www.refundPortOne;

import com.siot.IamportRestClient.exception.IamportResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/payments")
public class MyPaymentController {

    @Autowired
    private MyPaymentService myPaymentService;

    @DeleteMapping("/{merchantUid}")
    public String cancelPayment(@PathVariable String merchantUid, @RequestParam int refundAmount) throws IamportResponseException, IOException {
        myPaymentService.cancelPayment(merchantUid, refundAmount);
        return "환불 처리가 요청되었습니다.";
    }

}
