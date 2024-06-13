package SecretCode.ezen.www.repository;

import SecretCode.ezen.www.domain.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

    int reservationInsert(ReservationVO rvo);

    ReservationVO getImRes(String email, String merchantUid);

    List<ReservationVO> getmyReservation(String email);
}
