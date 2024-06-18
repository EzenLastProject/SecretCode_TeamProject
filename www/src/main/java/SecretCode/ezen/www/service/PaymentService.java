package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.ReservationVO;

import java.util.List;

public interface PaymentService {
    int reservationInsert(ReservationVO rvo);


    ReservationVO getImRes(String email, String merchantUid);

    List<ReservationVO> getmyReservation(String email);

    List<ReservationVO> getPayList(PagingVO pgvo);

    ReservationVO getReservation(String merchantUid);
}
