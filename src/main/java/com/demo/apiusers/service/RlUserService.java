package com.demo.apiusers.service;

import com.demo.apiusers.dtos.request.UserRequestDTO;
import com.demo.apiusers.dtos.response.ResponseTokenDTO;
import com.demo.apiusers.exception.IdRoleNotFoundException;
import com.demo.apiusers.exception.PasswordErrorException;
import com.demo.apiusers.exception.RepeatUserException;
import com.demo.apiusers.exception.UserNotFoundException;
import com.demo.apiusers.model.RlRole;
import com.demo.apiusers.model.RlUser;
import com.demo.apiusers.repository.RlRoleRepository;
import com.demo.apiusers.repository.RlUserRepository;
import com.demo.apiusers.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RlUserService {

   private final RlUserRepository rlUserRepository;
   private final RlRoleRepository rlRoleRepository;
   private final JWTUtils jwtUtils;

   public ResponseTokenDTO login(UserRequestDTO request) {
      RlUser user = rlUserRepository.findByUserName(request.getEmail());
      if (user == null) {
         throw new UserNotFoundException("The USER: " + request.getEmail() + " does not exist in the DataBase");
      }
      if (!user.getPassword().equals(request.getPassword())) {
         throw new PasswordErrorException("Wrong Password");
      }
      return jwtUtils.getTokenResponseDTO(user.getUsername());
   }

   public ResponseTokenDTO register(UserRequestDTO request) {
      if (rlUserRepository.findByUserName(request.getEmail()) != null) {
         throw new RepeatUserException("Repeat User");
      }

      RlRole role = rlRoleRepository.findById(1L).orElseThrow(() -> IdRoleNotFoundException
              .builder().message("Id Role Not Found").build());
      RlUser newUser = RlUser.builder()
                             .username(request.getEmail())
                             .password(request.getPassword())
                             .role(role)
                             .build();

      newUser = rlUserRepository.save(newUser);

      return jwtUtils.getTokenResponseDTO(newUser.getUsername());

   }
}
