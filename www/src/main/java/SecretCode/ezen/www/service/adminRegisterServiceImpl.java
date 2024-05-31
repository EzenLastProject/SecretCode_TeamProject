package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.MemberVO;
import SecretCode.ezen.www.domain.adRegisterVO;
import SecretCode.ezen.www.repository.adminRegisterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class adminRegisterServiceImpl implements adminRegisterService{
    private final adminRegisterMapper arMapper;

    @Override
    public int insert(adRegisterVO advo) {
        return arMapper.insert(advo);
    }

    @Override
    public List<MemberVO> getList() {
        return null;
    }

    @Override
    public MemberVO deleteUser(String email) {
        return null;
    }
}
