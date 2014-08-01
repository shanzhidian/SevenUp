package org.sevenup.util;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.sevenup.common.logs.MessageLoggerHelper;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * The DatabaseAccessor class is responsible for getting Connections and freeing them after
 * use. API's are also provided to close the Prepared Statement & Result Sets.
 *
 * @author Syed
 * @version 1.0 Nov/13/2008
 *
 * @since 1.0
 */
public final class DataSourceManager {
    private static final Logger logger =
        MessageLoggerHelper.getLogger(DataSourceManager.class.getName());

    /** The Singleton instance of the DatabaseAccessor. */
    private static DataSourceManager dbConnectionFactory = null;

    static {
        if (dbConnectionFactory == null) {
            dbConnectionFactory = new DataSourceManager();
        }
    }

/**
     * This is the default constructor for the class, it is private and only used 
     * from within the getInstance method
     */
    private DataSourceManager() {
    }

    /**
     * This should be called by the controllers to get an object reference to
     * DatabaseAccessor object.
     *
     * @return Object Reference to the DatabaseAccessor if it were successfully created, or returns
     *         a null if the creation failed
     */
    public static DataSourceManager getInstance() {
        return DataSourceManager.dbConnectionFactory;
    }

    /**
     * Retrieving <code>Connection</code> object based on data source name.
     *
     * @param dataSourceName JNDI Data source lookup name
     *
     * @return Database  Connection object from the container.
     *
     * @throws SQLException Thrown if error while getting connection object
     * @throws NamingException
     */
    public Connection getConnection(String dataSourceName) throws SQLException, NamingException {
        Connection conn = null;
        try {
            // Do a lookup to get the Data Source information.
            InitialContext ic = new InitialContext();
            DataSource dataSource = (DataSource) ic.lookup(dataSourceName);
            // Get the database Connection object.
            conn = dataSource.getConnection();

            // Return the Connection object.
            return conn;
        }
        catch (SQLException e) {
            // In case of a SQL Exception: Close the Connection.s
            if (conn != null) {
                DataSourceManager.freeConnection(conn);
            }

            throw e;
        }
    }

    /**
     * Calls close() method on the Connection object passed in.
     *
     * @param conn DB Connection Object
     *
     * @return returns true if successful.
     */
    public static boolean freeConnection(Connection conn) {
        boolean isSuccess = true;
        try {
            if (conn != null) {
                conn.close();
            }
        }
        catch (Exception ignore) {
            isSuccess = false;
            logger.warn("Exception occured while closing the connection :");
        }

        return isSuccess;
    }

    /**
     * Calls close() method on the Connection, PreparedStatement/Statement, ResultSet
     * objects passed in.
     *
     * @param connObj Database Connection Object
     * @param stmtObj Statement Object.  The code will cast this object to either PreParedStatement
     *        or Statement
     * @param rsetObj ResultSet Object.
     *
     * @return returns true if all passed in objects are closed successfully.
     */
    public static boolean freeConnection(Object connObj, Object stmtObj, Object rsetObj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rset = null;

        if (connObj instanceof Connection) {
            conn = (Connection) connObj;
        }

        if (connObj instanceof PreparedStatement) {
            pstmt = (PreparedStatement) connObj;
        }

        if (connObj instanceof Statement) {
            stmt = (Statement) connObj;
        }

        if (connObj instanceof ResultSet) {
            rset = (ResultSet) connObj;
        }

        if (stmtObj instanceof Connection) {
            conn = (Connection) stmtObj;
        }

        if (stmtObj instanceof PreparedStatement) {
            pstmt = (PreparedStatement) stmtObj;
        }

        if (stmtObj instanceof Statement) {
            stmt = (Statement) stmtObj;
        }

        if (stmtObj instanceof ResultSet) {
            rset = (ResultSet) stmtObj;
        }

        if (rsetObj instanceof Connection) {
            conn = (Connection) rsetObj;
        }

        if (rsetObj instanceof PreparedStatement) {
            pstmt = (PreparedStatement) rsetObj;
        }

        if (rsetObj instanceof Statement) {
            stmt = (Statement) rsetObj;
        }

        if (rsetObj instanceof ResultSet) {
            rset = (ResultSet) rsetObj;
        }

        boolean isSucess = true;
        if (rset != null) {
            try {
                rset.close();
            }
            catch (Exception e) {
                isSucess = false;
                logger.warn("Unable to close the result set : " + e.getMessage());
            }
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            }
            catch (Exception e) {
                isSucess = false;
                logger.warn("Unable to close the PreparedStatement : " + e.getMessage());
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            }
            catch (Exception e) {
                isSucess = false;
                logger.warn("Unable to close the Statement : " + e.getMessage());
            }
        }

        if (conn != null) {
            try {
                conn.close();
            }
            catch (Exception e) {
                isSucess = false;
                logger.warn("Unable to close the Connection : " + e.getMessage());
            }
        }

        return isSucess;
    }
}
