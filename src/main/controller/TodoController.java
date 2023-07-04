@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoItem> addTodoItem(@RequestBody TodoItem todoItem) {
        TodoItem addedItem = todoService.addTodoItem(todoItem);
        return ResponseEntity.ok(addedItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodoItemById(@PathVariable Long id) {
        TodoItem todoItem = todoService.getTodoItemById(id);
        return ResponseEntity.ok(todoItem);
    }

    @GetMapping
    public ResponseEntity<List<TodoItem>> getAllTodoItems() {
        List<TodoItem> todoItems = todoService.getAllTodoItems();
        return ResponseEntity.ok(todoItems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateTodoItem(@PathVariable Long id, @RequestBody TodoItem updatedTodoItem) {
        TodoItem updatedItem = todoService.updateTodoItem(id, updatedTodoItem);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoItem(@PathVariable Long id) {
        todoService.deleteTodoItem(id);
        return ResponseEntity.noContent().build();
    }
}