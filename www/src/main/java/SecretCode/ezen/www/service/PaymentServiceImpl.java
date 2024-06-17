package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.ReservationVO;
import SecretCode.ezen.www.repository.PaymentMapper;
import com.siot.IamportRestClient.IamportClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService{
    private final PaymentMapper paymentMapper;
    private IamportClient api;

    @Override
    public int reservationInsert(ReservationVO rvo) {
        return paymentMapper.reservationInsert(rvo);
    }

    @Override
    public ReservationVO getImRes(String email, String merchantUid) {
        return paymentMapper.getImRes(email, merchantUid);
    }

    @Override
    public List<ReservationVO> getmyReservation(String email) {

        return paymentMapper.getmyReservation(email);
    }

    @Override
    public List<ReservationVO> getPayList(PagingVO pgvo) {
        return paymentMapper.getPayList(pgvo);
    }


}

