package com.hexaware.ftp87.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp87.model.LeaveDetails;
import com.hexaware.ftp87.model.LeaveStatus;
import com.hexaware.ftp87.model.LeaveType;
/**
 * Mapper class to map from result set to Leavedetails object.
 */
public class LeavedetailsMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped Leavedetails object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    String s = rs.getString("LEAVE_TYPE");
    LeaveType lt1 = LeaveType.valueOf(s);

    String s2 = rs.getString("LEAVE_STATUS");
    LeaveStatus lt2 = LeaveStatus.valueOf(s2);
    /**
     * @return Leavedetails
     */
    return new LeaveDetails(rs.getInt("LEAVE_ID"), rs.getInt("EMP_ID"),
              rs.getDate("LEAVE_SDATE"), rs.getDate("LEAVE_EDATE"),
              rs.getInt("LEAVE_NDAYS"), lt1,
              lt2, rs.getString("LEAVE_REASON"),
              rs.getDate("LEAVE_APPLIEDON"), rs.getString("LEAVE_MGRCOMM"));
  }
}
