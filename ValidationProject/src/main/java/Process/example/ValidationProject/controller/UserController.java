package Process.example.ValidationProject.controller;

import Process.example.ValidationProject.model.Process;
import Process.example.ValidationProject.model.User;
import Process.example.ValidationProject.service.ProcessService;
import Process.example.ValidationProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final ProcessService processService;


    public UserController(UserService userService, ProcessService processService) {
        this.userService = userService;
        this.processService = processService;
    }



    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }


    @PostMapping("/{userId}/process")
    public ResponseEntity<Process> create(
            @PathVariable Long userId,
            @RequestBody String descricao) {

        return ResponseEntity.ok(processService.createProcess(userId, descricao)
        );
    }

    @PutMapping("/{userId}/process/{processId}/next")
    public ResponseEntity<Process> next(
            @PathVariable Long userId,
            @PathVariable Long processId) {

        return ResponseEntity.ok(processService.nextProcess(userId,processId));

    }

    @PutMapping("/{userId}/process/{processId}/cancel")
    public ResponseEntity<Process> cancel(
            @PathVariable Long userId,
            @PathVariable Long processId){

        return ResponseEntity.ok( processService.cancelProcess(userId, processId));
    }

    @DeleteMapping("/{userId}/process/{processId}/delete")
    public void delete(
            @PathVariable Long userId,
            @PathVariable Long processId) {

        processService.deleteProcess(userId,processId);

    }
}
