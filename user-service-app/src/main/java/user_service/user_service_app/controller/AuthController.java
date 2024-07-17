package user_service.user_service_app.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user_service.user_service_app.dto.request.LoginRequest;
import user_service.user_service_app.dto.request.RegistrationRequest;
import user_service.user_service_app.dto.response.DetailResponse;
import user_service.user_service_app.dto.response.GenericResponse;
import user_service.user_service_app.dto.response.LoginResponse;
import user_service.user_service_app.exceptions.CommonApplicationException;
import user_service.user_service_app.service.userService.authService.AuthService;
import user_service.user_service_app.service.userService.userService.AppUserService;
import user_service.user_service_app.utils.PasswordValidator;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    private final AppUserService userService;
    private final AuthService authService;
    private final PasswordValidator passwordValidator;

    @PostMapping(path = "/login")
    public ResponseEntity<GenericResponse<LoginResponse>> loginUser(@RequestBody @Valid LoginRequest request) {
        log.info("request to login user");
        GenericResponse<LoginResponse> response = authService.login(request);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<GenericResponse<String>> logout(HttpServletRequest request, @RequestHeader("Authorization") String authorizationHeader) throws CommonApplicationException {
        log.info("Received request with Authorization Header: {}", authorizationHeader);
        GenericResponse<String> response = authService.logout(request, authorizationHeader);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PostMapping(path = "/registerStudent")
    public ResponseEntity<?> registerStudent(@RequestBody @Valid RegistrationRequest request) {
        log.info("controller register: register user :: [{}] ::", request.getEmail());
        passwordValidator.isValid(request);
        GenericResponse response = userService.registerStudent(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
