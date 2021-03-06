package service;

import model.Task;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 01.06.14
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
public interface ITaskService {

    //public int getNewTaskId();
    public Task addTask(String taskTitle, String description);
    public List<Task> getAllTasks();
    public List<String> getAllTasksTitles();
    public Task getTaskByTitle(String title);
    public Task  getTaskById(int id);
    public void setDescription(String title, String Description);
}