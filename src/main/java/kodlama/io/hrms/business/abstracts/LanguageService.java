package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    Result addLanguage(Language language);
    DataResult<List<Language>> getAll();
}
