package com.thoughtworks.demo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ylqin on 7/23/14.
 */
public class HellowordTest {
    @Test
    public void testHelloWorld(){
        Assert.assertEquals("Helloworld", new Helloworld().sayHi());
    }
}
