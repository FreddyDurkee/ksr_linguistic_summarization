package fuzzyLogic;

import java.util.ArrayList;
import java.util.List;

public class Attribute {

    public List<Double> getAllValues(){
//        TODO: implement method
        List<Double> list = new ArrayList<>();
        list.add(22.0);
        list.add(35.0);
        list.add(29.0);
        list.add(40.0);

        return list;
    }

    public double getMin(){
        return 0;
    }

    public double getMax(){
        return 100;
    }
}
