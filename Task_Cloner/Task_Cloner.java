package Task_Cloner;

interface MyTask extends Cloneable {
    MyTask clone(); 
    void showTask();
}
class DailyTask implements MyTask {
    private String name;
    public DailyTask(String name) {this.name = name; }
    @Override
    public MyTask clone() {
        return new DailyTask(this.name);
    }
    public void showTask() {
        System.out.println("Task: " + name);
    }
}
 class Task_Cloner {
    public static void main(String[] args) {
        DailyTask original = new DailyTask("Study for Exams");
        DailyTask copy = (DailyTask) original.clone();
        copy.showTask();
    }
}