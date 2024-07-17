package user_service.user_service_app.securities;



import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import user_service.user_service_app.repositories.UserRepository;

@RequiredArgsConstructor
@Component
public class AppUserDetailsService implements UserDetailsService {
    private final UserRepository teacherRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return teacherRepository.findByEmail(username)
                .map(AppUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not in Database"));
    }
}
