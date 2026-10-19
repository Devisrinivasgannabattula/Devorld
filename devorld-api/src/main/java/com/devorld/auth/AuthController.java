package com.devorld.auth;
import jakarta.validation.Valid; import jakarta.validation.constraints.*; import org.springframework.http.*; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestController @RequestMapping("/api/auth") public class AuthController {
 private final UserRepository users; private final PasswordEncoder encoder; public AuthController(UserRepository u,PasswordEncoder e){users=u;encoder=e;}
 public record RegisterRequest(@NotBlank @Size(max=120) String fullName,@NotBlank @Email String email,@NotBlank @Size(min=8,max=72) String password,@Size(max=30) String gender,@Size(max=30) String mobile,@Size(max=500) String address){}
 @PostMapping("/register") public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest r){if(users.existsByEmailIgnoreCase(r.email()))return ResponseEntity.status(409).body(Map.of("message","Email is already registered")); AppUser u=new AppUser();u.setFullName(r.fullName().trim());u.setEmail(r.email().trim().toLowerCase());u.setGender(r.gender());u.setMobile(r.mobile());u.setAddress(r.address());u.setPasswordHash(encoder.encode(r.password()));users.save(u);return ResponseEntity.status(201).body(Map.of("message","Registration successful. Please log in."));}
 @PostMapping("/login") public ResponseEntity<?> login(@RequestBody Map<String,String> body){return ResponseEntity.status(501).body(Map.of("message","JWT login filter/service is the next setup step; registration and product catalog are wired."));}
}
