package org.raven.auth;

import org.raven.utils.Pair;

import java.util.Map;
import java.util.List;

public interface Authentication {
    void applyToParams(List<Pair> queryParams, Map<String, String> headerParams);
}
