package com.qa.vadym.Utils;

import java.util.Collection;
import java.util.stream.Stream;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

public class Utils {

    private Utils() {
    }

    public static Stream<String> collectionAsStream(Collection<String> collection) {
        return emptyIfNull(collection).stream();
    }
}
