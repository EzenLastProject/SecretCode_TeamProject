package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.AuthVO;
import SecretCode.ezen.www.domain.MemberVO;
import SecretCode.ezen.www.repository.MemberMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class OAuth2UserServiceImplement extends DefaultOAuth2UserService {

    private final MemberMapper memberMapper;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException{

        OAuth2User oAuth2User = super.loadUser(request);
        String oauthClientName = request.getClientRegistration().getClientName();

        try {
            System.out.println(new ObjectMapper().writeValueAsString(oAuth2User.getAttributes()));
        }catch (Exception exception){
            exception.printStackTrace();
        }

        MemberVO mvo = new MemberVO();
        AuthVO avo = new AuthVO();

        String userId = "";

        if(oauthClientName.equals("kakao")){
            userId = "kakao_"+oAuth2User.getAttributes().get("id");
            mvo.setEmail(userId);
            mvo.setPwd("보안처리된 소셜로그인 비밀번호");
            mvo.setNickName(userId);
            mvo.setPhone("010-1234-5678");
            mvo.setType("kakao");
            avo.setEmail(userId);
        }
        else if(oauthClientName.equals("naver")){
            Map<String, String> responseMap = (Map<String, String>)oAuth2User.getAttributes().get("response");
            userId = "naver_"+responseMap.get("email");
            mvo.setEmail(userId);
            mvo.setType("naver");
            mvo.setNickName(responseMap.get("name"));
            mvo.setPwd("보안처리된 소셜로그인 비밀번호");
            mvo.setPhone("01012345678");
            avo.setEmail(userId);

        }else if(oauthClientName.equals("Google")){
            userId = "google_"+oAuth2User.getAttributes().get("email");
            mvo.setEmail(userId);
            mvo.setType("google");
            mvo.setNickName((oAuth2User.getAttributes().get("name")).toString());
            mvo.setPwd("보안처리된 소셜로그인 비밀번호");
            mvo.setPhone("010-1234-5678");
            avo.setEmail(userId);
        }

//        log.info(">>>8888888888888888888888888{}",oAuth2User.getAttributes().get("name"));

        MemberVO checkSocialLogin = memberMapper.checkSocialLogin(userId);
//        log.info(">>>{}",checkSocialLogin);

        //만약 처음 등록한 회원이라면.. DB작업
        if(checkSocialLogin == null){
            memberMapper.insert(mvo);
            memberMapper.insertAuth(userId);
        }

        return oAuth2User;
    }

}
