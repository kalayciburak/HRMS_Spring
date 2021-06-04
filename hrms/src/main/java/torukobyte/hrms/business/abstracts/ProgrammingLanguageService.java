package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    Result addProgrammingLanguage(ProgrammingLanguage pl);

    DataResult<List<ProgrammingLanguage>> getAllProgrammingLanguage();
}
