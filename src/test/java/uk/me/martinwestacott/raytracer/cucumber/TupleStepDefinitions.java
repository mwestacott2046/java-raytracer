package uk.me.martinwestacott.raytracer.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import uk.me.martinwestacott.raytracer.DoubleCompare;
import uk.me.martinwestacott.raytracer.Tuple;
import uk.me.martinwestacott.raytracer.TupleOperations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TupleStepDefinitions {

    private final TupleTestContext tupleTestContext = new TupleTestContext();

    @Then("a.x = {double}")
    public void compareX(double expectedX) {
        assertTrue(DoubleCompare.equal(expectedX, tupleTestContext.getTuple("a").x()));
    }

    @And("a.y = {double}")
    public void compareY(double expectedY) {
        assertTrue(DoubleCompare.equal(expectedY, tupleTestContext.getTuple("a").y()));
    }

    @And("a.z = {double}")
    public void compareZ(double expectedZ) {
        assertTrue(DoubleCompare.equal(expectedZ, tupleTestContext.getTuple("a").z()));
    }

    @And("a.w = {double}")
    public void compareW(double expectedW) {
        assertTrue(DoubleCompare.equal(expectedW, tupleTestContext.getTuple("a").w()));
    }

    @And("a is a point")
    public void isAPoint() {
        assertTrue(tupleTestContext.getTuple("a").isPoint());
    }

    @And("a is not a vector")
    public void isNotAVector() {
        Assertions.assertFalse(tupleTestContext.getTuple("a").isVector());
    }

    @And("a is not a point")
    public void isNotAPoint() {
        Assertions.assertFalse(tupleTestContext.getTuple("a").isPoint());
    }

    @And("a is a vector")
    public void isAVector() {
        assertTrue(tupleTestContext.getTuple("a").isVector());
    }

    @Given("p ← point\\({double}, {double}, {double})")
    public void createPointP(double x, double y, double z) {
        tupleTestContext.setTuple("p", Tuple.point(x, y, z));
    }

    @Given("v ← vector\\({double}, {double}, {double})")
    public void createVectorV(double x, double y, double z) {
        tupleTestContext.setTuple("v", Tuple.vector(x, y, z));
    }

    @Then("a = tuple\\({double}, {double}, {double}, {double})")
    public void equalsTupleA(double x, double y, double z, double w) {
        assertEquals(new Tuple(x, y, z, w), tupleTestContext.getTuple("a"));
    }

    @Then("p = tuple\\({double}, {double}, {double}, {double})")
    public void equalsTupleP(double x, double y, double z, double w) {
        assertEquals(new Tuple(x, y, z, w), tupleTestContext.getTuple("p"));
    }

    @Then("v = tuple\\({double}, {double}, {double}, {double})")
    public void equalsTupleV(double x, double y, double z, double w) {
        assertEquals(new Tuple(x, y, z, w), tupleTestContext.getTuple("v"));
    }

    @Given("a ← tuple\\({double}, {double}, {double}, {double})")
    public void createTupleA(double x, double y, double z, double w) {
        Tuple tuple = new Tuple(x, y, z, w);
        tupleTestContext.setTuple("a", tuple);
    }

    @Then("a1 + a2 = tuple\\({double}, {double}, {double}, {double})")
    public void addTuplesA1A2Equals(double expectedX, double expectedY, double expectedZ, double expectedW) {
        Tuple arg1 = tupleTestContext.getTuple("a1");
        Tuple arg2 = tupleTestContext.getTuple("a2");
        Tuple result = TupleOperations.add(arg1, arg2);
        assertEquals(new Tuple(expectedX, expectedY, expectedZ, expectedW), result);
    }

    @Given("a{int} ← tuple\\({double}, {double}, {double}, {double})")
    public void createTupleAx(int index, double x, double y, double z, double w) {
        Tuple tuple = new Tuple(x, y, z, w);
        tupleTestContext.setTuple("a" + index, tuple);
    }

    @Given("p{int} ← point\\({double}, {double}, {double})")
    public void createPointPx(int index, double x, double y, double z) {
        tupleTestContext.setTuple("p" + index, Tuple.point(x, y, z));
    }

    @Then("p{int} - p{int} = vector\\({double}, {double}, {double})")
    public void subtractPaPbEquals(int indexA, int indexB, double x, double y, double z) {
        Tuple tupleA = tupleTestContext.getTuple("p" + indexA);
        Tuple tupleB = tupleTestContext.getTuple("p" + indexB);
        Tuple result = TupleOperations.subtract(tupleA, tupleB);
        assertEquals(Tuple.vector(x, y, z), result);
    }

    @Then("p - v = point\\({double}, {double}, {double})")
    public void subtractPV(double x, double y, double z) {
        Tuple p = tupleTestContext.getTuple("p");
        Tuple v = tupleTestContext.getTuple("v");
        Tuple result = TupleOperations.subtract(p, v);
        assertEquals(Tuple.point(x, y, z), result);
    }

    @Given("v{int} ← vector\\({double}, {double}, {double})")
    public void createTupleVx(int index, double x, double y, double z) {
        tupleTestContext.setTuple("v" + index, Tuple.vector(x, y, z));
    }

    @Then("v{int} - v{int} = vector\\({int}, {int}, {int})")
    public void subtractVectorsEqualsVector(int a, int b, double x, double y, double z) {
        Tuple vA = tupleTestContext.getTuple("v" + a);
        Tuple vB = tupleTestContext.getTuple("v" + b);
        Tuple result = TupleOperations.subtract(vA, vB);
        assertEquals(Tuple.vector(x, y, z), result);

    }

    @Given("zero ← vector\\({double}, {double}, {double})")
    public void zeroVector(double x, double y, double z) {
        tupleTestContext.setTuple("zero", Tuple.vector(x, y, z));
    }

    @Then("zero - v = vector\\({double}, {double}, {double})")
    public void SubtractZeroVEqualsVector(double x, double y, double z) {
        Tuple zero = tupleTestContext.getTuple("zero");
        Tuple v = tupleTestContext.getTuple("v");
        Tuple result = TupleOperations.subtract(zero, v);
        assertEquals(Tuple.vector(x, y, z), result);
    }

    @Then("-a = tuple\\({double}, {double}, {double}, {double})")
    public void negateTupleA(double x, double y, double z, double w) {
        Tuple a = tupleTestContext.getTuple("a");
        Tuple result = TupleOperations.negate(a);
        assertEquals(new Tuple(x, y, z, w), result);
    }

    @Then("a * {double} = tuple\\({double}, {double}, {double}, {double})")
    public void multiplyAByScalarEquals(double scalar, double x, double y, double z, double w) {
        Tuple a = tupleTestContext.getTuple("a");
        Tuple result = TupleOperations.multiply(a, scalar);
        assertEquals(new Tuple(x, y, z, w), result);
    }

    @Then("a \\/ 2 = tuple\\({double}, {double}, {double}, {double})")
    public void dividerTupleByDivisor(double x, double y, double z, double w) {
        Tuple a = tupleTestContext.getTuple("a");
        Tuple result = TupleOperations.divide(a, 2);
        assertEquals(new Tuple(x, y, z, w), result);
    }

    @Then("magnitude\\(v) = {double}")
    public void magnitudeV(double magnitude) {
        Tuple v = tupleTestContext.getTuple("v");
        double result = TupleOperations.magnitude(v);
        assertTrue(DoubleCompare.equal(magnitude, result));
    }

    @Then("magnitude\\(v) = √{int}")
    public void magnitudeV(int squareRoot) {
        Tuple v = tupleTestContext.getTuple("v");
        double result = TupleOperations.magnitude(v);
        double expectedMagnitude = Math.sqrt(squareRoot);
        assertTrue(DoubleCompare.equal(expectedMagnitude, result));
    }

    @Then("normalize\\(v) = vector\\({double}, {double}, {double})")
    public void normalizeVVector(double x, double y, double z) {
        Tuple v = tupleTestContext.getTuple("v");
        Tuple result = TupleOperations.normalize(v);
        assertEquals(Tuple.vector(x, y, z), result);
    }

    @Then("normalize\\(v) = approximately vector\\({double}, {double}, {double})")
    public void normalizeVApproximatelyVector(double x, double y, double z) {
        Tuple v = tupleTestContext.getTuple("v");
        Tuple result = TupleOperations.normalize(v);
        assertTrue(DoubleCompare.equal(x, result.x()));
        assertTrue(DoubleCompare.equal(y, result.y()));
        assertTrue(DoubleCompare.equal(z, result.z()));
    }

    @When("norm ← normalize\\(v)")
    public void normNormalizeV() {
        Tuple v = tupleTestContext.getTuple("v");
        Tuple norm = TupleOperations.normalize(v);
        tupleTestContext.setTuple("norm", norm);
    }

    @Then("magnitude\\(norm) = {double}")
    public void magnitudeNorm(double expectedMagnitude) {
        tupleTestContext.getTuple("norm");
        double result = TupleOperations.magnitude(tupleTestContext.getTuple("norm"));
        assertTrue(DoubleCompare.equal(expectedMagnitude, result));
    }

    @Given("a ← vector\\({double}, {double}, {double})")
    public void createVectorA(double x, double y, double z) {
        tupleTestContext.setTuple("a", Tuple.vector(x, y, z));
    }

    @And("b ← vector\\({double}, {double}, {double})")
    public void createVectorB(double x, double y, double z) {
        tupleTestContext.setTuple("b", Tuple.vector(x, y, z));
    }

    @Then("dot\\(a, b) = {double}")
    public void dotAB(double expectedProduct) {
        Tuple a = tupleTestContext.getTuple("a");
        Tuple b = tupleTestContext.getTuple("b");
        double result = TupleOperations.dot(a,b);
        assertTrue(DoubleCompare.equal(expectedProduct, result));
    }

    @Then("cross\\(a, b) = vector\\({double}, {double}, {double})")
    public void crossABVector(double x, double y, double z) {
        Tuple a = tupleTestContext.getTuple("a");
        Tuple b = tupleTestContext.getTuple("b");
        Tuple result = TupleOperations.cross(a, b);
        assertEquals(Tuple.vector(x, y, z), result);
    }

    @And("cross\\(b, a) = vector\\({double}, {double}, {double})")
    public void crossBAVector(double x, double y, double z) {
        Tuple a = tupleTestContext.getTuple("a");
        Tuple b = tupleTestContext.getTuple("b");
        Tuple result = TupleOperations.cross(b, a);
        assertEquals(Tuple.vector(x, y, z), result);
    }
}
