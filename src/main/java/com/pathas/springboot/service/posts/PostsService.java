package com.pathas.springboot.service.posts;

import com.pathas.springboot.domain.posts.Posts;
import com.pathas.springboot.domain.posts.PostsRepository;
import com.pathas.springboot.web.dto.PostsResponseDto;
import com.pathas.springboot.web.dto.PostsSaveRequestDto;
import com.pathas.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. ID=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());


        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. ID=" + id));

        return new PostsResponseDto(entity);
    }
}
