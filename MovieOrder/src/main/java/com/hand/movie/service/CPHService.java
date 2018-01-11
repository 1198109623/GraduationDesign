package com.hand.movie.service;

import java.util.List;

public interface CPHService {
    void deleteCPH(Integer id);

    void deleteBatch(List<Integer> ids);
}
