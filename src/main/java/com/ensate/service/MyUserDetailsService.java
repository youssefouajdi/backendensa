package com.ensate.service;
import com.ensate.entity.MyUserDetails;
import com.ensate.entity.Utilisateur;
import com.ensate.repo.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UtilisateurRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Utilisateur> user = userRepository.findByEmail(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable: " + userName));

        return user.map(MyUserDetails::new).get();
    }
}