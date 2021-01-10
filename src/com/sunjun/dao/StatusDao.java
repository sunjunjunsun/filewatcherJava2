package com.sunjun.dao;

import java.util.List;

import com.sunjun.domain.Status;

public interface StatusDao {
	int batchInsert(List<Status> list) throws Exception;
}
