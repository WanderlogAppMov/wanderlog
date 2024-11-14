package org.hign.platform.wanderlog.TravelAgencies.application.outboundservice.acl;

import org.hign.platform.wanderlog.TravelAgencies.domain.model.valueobjects.UserAgencyId;
import org.hign.platform.wanderlog.iam.interfaces.acl.IamContextFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExternalAgencyIamService {
    private final IamContextFacade iamContextFacade;

    public ExternalAgencyIamService(IamContextFacade iamContextFacade) {
        this.iamContextFacade = iamContextFacade;
    }

    public Optional<UserAgencyId> createUser(String email, String password, List<String> roles) {
        var userId = iamContextFacade.createUser(email, password, roles);
        if (userId == 0) return Optional.empty();
        return Optional.of(new UserAgencyId(userId));
    }
}
