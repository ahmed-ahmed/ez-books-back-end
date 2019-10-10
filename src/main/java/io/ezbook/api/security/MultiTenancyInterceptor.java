package io.ezbook.api.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.ezbook.api.util.SecurityConstants;
import io.ezbook.api.util.TenantContext;

public class MultiTenancyInterceptor extends HandlerInterceptorAdapter {

	private static final String AUTHORIZATION_HEADER = "Authorization";

	@Autowired
	private TokenStore tokenStore;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String tokenValue = this.resolveToken(request);
		if (StringUtils.hasText(tokenValue)) {
			OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
			String tenantId = (String) accessToken.getAdditionalInformation().get(SecurityConstants.JWT_TENANT_ID_HEADER);
			TenantContext.setCurrentTenant(tenantId);
		}
		return true;
	}

	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			String jwt = bearerToken.substring(7, bearerToken.length());
			return jwt;
		}
		return null;
	}
}