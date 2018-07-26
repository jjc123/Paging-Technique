package test;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;
import util.JdbcUtilsC3p0;

class StudentTest {
	
	// TRUNCATE TABLE teacher; 删除数据
	//创建数据
	@Test
	void test() throws SQLException {
		//创建虚拟数据
		/*Object[][] Teachers = new Object[41][2];
		for(int i=0;i<Teachers.length;i++) {
			for(int j=0;j<Teachers[i].length;j++) {
				Teachers[i][j]=i+j;
			}
		}
		String sql="INSERT INTO teacher(name,password) values(?,?)";
		QueryRunner queryRunner =JdbcUtilsC3p0.getQueryRunner();
		//批量处理数据
		queryRunner.batch(sql, Teachers);*/
		/*String sql="SELECT COUNT(*) FROM teacher";
		try {
			QueryRunner queryRunner =JdbcUtilsC3p0.getQueryRunner();
			Long count = queryRunner.query(sql, new ScalarHandler<Long>());
			int intCount = count.intValue();
			System.out.println(intCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}*/
	}
}
