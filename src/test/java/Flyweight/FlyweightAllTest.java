package Flyweight;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CharacterPropertiesFactoryTest.class,
        CharacterProperties.class,
        CharacterTest.class,
        DocumentsTest.class,
})

public class FlyweightAllTest { }
