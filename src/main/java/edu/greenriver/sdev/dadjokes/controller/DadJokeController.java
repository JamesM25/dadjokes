package edu.greenriver.sdev.dadjokes.controller;


import edu.greenriver.sdev.dadjokes.domain.DadJoke;
import edu.greenriver.sdev.dadjokes.service.DadJokeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class DadJokeController {
    private DadJokeService service;

    public DadJokeController(DadJokeService service) {
        this.service = service;
    }

    @GetMapping("/jokes")
    public List<DadJoke> getAll() {
        return service.getAll();
    }

    @PostMapping("/jokes")
    public void addJoke(@RequestBody DadJoke joke) {
        service.add(joke);
    }

    @PutMapping("/jokes/{id}")
    public void updateJoke(@PathVariable int id, @RequestBody DadJoke joke) {
        service.update(id, joke.getJokeText());
    }

    @DeleteMapping("/jokes/{id}")
    public void deleteJoke(@PathVariable int id) {
        service.delete(id);
    }
}
