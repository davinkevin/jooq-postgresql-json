package com.github.t9t.jooq.json;

import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

public class JsonDSLArrayElementTextIT extends AbstractJsonDSLTest {
    @Parameterized.Parameters(name = "{1}_{0}")
    public static List<Object[]> params() {
        return generateParams("arrayElementText", (type, f) -> Arrays.asList(
                params("getFirstObject", arrayRow, "{\"d\": 4408}", JsonDSL.arrayElementText(f, 0)),
                params("getString", arrayRow, type + " array", JsonDSL.arrayElementText(f, 3)),
                params("outOfBounds", arrayRow, null, JsonDSL.arrayElementText(f, 100)),
                params("negativeIndex", arrayRow, "true", JsonDSL.arrayElementText(f, -2)),
                params("onObject", genericRow, null, JsonDSL.arrayElementText(f, 100))
        ));
    }

}