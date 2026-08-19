package taskmanagement.infrastructure.adapter.in.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taskmanagement.application.account.RegisterAccountUseCase;
import taskmanagement.infrastructure.adapter.in.web.request.RegisterAccountRequest;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final RegisterAccountUseCase registerAccountUseCase;

    @PostMapping
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterAccountRequest request) {
        registerAccountUseCase.execute(request.toCommand());
        return ResponseEntity.ok().build();
    }
}
