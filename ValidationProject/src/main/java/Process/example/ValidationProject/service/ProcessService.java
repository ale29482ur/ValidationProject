package Process.example.ValidationProject.service;

import Process.example.ValidationProject.model.Process;
import Process.example.ValidationProject.model.StatusPedido;
import Process.example.ValidationProject.model.User;
import Process.example.ValidationProject.repository.ProcessRepository;
import Process.example.ValidationProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessService {

    private final UserRepository userRepository;
    private final ProcessRepository processRepository;

    public Process createProcess(Long userId, String descricao) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Process process = new Process();

        process.setDescricao(descricao);
        process.setStatus(StatusPedido.AGUARDANDO_VALIDACAO);
        process.setUser(user);

        return processRepository.save(process);
    }

    public Process nextProcess(Long userId, Long processId){
        Process process = processRepository.findById(processId)
                .orElseThrow(() -> new RuntimeException("process not found"));

        process.setStatus(process.getStatus().proximoStatus());

        return processRepository.save(process);

    }

    public Process cancelProcess(Long userId,Long processId) {

        Process process = processRepository.findById(processId)
                .orElseThrow( () -> new RuntimeException("process not found"));

        process.setStatus(process.getStatus().cancelStatus());

        return processRepository.save(process);
    }

    public void deleteProcess(Long userId, Long processId){

        Process process = processRepository.findById(processId)
                .orElseThrow(() -> new RuntimeException("process not found"));

        processRepository.deleteById(processId);
    }

    public Process ReadProcess(Long processId) {

        return processRepository.findById(processId)
                .orElseThrow(() -> new RuntimeException("process not found"));
    }
}
