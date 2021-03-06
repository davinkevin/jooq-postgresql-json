package com.github.t9t.jooq.json;

import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static com.github.t9t.jooq.json.JsonbDSL.deleteElement;
import static com.github.t9t.jooq.json.JsonbDSL.field;

public class JsonbDSLDeleteElementIT extends AbstractJsonDSLTest {
    @Parameterized.Parameters(name = "{0}")
    public static List<Object[]> params() {
        return generateParams("deleteElement", Arrays.asList(
                btest("array").selecting(deleteElement(field("[\"a\", 1, \"b\", false, \"c\"]"), 2)).expectJsonb("[\"a\", 1, false, \"c\"]"),
                btest("nested").selecting(deleteElement(deleteElement(field("[\"a\", 1, \"b\", false, \"c\"]"), 2), 2)).expectJsonb("[\"a\", 1, \"c\"]"),
                btest("negativeIndex").selecting(deleteElement(field("[\"a\", 1, \"b\", false, \"c\"]"), -2)).expectJsonb("[\"a\", 1, \"b\", \"c\"]")
        ));
    }
}
