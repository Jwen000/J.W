import lombok;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @getter @setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @getter @setter
    private String name;
    

}