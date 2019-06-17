package data;

import fuzzyLogic.Attribute;
import fuzzyLogic.functions.Function;

import java.util.List;

public interface Preconfigured {

    FunctionParameters getParametersFor(String name, Function.FunctionType type);

    Attribute getAttributeFor(String name, Function.FunctionType type);

    List<String> getNames(Function.FunctionType type);
}
