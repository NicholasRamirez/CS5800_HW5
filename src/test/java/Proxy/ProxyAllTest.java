package Proxy;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        SongServiceRealProxyTest.class,
        SongTest.class,
})

public class ProxyAllTest { }
