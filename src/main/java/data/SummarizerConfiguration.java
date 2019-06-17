package data;

import fuzzyLogic.Attribute;
import fuzzyLogic.functions.Function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SummarizerConfiguration implements Preconfigured {

    private static final SummarizerConfiguration INSTANCE = new SummarizerConfiguration();
    private Map<Function.FunctionType, Map<String, Object[]>> configuration = new HashMap<>();

    private SummarizerConfiguration() {
        initMap();
        //TODO: Add other configurations
        configuration.get(Function.FunctionType.TRIANGULAR).put("very young", new Object[]{new FunctionParameters(10, 12, 15), Attribute.AGE});
        configuration.get(Function.FunctionType.TRIANGULAR).put("young", new Object[]{new FunctionParameters(14, 17, 25), Attribute.AGE});
        configuration.get(Function.FunctionType.TRIANGULAR).put("average age", new Object[]{new FunctionParameters(24, 29, 32), Attribute.AGE});
        configuration.get(Function.FunctionType.TRIANGULAR).put("old", new Object[]{new FunctionParameters(29, 38, 50), Attribute.AGE});


        configuration.get(Function.FunctionType.TRAPEZOIDAL).put("very young", new Object[]{new FunctionParameters(10, 12, 14, 15), Attribute.AGE});
        configuration.get(Function.FunctionType.TRAPEZOIDAL).put("young", new Object[]{new FunctionParameters(14, 16, 20, 25), Attribute.AGE});
        configuration.get(Function.FunctionType.TRAPEZOIDAL).put("average age", new Object[]{new FunctionParameters(24, 26, 29, 32), Attribute.AGE});
        configuration.get(Function.FunctionType.TRAPEZOIDAL).put("old", new Object[]{new FunctionParameters(29, 35, 100, 100), Attribute.AGE});
    }

    private void initMap() {
        for (Function.FunctionType type : Function.FunctionType.values()) {
            configuration.put(type, new HashMap<>());
        }
    }

    @Override
    public FunctionParameters getParametersFor(String name, Function.FunctionType type) {
        if(configuration.get(type).get(name) != null){
            return (FunctionParameters) configuration.get(type).get(name)[0];
        }else{
            return null;
        }
    }

    @Override
    public Attribute getAttributeFor(String name, Function.FunctionType type) {
        if(configuration.get(type).get(name) != null){
            return (Attribute) configuration.get(type).get(name)[1];
        }else{
            return null;
        }
    }

    @Override
    public List<String> getNames(Function.FunctionType type) {
        return configuration.get(type).keySet().parallelStream().collect(Collectors.toList());
    }

    public static SummarizerConfiguration getInstance() {
        return INSTANCE;
    }
}
