package com.example.integradorV2.Services.impl;

import com.example.integradorV2.Entities.Role;
import com.example.integradorV2.Entities.User;
import com.example.integradorV2.Exceptions.EntityNotFoundException;
import com.example.integradorV2.Exceptions.InvalidIdException;
import com.example.integradorV2.Exceptions.NullFieldsException;
import com.example.integradorV2.Persistence.IUserRepository;
import com.example.integradorV2.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User login(String username, String password) {
        if(username==null) throw new NullFieldsException("Username cannot be null");
        if(password==null) throw new NullFieldsException("Password cannot be null");
        User user =userRepository.findByUsername(username);
        if(user==null) throw new EntityNotFoundException("This User doesn't exist");
        //userDTO.set token user.gettoken()
        //return userdto
        return user;
    }

    @Override
    public boolean changePssword(String username, String password, String newPassword) {
        return false;
    }

    @Override
    public String getJWTToken(String username, Role role) {
        return null;
    }

    /*
    public String getJWTToken(String username, Role role) {
        String secretKey = "$SG5%sgspH7ddmG38pr5vZZ+yx4mS*";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+role.toString());

        String token = Jwts
                .builder()
                .setIssuer("BackendTFI")
                .setSubject(username)
                .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 3600 * 1000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

        return "Bearer " + token;
    }*/


}
