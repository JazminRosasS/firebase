package com.spring.firebase.logic;

import com.spring.firebase.entities.PostDTO;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface PostManagementService {

    List<PostDTO> list();

    Boolean add(PostDTO post) throws ExecutionException, InterruptedException;

    Boolean edit(String id,PostDTO post);

    Boolean delete(String id);


}
