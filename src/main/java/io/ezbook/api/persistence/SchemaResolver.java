package io.ezbook.api.persistence;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import io.ezbook.api.util.TenantContext;

@Component
public class SchemaResolver implements CurrentTenantIdentifierResolver {
	
	public static final String DEFAULT_SCHEMA = "PUBLIC";
	
    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenantId = TenantContext.getCurrentTenant();
        if (tenantId != null) {
            return tenantId;
        }
        return DEFAULT_SCHEMA;
    }
    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}