package io.ezbook.api.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import io.ezbook.api.model.User;
import io.ezbook.api.service.UserService;
import io.ezbook.api.util.SecurityConstants;

@Component
public class TenantTokenEnhancer implements TokenEnhancer {

	@Autowired
	private UserService userService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		String username = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal())
				.getUsername();

		User user = userService.getUserByUsername(username);
		if (user != null) {
			Map<String, Object> additionalInfo = new HashMap<>();
			additionalInfo.put(SecurityConstants.JWT_TENANT_ID_HEADER, user.getTenantId());
			((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		}
		return accessToken;
	}
}