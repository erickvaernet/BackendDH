package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.PatientDTO;
import com.example.integradorV2.DTO.UserDTO;
import com.example.integradorV2.Entities.Dentist;
import com.example.integradorV2.Entities.Patient;
import com.example.integradorV2.Entities.Role;
import com.example.integradorV2.Entities.User;
import com.example.integradorV2.Exceptions.EntityNotFoundException;
import com.example.integradorV2.Exceptions.NullFieldsException;
import com.example.integradorV2.Exceptions.WrongCredentialsException;
import com.example.integradorV2.Persistence.IUserRepository;
import com.example.integradorV2.Services.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDTO login(String username, String password) {
        if(username==null) throw new NullFieldsException("Username cannot be null");
        if(password==null) throw new NullFieldsException("Password cannot be null");
        User user =userRepository.findByUsername(username);
        if(user==null) throw new EntityNotFoundException("This User doesn't exist");
        if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            UserDTO userDTO = mapToDTO(user);
            userDTO.setToken(getJWTToken(username, userDTO.getRole()));
            return userDTO;
        }
        else throw new WrongCredentialsException("Incorrect username or/and password");
    }

    @Override
    public boolean changePassword(String username, String password, String newPassword) {
        UserDTO userDto = login(username, password);
        if (userDto == null) return false;
        userRepository.save(mapToEntity(userDto));
        return true;
    }

    @Override
    public String getJWTToken(String username, Role role) {
        String secretKey = "$SG5%sgspH7ddmG38pr5vZZ+yx4mS*";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+role.toString());
        String token = Jwts
                .builder()
                .setIssuer("BackendIntegrador")
                .setSubject(username)
                .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 3600 * 1000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
        return "Bearer " + token;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User newuser= mapToEntity(userDTO);
        newuser=userRepository.save(newuser);
        return mapToDTO(newuser);
    }

    //Mappers
    private UserDTO mapToDTO(User user){
        return new ObjectMapper()
                .registerModule(new ParameterNamesModule()).
                registerModule(new Jdk8Module()).
                registerModule(new JavaTimeModule()).convertValue(user, UserDTO.class);
    }
    private User mapToEntity(UserDTO userDTO){
        return new ObjectMapper()
                .registerModule(new ParameterNamesModule()).
                registerModule(new Jdk8Module()).
                registerModule(new JavaTimeModule()).convertValue(userDTO, User.class);
    }


}
