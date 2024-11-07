package org.hign.platform.wanderlog.iam.domain.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.hign.platform.wanderlog.iam.domain.model.aggregates.User;
import org.hign.platform.wanderlog.iam.domain.model.commands.SignInCommand;
import org.hign.platform.wanderlog.iam.domain.model.commands.SignUpCommand;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(SignUpCommand command);
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
}
