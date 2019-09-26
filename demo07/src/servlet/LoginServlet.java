 package servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import vo.User;

public class LoginServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse resp)
	throws ServletException,IOException{
		String  path="login.jsp";
		String userid=req.getParameter("userid");
		String userpass=req.getParameter("userpass");
		List<String>info=new ArrayList<String>();
		if(userid==null||"".equals(userid))
		{
			info.add("�û�������Ϊ�գ�����");
			
		}
		if(userpass==null||"".equals("userpass"))
		{
			info.add("���벻��Ϊ�գ�����");
			
		}
		if(info.size()==0)
		{
			User user=new User();
			user.setUserid(userid);
			user.setPassword(userpass);
			try {
			if(DAOFactory.getIUserDAOInstance().findLogin(user))	
			{
				info.add("�û���½�ɹ�����ӭ"+user.getName()+"���٣���");
			
			}else
			{
				info.add("�û���¼ʧ�ܣ�������û��������룡��");
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		req.setAttribute("info", info);
		req.getRequestDispatcher(path).forward(req, resp);
	}
public void doPost(HttpServletRequest req,HttpServletResponse resp)
throws ServletException,IOException{
	this.doGet(req, resp);
}
}
