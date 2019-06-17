package data;

import data.enums.EnumAttributes;

import java.util.Map;

public interface AttributeSet {
    public Map<EnumAttributes, FunctionParameters> getSetForTriangularFunction();
    public Map<EnumAttributes, FunctionParameters> getSetForTrapezoidalFunction();
}
