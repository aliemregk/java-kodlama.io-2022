package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLangRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLang;

@Repository
public class InMemoryProgrammingLangRepository implements ProgrammingLangRepository {

    private List<ProgrammingLang> programmingLangs;

    /*
     * Creates fake data as an ArrayList.
     */
    public InMemoryProgrammingLangRepository() {
        programmingLangs = new ArrayList<ProgrammingLang>();
        programmingLangs.add(new ProgrammingLang(1, "C#"));
        programmingLangs.add(new ProgrammingLang(2, "Java"));
        programmingLangs.add(new ProgrammingLang(3, "Python"));
        programmingLangs.add(new ProgrammingLang(4, "C"));
        programmingLangs.add(new ProgrammingLang(5, "C++"));
    }

    /*
     * Returns all Programming Languages (PL).
     */
    @Override
    public List<ProgrammingLang> getAll() {
        return programmingLangs;
    }

    /*
     * @param {int} id
     * Returns the PL according to given id.
     * If there is no PL with the given id, throws an Exception.
     */
    @Override
    public ProgrammingLang getById(int id) throws Exception {
        for (ProgrammingLang programmingLang : programmingLangs) {
            if (programmingLang.getId() == id) {
                return programmingLang;
            }
        }
        throw new Exception("No record was found for id: " + id);
    }

    /*
     * @param {ProgrammingLang} programmingLangToAdd
     * Adds given PL to the system.
     * Returns the added PL.
     */
    @Override
    public ProgrammingLang Add(ProgrammingLang programmingLangToAdd) {
        programmingLangs.add(programmingLangToAdd);
        return programmingLangToAdd;
    }

    /*
     * @param {ProgrammingLang} programmingLang
     * Updates the given PL if it exists.
     * Returns the updated PL.
     */
    @Override
    public ProgrammingLang Update(ProgrammingLang programmingLang) throws Exception {
        ProgrammingLang programmingLangToUpdate = getById(programmingLang.getId());
        programmingLangToUpdate.setName(programmingLang.getName());
        return programmingLangToUpdate;
    }

    /*
     * @param {int} id
     * Deletes the given PL if it exists.
     * Returns the deleted PL.
     */
    @Override
    public ProgrammingLang Delete(int id) throws Exception {
        ProgrammingLang programmingLangToDelete = getById(id);
        programmingLangs.remove(programmingLangToDelete);
        return programmingLangToDelete;
    }
}
