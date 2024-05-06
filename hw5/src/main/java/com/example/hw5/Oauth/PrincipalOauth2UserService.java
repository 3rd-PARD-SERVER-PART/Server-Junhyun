package com.example.seminar5.Oauth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrincipalOauth2UserService  extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(
            OAuth2UserRequest oAuth2UserRequest
    ) throws OAuth2AuthenticationException {
        log.info("Google에서 받아온 user req : " + oAuth2UserRequest);
        // oAuth2UserRequest 로그인하고 구글에서 보내준거
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        // oAuth2User 얘는 아까 Cors에서 걸쳐서 온 애

        log.info("Google에서 받아온 정보 : "+ oAuth2User);
        return super.loadUser(oAuth2UserRequest);
    }
}
