//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package processing;

public class Status {
    private String taskName;
    private int progress;

    public int getProgress() {
        return this.progress;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public Status(String taskName, int progress) {
        this.taskName = taskName;
        this.progress = progress;
    }
}
