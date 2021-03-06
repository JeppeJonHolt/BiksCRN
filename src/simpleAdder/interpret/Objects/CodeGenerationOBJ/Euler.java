package simpleAdder.interpret.Objects.CodeGenerationOBJ;

import simpleAdder.interpret.GetMethods.ViableVariable;
import simpleAdder.interpret.Objects.SymolTableOBJ.SymbolTableType;
import simpleAdder.interpret.Objects.SymolTableOBJ.reaction;
import simpleAdder.interpret.TypeCheckers.BiksPair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Euler extends CodeGenerationMethods {
    ViableVariable vv = new ViableVariable();

    /***
     * This method, checks wether the CRN exist in the scope, if it does not exist it will return a
     * empty string, otherwise it will initiate the generation of the head of the Euler function.
     * @Param scope
     * @Param level
     * @Param str
     * @return
     */
    public String Generate(HashMap<String, SymbolTableType> scope, int level, String str)
    {
        if (scope.get(ViableVariable.CRN) == null || scope.get(ViableVariable.CRN).crn.size() == 0){
            String PrettyResult = ApplyTab(level, GenerateEulerDcl(str));

            level++;
            PrettyResult += ApplyTab(level, "pass\n\n");
            level--;

            return PrettyResult;
        }
        else
        {
            return GenerateEuler(scope.get(ViableVariable.CRN).crn, level, str);
        }
    }

    /***
     * Generates the head of the Euler function.
     * @Param str
     * @return
     */
    private String GenerateEulerDcl(String str){

        return "def Euler"+str+"(self, i) :\n";
    }

    /***
     * Checks if the reaction is directed to the left side, if it is, it will set the rate of the left side
     * direction. If the right direction rate is null, it will also add that rate.
     * @Param reac
     * @return
     */
    private void SetRate(reaction reac){
        if (reac.rateLhs == null && reac.lhs != null){
            reac.rateLhs = CALC.Calculate(reac.lhs);
        }
        if (reac.rateRhs == null){
            reac.rateRhs = CALC.Calculate(reac.rhs);
        }
    }



    /***
     * Handles the generation of the deriviation of the Euler method, so that it is possible the be run
     * in Python. It takes the reactions and orders them correctly, and use the level, to control the
     * amount of tabs. It will finally return the Python code for the Euler method.
     * @Param reacs
     * @Param level
     * @Param str
     * @return
     */
    private String GenerateEuler(List<reaction> reacs, int Level, String str){
        String PrettyResult = ApplyTab(Level, GenerateEulerDcl(str));
        HashMap<String, String> species = new HashMap<>();
        int rNum = 0;
        Level++;
        PrettyResult += ApplyTab(Level,"if(i < self.steps):\n");
        Level++;
        for (reaction r : reacs){
            Refragtor(r.lhsPair);
            Refragtor(r.rhsPair);
            SetRate(r);
            rNum = NumberOfReactions(r, rNum,species);
            PrettyResult += ApplyTab(Level, r.lhsDerivedEq.getKey()+"="+r.lhsDerivedEq.getValue()+"\n");
            if (!r.isOneway){
                PrettyResult += ApplyTab(Level, r.rhsDerivedEq.getKey()+"="+r.rhsDerivedEq.getValue()+"\n");
            }
        }
        Level--;
        PrettyResult += "\n";
        Level++;
        for (Map.Entry<String, String> s : species.entrySet()){
            PrettyResult += ApplyTab(Level, "self.sample[\"" + s.getKey() + "\"].append(self.sample.get(\""+s.getKey()+"\")[-1]+("+GenerateReactionRef(s.getKey(),reacs)+")*self.h)\n");
        }
        Level--;
        Level--;

        return PrettyResult + "\n";
    }

    public void Refragtor(List<BiksPair<String,String>> Side)
    {
        for (int i = 0; i < Side.size(); i++)
        {
            for (int j = i+1; j < Side.size(); j++)
            {
                if(Side.get(i).getKey().equals(Side.get(j).getKey()))
                {
                    String Value = String.valueOf(Integer.valueOf(Side.get(i).getValue()) + Integer.valueOf(Side.get(j).getValue()));
                    BiksPair<String, String> result = new BiksPair<>(Side.get(i).getKey(),Value);
                    Side.remove(j);
                    Side.remove(i);
                    Side.add(i,result);
                    i--;
                }
            }
        }
    }

    /***
     * Will return the total amount of reactions in the euler method. It takes the reactions and add them
     * to the rNum, which is the amount of reactions that are already in the Euler method.
     * @Param reac
     * @Param rNum
     * @Param Species
     * @return
     */
    private int NumberOfReactions(reaction reac,int rNum, HashMap<String,String> Species)
    {
        reac.lhsDerivedEq = GenerateDerivedEQ(rNum,reac.rateRhs,reac.lhsPair,Species);



        if(!reac.isOneway)
        {
            rNum++;
            reac.rhsDerivedEq = GenerateDerivedEQ(rNum,reac.rateLhs,reac.rhsPair,Species);
        }
        else
        {
            AddSpecieHash(Species, reac);
        }
        return ++rNum;
    }

    private void AddSpecieHash(HashMap<String,String> Species, reaction reac)
    {
        for (BiksPair<String, String> p : reac.rhsPair) {
            if (!Species.containsKey(p.getKey())){
                Species.put(p.getKey(),"");
            }
        }
    }

    private BiksPair<String,String> GenerateDerivedEQ(int rNum,String rate, List<BiksPair<String,String>> reac, HashMap<String,String> Species)
    {
        String name = "r"+ rNum;
        String Value = rate;
        for (BiksPair<String, String> p : reac) {
            if (!Species.containsKey(p.getKey())){
                Species.put(p.getKey(),"");
            }
            Value += "*(self.sample.get(\""+p.getKey()+"\")[-1]**" + p.getValue() + ")";
        }
        return new BiksPair<>(name,Value);
    }

    /***
     * Generates the derived equations for each of the reactions. It will finally return the string, that
     * will be used in the GenerateEuler method.
     * @Param specie
     * @Param reacList
     * @return
     */
    private String GenerateReactionRef(String specie, List<reaction> reacList) {
        String PrettyResult = "";
        for (reaction r : reacList)
        {
            HashMap<String,Integer> result = CountSpecies(r);
            PrettyResult += DerivedForOne(r.lhsPair, r.lhsDerivedEq.getKey(), specie,result, false);
            PrettyResult += DerivedForOne(r.rhsPair, r.lhsDerivedEq.getKey(), specie,result, false);

            if(!r.isOneway)
            {
                PrettyResult += DerivedForOne(r.lhsPair, r.rhsDerivedEq.getKey(), specie,result, true);
                PrettyResult += DerivedForOne(r.rhsPair, r.rhsDerivedEq.getKey(), specie,result, true);
            }

        }
        if ('+' == PrettyResult.charAt(0)){
            PrettyResult = PrettyResult.substring(1);
        }
        return PrettyResult;
    }

    public HashMap<String,Integer> CountSpecies(reaction reac)
    {
        HashMap<String,Integer> result = new HashMap<>();
        CountSide(result,reac.rhsPair, ViableVariable.plus);
        CountSide(result,reac.lhsPair, ViableVariable.minus);

        return result;
    }

    public void CountSide(HashMap<String,Integer> hash, List<BiksPair<String, String>> side, String Symbol)
    {
        for (BiksPair<String, String> rhs: side) {
            if(hash.containsKey(rhs.getKey()))
            {
                hash.replace(rhs.getKey(), hash.get(rhs.getKey()) + ApplySymbol(rhs.getValue(),Symbol));
            }
            else
            {
                hash.put(rhs.getKey(), ApplySymbol(rhs.getValue(),Symbol));
            }
        }
    }
    public int ApplySymbol(String str, String symbol)
    {
        int i = Integer.valueOf(str);
        switch(symbol)
        {
            case "-": return i*-1;
            default: return i;
        }
    }
    /***
     * Takes a symbol and adds it to the derived equation. It will do that for each side of the reaction
     * and then finally return it to the GenerateReactionRef method.
     * @Param pairs
     * @Param derivedEq
     * @Param specie
     * @Param symbol
     * @return
     */
    private String DerivedForOne(List<BiksPair<String, String>> pairs, String derivedEq, String specie, HashMap<String,Integer> species, boolean isTwoWay){
        String PrettyResult = "";
        for (BiksPair<String, String> p: pairs) {
            if(specie.equals(p.getKey()))
            {
                PrettyResult += "+"+ derivedEq +"*("+ species.get(specie) + (isTwoWay ? "*(-1)" : "") +")";
            }
        }
        return PrettyResult;
    }
}
