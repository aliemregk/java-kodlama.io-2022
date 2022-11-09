package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.languageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.languageResponses.GetAllLanguageResponse;
import Kodlama.io.Devs.business.responses.languageResponses.GetByIdLanguageResponse;

@RestController
@RequestMapping("/api/programminglangs")
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<GetAllLanguageResponse> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/getbyid")
    public GetByIdLanguageResponse getById(int id) {
        return languageService.getById(id);
    }

    @PostMapping("/add")
    public void Add(CreateLanguageRequest createLanguageRequest) {
        languageService.add(createLanguageRequest);
    }

    @PostMapping("/update")
    public void Update(UpdateLanguageRequest updateLanguageRequest) {
        languageService.update(updateLanguageRequest);
    }

    @PostMapping("/delete")
    public void Delete(DeleteLanguageRequest deleteLanguageRequest) {
        languageService.delete(deleteLanguageRequest);
    }
}
