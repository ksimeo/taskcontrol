package servlets;

import model.CommonTaskTable;
import model.CurrentTask;
import model.Task;
import model.User;
import service.CurrentTaskService;
import service.TaskService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avega on 02.06.14.
 */
@WebServlet(urlPatterns = "/secretPages/employee")
public class EmployeeServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        User sessionUserAttr = (User)session.getAttribute("user");

        req.setAttribute("currentUser", sessionUserAttr.getName());
        List<CurrentTask> allTasks = CurrentTaskService.INSTANCE.getAllByUserId(sessionUserAttr);
        List<CommonTaskTable> comTaskTab = new ArrayList<CommonTaskTable>();
        for(CurrentTask item : allTasks)
        {
            Task t = TaskService.INSTANCE.getTaskById(item.getTaskId());
            CommonTaskTable commonTaskTable = new CommonTaskTable(item, t);
            comTaskTab.add(commonTaskTable);
        }

        req.setAttribute("allUserTasks", comTaskTab);


        req.getRequestDispatcher("/secretPages/employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

    }
}
