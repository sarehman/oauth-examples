package com.tmcmum.security.oauth2.user;

import static com.tmcmum.model.AuthProvider.google;

import java.util.Map;

import com.tmcmum.exception.OAuth2AuthenticationProcessingException;



public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}