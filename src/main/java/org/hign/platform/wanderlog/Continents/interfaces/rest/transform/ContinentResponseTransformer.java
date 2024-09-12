package org.hign.platform.wanderlog.Continents.interfaces.rest.transform;

import org.hign.platform.wanderlog.Continents.domain.model.aggregates.Continent;
import org.hign.platform.wanderlog.Continents.interfaces.rest.resources.ContinentResponse;

public class ContinentResponseTransformer {

    public static ContinentResponse transform(Continent continent) {
        ContinentResponse response = new ContinentResponse();
        response.setContinentID(continent.getContinentID());
        response.setContinentName(continent.getContinentName());
        return response;
    }
}
