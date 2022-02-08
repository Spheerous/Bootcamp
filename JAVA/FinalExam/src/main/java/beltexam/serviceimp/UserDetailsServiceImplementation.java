package beltexam.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import beltexam.models.User;
import beltexam.repository.UserRepository;


@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw  new UsernameNotFoundException("user not Found");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user));
	}
	
	private List<GrantedAuthority> getAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        for(Permisos permiso : user.getPermisos()) {
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permiso.getName());
//            authorities.add(grantedAuthority);
//        }
        return authorities;
    }

}
