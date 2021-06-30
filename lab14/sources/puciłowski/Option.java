package puciłowski;

import java.util.ArrayList;
import java.util.List;

public class Option implements OptionMBean{
    ArrayList<OptionChoose> optionChooseList = new ArrayList<OptionChoose>();
    @Override
    public List<String> getNames() {
        List<String> stringList = new ArrayList<String>();
        optionChooseList.stream().forEach(e->stringList.add(e.name));
        return stringList;
    }

    @Override
    public List<Integer> getPriority() {
        List<Integer> intList = new ArrayList<Integer>();
        optionChooseList.stream().forEach(e->intList.add(e.priority));
        return intList;
    }

    @Override
    public void add(int priority, String name) {
        OptionChoose newOption = new OptionChoose(priority, name);
        optionChooseList.add(newOption);
    }

    @Override
    public void delete(String name) {
        OptionChoose optionChooseDel = null;
        for (OptionChoose choose:optionChooseList) {
            if(choose.name.equals(name)){
                optionChooseDel=choose;
                
            }

        }
        optionChooseList.remove(optionChooseDel);
    }


}
