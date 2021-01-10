package com.sunjun.service;

import java.sql.Connection;

public interface BorderService {

	int findCount(Connection con, String testerName, String boardType, String startTime, String endTime);

}
