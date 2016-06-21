package com.example.cornelious.busbooking.Interfaces;

import com.example.cornelious.busbooking.domain.account.Account;

import java.util.Set;

/**
 * Created by Cornelious on 4/19/2016.
 */
public interface IRepository <E,ID>{
   E findById(ID id);

    E add(E entity);

    E update(E entity);

    E remove(E entity);

    Set<E> findAll();

    int removeAll();
}