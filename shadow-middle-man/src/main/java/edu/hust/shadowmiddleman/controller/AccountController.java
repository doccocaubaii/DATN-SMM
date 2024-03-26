package edu.hust.shadowmiddleman.controller;

import edu.hust.shadowmiddleman.common.Constant;
import edu.hust.shadowmiddleman.dto.account.LoginDTO;
import edu.hust.shadowmiddleman.dto.account.ProfileDTO;
import edu.hust.shadowmiddleman.dto.account.RegisterDTO;
import edu.hust.shadowmiddleman.dto.common.ResponseDTO;
import edu.hust.shadowmiddleman.service.AccountService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final PasswordEncoder passwordEncoder;

    private final AccountService accountService;

    public AccountController(PasswordEncoder passwordEncoder1, AccountService accountService) {
        this.passwordEncoder = passwordEncoder1;
        this.accountService = accountService;
    }

    @PostMapping("/account/authenticate")
    public ResponseEntity<ResponseDTO> authorize(@Valid @RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .data(accountService.authorize(loginDTO))
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

    @SneakyThrows
    @GetMapping("/account/getProfile")
    public ResponseEntity<ResponseDTO> getProfile() {
        return ResponseEntity.ok()
                .body(
                        ResponseDTO.builder()
                                .code(Constant.HTTP_OK)
                                .message(Constant.RESPONSE.MESSAGE.OK)
                                .data(accountService.getProfile())
                                .build());
    }

    @SneakyThrows
    @PostMapping("/account/editProfile")
    public ResponseEntity<ResponseDTO> editProfile(@RequestBody ProfileDTO dto) {
        return ResponseEntity.ok()
                .body(
                        ResponseDTO.builder()
                                .code(Constant.HTTP_OK)
                                .message(Constant.RESPONSE.MESSAGE.OK)
                                .data(accountService.editProfile(dto))
                                .build());
    }

    @PostMapping("/public/createPassword")
    public ResponseEntity<String> createPassword(@RequestBody String pass) {
        return new ResponseEntity<>(this.passwordEncoder.encode(pass), HttpStatus.OK);
    }

    @SneakyThrows
    @GetMapping("/public/error")
    public ResponseEntity<String> createError() {
        throw new Exception("abdc");
//        return new ResponseEntity<>(this.passwordEncoder.encode(pass), HttpStatus.OK);
    }
}
