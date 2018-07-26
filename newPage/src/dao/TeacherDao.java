package dao;

import entity.Teacher;
import util.TeacherBean;

public interface TeacherDao {
	void getAll(TeacherBean<Teacher> teacherBean);
	int getTotalCount();
}
