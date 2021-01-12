package com.data.models.Repositories.Store;

import com.data.models.store.Brands;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/28/2020  : 15:23
 */
public interface BrandRepository extends JpaRepository<Brands,Long> {
}
