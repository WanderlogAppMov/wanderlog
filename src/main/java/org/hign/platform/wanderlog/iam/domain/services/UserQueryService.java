package org.hign.platform.wanderlog.iam.domain.services;

import org.hign.platform.wanderlog.iam.domain.model.aggregates.User;
import org.hign.platform.wanderlog.iam.domain.model.queries.GetAllUsersQuery;
import org.hign.platform.wanderlog.iam.domain.model.queries.GetUserByIdQuery;
import org.hign.platform.wanderlog.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);
}
