package com.demo.apiusers.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.demo.apiusers.dtos.response.ResponseTokenDTO;
import com.demo.apiusers.model.RlUser;
import com.demo.apiusers.repository.RlUserRepository;
import java.util.Date;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JWTUtils {

   @Value("${jwt.secret}")
   private String secret;
   private final RlUserRepository rlUserRepository;

   public ResponseTokenDTO getTokenResponseDTO(String email) {

      RlUser user = rlUserRepository.findByUserName(email);
      Algorithm algorithm = Algorithm.HMAC256(secret);

      String jwtToken = JWT.create()
                           .withIssuer("Api Users")
                           .withSubject("Api Users Subject")
                           .withClaim("userId", user.getId())
                           .withClaim("role", user.getRole().getId())
                           .withIssuedAt(new Date())
                           .withJWTId(UUID.randomUUID().toString())
                           .sign(algorithm);
      return ResponseTokenDTO.builder()
                             .accessToken(jwtToken)
                             .build();
   }
}
