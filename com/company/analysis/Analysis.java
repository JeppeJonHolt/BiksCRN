/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.company.analysis;

import com.company.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAMainProgram(AMainProgram node);
    void caseAInitializedclInit(AInitializedclInit node);
    void caseARateinitInitializebody(ARateinitInitializebody node);
    void caseAFuncinitInitializebody(AFuncinitInitializebody node);
    void caseASpeciesinitInitializebody(ASpeciesinitInitializebody node);
    void caseANumberinitInitializebody(ANumberinitInitializebody node);
    void caseAAltervalueInitializebody(AAltervalueInitializebody node);
    void caseASampleinitInitializebody(ASampleinitInitializebody node);
    void caseAStringAltervalue(AStringAltervalue node);
    void caseAFloatNumber(AFloatNumber node);
    void caseAIntNumber(AIntNumber node);
    void caseAMultipleFloats(AMultipleFloats node);
    void caseANoneFloats(ANoneFloats node);
    void caseAMultipleIntegers(AMultipleIntegers node);
    void caseANoneIntegers(ANoneIntegers node);
    void caseASingleSpecies(ASingleSpecies node);
    void caseAMultipleSpecie(AMultipleSpecie node);
    void caseASingleSpecie(ASingleSpecie node);
    void caseALambdaFuncFunc(ALambdaFuncFunc node);
    void caseAMultiInput(AMultiInput node);
    void caseAVoidInput(AVoidInput node);
    void caseASingleInput(ASingleInput node);
    void caseAFloatType(AFloatType node);
    void caseARateType(ARateType node);
    void caseAIntType(AIntType node);
    void caseADclRate(ADclRate node);
    void caseAMultipleRates(AMultipleRates node);
    void caseASingleRates(ASingleRates node);
    void caseATermExpression(ATermExpression node);
    void caseAOperatorExpression(AOperatorExpression node);
    void caseAExpressoinDouble(AExpressoinDouble node);
    void caseAPlusOperator(APlusOperator node);
    void caseAMinusOperator(AMinusOperator node);
    void caseAFactorTerm(AFactorTerm node);
    void caseAMultTerm(AMultTerm node);
    void caseADivideTerm(ADivideTerm node);
    void caseAOptermPower(AOptermPower node);
    void caseAParenPower(AParenPower node);
    void caseAParentesesParen(AParentesesParen node);
    void caseAFactorParen(AFactorParen node);
    void caseAPositivePolarity(APositivePolarity node);
    void caseANegativeParenPolarity(ANegativeParenPolarity node);
    void caseAIntegerFactor(AIntegerFactor node);
    void caseAVariableFactor(AVariableFactor node);
    void caseAFloatFactor(AFloatFactor node);
    void caseAFactorPowerIn(AFactorPowerIn node);
    void caseAExpressionPowerIn(AExpressionPowerIn node);
    void caseAWhileLoop(AWhileLoop node);
    void caseASingleLogicalExprs(ASingleLogicalExprs node);
    void caseAMultipleLogicalExprs(AMultipleLogicalExprs node);
    void caseASingleLogicalExpr(ASingleLogicalExpr node);
    void caseAOrBoolOperator(AOrBoolOperator node);
    void caseAAndBoolOperator(AAndBoolOperator node);
    void caseAGreaterEqualLogicalOperator(AGreaterEqualLogicalOperator node);
    void caseASmallerEqualLogicalOperator(ASmallerEqualLogicalOperator node);
    void caseAGreaterLogicalOperator(AGreaterLogicalOperator node);
    void caseASmallerLogicalOperator(ASmallerLogicalOperator node);
    void caseAEqualLogicalOperator(AEqualLogicalOperator node);
    void caseANotLogicalOperator(ANotLogicalOperator node);
    void caseANotEqualLogicalOperator(ANotEqualLogicalOperator node);
    void caseADclTitration(ADclTitration node);
    void caseASingleTitrations(ASingleTitrations node);
    void caseAMultipleTitrations(AMultipleTitrations node);
    void caseALoopTitrationEnd(ALoopTitrationEnd node);
    void caseASemicolonTitrationEnd(ASemicolonTitrationEnd node);
    void caseALoopTitrationContinue(ALoopTitrationContinue node);
    void caseACommaTitrationContinue(ACommaTitrationContinue node);
    void caseARemoveTitrationdcl(ARemoveTitrationdcl node);
    void caseAAddTitrationdcl(AAddTitrationdcl node);
    void caseADoubleReaction(ADoubleReaction node);
    void caseAMultipleReactant(AMultipleReactant node);
    void caseAPlusReactant(APlusReactant node);
    void caseAStringReactant(AStringReactant node);
    void caseASingleReactant(ASingleReactant node);
    void caseAOneWayArrows(AOneWayArrows node);
    void caseATwoWayArrows(ATwoWayArrows node);
    void caseAFuncReactionRateI(AFuncReactionRateI node);
    void caseAUnitReactionRateI(AUnitReactionRateI node);
    void caseAReactionRateReactionRateIi(AReactionRateReactionRateIi node);
    void caseAFCallFuncCall(AFCallFuncCall node);
    void caseAWithParamFuncParen(AWithParamFuncParen node);
    void caseANoParamFuncParen(ANoParamFuncParen node);
    void caseASingleFuncParameters(ASingleFuncParameters node);
    void caseAMultipleFuncParameters(AMultipleFuncParameters node);
    void caseASingleCrn(ASingleCrn node);
    void caseABlockCrnfunc(ABlockCrnfunc node);
    void caseASampleinitSample(ASampleinitSample node);
    void caseABodySamplefunc(ABodySamplefunc node);
    void caseARateSamplebody(ARateSamplebody node);
    void caseANumberinitSamplebody(ANumberinitSamplebody node);
    void caseAAltervalueSamplebody(AAltervalueSamplebody node);
    void caseASpeciesSamplebody(ASpeciesSamplebody node);
    void caseAFuncSamplebody(AFuncSamplebody node);
    void caseACrnSamplebody(ACrnSamplebody node);
    void caseATitsSamplebody(ATitsSamplebody node);
    void caseADclProtocol(ADclProtocol node);
    void caseAEquiliProtocolbody(AEquiliProtocolbody node);
    void caseASampleProtocolbody(ASampleProtocolbody node);
    void caseADisposeProtocolbody(ADisposeProtocolbody node);
    void caseANonzeroDisposePara(ANonzeroDisposePara node);
    void caseANoneDisposePara(ANoneDisposePara node);
    void caseAMixSampleref(AMixSampleref node);
    void caseASplitSampleref(ASplitSampleref node);
    void caseAMultiProtocolparam(AMultiProtocolparam node);
    void caseASingleProtocolparam(ASingleProtocolparam node);
    void caseAMultiProtoexstend(AMultiProtoexstend node);
    void caseASingleProtoexstend(ASingleProtoexstend node);
    void caseASingleEquili(ASingleEquili node);
    void caseATimeOption(ATimeOption node);
    void caseACycleOption(ACycleOption node);
    void caseASemiExtendequili(ASemiExtendequili node);
    void caseAStepExtendequili(AStepExtendequili node);
    void caseAWithTimestep(AWithTimestep node);
    void caseANoTimestep(ANoTimestep node);
    void caseAWithBitesize(AWithBitesize node);
    void caseAWithoutBitesize(AWithoutBitesize node);

    void caseTTPlus(TTPlus node);
    void caseTTMinus(TTMinus node);
    void caseTTMult(TTMult node);
    void caseTTDiv(TTDiv node);
    void caseTTEqual(TTEqual node);
    void caseTTPower(TTPower node);
    void caseTTLambda(TTLambda node);
    void caseTTTime(TTTime node);
    void caseTTCycle(TTCycle node);
    void caseTTSpace(TTSpace node);
    void caseTTInt(TTInt node);
    void caseTTString(TTString node);
    void caseTTFloat(TTFloat node);
    void caseTTEqualOrGreater(TTEqualOrGreater node);
    void caseTTEqualOrSmaller(TTEqualOrSmaller node);
    void caseTTNot(TTNot node);
    void caseTTNotEqual(TTNotEqual node);
    void caseTTAnd(TTAnd node);
    void caseTTOr(TTOr node);
    void caseTTLogicalEqual(TTLogicalEqual node);
    void caseTTGreater(TTGreater node);
    void caseTTSmaller(TTSmaller node);
    void caseTTComma(TTComma node);
    void caseTTColon(TTColon node);
    void caseTTSemicolon(TTSemicolon node);
    void caseTTLParen(TTLParen node);
    void caseTTRParen(TTRParen node);
    void caseTTLTurborg(TTLTurborg node);
    void caseTTRTurborg(TTRTurborg node);
    void caseTTArrow(TTArrow node);
    void caseTTDoubleArrow(TTDoubleArrow node);
    void caseTTNewl(TTNewl node);
    void caseTTDot(TTDot node);
    void caseTTComments(TTComments node);
    void caseTTBlank(TTBlank node);
    void caseTTEol(TTEol node);
    void caseTTBitesize(TTBitesize node);
    void caseTTAddmol(TTAddmol node);
    void caseTTRemmol(TTRemmol node);
    void caseTTInitializedcl(TTInitializedcl node);
    void caseTTSampledcl(TTSampledcl node);
    void caseTTSpeciesdcl(TTSpeciesdcl node);
    void caseTTRatedcl(TTRatedcl node);
    void caseTTFuncdcl(TTFuncdcl node);
    void caseTTFloatType(TTFloatType node);
    void caseTTIntType(TTIntType node);
    void caseTTRateType(TTRateType node);
    void caseTTWhiledcl(TTWhiledcl node);
    void caseTTCrndcl(TTCrndcl node);
    void caseTTProtocoldcl(TTProtocoldcl node);
    void caseTTEquilibratedcl(TTEquilibratedcl node);
    void caseTTMixdcl(TTMixdcl node);
    void caseTTDisposedcl(TTDisposedcl node);
    void caseTTSplitdcl(TTSplitdcl node);
    void caseTTFordcl(TTFordcl node);
    void caseTTVoiddcl(TTVoiddcl node);
    void caseTTBydcl(TTBydcl node);
    void caseTTEach(TTEach node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
