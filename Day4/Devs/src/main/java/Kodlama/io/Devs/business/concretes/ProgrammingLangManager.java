package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLangService;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLangRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLang;

@Service
public class ProgrammingLangManager implements ProgrammingLangService {

    private ProgrammingLangRepository programmingLangRepository;

    public ProgrammingLangManager(ProgrammingLangRepository programmingLangRepository) {
        this.programmingLangRepository = programmingLangRepository;
    }

    /*
     * Returns all Programming Languages (PL).
     */
    @Override
    public List<ProgrammingLang> getAll() {
        return programmingLangRepository.getAll();
    }

    /*
     * @param {int} id
     * Returns the PL according to given id.
     */
    @Override
    public ProgrammingLang getById(int id) throws Exception {
        return programmingLangRepository.getById(id);
    }

    /*
     * @param {ProgrammingLang} programmingLang
     * Adds given PL to the system.
     * Before adding, checks if it is null and its compliance with business rules.
     * If the given PL is null throws an exception.
     */
    @Override
    public ProgrammingLang Add(ProgrammingLang programmingLang) throws Exception {
        if (programmingLang != null) {
            if (this.CheckPLName(programmingLang.getName())
                    && this.CheckIfSameNamedPLExists(programmingLang.getName())) {
                return programmingLangRepository.Add(programmingLang);
            }
        }
        throw new Exception("PL can not be null.");
    }

    /*
     * @param {ProgrammingLang} programmingLang
     * Updates the given PL.
     */
    @Override
    public ProgrammingLang Update(ProgrammingLang programmingLang) throws Exception {
        return programmingLangRepository.Update(programmingLang);
    }

    /*
     * @param {int} id
     * Deletes the PL according to given id.
     */
    @Override
    public ProgrammingLang Delete(int id) throws Exception {
        return programmingLangRepository.Delete(id);
    }

    /*
     * @param {String} name
     * Checks if there is any PL with the given name parameter.
     * If there is, throws an exception, otherwise returns true.
     */
    private boolean CheckIfSameNamedPLExists(String name) throws Exception {
        if (this.getAll().stream().anyMatch(pl -> pl.getName().equals(name))) {
            throw new Exception("Same named PL already exists.");
        }
        return true;
    }

    /*
     * @param {String} name
     * Checks if the given name parameter is empty or blank.
     * If it is, throws an exception, otherwise returns true.
     */
    private boolean CheckPLName(String name) throws Exception {
        if (name.isEmpty() || name.isBlank()) {
            throw new Exception("PL name can not be null or blank.");
        }
        return true;
    }
}
