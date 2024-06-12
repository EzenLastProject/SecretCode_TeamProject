package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.ReservationVO;
import SecretCode.ezen.www.repository.PaymentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService{
    private final PaymentMapper paymentMapper;


    @Override
    public int reservationInsert(ReservationVO rvo) {



        return paymentMapper.reservationInsert(rvo);
    }
}

