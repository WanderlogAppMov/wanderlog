package org.hign.platform.wanderlog.Travelers.application.outboundservice.acl;

import org.hign.platform.wanderlog.Travelers.domain.model.valueobjects.UserId;
import org.hign.platform.wanderlog.iam.interfaces.acl.IamContextFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExternalIamService {
    private final IamContextFacade iamContextFacade;

    public ExternalIamService(IamContextFacade iamContextFacade) {
        this.iamContextFacade = iamContextFacade;
    }

    public Optional<UserId> createUser(String email, String password, List<String> roles) {
        var userId = iamContextFacade.createUser(email, password, roles);
        if (userId == 0) return Optional.empty();
        return Optional.of(new UserId(userId));
    }
}
