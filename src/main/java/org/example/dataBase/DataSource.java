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
 * Documentation: <a href="https://www.baeldung.com/hikaricp">https://www.baeldung.com/hikaricp</a>
 * --------------------
 */
public class DataSource {

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl ( "jdbc:mysql://localhost:3306/DATABASE_NAME" );
        config.setUsername( "USER" );
        config.setPassword( "PASSWORD" );
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
