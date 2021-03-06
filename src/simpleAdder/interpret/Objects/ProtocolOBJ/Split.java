package simpleAdder.interpret.Objects.ProtocolOBJ;

import simpleAdder.interpret.TypeCheckers.BiksPair;
import simpleAdder.interpret.TypeCheckers.PossibleToAdd;

import java.util.ArrayList;
import java.util.List;

public class Split {
    public List<String> ResultingSamples = new ArrayList<>();
    public String SplitSample = null;
    public List<String> DestributionValue = new ArrayList<>();

    private final Boolean AddInt = true;
    private final Boolean AddFloat = true;
    private final Boolean AddSpecie = false;
    private final Boolean AddRate = false;

    private final PossibleToAdd ps = new PossibleToAdd(AddInt, AddFloat, AddSpecie, AddRate);

    /**
     * Checks if the sample is valid.
     * @return Pair of a boolean and a string, which denotes what type of error occurred, and if the program should terminate.
     */
    public BiksPair<Boolean, String> IsDistributionvalueValid(){
        double result = 0.0;

        if (ResultingSamples.size() != DestributionValue.size()){
            return new BiksPair<>(false, "When splitting sample " + SplitSample + " there should be an equal amount of Sampels to split to " +
                    "(" + ResultingSamples.size() + ") and slices (" + DestributionValue.size() + ")");
        }

        for (String value:DestributionValue){
            try {
                result += Float.parseFloat(value);
            }catch (Exception e){
                System.out.println("Value in distributionValue could not be parsed to a float (Split)");
            }
        }
        return result <= 1.0 ? new BiksPair<>(true, "") : new BiksPair<>(false, "The distribution value in split should not equal a value higher than 1. The value is: " + result);
    }

    /**
     *
     * @param value of type string
     * @param type of type string
     * @return boolean true if successful added and false if not.
     */
    public Boolean AddValue(String value, String type){
        if (ps.CanBeAdded(type) && !value.contains("-")){
            DestributionValue.add(value);
            return true;
        }
        return false;
    }
}
