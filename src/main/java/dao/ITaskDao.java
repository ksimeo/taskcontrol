package dao;

import model.Task;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 01.06.14
 * Time: 10:54
 * To change this template use File | Settings | File Templates.
 */
interface ITaskDao
{

    public List<Task> getAllTasks();
    public boolean addTask(Task task);
    public List<String> getAllTasksTitles();
}