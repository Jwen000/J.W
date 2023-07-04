import lombok;

@Entity
@Table(name = "todos")
public class TodoItem {

    @Id
    @getter @setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @getter @setter
    private String title;

    @getter @setter
    private boolean completed;

}