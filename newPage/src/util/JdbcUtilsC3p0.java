package util;

import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtilsC3p0 {
	
	//创建数据源
	private static DataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	//获取dbutils操作的核心方法
	public static QueryRunner getQueryRunner() {
		
		return new QueryRunner(dataSource);
	}
}
