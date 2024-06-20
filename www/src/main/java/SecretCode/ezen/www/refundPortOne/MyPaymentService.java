package SecretCode.ezen.www.refundPortOne;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@PropertySource("classpath:iamport.properties")
@Service
public class MyPaymentService {


    private final IamportClient api;

    public MyPaymentService(
            @Value("${iamport.api.key}") String apiKey,
            @Value("${iamport.api.secret}") String apiSecret) {

        this.api = new IamportClient(apiKey,apiSecret);
    }

//    public CancelData cancelPayment(IamportResponse<Payment> response){
//
//    }

    public IamportResponse<Payment> cancelPayment(String merchantUid, int refundAmount) throws IOException, IamportResponseException {
        CancelData cancelData = new CancelData(merchantUid, false, BigDecimal.valueOf(refundAmount));
        return api.cancelPaymentByImpUid(cancelData);
    }




}
