package uk.me.martinwestacott.raytracer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TupleTest {

    @Test
    void testEqualsComparedToStringReturnsFalse() {
        Tuple t1 = new Tuple(1.0,2.0,3.0,1);
        assertFalse(t1.equals("Tuple"));
    }

    @Test
    void testXNotEqual(){
        Tuple t1 = new Tuple(1.0,2.0,3.0,1);
        Tuple t2 = new Tuple(4.0,2.0,3.0,1);
        assertNotEquals(t1, t2);
    }

    @Test
    void testYNotEqual(){
        Tuple t1 = new Tuple(4.0,2.0,3.0,1);
        Tuple t2 = new Tuple(4.0,3.0,3.0,1);
        assertNotEquals(t1, t2);
    }

    @Test
    void testZNotEqual(){
        Tuple t1 = new Tuple(4.0,2.0,3.0,1);
        Tuple t2 = new Tuple(4.0,2.0,9.0,1);
        assertNotEquals(t1, t2);
    }

    @Test
    void testWNotEqual(){
        Tuple t1 = new Tuple(4.0,2.0,3.0,1);
        Tuple t2 = new Tuple(4.0,2.0,3.0,0);
        assertNotEquals(t1, t2);
    }

    @Test
    void testHashCodeIsEqual(){
        Tuple t1 = new Tuple(1.0,2.0,3.0,1);
        Tuple t2 = new Tuple(1.0,2.0,3.0,1);
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testHashCodeXNotEqual(){
        Tuple t1 = new Tuple(1.0,2.0,3.0,1);
        Tuple t2 = new Tuple(4.0,2.0,3.0,1);
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testHashCodeYNotEqual(){
        Tuple t1 = new Tuple(4.0,2.0,3.0,1);
        Tuple t2 = new Tuple(4.0,3.0,3.0,1);
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testHashCodeZNotEqual(){
        Tuple t1 = new Tuple(4.0,2.0,3.0,1);
        Tuple t2 = new Tuple(4.0,2.0,9.0,1);
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testHashCodeWNotEqual(){
        Tuple t1 = new Tuple(4.0,2.0,3.0,1);
        Tuple t2 = new Tuple(4.0,2.0,3.0,0);
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }
}