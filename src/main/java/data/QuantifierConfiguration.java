package data;

import fuzzyLogic.Attribute;
import fuzzyLogic.functions.Function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuantifierConfiguration implements Preconfigured {

    private static final QuantifierConfiguration INSTANCE = new QuantifierConfiguration();
    private Map<Function.FunctionType, Map<String,FunctionParameters>> configuration = new HashMap<>();

    private QuantifierConfiguration() {
        initMap();
        configuration.get(Function.FunctionType.TRIANGULAR).put("Almost none", new FunctionParameters(0.0,0.0,0.2));
        configuration.get(Function.FunctionType.TRIANGULAR).put("Some", new FunctionParameters(0.12,0.25,0.4));
        configuration.get(Function.FunctionType.TRIANGULAR).put("About half", new FunctionParameters(0.35,0.5,0.65));
        configuration.get(Function.FunctionType.TRIANGULAR).put("Many", new FunctionParameters(0.6,0.75,0.9));
        configuration.get(Function.FunctionType.TRIANGULAR).put("Almost all", new FunctionParameters(0.85,0.99,1.5));


        configuration.get(Function.FunctionType.TRAPEZOIDAL).put("Almost none", new FunctionParameters(0.0,0.0,0.05, 0.2));
        configuration.get(Function.FunctionType.TRAPEZOIDAL).put("Some", new FunctionParameters(0.12,0.22,0.35, 0.4));
        configuration.get(Function.FunctionType.TRAPEZOIDAL).put("About half", new FunctionParameters(0.35,0.45, 0.55,0.65));
        configuration.get(Function.FunctionType.TRAPEZOIDAL).put("Many", new FunctionParameters(0.6,0.7,0.85, 0.9));
        configuration.get(Function.FunctionType.TRAPEZOIDAL).put("Almost all", new FunctionParameters(0.85,0.99,1.0, 1.0));
    }

    private void initMap() {
        for(Function.FunctionType type: Function.FunctionType.values()){
            configuration.put(type, new HashMap<>());
        }
    }

    @Override
    public FunctionParameters getParametersFor(String name, Function.FunctionType type) {
        return configuration.get(type).get(name);
    }

    @Override
    public Attribute getAttributeFor(String name, Function.FunctionType type) {
        return null;
    }

    @Override
    public List<String> getNames(Function.FunctionType type) {
        return configuration.get(type).keySet().parallelStream().collect(Collectors.toList());
    }

    public static QuantifierConfiguration getInstance(){
        return INSTANCE;
    }
}
