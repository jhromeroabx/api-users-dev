package com.demo.apiusers.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.demo.apiusers.dto.TokenResponseDTO;
import com.demo.apiusers.dto.UserRequestDTO;
import com.demo.apiusers.model.SystemUser;
import com.demo.apiusers.model.SystemUserRole;
import com.demo.apiusers.repository.SystemUserRepository;
import com.demo.apiusers.repository.SystemUserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

   @Value("${jwt.secret}")
   private String secret;

   private final SystemUserRepository systemUserRepository;
   private final SystemUserRoleRepository systemUserRoleRepository;

   public TokenResponseDTO register(UserRequestDTO request) {
      if (systemUserRepository.findByUsername(request.getUsername()) != null) {
         throw new RuntimeException();
      }

      SystemUserRole role = systemUserRoleRepository.findById(1).orElseThrow();
      SystemUser newUser = SystemUser.builder()
              .username(request.getUsername())
              .userPassword(request.getPassword())
              .systemUserRole(role)
              .build();

      newUser = systemUserRepository.save(newUser);

      return getTokenResponseDTO(newUser.getIdSystemUser());

   }

   public TokenResponseDTO login(UserRequestDTO request) {
      SystemUser user = systemUserRepository.findByUsername(request.getUsername());
      if (user == null) {
         throw new RuntimeException();
      }
      if (!user.getUserPassword().equals(request.getPassword())) {
         throw new RuntimeException();
      }

      return getTokenResponseDTO(user.getIdSystemUser());
   }

   private TokenResponseDTO getTokenResponseDTO(Long userId) {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      String jwtToken = JWT.create()
              .withIssuer("Api Users")
              .withSubject("Api Users Subject")
              .withClaim("userId", userId)
              .withIssuedAt(new Date())
              .withJWTId(UUID.randomUUID().toString())
              .sign(algorithm);
      return TokenResponseDTO.builder()
              .token(jwtToken)
              .build();
   }
}
