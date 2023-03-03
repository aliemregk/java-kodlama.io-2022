package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologyResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetByIdTechnologyResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/technologies")
@AllArgsConstructor
public class TechnologiesController {

    private TechnologyService technologyService;

    @GetMapping()
    public List<GetAllTechnologyResponse> getAll() {
        return this.technologyService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdTechnologyResponse getById(@PathVariable int id) {
        return this.technologyService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) {
        this.technologyService.add(createTechnologyRequest);
    }

    @PutMapping()
    public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest) {
        this.technologyService.update(updateTechnologyRequest);
    }

    @PostMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.technologyService.delete(id);
    }

}
