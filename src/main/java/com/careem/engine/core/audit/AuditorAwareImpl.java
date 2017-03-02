package com.careem.engine.core.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.careem.engine.web.security.EngineUserDetails;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
			return "SYSTEM";
		} else {
			return ((EngineUserDetails) (SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getUsername();			
		}
	}
}