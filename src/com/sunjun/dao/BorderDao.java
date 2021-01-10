package com.sunjun.dao;

import java.util.List;
import java.util.Map;

import com.sunjun.domain.Border;

public interface BorderDao {

	int  add(Border border);
	
	Border findBorderByserialNumber(String serialNumber);
	List<Border> findBorderTypesAll();
	
	int findTotalCount(Map<String, String[]> condition);

	int adds(Border border);

	Border findBorderByserialNumbers(String text);
	
}
