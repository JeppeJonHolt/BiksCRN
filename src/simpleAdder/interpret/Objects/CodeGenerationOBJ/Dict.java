package simpleAdder.interpret.Objects.CodeGenerationOBJ;

import simpleAdder.interpret.Objects.SymolTableOBJ.reaction;
import simpleAdder.interpret.Objects.SymolTableOBJ.SymbolTableType;
import simpleAdder.interpret.GetMethods.ViableVariable;
import simpleAdder.interpret.TypeCheckers.BiksPair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dict extends CodeGenerationMethods {
    ViableVariable vv = new ViableVariable();


    /***
     * This method generates the head of the sample, and the converts the species to variables from the global and local scope.
     * It finally returns sample dictonary.
     * @Param global
     * @Param local
     * @Param level
     * @return
     */
    public String GenerateDictionary(HashMap<String, SymbolTableType> global, HashMap<String, SymbolTableType> local, int level)
    {

        String PrettyResult = "";
        PrettyResult += ApplyTab(level, GenerateDictInit());

        if (!local.containsKey(ViableVariable.CRN)){
            return PrettyResult;
        }

        level++;
        PrettyResult += GenerateDictFromHashmap(local, global, level);
        if (PrettyResult.contains(",")){
            PrettyResult = PrettyResult.substring(0, PrettyResult.lastIndexOf(",")) + "" + PrettyResult.substring(PrettyResult.lastIndexOf(",") + 1);
        }

        level--;


        return PrettyResult;
    }

    /***
     * This method generates the head of the sample, and the converts the species to variables from the global scope.
     * It finally returns sample dictonary.
     * @Param global
     * @Param level
     * @return
     */
    public String GenerateDictionary(HashMap<String, SymbolTableType> global, int level)
    {
        String PrettyResult = "";

        if (global.containsKey(ViableVariable.SPECIE)){
            PrettyResult += ApplyTab(level, GenerateDictInit());
            level++;
            PrettyResult += GenerateDictFromHashmap(global, level);

            PrettyResult = PrettyResult.substring(0, PrettyResult.lastIndexOf(",")) + "" + PrettyResult.substring(PrettyResult.lastIndexOf(",") + 1);

            level--;
        }

        return PrettyResult;
    }

    private String GenerateDictInit()
    {
        return "sample = {\n";
    }

    /***
     * Verifies the species, such that there are no duplicates and unused species in the dictionary. It does so
     * based on both the local and global scope. Finally the relevant species are returned.
     * @Param local
     * @Param global
     * @Param level
     * @return
     */
    public String GenerateDictFromHashmap(HashMap<String, SymbolTableType> local, HashMap<String, SymbolTableType> global, int level){
        String PrettyResult = "";
        HashMap<String, String> UsedSpecie = new HashMap<>();

        if(local.containsKey(ViableVariable.CRN)) {
            if (local.containsKey(ViableVariable.SPECIE)){
                UniqueSpecieToHash(local.get(ViableVariable.SPECIE).species, local.get(ViableVariable.CRN).crn, UsedSpecie);

            }
            if (global.containsKey(ViableVariable.SPECIE)){
                UniqueSpecieToHash(global.get(ViableVariable.SPECIE).species, local.get(ViableVariable.CRN).crn, UsedSpecie);
            }
        }

        if(UsedSpecie != null)
        {
            for (Map.Entry<String,String> p: UsedSpecie.entrySet()) {
                PrettyResult += ApplyTab(level,GenerateDictField(p.getKey(), p.getValue()));
            }
        }
        return PrettyResult;
    }

    /***
     * Verifies the species, such that there are no duplicates and unused species in the dictionary. It does so
     * based on the global scope. Finally the relevant species are returned.
     * @Param global
     * @Param level
     * @return
     */
    public String GenerateDictFromHashmap(HashMap<String, SymbolTableType> global, int level){

        String PrettyResult = "";
        HashMap<String, String> UsedSpecie = new HashMap<>();
        if (global.containsKey(ViableVariable.SPECIE)){
            UniqueSpecieToHash(global.get(ViableVariable.SPECIE).species, UsedSpecie);
        }

        if(UsedSpecie != null)
        {
            for (Map.Entry<String,String> p: UsedSpecie.entrySet()) {
                PrettyResult += ApplyTab(level,GenerateDictField(p.getKey(), p.getValue()));
            }
        }
        return PrettyResult + GenerateDictEnd();
    }

    /***
     * Takes the HashMap of species, and check each entryset to see if the specie already initiated
     * and is used in the CRN.
     * If the specie is not initiated, the specie is added to the UsedSpecies HashMap.
     * @Param species
     * @Param reactiones
     * @Param UsedSpeces
     * @return
     */
    private void UniqueSpecieToHash(HashMap<String, String> species, List<reaction> reactions, HashMap<String, String> UsedSpecies){
        for (Map.Entry<String, String> p : species.entrySet()) {
            if (!UsedSpecies.containsKey(p.getKey()) && UsedInCRN(p.getKey(), reactions)){
                UsedSpecies.put(p.getKey(), p.getValue());
            }
        }
    }

    /***
     * Takes the HashMap of species, and check each entryset to see if the specie already initiated.
     * If the specie is not initiated, the specie is added to the UsedSpecies HashMap.
     * @Param species
     * @Param UsedSpeces
     * @return
     */
    private void UniqueSpecieToHash(HashMap<String, String> species, HashMap<String, String> UsedSpecies){
        for (Map.Entry<String, String> p : species.entrySet()) {
            if (!UsedSpecies.containsKey(p.getKey())){
                UsedSpecies.put(p.getKey(), p.getValue());
            }
        }
    }

    /***
     * Takes a specie, and check if the specie is used in the CRN. A boolean is returned
     * depending on the outcome.
     * @Param specie
     * @Param reactiones
     * @return
     */
    private boolean UsedInCRN(String specie, List<reaction> reactions){
        for (reaction r: reactions) {
            if (CheckOnePairlist(r.lhsPair, specie) || CheckOnePairlist(r.rhsPair, specie)){
                return true;
            }
        }
        return false;
    }

    /***
     * Takes a specie, and check if the specie is used in the CRN. A boolean is returned
     * depending on the outcome.
     * @Param specie
     * @Param reactiones
     * @return
     */
    private boolean CheckOnePairlist(List<BiksPair<String, String>> pairs, String specie){
        for (BiksPair<String, String> p: pairs) {
            if (specie.equals(p.getKey())){
                return true;
            }
        }
        return false;
    }

    private String GenerateDictEnd()
    {
        return "}\n";
    }

    private String GenerateDictField(String key, String value)
    {
        return "\""+key+"\":["+value+"],\n";
    }
}
