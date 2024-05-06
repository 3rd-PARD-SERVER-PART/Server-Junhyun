package com.example.hw5.Oauth;

import com.example.hw5.user.dto.UserDTO;
import com.example.hw5.user.repo.UserRepo;
import com.example.hw5.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrincipalOauth2UserService  extends DefaultOAuth2UserService {
    private final UserRepo userRepo;
    private final UserService userService;

    public PrincipalOauth2UserService(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @Override
    public OAuth2User loadUser(
            OAuth2UserRequest oAuth2UserRequest
    ) throws OAuth2AuthenticationException {
        log.info("Google에서 받아온 user req : " + oAuth2UserRequest);
        // oAuth2UserRequest 로그인하고 구글에서 보내준거
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        // oAuth2User 얘는 아까 Cors에서 걸쳐서 온 애

        log.info("Google에서 받아온 정보 : "+ oAuth2User);

        userService.createUser(makeUserDtotoGoogle(oAuth2User));
        //userServiced에 있는 createUser를 이용해 받은 dto를 바탕으로 값 추가
        return super.loadUser(oAuth2UserRequest);
    }

    public UserDTO.Create makeUserDtotoGoogle(OAuth2User oAuth2User){
        String name = (String) oAuth2User.getAttribute("name");
        String email = (String) oAuth2User.getAttribute("email");
        return new UserDTO.Create(name,email);
    }// oAuth2User를 통해 name과 email을 받고 이걸 UserDto.Create로 넘겨줘서 dto 생성 후 리턴
}
