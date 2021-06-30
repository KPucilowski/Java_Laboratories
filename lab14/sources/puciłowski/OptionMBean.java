package puciłowski;

import java.util.ArrayList;
import java.util.List;

public interface OptionMBean {
    public List<String> getNames();
    public List<Integer> getPriority();
    public void add(int priority,String name);
    public void delete(String name);
}
