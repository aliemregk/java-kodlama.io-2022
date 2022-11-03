package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.ProgrammingLang;

public interface ProgrammingLangRepository {

    List<ProgrammingLang> getAll();

    ProgrammingLang getById(int id) throws Exception;

    ProgrammingLang Add(ProgrammingLang programmingLang) throws Exception;

    ProgrammingLang Update(ProgrammingLang programmingLang) throws Exception;

    ProgrammingLang Delete(int id) throws Exception;
}
