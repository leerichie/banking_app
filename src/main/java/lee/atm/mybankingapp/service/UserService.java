package lee.atm.mybankingapp.service;

import lee.atm.mybankingapp.model.User;
import lee.atm.mybankingapp.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
