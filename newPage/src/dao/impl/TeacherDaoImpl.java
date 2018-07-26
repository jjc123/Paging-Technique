package dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import dao.TeacherDao;
import entity.Teacher;
import util.JdbcUtilsC3p0;
import util.TeacherBean;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public void getAll(TeacherBean<Teacher> teacherBean) {
		
		//获取全部数据数     
		int totalCount = this.getTotalCount();
		teacherBean.setTotalCount(totalCount);
		System.out.println(teacherBean.getCurrentPage().intValue());
		// 判断是否超出界限
		if (teacherBean.getCurrentPage().intValue() <= 0) {
			teacherBean.setCurrentPage(1);
		} else if (teacherBean.getCurrentPage().intValue() > teacherBean.getTotalCount().intValue()) {
			teacherBean.setCurrentPage(totalCount);
		}
		
		int currentPage = teacherBean.getCurrentPage();
		int pageCount = teacherBean.getPageCount();
		//获取当前页的第一个数据的下标
		int index = (currentPage-1)*pageCount;
		String sql="SELECT * FROM teacher LIMIT ?,?";
		try {
			QueryRunner queryRunner = JdbcUtilsC3p0.getQueryRunner();
			List<Teacher> list = queryRunner.query(sql, new BeanListHandler<Teacher>(Teacher.class), index, pageCount);
			teacherBean.setPageData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalCount() {
		String sql = "SELECT COUNT(*) FROM teacher";
		try {
			QueryRunner queryRunner = JdbcUtilsC3p0.getQueryRunner();
			Long count = queryRunner.query(sql, new ScalarHandler<Long>());
			int intCount = count.intValue();
			return intCount;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
