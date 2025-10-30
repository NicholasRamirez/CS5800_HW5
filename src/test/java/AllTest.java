import Flyweight.FlyweightAllTest;
import Proxy.ProxyAllTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        FlyweightAllTest.class,
        ProxyAllTest.class,
})

public class AllTest { }
