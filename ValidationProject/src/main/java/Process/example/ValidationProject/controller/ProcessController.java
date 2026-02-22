package Process.example.ValidationProject.controller;

import Process.example.ValidationProject.model.Process;
import Process.example.ValidationProject.service.ProcessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/process")
@CrossOrigin(origins = "*")
public class ProcessController {

    private final ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Process> create(
            @PathVariable Long userId,
            @RequestBody String descricao) {

        return ResponseEntity.ok(processService.createProcess(userId, descricao)
        );
    }

    @GetMapping("/{processId}")
    public Process read(
            @PathVariable Long processId
    ) {
        return processService.ReadProcess(processId);
    }

    @PutMapping("/{processId}/{userId}/next")
    public ResponseEntity<Process> next(
            @PathVariable Long userId,
            @PathVariable Long processId) {

        return ResponseEntity.ok(processService.nextProcess(userId,processId));

    }

    @PutMapping("/{processId}/{userId}/cancel")
    public ResponseEntity<Process> cancel(
            @PathVariable Long userId,
            @PathVariable Long processId){

        return ResponseEntity.ok( processService.cancelProcess(userId, processId));
    }

    @DeleteMapping("/{processId}/{userId}/delete")
    public void delete(
            @PathVariable Long userId,
            @PathVariable Long processId) {

        processService.deleteProcess(userId,processId);

    }
}
