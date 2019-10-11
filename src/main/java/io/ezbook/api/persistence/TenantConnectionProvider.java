package io.ezbook.api.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.ezbook.api.util.TenantContext;

@Component
public class TenantConnectionProvider implements MultiTenantConnectionProvider {
	
	private static final long serialVersionUID = -2631940369667214773L;

	@Autowired
	private DataSource dataSource;

	@Override
	public Connection getAnyConnection() throws SQLException {
		return dataSource.getConnection();
	}

	@Override
	public void releaseAnyConnection(Connection connection) throws SQLException {
		connection.close();
	}

	@Override
	public Connection getConnection(String tenantIdentifie) throws SQLException {
		String tenantIdentifier = TenantContext.getCurrentTenant();
		final Connection connection = getAnyConnection();
		try {
			if (tenantIdentifier != null) {
				connection.createStatement().execute(String.format("SET SCHEMA \"%s\";", tenantIdentifier));
				// connection.createStatement().execute("USE " + tenantIdentifier);
			} else {
				connection.createStatement().execute(String.format("SET SCHEMA \"%s\";", SchemaResolver.DEFAULT_SCHEMA));
				//connection.createStatement().execute("USE " + SchemaResolver.DEFAULT_SCHEMA);
			}
		} catch (SQLException e) {
			throw new HibernateException("Problem setting schema to " + tenantIdentifier, e);
		}
		return connection;
	}

	@Override
	public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
		try {
			connection.createStatement().execute(String.format("SET SCHEMA \"%s\";", SchemaResolver.DEFAULT_SCHEMA));
			//connection.createStatement().execute("USE " + SchemaResolver.DEFAULT_SCHEMA);
		} catch (SQLException e) {
			throw new HibernateException("Problem reverting schema to " + SchemaResolver.DEFAULT_SCHEMA, e);
		}
		connection.close();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		return null;
	}

	@Override
	public boolean supportsAggressiveRelease() {
		return true;
	}
}