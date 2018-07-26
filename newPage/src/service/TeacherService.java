package service;

import entity.Teacher;
import util.TeacherBean;

public interface TeacherService {
	void getAll(TeacherBean<Teacher> teacherBean);
}
