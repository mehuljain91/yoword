package com.company.socialmediaapp.mapper;

import com.company.socialmediaapp.dto.MwordDto;
import com.company.socialmediaapp.model.Mword;
import com.company.socialmediaapp.model.Post;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author mehul jain
 */


@Mapper(componentModel = "spring")
public interface MwordMapper {
    
    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(mword.getPosts()))")
    MwordDto mapMwordToDto(Mword mword);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Mword mapDtoToMword(MwordDto mwordDto);
}
