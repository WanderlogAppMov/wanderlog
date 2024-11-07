package org.hign.platform.wanderlog.iam.infrastructure.hashing.bcrypt;

import org.hign.platform.wanderlog.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {

}

