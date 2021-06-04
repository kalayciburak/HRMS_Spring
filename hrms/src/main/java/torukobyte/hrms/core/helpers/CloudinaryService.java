package torukobyte.hrms.core.helpers;

import org.springframework.web.multipart.MultipartFile;
import torukobyte.hrms.core.utilities.results.DataResult;

import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {

    DataResult<Map> addPicture(MultipartFile file) throws IOException;
}
