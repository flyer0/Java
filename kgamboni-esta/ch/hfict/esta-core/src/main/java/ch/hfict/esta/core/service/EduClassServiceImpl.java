package ch.hfict.esta.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.hfict.esta.core.domain.EduClass;
import ch.hfict.esta.core.repository.EduClassRepository;

@Service("eduClassService")
@Transactional
public class EduClassServiceImpl implements EduClassService {

    @Autowired
    EduClassRepository eduClassRepository;
    
    @Override
    public EduClass save(EduClass educlass) {
        // TODO Auto-generated method stub
        return eduClassRepository.save(educlass);
    }

}
