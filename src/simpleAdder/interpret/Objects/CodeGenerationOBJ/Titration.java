package simpleAdder.interpret.Objects.CodeGenerationOBJ;

import simpleAdder.interpret.Objects.SymolTableOBJ.titration;
import simpleAdder.interpret.TypeCheckers.BetaStackToString;
import simpleAdder.interpret.TypeCheckers.Check;
import simpleAdder.interpret.TypeCheckers.StackChecker;

import java.util.List;
import java.util.Stack;

public class Titration extends CodeGenerationMethods{
    int Level = 0;

    /**
     Generates the python code for the titration mecanic*/
    public String Generate(List<titration> AddMol, List<titration> RemMol, int level)
    {
        Level = level;

        if (AddMol == null && RemMol == null){
            return "";
        }
        String PrettyResult = ApplyTap(Level,"def ApplyTitration(self,i):\n");
        PrettyResult += GenerateAddMol(AddMol);
        PrettyResult += GenerateRemMol(RemMol);
        return PrettyResult + "\n";
    }

    /**
     Generates the code for the addition titrations*/
    private String GenerateAddMol(List<titration> AddTits)
    {
        int i = 0;
        String PrettyResult = "";
        if (AddTits != null){
            Level++;

            for (titration titra : AddTits) {
                if (titra.LogicalExpr != null && titra.LogicalExpr.size() > 0){
                    PrettyResult += ConstructConditionalStatement(titra);
                    Level++;
                }
                PrettyResult += ApplyTap(Level,"Result, self."+vv.ADDMOL+ i +" = self.TitAccumilationA(self, "+titra.Timestep+", self."+vv.ADDMOL+ i++ +")\n");
                PrettyResult += ApplyTap(Level,"self.sample[\""+titra.Species+"\"][-1] = self.sample.get(\""+titra.Species+"\")[-1]+Result*1\n");
                Level -= titra.LogicalExpr != null ? 1 : 0;
            }
            Level--;
        }
        return PrettyResult;
    }

    /**
     generates the code for the remove titrations*/
    private  String GenerateRemMol(List<titration> RemTits)
    {
        String PrettyResult = "";
        int i = 0;
        if (RemTits != null){
            Level++;
            for (titration titra : RemTits) {
                if (titra.LogicalExpr != null){
                    PrettyResult += ConstructConditionalStatement(titra);
                    Level++;
                }
                PrettyResult += ApplyTap(Level,"if self.sample.get(\""+titra.Species+"\")[-1]-1 <= 0:\n");
                Level++;
                PrettyResult += ApplyTap(Level,"self.sample.get(\""+titra.Species+"\")[-1] = 0\n");
                Level--;
                PrettyResult += ApplyTap(Level,"else:\n");
                Level++;
                PrettyResult += ApplyTap(Level,"Result, self."+vv.REMMOL+ i +" = self.TitAccumilationA(self, "+titra.Timestep+", self."+vv.REMMOL+ i++ +")\n");
                PrettyResult += ApplyTap(Level,"self.sample[\""+titra.Species+"\"][-1] = self.sample.get(\""+titra.Species+"\")[-1]-Result*1\n");
                Level -= titra.LogicalExpr != null ? 1 : 0;
                Level--;
            }
            Level--;
        }
        return PrettyResult;
    }

    /**
     Construct the conditional statement for the titrations*/
    private String ConstructConditionalStatement(titration titra)
    {
        String PrettyResult = "";
        PrettyResult += ApplyTap(Level,"if ");
        PrettyResult += GenerateLogicalExpression(titra);
        PrettyResult += ":\n";
        return PrettyResult;
    }
    BetaStackToString BSTS = new BetaStackToString();
    StackChecker SC = new StackChecker();
    /**
     Generates a logical exsprression*/
    private String GenerateLogicalExpression(titration titra)
    {
        String PrettyResult = "";
        if(titra.LogicalExpr != null)
        {
            for (int i = 0; i < titra.LogicalExpr.size();i++)
            {
                if(i == 0)
                {
                    PrettyResult += "";
                }

                String lhs = StackToPython(titra.LogicalExpr.get(i).lhs);
                String rhs = StackToPython(titra.LogicalExpr.get(i).rhs);

                PrettyResult += lhs + titra.LogicalExpr.get(i).logicalOperator + rhs;

                if(titra.booleanOperator != null && titra.booleanOperator.size() > i)
                {
                    PrettyResult += TransBool(titra.booleanOperator.get(i));
                }
            }
        }
        return PrettyResult;
    }

    public String StackToPython(Stack<String> stack){
        Stack<String> result = new Stack<>();
        while (!stack.isEmpty()){
            result.push(CheckValue(stack.pop()));
        }
        return BSTS.StackToString(SC.ReverseStack(result));
    }

    /**Checks if a String value is variable name*/
    private String CheckValue(String str)
    {
        return Character.isDigit(str.charAt(0)) || BSTS.IsOperator(str) ? str : "self.sample.get(\""+str+"\")[-1]";
    }

    /**
     * Trnaslates the logical operator thier python equavalent*/
    private String TransBool(String bool)
    {
        switch (bool){
            case "&&": return " and ";
            case "||": return  " or ";
            default: return "";
        }

    }
}
