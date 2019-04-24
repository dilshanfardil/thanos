package lk.avalanche.godslayer.service;

import lk.avalanche.godslayer.dto.SuperDTO;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 11:09 PM}
 */


public interface SuperService<T extends SuperDTO> {

    List<T> findAll();

    T getrById(int id);

    void update(T t);

    void delete(int id);

    void insert(T t);

}
