package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLangService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLang;

@RestController
@RequestMapping("/api/programminglangs")
public class ProgrammingLangsController {

    private ProgrammingLangService programmingLangService;

    public ProgrammingLangsController(ProgrammingLangService programmingLangService) {
        this.programmingLangService = programmingLangService;
    }

    @GetMapping("/getall")
    public List<ProgrammingLang> getAll() {
        return programmingLangService.getAll();
    }

    @GetMapping("/getbyid")
    public ProgrammingLang getById(int id) throws Exception {
        return programmingLangService.getById(id);
    }

    @PostMapping("/add")
    public ProgrammingLang Add(ProgrammingLang programmingLang) throws Exception {
        return programmingLangService.Add(programmingLang);
    }

    @PostMapping("/update")
    public ProgrammingLang Update(ProgrammingLang programmingLang) throws Exception {
        return programmingLangService.Update(programmingLang);
    }

    @PostMapping("/delete")
    public ProgrammingLang Delete(int id) throws Exception {
        return programmingLangService.Delete(id);
    }
}
