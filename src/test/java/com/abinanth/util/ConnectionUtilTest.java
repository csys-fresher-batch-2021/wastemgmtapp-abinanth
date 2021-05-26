package com.abinanth.util;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionUtilTest {

	@Test
	public void test() throws ClassNotFoundException, SQLException {
		Connection connection= ConnectionUtil.getConnection();
	
			assertNotNull(connection);
			ConnectionUtil.close(null, connection);
		
	}

}
