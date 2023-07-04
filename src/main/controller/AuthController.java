@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/google")
    public ResponseEntity<String> signInWithGoogle(@RequestParam("code") String authorizationCode) {
        try {
            String customToken = authService.signInWithGoogle(authorizationCode);
            return ResponseEntity.ok(customToken);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/facebook")
    public ResponseEntity<String> signInWithFacebook(@RequestParam("code") String authorizationCode) {
        try {
            String customToken = authService.signInWithFacebook(authorizationCode);
            return ResponseEntity.ok(customToken);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/github")
    public ResponseEntity<String> signInWithGithub(@RequestParam("code") String authorizationCode) {
        try {
            String customToken = authService.signInWithGithub(authorizationCode);
            return ResponseEntity.ok(customToken);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}