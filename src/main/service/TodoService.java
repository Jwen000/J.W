@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoItem addTodoItem(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    public TodoItem getTodoItemById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("TodoItem not found with id: " + id));
    }

    public List<TodoItem> getAllTodoItems() {
        return todoRepository.findAll();
    }

    public TodoItem updateTodoItem(Long id, TodoItem updatedTodoItem) {
        TodoItem todoItem = getTodoItemById(id);
        todoItem.setTitle(updatedTodoItem.getTitle());
        todoItem.setCompleted(updatedTodoItem.isCompleted());


        return todoRepository.save(todoItem);
    }

    public void deleteTodoItem(Long id) {
        todoRepository.deleteById(id);
    }
}