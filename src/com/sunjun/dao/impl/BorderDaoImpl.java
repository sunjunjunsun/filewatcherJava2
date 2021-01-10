package com.sunjun.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sunjun.dao.BorderDao;
import com.sunjun.domain.Border;
import com.sunjun.util.JDBCUtils;

public class BorderDaoImpl implements BorderDao{
	 private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	 @Override
	public int add(Border border) {
		 String sql = "INSERT INTO  `t_borders` VALUES(NULL,?,?,?,?,?)";
	      return  template.update(sql,border.getTestTime(),border.getSerialNumber(),border.getTesterName(),border.getTestStatus(),border.getBoardType());
	 }
	 
	 @Override
		public int adds(Border border) {
		 String sql = "INSERT INTO  `tt_borders` VALUES(?,?,?,?,?)";
	      return  template.update(sql,border.getSerialNumber(),border.getBoardType(),border.getTesterName(),border.getTestStatus(),border.getTestTime());
	 }
	 
	 
	 
	 
	@Override
	public Border findBorderByserialNumber(String serialNumber) {
		   try{ 
		String sql="SELECT * FROM `t_borders` WHERE serialNumber = ?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<Border>(Border.class),serialNumber);
	
	 } catch (Exception e) {
         e.printStackTrace();
         return null;
     }
	
	}


	@Override
	public Border findBorderByserialNumbers(String serialNumber) {
		  try{ 
				String sql="SELECT * FROM `tt_borders` WHERE serialNumber = ?";
				return template.queryForObject(sql, new BeanPropertyRowMapper<Border>(Border.class),serialNumber);
			
			 } catch (Exception e) {
		         e.printStackTrace();
		         return null;
		     }
	}

	
	
	
	@Override
	public List<Border> findBorderTypesAll() {
		String sql = "select `boardType` from `t_borders`";
		List<Border> lists = template.query(sql, new BeanPropertyRowMapper<Border>(Border.class));
		return lists;
	}


	@Override
	public int findTotalCount(Map<String, String[]> condition) {
		 //1.定义模板初始化sql
        String sql = "select count(*) from t_borders where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
	}



	
}
