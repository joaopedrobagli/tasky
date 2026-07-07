package com.tasky.tasky.service;

import com.tasky.tasky.model.Task;
import com.tasky.tasky.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> listarTodas() {
        return taskRepository.findAll();
    }

    public Task buscarPorId(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public Task criar(Task task) {
        return taskRepository.save(task);
    }

    public Task atualizar(Long id, Task taskAtualizada) {
        Task task = buscarPorId(id);
        task.setTitulo(taskAtualizada.getTitulo());
        task.setDescricao(taskAtualizada.getDescricao());
        task.setStatus(taskAtualizada.getStatus());
        task.setPrioridade(taskAtualizada.getPrioridade());
        return taskRepository.save(task);
    }

    public void deletar(Long id) {
        taskRepository.deleteById(id);
    }
}