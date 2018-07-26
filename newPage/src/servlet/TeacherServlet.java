package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Teacher;
import service.TeacherService;
import service.impl.TeacherServiceImpl;
import util.TeacherBean;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TeacherService teacherService = new TeacherServiceImpl();
	private String url;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {    
			//第一次访问的时候没有数据
			String current = request.getParameter("currentPage");
			if(current == null ||"".equals(current)) {
				current ="1";
			}
			//类型转换
			Integer integer = Integer.valueOf(current);
			
			TeacherBean<Teacher> teacherBean = new TeacherBean<Teacher>();
			//设置当前页
			teacherBean.setCurrentPage(integer);
			//得到数据
			teacherService.getAll(teacherBean);
			//传递数据
			request.setAttribute("TeacherBean", teacherBean);
			url = "/List.jsp";
			//转发跳转到页面
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
