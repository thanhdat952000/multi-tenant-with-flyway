//package dev.sultanov.springdata.multitenancy.service;
//
//import dev.sultanov.springdata.multitenancy.entity.City;
//import dev.sultanov.springdata.multitenancy.repository.CityRepository;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    private CityRepository repository;
//    private PasswordEncoder encoder;
//    private TenantService tenantService;
//
//    public UserService(CityRepository repository, TenantService tenantService) {
//        this.repository = repository;
//        this.tenantService = tenantService;
//        this.encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//    @Transactional
//    public City createUser(City user) {
//        String encodedPassword = encoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        City saved = repository.save(user);
//        tenantService.initDatabase(user.getUsername());
//        return saved;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return repository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User with the specified username is not found"));
//    }
//}
