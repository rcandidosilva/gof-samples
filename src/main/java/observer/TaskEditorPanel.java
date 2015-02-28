package observer;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
public class TaskEditorPanel extends JPanel implements ActionListener, TaskChangeObserver{
    private JPanel controlPanel, editPanel;
    private JButton add, update, exit;
    private JTextField taskName, taskNotes, taskTime;
    private TaskChangeObservable notifier;
    private Task editTask;
    
    public TaskEditorPanel(TaskChangeObservable newNotifier){
        notifier = newNotifier;
        createGui();
    }
    public void createGui(){
        setLayout(new BorderLayout());
        editPanel = new JPanel();
        editPanel.setLayout(new GridLayout(3, 2));
        taskName = new JTextField(20);
        taskNotes = new JTextField(20);
        taskTime = new JTextField(20);
        editPanel.add(new JLabel("Task Name"));
        editPanel.add(taskName);
        editPanel.add(new JLabel("Task Notes"));
        editPanel.add(taskNotes);
        editPanel.add(new JLabel("Time Required"));
        editPanel.add(taskTime);
        
        controlPanel = new JPanel();
        add = new JButton("Add Task");
        update = new JButton("Update Task");
        exit = new JButton("Exit");
        controlPanel.add(add);
        controlPanel.add(update);
        controlPanel.add(exit);
        add.addActionListener(this);
        update.addActionListener(this);
        exit.addActionListener(this);
        add(controlPanel, BorderLayout.SOUTH);
        add(editPanel, BorderLayout.CENTER);
    }
    public void setTaskChangeObservable(TaskChangeObservable newNotifier){
        notifier = newNotifier;
    }
    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        if (source == add){
            double timeRequired = 0.0;
            try{
                timeRequired = Double.parseDouble(taskTime.getText());
            }
            catch (NumberFormatException exc){}
            notifier.addTask(new Task(taskName.getText(), taskNotes.getText(), timeRequired));
        }
        else if (source == update){
            editTask.setName(taskName.getText());
            editTask.setNotes(taskNotes.getText());
            try{
                editTask.setTimeRequired(Double.parseDouble(taskTime.getText()));
            }
            catch (NumberFormatException exc){}
            notifier.updateTask(editTask);
        }
        else if (source == exit){
            System.exit(0);
        }
        
    }
    public void taskAdded(Task task){ }
    public void taskChanged(Task task){ }
    public void taskSelected(Task task){
        editTask = task;
        taskName.setText(task.getName());
        taskNotes.setText(task.getNotes());
        taskTime.setText("" + task.getTimeRequired());
    }
}