package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.SystemPersonel;

import java.util.List;

public interface SystemPersonelService {
    DataResult<List<SystemPersonel>> getSystemPersonels();

    Result addSystemPersonel(SystemPersonel systemPersonel);

    DataResult<SystemPersonel> getSystemPersonelById(int systemPersonelId);

    Result deleteSystemPersonelById(int systemPersonelId);
}
