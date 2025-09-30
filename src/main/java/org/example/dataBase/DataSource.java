package org.example.dataBase;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file PoolConection
 * @since 29/09/2025 - 23:31
 * --------------------
 * Connection pool using HikariCP's DataSource
 * --------------------
 * --------------------
 * Documentation: https://www.baeldung.com/hikaricp
 * --------------------
 */
public class DataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl ( "jdbc:mysql://localhost:3306/YOUR_DATABASE_HERE" );
        config.setUsername( "YOUR_USERNAME" );
        config.setPassword( "YOUR_PASSWORD" );
        config.addDataSourceProperty( "cachePrepStmts", "true" );
        config.addDataSourceProperty( "prepStmtCacheSize", "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit", "2048" );
        ds = new HikariDataSource( config );
    }

    public DataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
