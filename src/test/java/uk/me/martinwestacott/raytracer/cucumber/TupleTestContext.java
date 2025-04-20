package uk.me.martinwestacott.raytracer.cucumber;

import uk.me.martinwestacott.raytracer.Tuple;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public final class TupleTestContext {
    private final Map<String, Tuple> tupleMap = new HashMap<String, Tuple>();

    public void setTuple(String name, Tuple tuple) {
        tupleMap.put(name, tuple);
    }

    public Tuple getTuple(String name) {
        Tuple tuple = tupleMap.get(name);
        assertNotNull(tuple, "No tuple found for name " + name);
        return tuple;
    }
}
