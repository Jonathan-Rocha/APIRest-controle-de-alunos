package br.com.server.domain.format.service;

import br.com.server.domain.format.ClassFormat;
import br.com.server.domain.format.ClassFormatRepository;
import br.com.server.domain.format.dto.ClassFormatCreate;
import br.com.server.domain.format.dto.ClassFormatData;
import br.com.server.domain.format.dto.ClassFormatUpdate;
import br.com.server.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClassFormatService {

  private final ClassFormatRepository classFormatRepository;
  private final UserRepository userRepository;

  public ClassFormat create(ClassFormatCreate data) {
    return classFormatRepository
            .save(new ClassFormat(null, data.modality(), data.timeMinutes(), data.price(),
                    userRepository.getReferenceById(data.userId())));
  }

  public Page<ClassFormatData> findAll(Long id, Pageable pageable) {
    return classFormatRepository
            .findAllByUserId(pageable, userRepository.getReferenceById(id).getId())
            .map(ClassFormatData::new);
  }

  public ClassFormat findById(Long id) {
    return classFormatRepository.getReferenceById(id);
  }

  public ClassFormat update(Long id, ClassFormatUpdate data) {
    var format = classFormatRepository.getReferenceById(id);
    if(data.modality() != null) {
      format.setModality(data.modality());
    }
    if(data.timeMinutes() != null) {
      format.setTimeMinutes(data.timeMinutes());
    }
    if(data.price() != null) {
      format.setPrice(data.price());
    }
    return format;
  }

  public void delete(Long id) {
    classFormatRepository.delete(classFormatRepository.getReferenceById(id));
  }
}
