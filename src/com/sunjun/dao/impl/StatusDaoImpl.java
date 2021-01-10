package com.sunjun.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.sunjun.dao.StatusDao;
import com.sunjun.domain.Status;
import com.sunjun.util.JDBCUtils;

public class StatusDaoImpl implements StatusDao {

	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	@Override
	public int batchInsert(List<Status> list) throws Exception {
		String insertBatchSql = "INSERT INTO t_status (serial_number,location,pin,err_code,repair_status,image_filename,algorithm,sub_type) VALUES (?,?,?,?,?,?,?,?)";
		if(list.size()==0) {
			return 0;
		}
		String batchsql = getBatchInsertSql(insertBatchSql,list);
		int k = template.update(batchsql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ObjectToPs(ps,list);
			}
		});
		return k;
	}

	 public void ObjectToPs(PreparedStatement ps,List<Status> list) throws SQLException{
		 for(int i=0;i<list.size();++i) {
			 Status statusModel = (Status)list.get(i);
			 ps.setString(8*i+1, statusModel.getSerialNumber());
			 ps.setString(8*i+2, statusModel.getLocation());
			 ps.setString(8*i+3, statusModel.getPin());
			 ps.setString(8*i+4, statusModel.getErrCode());
			 ps.setString(8*i+5, statusModel.getRepairStatus());
			 ps.setString(8*i+6, statusModel.getImageFilename());
			 ps.setString(8*i+7, statusModel.getAlgorithm());
			 ps.setString(8*i+8, statusModel.getSubType());
		 }
	 }
	 
	 public static String getBatchInsertSql(String keyStr,List list)throws Exception {
		 int index = keyStr.indexOf("VALUES");
		 String loopStr = keyStr.substring(index + 6);
		 StringBuilder sb = new StringBuilder(keyStr.substring(0,index+6));
		 for(int j=0;j<list.size();++j) {
			 sb.append(loopStr);
			 if(j<list.size()-1) {
				 sb.append(",");
			 }
		 }
		 return sb.toString();
	 }
	
}
