@Service
public class AuthService {

    private final UserRepository userRepository;
    private final GoogleAuthenticator googleAuthenticator;
    private final FacebookAuthenticator facebookAuthenticator;
    private final GithubAuthenticator githubAuthenticator;

    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public AuthService(UserRepository userRepository, GoogleAuthenticator googleAuthenticator,
                       FacebookAuthenticator facebookAuthenticator, GithubAuthenticator githubAuthenticator) {
        this.userRepository = userRepository;
        this.googleAuthenticator = googleAuthenticator;
        this.facebookAuthenticator = facebookAuthenticator;
        this.githubAuthenticator = githubAuthenticator;
    }

    public String signInWithGoogle(String authorizationCode) {
        User user = googleAuthenticator.authenticate(authorizationCode);

        User savedUser = userRepository.save(user);

        return generateAuthToken(savedUser);
    }

    public String signInWithFacebook(String authorizationCode) {
        User user = facebookAuthenticator.authenticate(authorizationCode);

        User savedUser = userRepository.save(user);

        return generateAuthToken(savedUser);
    }

    public String signInWithGithub(String authorizationCode) {
        User user = githubAuthenticator.authenticate(authorizationCode);

        User savedUser = userRepository.save(user);

        return generateAuthToken(savedUser);
    }

    private String generateAuthToken(User user) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(14);

        for (int i = 0; i < 14; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}