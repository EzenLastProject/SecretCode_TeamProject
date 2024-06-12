package SecretCode.ezen.www.repository;

import SecretCode.ezen.www.domain.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

    int reservationInsert(ReservationVO rvo);
}
