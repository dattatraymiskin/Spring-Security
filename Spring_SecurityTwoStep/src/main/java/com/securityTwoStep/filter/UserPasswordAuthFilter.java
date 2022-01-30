package com.securityTwoStep.filter;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.securityTwoStep.auth.SecretKeyAuthToken;
import com.securityTwoStep.auth.UserPasswordAuthToken;
import com.securityTwoStep.model.UserSecretKey;
import com.securityTwoStep.repo.ReceiptManager;
import com.securityTwoStep.repo.UserSecretKeyRepo;

@Component
public class UserPasswordAuthFilter  extends OncePerRequestFilter{

	@Autowired
	AuthenticationManager manager;
	
	@Autowired
	UserSecretKeyRepo userSecretKeyRepo;
	
	@Autowired
	ReceiptManager receiptManager;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	   var uname=request.getHeader("uname");
	   var password=request.getHeader("password");
	   
	   var key=request.getHeader("secret_key");
		
	   if(key==null) {
		  //uid and password
		   var a=new UserPasswordAuthToken(uname, password);
		   var auth=manager.authenticate(a);
		   
		   //save generated key into db
		   UserSecretKey secretKey=new UserSecretKey();
		   secretKey.setKey((new Random().nextInt(999)*1000)+"");
		   secretKey.setUsername(uname);
		   userSecretKeyRepo.save(secretKey);
	   }else {
		   //Through the key
		   var auth =manager.authenticate(new SecretKeyAuthToken(uname,key));
		   //store in db
		   String str = UUID.randomUUID().toString();
		   receiptManager.add(str);
		   //generate a token 
		   response.setHeader("Authorization",str);
	   }
		   
	   
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return !request.getServletPath().equals("/login");
	}

	
	
	  
}
