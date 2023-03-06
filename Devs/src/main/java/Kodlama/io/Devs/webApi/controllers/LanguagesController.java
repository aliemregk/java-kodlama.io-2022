package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.languageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.languageResponses.GetAllLanguageResponse;
import Kodlama.io.Devs.business.responses.languageResponses.GetByIdLanguageResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/programminglangs")
@AllArgsConstructor
public class LanguagesController {

    private LanguageService languageService;

    @GetMapping()
    public List<GetAllLanguageResponse> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdLanguageResponse getById(@PathVariable int id) {
        return languageService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateLanguageRequest createLanguageRequest) {
        languageService.add(createLanguageRequest);
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdateLanguageRequest updateLanguageRequest) {
        languageService.update(updateLanguageRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        languageService.delete(id);
    }
}
