package edu.hust.shadowmiddleman.controller;

import edu.hust.shadowmiddleman.common.Constant;
import edu.hust.shadowmiddleman.dto.account.LoginDTO;
import edu.hust.shadowmiddleman.dto.account.RegisterDTO;
import edu.hust.shadowmiddleman.dto.common.ResponseDTO;
import edu.hust.shadowmiddleman.security.jwt.JWTFilter;
import edu.hust.shadowmiddleman.security.jwt.TokenProvider;
import edu.hust.shadowmiddleman.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final PasswordEncoder passwordEncoder;

    private final AccountService accountService;

    public AccountController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, PasswordEncoder passwordEncoder1, AccountService accountService) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.passwordEncoder = passwordEncoder1;
        this.accountService = accountService;
    }
    @PostMapping("/account/authenticate")
    public ResponseEntity<ResponseDTO> authorize(@Valid @RequestBody LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginDTO.getUsername(),
                loginDTO.getPassword()
        );

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .data(jwt)
                        .code(Constant.HTTP_OK)
                        .message("Đăng nhập thành công")
                        .build()
        );
    }

    @PostMapping("/account/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterDTO registerDTO) {
        return ResponseEntity.ok()
                .body(
                        ResponseDTO.builder()
                                .code(Constant.HTTP_OK)
                                .message(Constant.RESPONSE.MESSAGE.OK)
                                .data(accountService.register(registerDTO))
                                .build());
    }

    @PostMapping("/public/createPassword")
    public ResponseEntity<String> createPassword(@RequestBody String pass) {
        return new ResponseEntity<>(this.passwordEncoder.encode(pass), HttpStatus.OK);
    }
}
