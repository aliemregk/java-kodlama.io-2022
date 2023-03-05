package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest) {
        languageService.add(createLanguageRequest);
    }

    @PostMapping()
    public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) {
        languageService.update(updateLanguageRequest);
    }

    @PostMapping("/{id}")
    public void delete(@PathVariable int id) {
        languageService.delete(id);
    }
}
