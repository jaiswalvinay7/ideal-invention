package io.javabrains.springsecurityjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springsecurityjwt.model.AuthenticationRequest;
import io.javabrains.springsecurityjwt.model.AuthenticationResponse;
import io.javabrains.springsecurityjwt.util.JwtUtil;

@RestController
public class HomeController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping("/hello")
	public String hello() {
		return ("<h1>Hello World !!!!</h1>");
	}

	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception{
		//Authenticate username password  
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername                        (),authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password",e);
		}
		// generate jwt token
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		System.out.println("UserDetails::::::: "+String.valueOf(userDetails));
		final String jwt = jwtUtil.generateToken(userDetails);
		System.out.println("JWT Token::::::"+jwt);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
