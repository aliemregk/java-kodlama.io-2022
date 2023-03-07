package Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.core.utils.exceptions.BusinessException;
import Kodlama.io.Devs.core.utils.exceptions.NotFoundException;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageBusinessRules {

    private LanguageRepository languageRepository;

    public void checkIfLanguageExists(String languageName) {
        if (languageRepository.existsByName(languageName)) {
            throw new BusinessException("Language already exists.");
        }
    }

    public void checkIfLanguageExistsById(int languageId) {
        if (languageRepository.findById(languageId).isEmpty()) {
            throw new NotFoundException("Language not found with given ID.");
        }
    }
}
