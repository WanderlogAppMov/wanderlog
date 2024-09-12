package org.hign.platform.wanderlog.Continents.interfaces.rest;

import org.hign.platform.wanderlog.Continents.application.commandServices.AddContinentCommandService;
import org.hign.platform.wanderlog.Continents.application.queryServices.GetContinentsQueryService;
import org.hign.platform.wanderlog.Continents.domain.model.aggregates.Continent;
import org.hign.platform.wanderlog.Continents.domain.model.commands.AddContinentCommand;
import org.hign.platform.wanderlog.Continents.interfaces.rest.resources.ContinentResponse;
import org.hign.platform.wanderlog.Continents.interfaces.rest.transform.ContinentResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/continents")
public class ContinentController {

    @Autowired
    private GetContinentsQueryService getContinentsQueryService;

    @Autowired
    private AddContinentCommandService addContinentCommandService;


    @GetMapping
    public List<ContinentResponse> getContinents() {
        return getContinentsQueryService.getAllContinents()
                .stream()
                .map(ContinentResponseTransformer::transform)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Continent addContinent(@RequestBody AddContinentCommand command) {
        return addContinentCommandService.addContinent(command.getContinentName());
    }
}
