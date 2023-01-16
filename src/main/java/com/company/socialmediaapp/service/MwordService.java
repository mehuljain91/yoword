package com.company.socialmediaapp.service;

import com.company.socialmediaapp.dto.MwordDto;
import com.company.socialmediaapp.exceptions.AppException;
import com.company.socialmediaapp.mapper.MwordMapper;
import com.company.socialmediaapp.model.Mword;
import com.company.socialmediaapp.repository.MwordRepository;
import java.util.List;
import static java.util.stream.Collectors.toList;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author mehul jain
 */

@Service
@AllArgsConstructor
@Slf4j
public class MwordService {
    
    private final MwordRepository mwordRepository;
    private final MwordMapper mwordMapper;

    @Transactional
    public MwordDto save(MwordDto mwordDto) {
        Mword save = mwordRepository.save(mwordMapper.mapDtoToMword(mwordDto));
        mwordDto.setId(save.getId());
        return mwordDto;
    }

    @Transactional(readOnly = true)
    public List<MwordDto> getAll() {
        return mwordRepository.findAll()
                .stream()
                .map(mwordMapper::mapMwordToDto)
                .collect(toList());
    }

    public MwordDto getMword(Long id) {
        Mword mword = mwordRepository.findById(id)
                .orElseThrow(() -> new AppException("No mword found with ID - " + id));
        return mwordMapper.mapMwordToDto(mword);
    }
}
