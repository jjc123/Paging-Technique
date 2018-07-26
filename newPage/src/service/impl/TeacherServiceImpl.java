package service.impl;

import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;
import entity.Teacher;
import service.TeacherService;
import util.TeacherBean;

public class TeacherServiceImpl implements TeacherService {
	
	private TeacherDao teacherdao = new TeacherDaoImpl();
	@Override
	public void getAll(TeacherBean<Teacher> teacherBean) {
		teacherdao.getAll(teacherBean);
	}

}
